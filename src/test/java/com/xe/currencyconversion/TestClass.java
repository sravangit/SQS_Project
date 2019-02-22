package com.xe.currencyconversion;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.xe.pages.ConversionPage;
import com.xe.pages.HomePage;
import com.xe.util.Base;

public class TestClass extends Base {

	public static FluentWait<WebDriver> wait;
	static HomePage homepage;
	static ConversionPage conversionpage;

	public TestClass() {

		super();
	}

	/**
	 * this testng beforemethod is to setup WebDriver of a particular browser and
	 * launch application before test method executes
	 * 
	 * 
	 */
	@BeforeMethod
	public void setup() {

		driverInitialization();
		homepage = new HomePage();
		conversionpage = new ConversionPage();

	}

	/**
	 * This is test method for testing currency exchange with different set of test
	 * data
	 * 
	 *
	 */

	@Test(dataProvider = "data")
	public static void f(double currencyValue) {

		homepage.enterCurrency(currencyValue);
		conversionpage.afterCoversion();

	}

	/**
	 * this is DataProvider method and returns object arrays for using parameters
	 * for test data
	 * 
	 * @return
	 */

	@DataProvider(name = "data")
	public static Object[][] values() {
		Object[][] data = new Object[5][1];

		data[0][0] = 125.24;
		data[1][0] = 132.32;
		data[2][0] = 185.25;
		data[3][0] = 223.67;
		data[4][0] = 345.21;

		return data;
	}

	/**
	 * this method executes after each test method to close the driver
	 */
	@AfterMethod
	public void tearDown() {

		driver.quit();
	}

}
