package api.com.tests;

import java.net.ResponseCache;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class LoginAPITest2 {

	@Test(description = "Verfiy The login API working fine or not")
	public void loginTest() {

		Response response = given().baseUri("http://64.227.160.186:8080").header("Content-Type", "application/json")
				.body("{ \"username\": \"AayushMishra\", \"password\": \"AayushMishra\"}").log().all().post("/api/auth/login");
		System.out.println(response.asPrettyString());

	}

}
