package restAssurePractice;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class TC001_GetListUsers {
	
	@Test
	public void getRequest() {
		//get/fetch of list of users and stored in a "response" variable 
		Response response = RestAssured.get("https://reqres.in/api/users?page=2");
		
		//get status code
		//response.getStatusCode();
		//print status code
		System.out.println(response.getStatusCode());
		System.out.println(response.getBody());
		
		Assert.assertEquals(response.getStatusCode(), 200);
		
	}
	
	

}
