package items;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Item1 {

	@Test
	public void getUserDetailsTest() {
		
		final String baseURI = "https://reqres.in";
		final String requestURI = "/api/users/2";
		final String expectedEmailAddress = "janet.weaver@reqres.in";
		final String nodePath = "data.email";
		
		RestAssured.baseURI = baseURI;
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.request(Method.GET, requestURI);
		JsonPath path = response.jsonPath();
		Assert.assertEquals(path.get(nodePath), expectedEmailAddress);
		
	}
	
}