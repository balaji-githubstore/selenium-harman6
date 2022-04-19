package com.harman.advance;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Demo1FindElements {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "D:\\Software\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://www.google.com/");

		List<WebElement> elements = driver.findElements(By.tagName("a"));

		int linkCount = elements.size();
		System.out.println(linkCount);

		for (int i = 0; i < linkCount; i++) {
			String text = elements.get(i).getText();
			System.out.println(text);

			String href = elements.get(i).getAttribute("href");
			System.out.println(href);

			if (text.equals("Images")) {
				elements.get(i).click();
				break;
			}
			System.out.println("-----------------");
		}

	}
}
