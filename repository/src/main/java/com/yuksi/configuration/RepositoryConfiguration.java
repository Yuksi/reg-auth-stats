package com.yuksi.configuration;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Created by Yuksi on 28.07.2017.
 */

@Configuration
@EnableAutoConfiguration
@EntityScan(basePackages = "com.yuksi.entities")
@EnableJpaRepositories(basePackages = "com.yuksi.repositories")
@EnableTransactionManagement
public class RepositoryConfiguration {

}
