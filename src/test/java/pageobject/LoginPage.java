package pageobject;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class LoginPage {
	
	WebDriver driver;
	
	By email = By.xpath("//input[@id='formHorizontalEmail']");
	By password = By.name("password");
	By btnLogin = By.className("col-login__btn");
	By btnFilters = By.xpath("//button[(text()=' Filters')]");
	public LoginPage(WebDriver driver){
		this.driver = driver;
	}
	
	public void LoginAction(String user, String pass){
		driver.findElement(email).sendKeys(user);
		driver.findElement(password).sendKeys(user);
		driver.findElement(btnLogin).click();
	}

}
