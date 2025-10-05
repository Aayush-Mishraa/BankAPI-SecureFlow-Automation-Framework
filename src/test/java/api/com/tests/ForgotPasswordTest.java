package api.com.tests;

import java.net.Authenticator;
import java.net.ResponseCache;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.api.base.AuthService;
import com.api.models.request.LoginRequest;
import com.api.models.response.LoginResponse;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ForgotPasswordTest {
	
	@Test(description = "Veriy signup api working fine or not .....")
	public void forgotPassword() {
		
		AuthService authService = new AuthService();
		Response response = authService.forgotPassword("raagpremium@gmail.com");
		System.out.println(response.asPrettyString());
//		
	}

}
