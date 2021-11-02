package pageObjects;


import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class WWPage {

WebDriver driver = null;
	
	
	
	By studio = By.xpath("//*[@id=\"search-container\"]/div/div[2]/button/div/span");
	
    By textbox_search = By.id("location-search");
    
    By right_arrow = By.className("rightArrow-daPRP");
    
    By search_result = By.className("linkUnderline-1_h4g");
    
    By firstSearch_result = By.className("linkUnderline-1_h4g");
    
    By distance = By.className("distance-OhP63");
    
    By business_hours = By.className("title-3o8Pv");
    
    By days = By.className("dayName-CTNC6");
    
    By timings = By.className("times-fms3v");
    
    By location_title = By.className("locationName-1jro_");
    
    
    	
	public WWPage(WebDriver driver) {
		
		this.driver = driver;
		
	}
	
	
	public void clickStudio() {
		driver.findElement(studio).click();
		
	}
	
		public void setTextInSearchBox (String text) {
		driver.findElement(textbox_search).sendKeys(text);
	
	}
	
	public void clickSearchButton() {
		driver.findElement(right_arrow).click();
	}
	
	public void clickSearchResult() {
		driver.findElement(search_result).click();
	}
	
	public void clickBuisnessHours() {
		driver.findElement(business_hours).click();
	}
	
	public List<WebElement> getDays() {
		List<WebElement> myElements = driver.findElements(days);
		return myElements;
	}
	
	public List<WebElement> getTimings() {
		List<WebElement> allElements = driver.findElements(timings);
		return allElements;
	}

	public String getFirstSearchResult() {
		return driver.findElement(firstSearch_result).getText();
	}
	
	public String getDistance() {
		return driver.findElement(distance).getText();
	}
	
	public String getLocationTitle() {
		return driver.findElement(location_title).getText();
	}
	
}

