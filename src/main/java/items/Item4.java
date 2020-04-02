package items;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Item4 {

	@Test
	public void patchUserDetails() {
		
		final String baseURI = "https://reqres.in";
		final String patchURI = "/api/users/2";
		final String json = "{\"name\":\"morpheus2\",\"job\":\"zion resident\"}";
		final int expectedStatusCode = 200;
		final String nodeKey = "updatedAt";
		
		Response response = null;
		(response = RestAssured
			.given()
				.baseUri(baseURI)
				.contentType(ContentType.JSON)
				.body(json)
			.when()
				.patch(patchURI))
			.then()
				.assertThat()
					.statusCode(expectedStatusCode).and()
					.body("name", Matchers.equalTo("morpheus2"));
		
		System.out.print("updatedAt: ");
		System.out.println(response.jsonPath().get(nodeKey));
	}
	
}
