package restAssurePractice;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;
import org.json.simple.JSONObject;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class TC002_GetList {
	
	@Test
	public void getListOfUser() {
		
		given()
		.when().get("https://reqres.in/api/users?page=2")
		.then()
		.statusCode(200)
		.log().all()
		.body("data[0].id", equalTo (7))
		.body("data[0].email", equalTo ("michael.lawson@reqres.in"))
		.body("data[0].first_name", equalTo ("Michael"))
		;
		
	}

}
