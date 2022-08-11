package flightSearch;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import testSearch.InitialTest;

public class TestCases extends InitialTest{
	public WebDriver driver;
	@BeforeTest
	public void initialise()
	{
		driver = initializeDriver();
	}
	
	@Test(enabled=true)
	public void Test1()
	{
		//Test URL entered is proper
		
		System.out.println(driver.getCurrentUrl());
		String actual=driver.getCurrentUrl();
		String expected = "https://the-internet.herokuapp.com/challenging_dom";
		Assert.assertEquals(actual, expected);
		System.out.println(expected);
		
	}
	
	@Test(enabled=true)
	public void Test2()
	{
		//get title of the web page
		System.out.println("Title of web page is: "+driver.getTitle());
	}
	
	@Test(enabled=true)
	public void Test3()
	{
		//Assert the Challenging DOM text
		
		Assert.assertEquals("Challenging DOM", driver.findElements(By.cssSelector("div[class='example'] h3")).get(0).getText());
	}
	
	@Test(enabled=true)
	public void Test4()
	{
		//verify change in URL after clicking edit
		String actual=driver.getCurrentUrl();
		System.out.println("URL before clicking edit: "+actual);
		driver.findElement(By.cssSelector("a[href='#edit']")).click();
		
		Assert.assertEquals("https://the-internet.herokuapp.com/challenging_dom#edit", driver.getCurrentUrl());
		System.out.println("URL after clicking edit: "+driver.getCurrentUrl());
	}
	
	@Test(enabled=true)
	public void Test5()
	{
		//verify navigating back
		String actual=driver.getCurrentUrl();
		System.out.println("URL before navigating back: "+actual);
		driver.navigate().back();
		
		System.out.println("URL after navigating back: "+driver.getCurrentUrl());
	}
	
	@Test(enabled=true)
	public void Test6()
	{
		//verify change in URL after clicking delete
		String actual=driver.getCurrentUrl();
		System.out.println("URL before clicking delete: "+actual);
		driver.findElement(By.cssSelector("a[href='#delete']")).click();
		
		Assert.assertEquals("https://the-internet.herokuapp.com/challenging_dom#delete", driver.getCurrentUrl());
		System.out.println("URL after clicking delete: "+driver.getCurrentUrl());
	}
	
	
	
	@Test
	public void Test7()
	{
		//Click the blue button 
		driver.findElement(By.cssSelector("a.button")).click();
		
	}
	
	@Test
	public void Test8()
	{
		//Click the red button and get the text on the button
		System.out.println(driver.findElement(By.cssSelector("a.button.alert")).getText());
		
	}
	
	@Test
	public void Test9()
	{
		//Click the green button and check whether it is enabled
		System.out.println("Is the green button enabled: "+driver.findElement(By.cssSelector("a.button.success")).isEnabled());
		
	}
	
	@Test(enabled=true)
	public void Test10()
	{
		//verify URL refreshes
		String actual=driver.getCurrentUrl();
		System.out.println("URL before navigating back: "+actual);
		driver.navigate().refresh();;
		
		System.out.println("URL after navigating back: "+driver.getCurrentUrl());
	}
	
	
	
	@AfterTest
	public void tearDown()
	{
		closeDriver();
	}
	

}
