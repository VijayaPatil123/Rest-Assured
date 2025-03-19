package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import  io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class test1 {
	//Non BDD pattern
	
	@Test
	public void getsingleuser() {
		Response resp = RestAssured.get("https://reqres.in/api/users/2");//This will send the get request 
		System.out.println("Status Code:"+resp.getStatusCode());
		System.out.println("Response Time in MS:"+resp.getTime());
        System.out.println("Respinse Body:"+resp.getBody().asString());
        System.out.println("PreetyFormat:"+resp.asPrettyString());
        System.out.println("Headr-ContentType:"+resp.header("Content-Type"));
        
        int statuscode = resp.getStatusCode();
        Assert.assertEquals(statuscode, 200,"Staus code is not matching...");
		
	}

	@Test
	public void RespValidation() {
	Response resp= 	RestAssured.get("https://reqres.in/api/users/2");
	int statuscode = resp.getStatusCode();
	Assert.assertEquals(statuscode, 201,"Code is not matching..");
		
	}
	
	@Test
	public void ValidateJsonFeilds() {
	Response resp = 	RestAssured.get("https://reqres.in/api/users/2");
	//TO validate json-feilds we use josnPath method
	
	int id = resp.jsonPath().getInt("data.id");
	Assert.assertEquals(id,2);
	System.out.println("Id is:"+id);
	
	String email = resp.jsonPath().getString("data.email");
	Assert.assertEquals(email, "janet.weaver@reqres.in","Email is not matching...");
	
	JsonPath path = resp.jsonPath();
	String firstname = path.getString("data.first_name");
	String lastname = path.getString("data.last_name");
	
	Assert.assertEquals(firstname, "Janet");
	Assert.assertEquals(lastname, "Weaver");
	System.out.println("Firsnt Name:"+firstname);
	System.out.println("Last Name :"+lastname);
	
	}
	
}
