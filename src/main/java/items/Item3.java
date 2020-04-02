package items;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Item3 {

	@Test
	public void deleteUserDetails() {
		
		final String baseURI = "https://reqres.in";
		final String requestURI = "/api/users/2";
		final int expectedReturnCode = 204;
		
		RestAssured.baseURI = baseURI;
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.request(Method.DELETE, requestURI);
		
		Assert.assertEquals(response.getStatusCode(), expectedReturnCode);
		// The server has successfully fulfilled the request and that there is no additional content to send in the response payload body.
		
	}
	
}
