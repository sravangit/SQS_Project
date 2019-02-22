package com.xe.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Base {

	public static WebDriver driver;
	public static Properties prop = new Properties();

	public Base() {

		try {

			prop = new Properties();
			String location = System.getProperty("user.dir");
			System.out.println("location is: " + location);
			FileInputStream fis = new FileInputStream(
					System.getProperty("user.dir") + "\\src\\main\\java\\config\\config.properties");
			prop.load(fis);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.getMessage();
		}

	}

	public static void driverInitialization() {

		String browserName = prop.getProperty("browser");

		if (browserName.equalsIgnoreCase("chrome")) {

			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "//browserDrivers//chromedriver.exe");
			driver = new ChromeDriver();

		}

		else if (browserName.equalsIgnoreCase("firefox")) {

			System.setProperty("webdriver.gecko.driver",
					System.getProperty("user.dir") + "//browserDrivers//geckodriver.exe");
			driver = new FirefoxDriver();

		}

		else if (browserName.equalsIgnoreCase("ie")) {

			System.setProperty("webdriver.ie.driver",
					System.getProperty("user.dir") + "//browserDrivers//IEDriverServer.exe");
			driver = new InternetExplorerDriver();

		}

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(prop.getProperty("url"));
		// driver.quit();
	}

}
