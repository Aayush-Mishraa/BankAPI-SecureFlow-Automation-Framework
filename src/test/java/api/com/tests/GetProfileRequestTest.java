package api.com.tests;

import org.testng.annotations.Test;

import com.api.base.AuthService;
import com.api.base.UserProfileManagmentService;
import com.api.models.request.LoginRequest;
import com.api.models.response.LoginResponse;
import com.api.models.response.UserProfileResponse;

import io.restassured.response.Response;

public class GetProfileRequestTest {

	@Test(description = "Veriy Get Profile api working fine or not .....")
	public void getProfileInfoTest() {

		AuthService authService = new AuthService();
		Response response = authService.login(new LoginRequest("uday1234", "uday12345"));
		LoginResponse loginResponse = response.as(LoginResponse.class);
		System.out.println(loginResponse.getToken());
//		System.out.println(response.getBody().asString());

		UserProfileManagmentService userProfileManagementService = new UserProfileManagmentService();
	     response = userProfileManagementService.getUserProfile(loginResponse.getToken());
		System.out.println(response.asPrettyString());
		
		
		UserProfileResponse userProfileResponse =  response.as(UserProfileResponse.class);
		System.out.println(userProfileResponse.getUsername());
//		System.out.println("Profile Response: " + response.getBody().asString());
//		System.out.println("Status Code: " + response.getStatusCode());
//		System.out.println("Headers: " + response.getHeaders());
//		Assert.assertEquals(response.getStatusCode(), 200, "Profile API failed");
	}

}
