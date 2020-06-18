package testcase;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import base.BaseClass;
import pageobject.LoginPage;
import pageobject.MainPage;;
public class TC01_Verify_student_inactive extends BaseClass {

	@Test
	public void TC01_Verify_student_inactive(){
		
		LoginPage login = new LoginPage(driver);
		MainPage mainpage = new MainPage(driver);
		
		//Login to the system
		login.LoginAction("admin@test.com", "test123");
		
		// Click on Filters button
		mainpage.clickFilterButton();
		
		//Filter Student Access Request with INACTIVE
		mainpage.filterStudentStatus("Inactive");
		mainpage.clickApplyFilterButton();
		
		//Verify result of filter Student Access Request with INACTIVE
		mainpage.verifyFilterRequestStatus("Inactive");
	}

}
