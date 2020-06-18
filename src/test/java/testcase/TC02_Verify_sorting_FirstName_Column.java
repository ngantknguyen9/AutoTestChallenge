package testcase;


import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.firefox.*;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import com.sun.istack.internal.logging.Logger;

import base.BaseClass;
import pageobject.LoginPage;
import pageobject.MainPage;;

public class TC02_Verify_sorting_FirstName_Column extends BaseClass {
	
	@Test
	public void TC02_Verify_sorting_FirstName_Column(){
	LoginPage login = new LoginPage(driver);
	MainPage mainpage = new MainPage(driver);

	//Login to the system
	login.LoginAction("admin@test.com", "test123");
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	
	// Descending Sorting from Original List
	List< String > descendingExpectedList = new ArrayList< String >();
	descendingExpectedList = mainpage.setDescendingExpectedList();
	System.out.println("Descending sorting as Expected: " + descendingExpectedList);
	//  Ascending Sorting from Original List
	List< String > ascendingExpectedList = new ArrayList< String >();
	ascendingExpectedList = mainpage.setAscendingExpectedList();
	System.out.println("Ascending sorting as Expected: " + ascendingExpectedList);
	System.out.println("------------");
	// Click on the header to Descending sorting 
	driver.findElement(By.xpath("//th[contains(text(),'First Name')]")).click();
	
	// Get Actual List after clicking sorting
	List< String > descendingActualList = new ArrayList< String >();
	descendingActualList = mainpage.getItemListColumn();
	System.out.println("Actual result-Descending sorting" + descendingActualList);
	// Verify ActualList and DescendingList
	assertTrue(descendingActualList.equals(descendingExpectedList));
	
	// Click on the header to Ascending sorting 
	driver.findElement(By.xpath("//th[contains(text(),'First Name')]")).click();
	
	// Get Actual List after clicking Ascending sorting 
	List< String > ascendingActualList = new ArrayList< String >();
	ascendingActualList = mainpage.getItemListColumn();
	System.out.println("Actual result-Ascending sorting" + ascendingActualList);
	
	// Verify ActualList and AscendingList
	assertTrue(ascendingActualList.equals(ascendingExpectedList));

	}
}
