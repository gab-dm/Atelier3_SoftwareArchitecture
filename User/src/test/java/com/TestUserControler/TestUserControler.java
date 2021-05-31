package com.TestUserControler;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import com.user.model.User;
import com.user.restcontroler.UserRestControler;
import com.user.service.UserService;


@RunWith(SpringRunner.class)
@WebMvcTest(value = UserRestControler.class)

public class TestUserControler {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private UserService uService;

	User mockUser = new User("Lucas", "AZERTY");


	@Test
	public void getUserById() throws Exception {

		Mockito.when(
				uService.getUserById(Mockito.anyInt())).thenReturn(mockUser);

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
				"/getUserId/10").accept(
				MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		System.out.println(result.getResponse());
		
	}
	
	@Test
	public void getUserByString() throws Exception {

		Mockito.when(
				uService.getUserByName(Mockito.anyString())).thenReturn(mockUser);

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
				"/user/Nick").accept(
				MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		System.out.println(result.getResponse());
		
	}
	
	
	
	


}