package testcases;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseTest;

public class LoginTest extends BaseTest{

	@Test(dataProvider="testData")
	public static void loginTest(String username, String password, String pageTitle) throws InterruptedException {

        WebElement elementToHover = driver.findElement(By.xpath(loca.getProperty("my_account"))); 
        // Create an instance of Actions class
        Actions actions = new Actions(driver);
        //hover
        actions.moveToElement(elementToHover).perform();
        Thread.sleep(2000);
        driver.findElement(By.xpath(loca.getProperty("login_optn"))).click();
        Thread.sleep(2000);
        driver.findElement(By.id(loca.getProperty("email_field"))).sendKeys(username);
        driver.findElement(By.id(loca.getProperty("password_field"))).sendKeys(password);
        Thread.sleep(2000);
        driver.findElement(By.xpath(loca.getProperty("login_button"))).click();
        Thread.sleep(2000);
        // Verify the title
        String expectedTitle = pageTitle ;
        String actualTitle = driver.getTitle();
        Assertions.assertEquals(expectedTitle, actualTitle, "expected title is equal to actual title");

	}
	
	@DataProvider(name="testData")
	public Object[][] tData()
	{
		return new Object [][]{
			{"tom@gmail.com","Tom123","Account Login"},
			{" "," ","Account Login"},
			{"tom123@gmail.com","Tom@123","My Account"}
		};
				
	}
}
