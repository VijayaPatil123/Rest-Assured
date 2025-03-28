package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class ValidateJsonResponseData {

	
	@Test(priority =1)
	public void validateJsonResponse() {
		
		/*
		given()
		      .contentType("Content-type.json")
		
		.when()
		      .get("http://localhost:3000/store")      
		.then()
		     .statusCode(200)
		     .header("Content-Type","application/json")
		     .body("book[3].title", equalTo("The Lord Of Things"));
		
		
		*/
		
	      Response res =	given()
		      .header("Content-Type","application/json")   
		      .when().get("http://localhost:3000/store");
	      
	      /*
	       Assert.assertEquals(res.getStatusCode(), 200); //validate status code 
	      Assert.assertEquals(res.header("Content-Type"),"application/json") ;
	    String bookname = res.jsonPath().get("book[3].title").toString();
	    Assert.assertEquals(bookname, "The Lord Of Things");
	    System.out.println("Title"+bookname);
	       */
	      
	      
	}
	
	//Form each book object capture title and print the 
}
