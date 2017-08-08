package com.yuksi.controllers;

import static org.hamcrest.Matchers.containsString;

import com.yuksi.boot.Application;
import com.yuksi.entities.User;
import com.yuksi.services.UserService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

/**
 * Created by Yuksi on 04.08.2017.
 */

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@AutoConfigureMockMvc
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    UserService userServiceMock;

    @Autowired
    User user;

    @Autowired
    UserController userController;


    @Before
    public void init() {
        user.setId(1L);
        user.setLogin("admin");
        user.setName("Admin");
        user.setSurname("Administrator");
        user.setPswd("admin");
        user.setEmail("admin@ukr.net");
        when(userServiceMock.findById(1L)).thenReturn(user);
    }

    @Test
    public void userInfo_byId_found() throws Exception {
        mockMvc.perform(get("/users/{id}", 1L))
                .andExpect(status().isOk())
                .andExpect(content().contentType(TestUtil.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.login", is("admin")))
                .andExpect(jsonPath("$.name", is("Admin")))
                .andExpect(jsonPath("$.surname", is("Administrator")))
                .andExpect(jsonPath("$.password", is("admin")))
                .andExpect(jsonPath("$.email", is("admin@ukr.net")));

        verify(userServiceMock, times(1)).findById(1L);
        verifyNoMoreInteractions(userServiceMock);
    }

    @Test
    public void shouldReturnDefaultMessage() throws Exception {
        this.mockMvc.perform(get("/users/hi")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("Hello")));
    }
}