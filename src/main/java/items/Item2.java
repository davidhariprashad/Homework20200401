package items;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Item2 {

	@Test
	public void successfulLogIn() {
		
		final String baseURI = "https://reqres.in";
		final String postURI = "/api/login";
		final String nodePath = "token";
		final String expectedToken = "QpwL5tke4Pnpja7X4";
		
		RestAssured.baseURI = baseURI;
		RequestSpecification httpRequest = RestAssured.given();
		JSONObject parameters = new JSONObject();
		parameters.put("email", "eve.holt@reqres.in");
		parameters.put("password", "cityslicka");
		httpRequest.header("Content-Type", "application/json");
		httpRequest.body(parameters.toJSONString());
		Response response = httpRequest.request(Method.POST, postURI);
		JsonPath path = response.jsonPath();
		
		Assert.assertEquals(path.get(nodePath), expectedToken);;
		
	}
	
}
