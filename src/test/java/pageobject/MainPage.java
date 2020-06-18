package pageobject;

import static org.testng.Assert.assertTrue;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class MainPage {

	WebDriver driver;
	
	By btnFilters = By.xpath("//button[(text()=' Filters')]");
	By RequestStatus_filter = By.id("formControlsSelect");
	By btnApplyFilters = By.xpath("//button[(text()='Apply Filters')]");
	
	public MainPage(WebDriver driver){
		this.driver = driver;
	}
	
	public void clickFilterButton(){
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(btnFilters).click();
	}
	
	public void filterStudentStatus(String status){
		Select Rstatus = new Select(driver.findElement(RequestStatus_filter));
		Rstatus.selectByVisibleText(status);
	}
	
	public void clickApplyFilterButton(){
		driver.findElement(btnApplyFilters).click();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	}
	
	public void verifyFilterRequestStatus(String requestStatus){
		List<WebElement> rows = driver.findElements(By.xpath("//div[@class='react-bs-container-body']/table/tbody/tr"));
		for(int i=0; i<rows.size(); i++) {
		    List<WebElement> cols = rows.get(i).findElements(By.tagName("td"));
		    String actualStatus = cols.get(1).getText();
		    System.out.println("Request Status: " + actualStatus );
		    try{
		    	Assert.assertEquals(actualStatus,requestStatus,"Error: Filter Student");
		    }
		    catch (WebDriverException e) {
		    	System.out.println(e.getMessage());
		    }
		}
	}
	
	
	public List< String > getItemListColumn(){
		List<WebElement> rows = driver.findElements(By.xpath("//div[@class='react-bs-container-body']/table/tbody/tr"));
		List<String> originalList = new ArrayList<String>();
		for(int i=0; i<rows.size(); i++) {
		    List<WebElement> cols = rows.get(i).findElements(By.tagName("td"));
		    String firstName = cols.get(5).getText();	    
		    originalList.add(firstName);
		}
		
		return originalList;
	}
	
	public List< String > setDescendingExpectedList(){
		List< String > expectedList = new ArrayList< String >();
		expectedList.addAll(getItemListColumn());
		Collections.sort(expectedList, Collections.reverseOrder());
		return expectedList;
	}
	
	public List< String > setAscendingExpectedList(){
		List< String > expectedList = new ArrayList< String >();
		expectedList.addAll(getItemListColumn());
		Collections.sort(expectedList);
		return expectedList;
	}
	
}
