package jsonParse_MockAPI;

import org.testng.Assert;

import allPayloads.Payload;
import io.restassured.path.json.JsonPath;



/* 1.Print NO. of Courses returned by API
2.Print Purchase Amount
3.Print title of the first course
4.Print all course title and their respective price.
5.Print No of copies sold by RPA Course
6.Verify if sum of all course price matches with Purchase Amount.
*/


public class ComplexJsonParse {
	
	public static void main(String [] args)
	{
		JsonPath js = new JsonPath(Payload.coursePrice());
		
		
		
		//1.Print NO. of Courses returned by API :
			
				int totalCoursesOffered = js.getInt("courses.size()");
				System.out.println("Total Courses = "+totalCoursesOffered);
				
		//2.Print Purchase Amount :
				
				String purchaseAmount = js.getString("dashboard.purchaseAmount");
				System.out.println("Purchase Amount = "+purchaseAmount);
		
	   //3.Print title of the first course:
				String firstCourseTitle = js.getString("courses[0].title");
				System.out.println("First Course  = "+firstCourseTitle);
				
		
	   //4.Print all course title and their respective price:
				int totalCourses = js.getInt("courses.size()");
				String courseTitle;
				int coursePrice;
				for(int i=0;i<totalCourses;i++)
				{
					courseTitle = js.getString("courses["+i+"].title");
					coursePrice = js.getInt("courses["+i+"].price");
				
					System.out.println("=======================================================");
					int ii = i+1;
					System.out.println("Course  = "+ii); // Print Course = 1/2/3/...
					System.out.println("Course Name  = "+courseTitle);
					System.out.println("Course Price  = "+coursePrice);
				}
			
		
		//5.Print No of copies sold by RPA Course:
				int totalCoursess = js.getInt("courses.size()");
				String courseTitlee="";
				int totalCopies=0;
				for(int i=0;i<totalCoursess;i++)
				{
					courseTitlee = js.getString("courses["+i+"].title");
					if(courseTitlee.equals("RPA"))
					{
						totalCopies = js.getInt("courses["+i+"].copies");
						//System.out.println("Total Copies Sold  = "+totalCopies);
						break;
					}
				}
				
				System.out.println("Course Name  = "+courseTitlee);
				System.out.println("Total Copies Sold  = "+totalCopies);
				
		
		//6.Verify if sum of all course price matches with Purchase Amount.
		
				int totalCoursesss = js.getInt("courses.size()");
				int purchaseAmt = js.getInt("dashboard.purchaseAmount");
				int sumOfAllCoursePrice = 0;
				//int coursePrice = 0;
				//int courseCopies = 0;
				for(int i=0; i<totalCoursesss; i++)
				{
					sumOfAllCoursePrice = sumOfAllCoursePrice + js.getInt("courses["+i+"].price") * js.getInt("courses["+i+"].copies");
				}
				
				Assert.assertEquals(sumOfAllCoursePrice, purchaseAmt);
				
				//OR
				
				if(purchaseAmt == sumOfAllCoursePrice)
				{
					System.out.println("Purchase Amount = " +purchaseAmt + " and Sum of all course price = " +sumOfAllCoursePrice+ " Matches");
				}
				else
				{
					System.out.println("Purchase Amount = " +purchaseAmt + "and Sum of all course price = " +sumOfAllCoursePrice+ "Not Matches");
				}
		
				
	
				
				
	}
}
