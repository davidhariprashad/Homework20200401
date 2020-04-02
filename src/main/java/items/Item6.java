package items;

import org.hamcrest.Matchers;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Item6 {

	@Test
	public void updateMorpheus() throws ParseException {
		
		final String baseURI = "https://reqres.in";
		final String patchURI = "/api/users/2";
		final int expectedStatusCode = 200;
		
		Response response = null;
		(response = RestAssured
			.given()
				.baseUri(baseURI)
				.contentType(ContentType.JSON)
			.when()
				.get(patchURI))
			.then()
				.assertThat()
					.statusCode(expectedStatusCode)
					.body("data.first_name", Matchers.equalTo("Janet"));

		final JSONParser parser = new JSONParser();
		final String responseString = response.asString();
		final JSONObject userObject = (JSONObject) parser.parse(responseString);
		final JSONObject dataObject = (JSONObject) userObject.get("data");
		final String name = dataObject.get("first_name").toString();
		System.out.println(name);
		
	}
	
}
