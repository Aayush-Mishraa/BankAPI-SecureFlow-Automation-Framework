package com.api.base;
import static io.restassured.RestAssured.*;

import java.util.HashMap;

import com.api.models.request.LoginRequest;
import com.api.models.request.SignUpRequest;

import io.restassured.response.Response;
public class AuthService extends BaseService{
	
	private static final String BASE_PATH = "/api/auth/";

	public Response  login(LoginRequest loginRequest) {
		return postRequest(loginRequest, BASE_PATH+"login");
		
	}
	public Response  signUp(SignUpRequest signUpRequest) {
		return postRequest(signUpRequest, BASE_PATH+"signup");
		
	}
	public Response forgotPassword(String emailAddress) {
		
		HashMap<String, String> payLoad = new HashMap<String, String>();
		payLoad.put("email", emailAddress);
		return postRequest(emailAddress, BASE_PATH +"forgot-password");
		
	}
	
}
