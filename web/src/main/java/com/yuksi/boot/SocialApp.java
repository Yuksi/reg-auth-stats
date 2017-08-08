package com.yuksi.boot;

import javax.servlet.Filter;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.boot.autoconfigure.security.oauth2.resource.ResourceServerProperties;
import org.springframework.boot.autoconfigure.security.oauth2.resource.UserInfoTokenServices;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.filter.OAuth2ClientAuthenticationProcessingFilter;
import org.springframework.security.oauth2.client.filter.OAuth2ClientContextFilter;
import org.springframework.security.oauth2.client.token.grant.code.AuthorizationCodeResourceDetails;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;
import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.filter.CompositeFilter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.security.Principal;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Yuksi on 07.08.2017.
 */

@SpringBootApplication(scanBasePackages={"com.yuksi"})
@EnableOAuth2Client
@RestController
@EnableAuthorizationServer
@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
public class SocialApp extends WebSecurityConfigurerAdapter {

    private static final Logger LOGGER = LogManager.getLogger(SocialApp.class.getName());

    @Autowired
    OAuth2ClientContext oauth2ClientContext;

    /*
    @RequestMapping({ "/user", "/me" })
    public Map<String, String> user(Principal principal) {
        Map<String, String> map = new LinkedHashMap<>();
        map.put("name", principal.getName());

        LOGGER.info("principal.getName = " + principal.getName());
        LOGGER.info("principal = " + principal);

        try {
            System.setErr(new PrintStream(new File("log.txt")));
            System.err.println("principal.getName = " + principal.getName());
            System.err.println("principal = " + principal);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return map;
    }
    */

    @RequestMapping({ "/user", "/me" })
    public Principal user(Principal principal) {
        LOGGER.info("principal.getName = " + principal.getName());
        LOGGER.info("principal = " + principal);

        try {
            System.setErr(new PrintStream(new File("log.txt")));
            System.err.println("principal.getName = " + principal.getName());
            System.err.println("principal = " + principal);
            System.err.println();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return principal;
    }

    public static void main(String[] args) {
        SpringApplication.run(SocialApp.class, args);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.antMatcher("/**")
                .authorizeRequests()
                .antMatchers("/", "/login**", "/webjars/**")
                .permitAll()
                .anyRequest()
                .authenticated()
                .and().exceptionHandling()
                .authenticationEntryPoint(new LoginUrlAuthenticationEntryPoint("/"))
                .and().logout().logoutSuccessUrl("/").permitAll()
                .and().csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
                .and().addFilterBefore(ssoFilter(), BasicAuthenticationFilter.class);

    }

    @Bean
    public FilterRegistrationBean oauth2ClientFilterRegistration(
            OAuth2ClientContextFilter filter) {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(filter);
        registration.setOrder(-100);
        return registration;
    }

    @Bean
    @ConfigurationProperties("google")
    public ClientResources google() {
        return new ClientResources();
    }

    @Bean
    @ConfigurationProperties("github")
    public ClientResources github() {
        return new ClientResources();
    }

    @Bean
    @ConfigurationProperties("facebook")
    public ClientResources facebook() {
        return new ClientResources();
    }

    private Filter ssoFilter() {
        CompositeFilter filter = new CompositeFilter();
        List<Filter> filters = new ArrayList<>();
        filters.add(ssoFilter(facebook(), "/login/facebook"));
        filters.add(ssoFilter(github(), "/login/github"));
        filters.add(ssoFilter(google(), "/login/google"));
        filter.setFilters(filters);
        return filter;
    }

    private Filter ssoFilter(ClientResources client, String path) {
        OAuth2ClientAuthenticationProcessingFilter filter =
                new OAuth2ClientAuthenticationProcessingFilter(path);
        OAuth2RestTemplate template = new OAuth2RestTemplate(client.getClient(), oauth2ClientContext);
        filter.setRestTemplate(template);
        UserInfoTokenServices tokenServices =
                new UserInfoTokenServices(client.getResource().getUserInfoUri(), client.getClient().getClientId());
        tokenServices.setRestTemplate(template);
        filter.setTokenServices(tokenServices);
        return filter;
    }

}

class ClientResources {

    @NestedConfigurationProperty
    private AuthorizationCodeResourceDetails client = new AuthorizationCodeResourceDetails();

    @NestedConfigurationProperty
    private ResourceServerProperties resource = new ResourceServerProperties();

    public AuthorizationCodeResourceDetails getClient() {
        return client;
    }

    public ResourceServerProperties getResource() {
        return resource;
    }
}
