package api.com.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.api.base.AuthService;
import com.api.base.UserProfileManagmentService;
import com.api.models.request.LoginRequest;
import com.api.models.request.ProfileRequest;
import com.api.models.response.LoginResponse;
import com.api.models.response.UserProfileResponse;

import io.restassured.response.Response;

public class UpdateProfileTest {

	@Test
	public void updateProfileTest() {
		AuthService authService = new AuthService();

		Response response = authService.login(new LoginRequest("uday1234", "uday12345"));
		LoginResponse loginResponse = response.as(LoginResponse.class);
		System.out.println(response.asPrettyString());
		System.out.println(loginResponse.getToken());
		
		System.out.println("=====================================================================");
		
		UserProfileManagmentService userProfileManagementService = new UserProfileManagmentService();
		response = userProfileManagementService.getUserProfile(loginResponse.getToken());
		System.out.println("Before Update: " + response.asPrettyString());
		UserProfileResponse userProfileResponse = response.as(UserProfileResponse.class);
		Assert.assertEquals(userProfileResponse.getFirstName(), "Yogesh");
		
		System.out.println("=====================================================================");
		
		ProfileRequest profileUpdateRequest = new ProfileRequest.Builder().firstName("Udayesh").lastName("Kumar")
				.mobileNumber("9876543210").email("Aayush@gmail.com").build();

		response = userProfileManagementService.updateUserProfile(loginResponse.getToken(), profileUpdateRequest);
		System.out.println("Update Response: " + response.asPrettyString());
		Assert.assertEquals(response.getStatusCode(), 200, "Update Profile API Failed");

	}

}
