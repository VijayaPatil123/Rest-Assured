package tests;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.Map;

public class testCookies {
	@Test
	public void testCookies() {
		given()
		.when().get("https://www.google.com/")
		.then()
		.cookies("AEC", "AVcja2cP6EE5zFYJLpNWJHtJ9DYi_dQ1yNKJMxf-qjaaIWpDG8WIN3oQ-A")
		.log().all();
		
		
	}
	
	@Test
	public void getCookiesinfo() {
		Response res = given() //hold the response into res variable 
		.when().get("https://www.google.com/");
		
		//get sinlge cookie info 
		
	String cookie_value = res.getCookie("AEC"); // getcookie will return the cookie value
	System.out.println("Cookie Value:"+cookie_value);
	
	//Get All cookies 
   Map<String, String> allcookiesvalue = res.getCookies();
  System.out.println(allcookiesvalue.keySet());//It will give key value
		for(String k :allcookiesvalue.keySet()) {
			System.out.println(k + "   "+allcookiesvalue);
			
		}
		
		
	}
	@Test
	public void test() {
		System.out.println("Demo Purpose");
	}

}
