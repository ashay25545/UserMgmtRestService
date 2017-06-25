package com.test.User.usermanagement.controller;

/**
 * Created by AshayRajimwale on 6/25/2017.
 */
import com.test.User.usermanagement.UserUtil;
import com.test.User.usermanagement.exception.UserExistException;
import com.test.User.usermanagement.service.UserService;
import com.test.User.usermanagement.domain.User;
import org.junit.Assert;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletResponse;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@WebMvcTest(value = UserController.class, secure = false)
public class UserControllerTest {

    @Autowired private MockMvc mockMvc;

    @MockBean private UserService userService;

    @Test
    public void createuser() throws Exception,UserExistException
    {
        User user = UserUtil.createUser();
        String uri = "/createUser";
        String url = "http://localhost/createUser";
        Mockito.when(userService.save(Mockito.anyObject())).
                thenReturn(user);
        String inputJson = "{ \n" +
                "\t\"firstName\":\"Ashd\",\n" +
                "\t\"lastName\":\"Rajimwale\",\n" +
                "\t\"age\":\"23\",\n" +
                "\t\"gender\":\"M\",\n" +
                "\t\"phoneNumber\":\"9827180483\",\n" +
                "\t\"zip\":\"76013\"}";
        RequestBuilder requestBuilder=MockMvcRequestBuilders.post(uri).
                accept(MediaType.APPLICATION_JSON_UTF8).content(inputJson).contentType(MediaType.APPLICATION_JSON);

        MvcResult mockResult = mockMvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse response = mockResult.getResponse();
        assertEquals(HttpStatus.CREATED.value(),response.getStatus());
        assertEquals(MediaType.APPLICATION_JSON_UTF8_VALUE,response.getHeader(HttpHeaders.CONTENT_TYPE));
        try
        {
            MvcResult mockResultNew = mockMvc.perform(requestBuilder).andReturn();
            MockHttpServletResponse responseNew = mockResult.getResponse();
            return;
        }
        catch(UserExistException exp)
        {
            Assert.fail();

        }


    }

    @Test
    public void updateUser() throws Exception,UserExistException
    {
        User user = UserUtil.createUser();
        String uri = "/updateUser";
        String url = "http://localhost/updateUser";
        Mockito.when(userService.updateUser(Mockito.anyObject())).
                thenReturn(user);
        String inputJson = "{ \n" +
                "\t\"firstName\":\"Ashd\",\n" +
                "\t\"lastName\":\"Rajimwale\",\n" +
                "\t\"age\":\"23\",\n" +
                "\t\"gender\":\"M\",\n" +
                "\t\"phoneNumber\":\"9827180483\",\n" +
                "\t\"zip\":\"76013\"}";
        RequestBuilder requestBuilder=MockMvcRequestBuilders.patch(uri).
                accept(MediaType.APPLICATION_JSON_UTF8).content(inputJson).contentType(MediaType.APPLICATION_JSON);

        MvcResult mockResult = mockMvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse response = mockResult.getResponse();
        assertEquals(HttpStatus.CREATED.value(),response.getStatus());
        assertEquals(MediaType.APPLICATION_JSON_UTF8_VALUE,response.getHeader(HttpHeaders.CONTENT_TYPE));
        try
        {
            MvcResult mockResultNew = mockMvc.perform(requestBuilder).andReturn();
            MockHttpServletResponse responseNew = mockResult.getResponse();
            return;
        }
        catch(UserExistException exp)
        {
            Assert.fail();

        }
    }

    @Test
    public void getUser() throws Exception,UserExistException
    {
        User user = UserUtil.createUser();
        List<User> users = new ArrayList<User>();
        users.add(user);
        String uri = "/getAllUsers";
        String url = "http://localhost/updateUser";
        Mockito.when(userService.getAllUsers()).
                thenReturn(users);
        String inputJson = "{ \n" +
                "\t\"firstName\":\"Ashd\",\n" +
                "\t\"lastName\":\"Rajimwale\",\n" +
                "\t\"age\":\"23\",\n" +
                "\t\"gender\":\"M\",\n" +
                "\t\"phoneNumber\":\"9827180483\",\n" +
                "\t\"zip\":\"76013\"}";
        RequestBuilder requestBuilder=MockMvcRequestBuilders.get(uri).
                accept(MediaType.APPLICATION_JSON_UTF8).content(inputJson).contentType(MediaType.APPLICATION_JSON);

        MvcResult mockResult = mockMvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse response = mockResult.getResponse();
        assertEquals(HttpStatus.OK.value(),response.getStatus());
        assertEquals(MediaType.APPLICATION_JSON_UTF8_VALUE,response.getHeader(HttpHeaders.CONTENT_TYPE));

    }

}
