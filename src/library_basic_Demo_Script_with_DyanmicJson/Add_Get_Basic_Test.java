package library_basic_Demo_Script_with_DyanmicJson;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import allPayloads.Payload;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import utils.ReUsableMethods;

import static io.restassured.RestAssured.*;

public class Add_Get_Basic_Test {
	
	String id;
	
	@Test(dataProvider="getData")
	public void addBook_Request(String isbn, String aisle)
	{
		RestAssured.baseURI = "http://216.10.245.166";
		
		String addBookResponse = given().header("Content-Type","application/javascript")
				//.body(Payload.addBook("fghry","4534"))
				.body(Payload.addBook(isbn,aisle))
		.when().post("/Library/Addbook.php")
		.then().assertThat().statusCode(200).extract().response().asString();
		
		JsonPath js = ReUsableMethods.rowToJson(addBookResponse);
		id = js.get("ID");
		System.out.println(id);
	}
	
	@DataProvider
	public Object[][] getData()
	{
		return new Object[][] {{"oklhg","8907"},{"uiydd","7632"},{"nhjlv","8061"}};
	}
	
	@Test
	public void getBookById()
	{
		given().queryParam("ID",id)
		.when().get("/Library/GetBook.php")
		.then().log().all().assertThat().statusCode(200);
	}

}
