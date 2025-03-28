package tests;

import org.testng.annotations.Test;

import POJO.pojo_postRequest;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

public class differenWaysToCreatePostRequest {
	
	//Post request - create student record
	@Test(priority = 1)
	public void creatPostUsingHashMap() {
	    
	    HashMap<String, Object> data = new HashMap<String, Object>();
	    data.put("name", "Scott");  
	    data.put("location", "France");
	    data.put("phone", "12345");

	    String CourseArr[] = {"c", "c++"};
	    data.put("courses", CourseArr);

	    given()
	        .header("Content-Type", "application/json")
	        .body(data)

	    .when()
	        .post("http://localhost:3000/students")

	    .then()
	        .statusCode(201)
	        .body("name", equalTo("Scott")) 
	        .body("location", equalTo("France"))
	        .body("phone", equalTo("12345"))
	        .body("courses[0]", equalTo("c"))
	        .body("courses[1]", equalTo("c++"))
	       // .header("Content-Type", "application/json; charset=utf-8") 
	        .log().all();
	}

	

	//Delete the student records
	    @Test(priority = 2)
	    public void Delete() {
	    	
	    	
	    	given()
	    	
	    	.when().delete("http://localhost:3000/students/cddb")
	    	.then()
	    	.statusCode(200);
	    	
	    }
	    
	    
	    //Post request using POJO class
	    @Test
	    public void creatPostUsingUsingPOJO() {
		    
	    	pojo_postRequest data = new pojo_postRequest();
	    	data.setName("Vijaya");
	    	data.setLocation("Pune");
	    	data.setPhone("12345");
	    	String coursesArr[] = {"Testing","Sql"};
	    	data.setCourses(coursesArr);

		    given()
		        .header("Content-Type", "application/json")
		        .body(data)

		    .when()
		        .post("http://localhost:3000/students")

		    .then()
		        .statusCode(201)
		        .body("name", equalTo("Vijaya")) 
		        .body("location", equalTo("Pune"))
		        .body("phone", equalTo("12345"))
		        .body("courses[0]", equalTo("Testing"))
		        .body("courses[1]", equalTo("Sql"))
		       // .header("Content-Type", "application/json; charset=utf-8") 
		        .log().all();
		}


}
