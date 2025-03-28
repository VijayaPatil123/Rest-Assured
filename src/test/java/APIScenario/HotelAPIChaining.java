package APIScenario;

import org.testng.annotations.Test;

import POJO.BookingDates;
import POJO.bookingDeatails;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class HotelAPIChaining {
	int id ;
	@Test(priority = 1)
	public void createNewUser() {
		BookingDates date = new BookingDates();
		date.setCheckin("2025-03-19");
		date.setCheckout("2025-03-25");
		
		bookingDeatails data = new bookingDeatails();
		data.setFirstname("Vijaya");
		data.setLastname("Patil");
		data.setTotalprice(4000);
		data.setDepositpaid(true);
		data.setBookingdates(date);
		data.setAdditionalneeds("dinner");
		
		Response res = given()
		.header("Content-Type","application/json")
		.body(data)
		
		
		.when().post("https://restful-booker.herokuapp.com/booking");
		
		//log 
		res.then().log().all();
		
	 id = 	res.jsonPath().getInt("bookingid");
	System.out.println("Generated Booking Id is:"+id);
		
	}
	
	
	@Test(priority = 2)
	public void GetbookingDetails() {
		
		System.out.println("Details for the same user id:" +id);
		Response res = given()
		
		.when().get("https://restful-booker.herokuapp.com/booking/"+id);
		
		//log
		res.then().log().body();
		
		
	}
	
	@Test(priority = 3)
	public void CreateToken() {
		
	}

}
