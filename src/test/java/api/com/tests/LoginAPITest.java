package api.com.tests;

import java.net.ResponseCache;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class LoginAPITest {

	@Test(description = "Verfiy The login API working fine or not")
	public void loginTest() {

		RestAssured.baseURI = "http://64.227.160.186:8080";
		RequestSpecification x = RestAssured.given();
		RequestSpecification y = x.header("Content-Type", "application/json");
		RequestSpecification z = y.body("{ \"username\": \"udy1234\", \"password\": \"uday12345\"}").log().all();

		Response response = z.post("/api/auth/login");
		System.out.println(response.asPrettyString());

	}

}
