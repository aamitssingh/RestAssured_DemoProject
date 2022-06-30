package allPayloads;

public class Payload {
	
//=================================================Map Paylod===============================================	
	public static String addPlace()
	{
		return "{\r\n" + 
				"\"location\":{\r\n" + 
				"	\"lat\":-38.383494,\r\n" + 
				"	\"lng\":33.427362\r\n" + 
				"},\r\n" + 
				"\"accuracy\":50,\r\n" + 
				"\"name\":\"Mark C\",\r\n" + 
				"\"phone_number\":\"(+91)983 893 8798\",\r\n" + 
				"\"address\":\"29, side layout, cohen 09\",\r\n" + 
				"\"types\":[\r\n" + 
				"\"shoe park\",\r\n" + 
				"\"shop\"\r\n" + 
				"],\r\n" + 
				"\"website\":\"http://google.com\",\r\n" + 
				"\"language\": \"French-IN\"\r\n" + 
				"}\r\n" + 
				"";
	}
	
	public static String updatePlace()
	{
		return "{\r\n" + 
				"\"place_id\":\"986d4c7ae208118f3b77d81736c15f61\",\r\n" + 
				"\"address\":\"70 Bank Street, USA\",\r\n" + 
				"\"key\":\"qaclick123\"\r\n" + 
				"}";
	}
	//=================================================End of Map Paylod===============================================	
	
	//=================================================Mock API===============================================	
	
	public static String coursePrice()
	{
		return "{\r\n" + 
				"  \"dashboard\": {\r\n" + 
				"    \"purchaseAmount\": 910,\r\n" + 
				"    \"website\": \"rahulshettyacademy.com\"\r\n" + 
				"  },\r\n" + 
				"  \"courses\":[\r\n" + 
				"    {\r\n" + 
				"      \"title\": \"selenium python\",\r\n" + 
				"      \"price\": 50,\r\n" + 
				"      \"copies\": 6\r\n" + 
				"      \r\n" + 
				"    },\r\n" + 
				"    {\r\n" + 
				"      \"title\": \"cypress\",\r\n" + 
				"      \"price\": 40,\r\n" + 
				"      \"copies\": 4\r\n" + 
				"    },\r\n" + 
				"    {\r\n" + 
				"      \"title\": \"RPA\",\r\n" + 
				"      \"price\": 45,\r\n" + 
				"      \"copies\": 10\r\n" + 
				"    }]}\r\n" + 
				"";
	}
	
	//=================================================End of Mock API===============================================
	
	//=================================================Library API===============================================
	
	public static String addBook(String isbn, String aisle)
	{
		String payload = "{\r\n" + 
				"\"name\":\"Learn Appium Automation with Java\",\r\n" + 
				"\"isbn\":\""+isbn+"\",\r\n" + 
				"\"aisle\":\""+aisle+"\",\r\n" + 
				"\"author\":\"John foe\"\r\n" + 
				"}";
		
		return payload;
	}
	
	
	
	
	
	
	
	
	
	
	
	//=================================================End of Mock API===============================================

}
