package com.harman.basics;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Demo3FBSignUp {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "D:\\Software\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		driver.get("https://www.facebook.com/");

		driver.findElement(By.linkText("Create New Account")).click();	
		driver.findElement(By.name("firstname")).sendKeys("Balaji");
		driver.findElement(By.name("lastname")).sendKeys("Dinakaran");
		driver.findElement(By.name("reg_email__")).sendKeys("hello123@gmail.com");
		driver.findElement(By.name("reg_email_confirmation__")).sendKeys("hello123@gmail.com");
		driver.findElement(By.id("password_step_input")).sendKeys("welcome123");
		
		driver.findElement(By.xpath("//input[@value='-1']")).click();
		
		Select selectDay=new Select(driver.findElement(By.id("day")));
		selectDay.selectByVisibleText("9");	
		
		Select selectMon=new Select(driver.findElement(By.name("birthday_month")));
		selectMon.selectByValue("11");
		
		//select year 2000
		
		//click on sign up
		driver.findElement(By.name("websubmit")).click();
	}

}
