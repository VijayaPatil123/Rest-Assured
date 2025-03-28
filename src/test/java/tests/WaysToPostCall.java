package tests;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.Test;

import POJO.AunthenticationTest;
import io.restassured.response.Response;
public class WaysToPostCall {
	
	@Test(enabled = false)
	public void CreateBasicCall() {
	Response resp =	given()
		.header("Content-Type","application/json")
		.body("{\r\n"
				+ "    \"username\" : \"admin\",\r\n"
				+ "    \"password\" : \"password123\"\r\n"
				+ "}")
		
		.when().post("https://restful-booker.herokuapp.com/auth");
	    //Log - TO log all the response  
	   resp.then().log().all();		
	   
	   //Log only body 
	   
	   resp.then().log().body();
		
	   //Sttuc code should be 200 
	   
	 int code =   resp.getStatusCode();
	 Assert.assertEquals(code, 200);
	 System.out.println("Status Code is:"+code);
	 
	 //Validate json response 
	String tokenvalue = resp.jsonPath().getString("token") 	; 	
	System.out.println("Token value "+tokenvalue);
	}
	
	@Test
	public void createPostusingHashMap() {
		//HashMap - one way to send payload
		HashMap<String,Object> data = new HashMap<String, Object>();
		data.put("username", "admin");
		data.put("password", "password123");
		
		Response resp = given()
		               .header("Content-Type", "application/json")
		               .body(data)
		               .when().post("https://restful-booker.herokuapp.com/auth");
		//Log - log all response  
		resp.then().log().all();
		//log body 
		resp.then().log().body();
		
		Assert.assertEquals(resp.statusCode(), 200);
		System.out.println("Status code is :"+resp.getStatusCode());
		
		//Validate TokenValue 
		String tokenvalue = resp.jsonPath().getString("token");
		System.out.println("Token Value is :"+tokenvalue);
		
	}
	
	@Test
	public void createPostusingPOJO() {
		
		//Request Payload using POJO - plain old java object
		AunthenticationTest auth = new AunthenticationTest();
		auth.setUsername("admin");
		auth.setPassword("password123");
		
		
		Response res = given()
		.header("Content-Type", "application/json")
		.body(auth)
		
		.when().post("https://restful-booker.herokuapp.com/auth");
		
		//log 
		res.then().log().all();
		
		//token
		String tokenValue = res.jsonPath().getString("token");
		System.out.println("Token Generated"+tokenValue);
	}
	

}
