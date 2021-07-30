package restAssurePractice;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class DeleteRequest {
	
	@Test
	public void deleteUser() {
		
		given()
		.header("Content-Type","application/json")
		.when()
		.delete("https://reqres.in/api/users/2")
		.then()
		.statusCode(204)
		.log().all();
	}
	
	@Test
	public void deleteEmployeeRecord() {
		
		given()
		.header("Content-Type", "application/json")
		.accept(ContentType.JSON)
		.when()
		.delete("http://dummy.restapiexample.com/api/v1/delete/2")
		.then()
		.statusCode(200)
		.log().all()
		.body("status", equalTo("success"));
	}

}
