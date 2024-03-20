package sit707_week2;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class SeleniumOperations2 {

	public static void sleep(int sec) {
		try {
			Thread.sleep(sec*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public static void macfixit_registration_page(String url) {
		// Step 1: Locate chrome driver folder in the local drive.
				System.setProperty("webdriver.chrome.driver", "D:\\\\Java Projects\\\\chromedriver-win64\\\\chromedriver-win64\\\\chromedriver.exe");
				
				// Step 2: Use above chrome driver to open up a chromium browser.
				System.out.println("Fire up chrome browser.");
				WebDriver driver = new ChromeDriver();
				WebDriverWait wait = new WebDriverWait(driver, 10);
				System.out.println("Driver info: " + driver);
				
				sleep(2);
			
				// Load a webpage in chromium browser.
				driver.get(url);
				
		
		       
				WebElement element = driver.findElement(By.id("register_first_name"));
		        System.out.println("Found element: " + element);
		        element.sendKeys("Dhruv");
		        
		        WebElement lastnameInput = driver.findElement(By.id("register_last_name"));
		        System.out.println("Found element: " + lastnameInput);
		        lastnameInput.sendKeys("Kaswala");
				
		        WebElement emailInput = driver.findElement(By.id("register_email"));
		        System.out.println("Found element: " + emailInput);
		        emailInput.sendKeys("s223676061@deakin.edu.au");
		        
		        
		        WebElement passwordInput = driver.findElement(By.id("register_password"));
		        System.out.println("Found element: " + passwordInput);
		        passwordInput.sendKeys("Deakinuniversity@123");
		        

		        WebElement createAccountButton = driver.findElement(By.xpath("//button[contains(text(),'Create')]"));
		        System.out.println("Found element: " + createAccountButton);
		        createAccountButton.click();

		        // Take screenshot after submitting the form
		        takeScreenshot(driver, "registration_page");

	    	// Sleep a while
			sleep(2);
			
			// close chrome driver
			driver.close();	
	
	
	}
	   // Method to take screenshot
    public static void takeScreenshot(WebDriver driver, String fileName) {
        try {
            // Convert WebDriver instance to TakesScreenshot
            TakesScreenshot screenshot = (TakesScreenshot) driver;

            // Capture screenshot as File
            File sourceFile = screenshot.getScreenshotAs(OutputType.FILE);

            // Define destination file path and copy the screenshot file
            File destinationFile = new File(fileName + ".png");
            FileUtils.copyFile(sourceFile, destinationFile);

            // Print success message
            System.out.println("Screenshot taken and saved as '" + fileName + ".png'");
        } catch (Exception e) {
            // Print error message
            System.out.println("Failed to take screenshot: " + e.getMessage());
        }
    }
	
	
}
