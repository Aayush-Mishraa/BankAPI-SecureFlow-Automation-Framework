package api.com.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.api.base.AuthService;
import com.api.models.request.SignUpRequest;

import io.restassured.response.Response;

public class AccountCreationTest {
	String uniqueSuffix = String.valueOf(System.currentTimeMillis());
	String uniqueUsername = "Aaaayush_" + uniqueSuffix;
	String uniqueEmail = "AaayusshMishra_" + uniqueSuffix + "@gmail.com";

	@Test(description = "Veriy signup api working fine or not .....")
	public void createAccount() {
//		SignUpRequest signUpRequest = new SignUpRequest(null, null, null, null, null, 0);
		SignUpRequest signUpRequest = new SignUpRequest.Builder().username(uniqueUsername).email(uniqueEmail)
				.firstName("Aasyush").lastName("Mishra").password("Ayush123").mobileNumber("1234567896").build();

		AuthService authService = new AuthService();
		Response response = authService.signUp(signUpRequest);
		System.out.println(response.asPrettyString());
		Assert.assertEquals(response.asPrettyString(), "User registered successfully!",
				"User Already Register or Invalid API");

		Assert.assertEquals(response.statusCode(), 200, "Wrong Status code");

	}

}
