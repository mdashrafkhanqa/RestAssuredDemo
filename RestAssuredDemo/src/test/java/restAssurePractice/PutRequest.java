package restAssurePractice;

import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class PutRequest {
	
	@Test
	public void updateUser() {
		
		JSONObject requestBody = new JSONObject();
		
		requestBody.put("name", "morpheus");
		requestBody.put("job", "zion resident");
		
		given()
		.header("Content-Type","application/json")
		//using JSON format to pass the body by toJsonString()
		.body(requestBody.toJSONString())
		.when()
		.put("https://reqres.in/api/users/2")
		.then()
		.log().all()
		.statusCode(200)
		.statusLine("HTTP/1.1 200 OK")
		.contentType("application/json; charset=utf-8") //This is not a part of body, we are validating the value of content type directly
		.body("name", equalTo("morpheus"))
		.body("job", equalTo("zion resident"));
	}

}
