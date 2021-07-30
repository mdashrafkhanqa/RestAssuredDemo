package restAssurePractice;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

public class PatchRequest {

	@Test
	public void updateUser() {

		JSONObject requestBody = new JSONObject();

		requestBody.put("name", "morpheus");
		requestBody.put("job", "zion resident");

		given()
		.header("Content-Type", "application/json")
		// using JSON format to pass the body by toJsonString()
		.body(requestBody.toJSONString())
		.when()
		.patch("https://reqres.in/api/users/2")
		.then().log().all()
		.statusCode(200)
		.statusLine("HTTP/1.1 200 OK")
		.contentType("application/json; charset=utf-8") 
		.body("name", equalTo("morpheus"))
		.body("job", equalTo("zion resident"));
	}

}
