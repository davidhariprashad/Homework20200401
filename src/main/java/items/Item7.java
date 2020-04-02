package items;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Item7 {

	@Test
	public void deserializeUsers() throws ParseException {

		final String baseURI = "https://reqres.in";
		final String getURI = "/api/users";
		final int expectedStatusCode = 200;

		Response response = null;
		(response = RestAssured
			.given()
				.baseUri(baseURI)
				.contentType(ContentType.JSON)
			.when()
				.get(getURI))
			.then()
				.assertThat()
				.statusCode(expectedStatusCode);

		final JSONParser parser = new JSONParser();
		final String responseString = response.asString();
		final JSONObject usersObject = (JSONObject) parser.parse(responseString);
		final JSONArray usersDataObject = (JSONArray) usersObject.get("data");
		Object[] objects = usersDataObject.toArray();
		
	}

}
