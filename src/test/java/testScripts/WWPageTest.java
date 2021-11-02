package testScripts;


import java.util.List;
import java.util.concurrent.TimeUnit;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObjects.WWPage;



public class WWPageTest {

	public static void main(String[] args) {

		wwTest();

	}

	public static void wwTest() {

		System.setProperty("webdriver.chrome.driver", "/Users/anuperumal/Desktop/chromedriver");
		
		//launching the chrome browser
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		WWPage wwPageObjects = new WWPage(driver);

		driver.get(" https://www.weightwatchers.com/us/find-a-workshop/");

		String actualTitle = "Find WW Studios & Meetings Near You | WW USA";

		//asserting the title of the page
		Assert.assertEquals(driver.getTitle(), actualTitle);
		
		System.out.println("Page title is : " + driver.getTitle());
		System.out.println();
		
       //clicking the studio option
		wwPageObjects.clickStudio();

		//Searching for studio options by providing a pincode
		wwPageObjects.setTextInSearchBox("10011");

		wwPageObjects.clickSearchButton();

		//scrolling down the page
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript(("window.scrollBy(0,250)"));
		
        //Getting the search result and the distance
		String searchResult = wwPageObjects.getFirstSearchResult();
		String distance = wwPageObjects.getDistance();
		System.out.println("The title of the first result and distance :  " + searchResult + "     " + distance);
		System.out.println();
		

		wwPageObjects.clickSearchResult();
		
		
		//Verifying the search result on the find a workshop location page
		if (wwPageObjects.getLocationTitle().contains(searchResult)) {
				
			System.out.println("The first displayed search result is correct : " + wwPageObjects.getLocationTitle());
			System.out.println();
		}
		
		else {
			System.out.println("The first displayed search result is incorrect" + wwPageObjects.getLocationTitle());
			System.out.println();
		}
		
		js.executeScript(("window.scrollBy(0,250)"));

		wwPageObjects.clickBuisnessHours();

		//Method to print the business hours
		List<WebElement> dayName = wwPageObjects.getDays();           
		List<WebElement> times = wwPageObjects.getTimings();

		for (int i = 0; i < dayName.size(); i++) {
			System.out.print(dayName.get(i).getText() + "  ");
			System.out.print(times.get(i).getText() + "  ");
			System.out.println();
			System.out.println();
		}

		driver.close();

	}
}
