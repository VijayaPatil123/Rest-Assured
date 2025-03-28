package tests;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class PathAndQuerParameter {
	
	@Test
	public void testpathandQueryParamter() {
		//https://reqres.in/api/users?page=2&id=5
		
		given()
		.pathParam("myPath", "users") //path paramtere 
		.queryParam("page", 2) //Query Paramter
		.queryParam("id", 5)
		
		.when()
		      .get("https://reqres.in/api/{myPath}")
		
		.then()                         //Validation
		      .statusCode(200)
		      .log().all();
	}

}
