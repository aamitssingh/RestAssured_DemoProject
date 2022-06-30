package googleMap_basic_Demo_Script;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import utils.ReUsableMethods;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.Assert;

import allPayloads.Payload;

public class Add_Put_Delete_Get_Basic_Test {

	public static void main(String[] args) {
		
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		
	
	//Add Place:	
		
		System.out.println("Add Place API Test Start:");
		
		
		
		String response_AddPlace = given().log().all().queryParam("key", "qaclick123").header("Content-Type", "application/json")
				/*.body("{\r\n" + 
						"\"location\":{\r\n" + 
						"	\"lat\":-38.383494,\r\n" + 
						"	\"lng\":33.427362\r\n" + 
						"},\r\n" + 
						"\"accuracy\":50,\r\n" + 
						"\"name\":\"Varun C\",\r\n" + 
						"\"phone_number\":\"(+91)983 893 8798\",\r\n" + 
						"\"address\":\"29, side layout, cohen 209\",\r\n" + 
						"\"types\":[\r\n" + 
						"\"shoe park\",\r\n" + 
						"\"shop\"\r\n" + 
						"],\r\n" + 
						"\"website\":\"http://google.com\",\r\n" + 
						"\"language\": \"French-IN\"\r\n" + 
						"}\r\n" + 
						"") */
				.body(Payload.addPlace())
				.when().post("/maps/api/place/add/json")
				.then().assertThat().statusCode(200).body("scope",equalTo("APP"))
																.body("status",equalTo("OK"))
				.header("Server","Apache/2.4.41 (Ubuntu)").extract().response().asString();
		
		System.out.println(response_AddPlace); // Print Add Place Response
		
		//JsonPath js = new JsonPath(response_AddPlace);
		JsonPath js = ReUsableMethods.rowToJson(response_AddPlace);
		String placeId = js.getString("place_id");
		System.out.println(placeId);
		
		System.out.println("Add Place API Test End:");
		
		String newAddress = "70 Bank Street, USA";
	//Update Place:
		
			//Payload:
					/*
					 	* "{\r\n" + 
						"\"place_id\":\""+placeId+"\",\r\n" + 
						"\"address\":\"70 Bank Street, USA\",\r\n" + 
						"\"key\":\"qaclick123\"\r\n" + 
						"}";
					 */
		
		
		given().log().all().queryParam("key", "qaclick123").header("Content-Type", "application/json")
				//.body(Payload.updatePlace())
				.body("{\r\n" + 
						"\"place_id\":\""+placeId+"\",\r\n" + 
						"\"address\":\""+newAddress+"\",\r\n" + 
						"\"key\":\"qaclick123\"\r\n" + 
						"}")
		.when().put("/maps/api/place/update/json")
		.then().log().all().assertThat().statusCode(200).body("msg", equalTo("Address successfully updated"));
		
		
	//Get Place:
				String getPlaceResponse = given().queryParam("key", "qaclick123")
						.queryParam("place_id", placeId)
				.when().get("/maps/api/place/get/json")
				.then().assertThat().statusCode(200).extract().response().asString();
				
				JsonPath jsGP = ReUsableMethods.rowToJson(getPlaceResponse);
				String actualAddress = jsGP.getString("address");
				
				System.out.println(actualAddress);
				Assert.assertEquals(actualAddress, newAddress); // TestNg Assertion
				

	}

}
