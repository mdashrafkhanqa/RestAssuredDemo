package restAssurePractice;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

public class PostRequest01 {
	
	@Test
	public void postRequest02() {
		
		
		JSONObject requesyBody = new JSONObject();
		
		//POST request we need to pass body
		//Create new record in database
		
		requesyBody.put("name", "mamun");
		requesyBody.put("salary", "5000");
		requesyBody.put("age", "45");
		requesyBody.put("country", "usa");
		requesyBody.put("city", "dallas");
		requesyBody.put("id", "101");
		
		//System.out.println(requesyBody);
		
		given()
		.header("Content-Type","application/json")
		//.accept(ContentType.JSON)
		.body(requesyBody.toJSONString())
		.when()
		.post("http://dummy.restapiexample.com/api/v1/create")
		.then()
		.statusCode(200)
		.contentType("application/json")
		.log().all()
		.body("data.name", equalTo("mamun"))
		.body("data.salary", equalTo("5000"))
		.body("data.city", equalTo("dallas"));
	}

}
