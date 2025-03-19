package tests;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class APITestUsingBDD {
/*
 * Given () - Pre-requisite,PreConditions
 * When()  - Steps to perform 
 * then() - Result Validate Response - status code, Resp time,status code 
 * 
 * ===================================
 * /*
	 * given() - Pre requisite ,Pre conditions
	 * headers information,query parameter,request payload,aunthentication,cookies
	 * when() - API call/Request Type - Actions to perform
	 * GET,POST,PUT,PATCH,DELETE
	 * then() - Validate Response - expected result - status code,status message , Response time,Response Payload,headers
	 */
 
	@Test
	public void getsingleUser() {
		//BDD Basic Call
		given()
		.when()
		.get("https://reqres.in/api/users/2")
		.then()
		.statusCode(200)
		.log().all();
		
	}
	@Test
	public void validateSingleUser() {
	Response resp = 	given()
		.when()
		.get("https://reqres.in/api/users/2");
	
	//Validation of status code 
	int code = resp.getStatusCode();
	Assert.assertEquals(code, 200);
	System.out.println("Code is matching...");
	
	//Validation of any jsonFeilds
	String exptext = "Caddy generate";
	String text =    resp.jsonPath().getString("support.text");
	Assert.assertTrue(text.contains(exptext));
	System.out.println("Text is "+text);
	
	}
	
	@Test
	public void ValidateListOfUsers() {
	Response resp = 	given()
		.when()
		.get("https://reqres.in/api/users?page=2");
	
	//Valdiate id is 8
	    JsonPath path = resp.jsonPath(); // taken whole jsin response into path
	  int id =   path.getInt("data[1].id");
	  Assert.assertEquals(id, 8);
	  System.out.println("Id is:"+id);
		
	  //all the id from list 
	  
	 List<Integer> allIDs =  path.getList("data.id");
	 System.out.println("Toatl ids are "+allIDs.size());
	 
	 Assert.assertTrue(allIDs.size()==6);
	 System.out.println("ID count is matches..");
	 
	// to print all the list value we use advanced for loop
	 
	 for(Integer i : allIDs) {
		 System.out.println("All the Ids Are:"+i);
	 }
		
	}
	
	
}
