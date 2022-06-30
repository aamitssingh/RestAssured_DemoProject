package deserialization_POJO_CoursesAndPrice;

import java.util.ArrayList;
import java.util.List;

public class SetAndGet {

	public static void main(String[] args) {
		
//Serialization:
		
	//Main Class: Object creation and seeding values
		Main mn = new Main();
		mn.setInstructor("Mukesh kk");
		mn.setExperties("xyz");
		mn.setLinkedIn("https://mnkdkj.com");
		mn.setServices("service");
		mn.setUrl("https://mnkdkjurl.com");
		//mn.setCourses(courses);
		
	//Courses Class [Child Class of Main]: Object creation
		Courses c = new Courses();
		
	// All Child Class of Courses class: 
		
		// WebAutomation Child of Courses class:
			WebAutomation wa = new WebAutomation();
			wa.setCourseTitle("Selenium java");
			wa.setPrice("50");
			wa.setCourseTitle("Selenium JS");
			wa.setPrice("80");
			
		// Api Child of Courses class:
			Api api = new Api();
			api.setCourseTitle("Rest API With Java");
			api.setPrice("30");
			api.setCourseTitle("Rest API With JS");
			api.setPrice("60");
		
		// Api Child of Courses class:
			Mobile mob = new Mobile();
			mob.setCourseTitle("Appum testing");
			mob.setPrice("20");
		
	// In Courses Class,WebAutomation, Api and Mobile is as a List: 
		List<WebAutomation> waList = new ArrayList<WebAutomation>();
		waList.add(wa);
		
		List<Api> apiList = new ArrayList<Api>();
		apiList.add(api);
		
		List<Mobile> mobList = new ArrayList<Mobile>();
		mobList.add(mob);
	
	//Seeding List into Course Class:
		c.setWebAutomation(waList);
		c.setApi(apiList);
		c.setMobile(mobList);
		
	//Seeding Courses into Main class:
		mn.setCourses(c);
		
//======================== End of Serialization ====================================================
		
//De-Serialization: Starts with Main/Root class, so use Object of Main/Root
		
		String instructor = mn.getInstructor();
		System.out.println("Instructor Name = " +instructor);
		
		String experties = mn.getExperties();
		System.out.println("Experties is = " +experties);
		
		String linkedIn = mn.getLinkedIn();
		System.out.println("LinkedIn is = " +linkedIn);
		
		String services = mn.getServices();
		System.out.println("Services is = " +services);
		
		String url = mn.getUrl();
		System.out.println("Url is = " +url);
		
	//Courses Details:
		
		//c = mn.getCourses(); //storing all the courses into Courses class object c.
		//waList = c.getWebAutomation(); // Using Courses class object c, getting each courses into List
		
		//OR
		
		waList = mn.getCourses().getWebAutomation();
		System.out.println("");
		System.out.println("All WebAutomation Courses Details:");
		System.out.println("===============================================================");
		for(int i=0; i<waList.size();i++)
		{
			String courseTitle = waList.get(i).getCourseTitle();
			String price = waList.get(i).getPrice();
			System.out.println("Course Title = "+courseTitle+ ", Course Price ="+price);
		}
		
		

	}

}
