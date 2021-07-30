package restAssurePractice;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

public class TC003_GetSingleUser {
	
	@Test
	public void getSingleUser() {
		
		given()
		.when().get("https://reqres.in/api/users/2")
		.then()
		.statusCode(200)
		.log().all()
		.statusLine("HTTP/1.1 200 OK")
		.contentType("application/json; charset=utf-8")
		.body("data.id", equalTo (2))
		.body("data.email", equalTo ("janet.weaver@reqres.in"))
		.body("data.first_name", equalTo ("Janet"))
		.body("data.last_name", equalTo ("Weaver"))
		.body("data.avatar", equalTo ("https://reqres.in/img/faces/2-image.jpg"));
	}

}
