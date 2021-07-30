package restAssurePractice;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class PostRequest {
	
	@Test
	public void test1() {
		/*//way 1
		Map<String, Object>map = new HashMap<String, Object>();
		map.put("Name", "Ashraf");
		map.put("Job", "Software Tester");
		System.out.println(map);
		
		JSONObject requestBody = new JSONObject(map);
		//print requestBody in JSON format
		System.out.println(requestBody);
		//print requestBody directly in JSON format
		System.out.println(requestBody.toJSONString());*/
		
		//Way 2
				JSONObject requestBody = new JSONObject();
				
				requestBody.put("name", "morpheus");
				requestBody.put("job", "leader");
				
				//System.out.println(requestBody.toJSONString());
				
				//pre-requesite(body, header)
				given()
				//if there is an issue with printing body then we can use this
				.header("Content-Type", "application/json")
				//the body will print in json format
				.accept(ContentType.JSON)
				
				.body(requestBody.toJSONString())
				
				//http method and URI(action)
				.when()
				.post("https://reqres.in/api/users")
				
				//get response and validate response(output & Assertion)
				.then()
				.statusCode(201)
				.log().all()
				//.log().body()
				.body("name", equalTo("morpheus"))
				.body("job", equalTo("leader"));
			}
	}

