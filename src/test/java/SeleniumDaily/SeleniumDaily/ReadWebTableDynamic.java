package SeleniumDaily.SeleniumDaily;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;

public class ReadWebTableDynamic {
	
	
	@FindBy(xpath = "//table[@class='dataTable']/tbody/tr/td[1]")
	WebElement companyHeader;
	
	@FindBy(xpath = "//table[@class='dataTable']/tbody/tr/td[1]")
	WebElement group;
	
	@FindBy(xpath = "//table[@class='dataTable']/thead/tr/th[2]")
	WebElement prevClose;
	
	List<WebElement> list;
	List<String> list2;
	
	static
	{
		String path = System.getProperty("user.dir");
		System.out.println(path);
		System.setProperty("webdriver.chrome.driver", path+"\\BrowserDrivers\\chromedriver.exe");
	}
	
	 WebDriver driver = new ChromeDriver();
	
	 
	 public List<String> getAnyColData(int columnNo)
	 {
		 list  = new ArrayList<WebElement>();
		 list = driver.findElements(By.xpath("//table[@class='dataTable']/tbody/tr/td["+columnNo+"]"));
		 list2 = new ArrayList<String>();
		 for(WebElement w : list)
		 {
			list2.add(w.getText()) ;
		 }
		 //System.out.println(list2.toString());
		return list2 ;
	 }
	 
	 public List<String> getAnyRowData(int rowNo)
	 {
		 list  = new ArrayList<WebElement>();
		 list = driver.findElements(By.xpath("//table[@class='dataTable']/tbody/tr["+rowNo+"]"));
		 list2 = new ArrayList<String>();
		 for(WebElement w : list)
		 {
			list2.add(w.getText()) ;
		 }
		 //System.out.println(list2.toString());
		return list2 ;
	 }
	 
	 
	@Test
	public void testClass()
	{
		
		driver.get("http://demo.guru99.com/test/web-table-element.php#");
		driver.manage().window().maximize();
		System.out.println(getAnyColData(4));
		System.out.println(getAnyRowData(1));

		
		
		
		
		
	}

}
