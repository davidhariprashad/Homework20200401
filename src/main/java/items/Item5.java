package items;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Item5 {

	@Test
	public void updateMorpheus() {
		
		final String baseURI = "https://reqres.in";
		final String patchURI = "/api/users/2";
		final String json = "{\"name\":\"morpheus2\",\"job\":\"zion resident\"}";
		final int expectedStatusCode = 200;
		
		Response response = null;
		(response = RestAssured
			.given()
				.baseUri(baseURI)
				.contentType(ContentType.JSON)
				.body(json)
			.when()
				.put(patchURI))
			.then()
				.assertThat()
					.statusCode(expectedStatusCode)
					.body("name", Matchers.equalTo("morpheus2"));
		
	}
	
}
