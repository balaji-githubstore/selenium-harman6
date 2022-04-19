package com.harman.multipletabs;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Demo1DBFree {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "D:\\Software\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		driver.get("https://www.db4free.net/");
		
		driver.findElement(By.partialLinkText("phpMy")).click();
		
		List<String> windows=new ArrayList<String>(driver.getWindowHandles());
		
		System.out.println(windows.get(0));//1st tab session id
		System.out.println(windows.get(1));//2nd tab session id
		
		driver.switchTo().window(windows.get(1)); //switching to 2nd tab
		
		driver.findElement(By.id("input_username")).sendKeys("admin");
		driver.findElement(By.id("input_password")).sendKeys("admin");
		driver.findElement(By.id("input_go")).click();
		
		String text=driver.findElement(By.xpath("(//div[@class='alert alert-danger'])[3]")).getText();
		System.out.println(text);
		
//		driver.close(); //check which tab is getting closed
		driver.quit(); //close the browser
		
	}
}
