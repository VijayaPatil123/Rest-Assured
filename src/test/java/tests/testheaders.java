package tests;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class testheaders {
	
	@Test
	public void testHeaders() {
		given()
		.when()
		.get("https://www.google.com/")
		.then()
		.header("Content-Type","text/html; charset=ISO-8859-1")
		.and()
		.header("Content-Encoding", "gzip");
		
	}
	
	@Test
	public void getHeaders() {
		Response res = given()
				
		.when().get("https://www.google.com/");
		
		//get Single Header Value
	  String headerValue = res.getHeader("Content-Type");
	  System.out.println("Header value is :"+headerValue);
	  
	  //capture all headers info 
	  
	  Headers headersValue = res.getHeaders();
	  
	  for(Header h :headersValue) {
		  System.out.println(h.getName()+"      "+h.getValue());
		  
	  }
	  
	}

}
