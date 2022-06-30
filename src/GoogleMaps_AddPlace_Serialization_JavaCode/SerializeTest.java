package GoogleMaps_AddPlace_Serialization_JavaCode;

import io.restassured.RestAssured;
import io.restassured.parsing.Parser;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.ArrayList;
import java.util.List;

import POJO_GoogleMaps_AddPlace_DeSerialization.Main_getPlace;
import POJO_GoogleMaps_AddPlace_DeSerialization.getPlaceLocation;
import POJO_GoogleMaps_AddPlace_Serialization.Location;
import POJO_GoogleMaps_AddPlace_Serialization.Main_AddPlace;

public class SerializeTest {

	public static void main(String[] args) {
		
	//Serialize:
		Main_AddPlace ap = new Main_AddPlace();
		ap.setAccuracy(50);
		ap.setAddress("29, side layout, cohen 09");
		ap.setLanguage("French-IN");
		ap.setName("Amit S");
		ap.setPhone_number("(+91)983 893 8798");
		ap.setWebsite("http://google.com");
		
		List<String> typeList = new ArrayList<String>();
		typeList.add("shoe park");
		typeList.add("shop");
		ap.setTypes(typeList);
		
		Location l = new Location();
		l.setLat(-38.383494);
		l.setLng(33.427362);
		ap.setLocation(l);
		
		
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		
		Response resp = given().queryParam("key","qaclick123")
				.header("Content-Type","application/json")
				.body(ap)
		.when().post("/maps/api/place/add/json")
		.then().assertThat().statusCode(200).extract().response();
		
		String response = resp.asString();
		System.out.println("====================================================");
		System.out.println(response);
		
		JsonPath jp = new JsonPath(response);
		String placeId = jp.get("place_id");
		//System.out.println("Place Id = "+placeId);
		
		
 //De-Serialization:
		
		Main_getPlace mnGetPlace = given().queryParam("key", "qaclick123")
				.queryParam("place_id",placeId)
				.header("Content-Type", "application/json").expect().defaultParser(Parser.JSON)
		.when().get("/maps/api/place/get/json").as(Main_getPlace.class);
		//.then().assertThat().statusCode(200);
		
		System.out.println("=================================================================================================");
		//String name = mnAddPlace.getName();
		String name = mnGetPlace.getName();
		System.out.println("Name is = "+name);
		
		//int accuracy = mnAddPlace.getAccuracy();
		String accuracy = mnGetPlace.getAccuracy();
		System.out.println("Accuracy is = "+accuracy);
		
		//String address = mnAddPlace.getAddress();
		String address = mnGetPlace.getAddress();
		System.out.println("Address is = "+address);
		
		//String language = mnAddPlace.getLanguage();
		String language = mnGetPlace.getLanguage();
		System.out.println("Language is = "+language);
		
		//String ph = mnAddPlace.getPhone_number();
		String ph = mnGetPlace.getPhone_number();
		System.out.println("Phone Number is = "+ph);
		
		//String website = mnAddPlace.getWebsite();
		String website = mnGetPlace.getWebsite();
		System.out.println("WebSite is = "+website);
		
		String types = mnGetPlace.getTypes();
		System.out.println("Types is = "+types);
		
		//l = mnAddPlace.getLocation(); // returns object of Location class, so capturing it in 'l' , 'l' is object of Location class created above
		getPlaceLocation gpLocation = new getPlaceLocation();
		String lat = gpLocation.getLatitude();
		System.out.println("Lat is = "+lat);
		
		String lng = gpLocation.getLongitude();
		System.out.println("Lng is = "+lng);
		
	
		

	}

}
