package com.api.tests;

import java.net.Authenticator;
import java.net.ResponseCache;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.api.base.AuthService;
import com.api.models.request.LoginRequest;
import com.api.models.response.LoginResponse;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


@Listeners(com.api.listeners.TestListener.class)
public class LoginUserAPITest {

	@Test(description = "Verfiy The login API working fine or not")
	public void loginTest() {
		LoginRequest loginRequest = new LoginRequest("uday1234", "uday12345");
		AuthService authService = new AuthService();
		Response response = authService.login(loginRequest);
		System.out.println(response.asPrettyString());
		
		LoginResponse loginResponse = response.as(LoginResponse.class);
		System.out.println(loginResponse.getId());
		System.out.println(loginResponse.getToken());
		System.out.println(loginResponse.getEmail());
		
		Assert.assertTrue(loginResponse.getToken()!= null);
		Assert.assertEquals(loginResponse.getId(), 1);
//		Assert.assertEquals(loginResponse.getEmail(), );
	}

}
