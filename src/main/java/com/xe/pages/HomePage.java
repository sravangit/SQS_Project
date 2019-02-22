package com.xe.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.xe.util.Base;

public class HomePage extends Base {

	// Using FindBy for locating elements
	@FindBy(how = How.XPATH, using = "//*[contains(text(), 'From')]/parent::div")
	static WebElement currencyFromDropdown;

	@FindBy(how = How.XPATH, using = "//*[contains(text(), 'To')]/parent::div")
	static WebElement currencyToDropdown;

	@FindBy(how = How.ID, using = "amount")
	static WebElement amountField;

	@FindBy(how = How.XPATH, using = "//button[contains(@class, 'submit')]")
	static WebElement submitButton;

	public HomePage() {
		// using PageFactory class to initialize page object elements
	   PageFactory.initElements(driver, this);
	}

	public void enterCurrency(double currencyValue) {



		// find currency_from_field and select a currency
		// implicit wait to wait until element is loaded on the page
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Actions action = new Actions(driver);
		action.moveToElement(currencyFromDropdown).click().build().perform();
		action.moveToElement(driver.findElement(By.xpath("//*[contains(text(), 'EUR')]")))
				.click(driver.findElement(By.xpath("//*[contains(text(), 'EUR')]"))).build().perform();

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		String getcurrencyFromValue = driver
				.findElement(By.xpath("//div/label[@for='from']//..//div/span[@class='dropdown-currencyCode']"))
				.getText();
		System.out.println("currency value 1: " + getcurrencyFromValue);

		// find currency_to_field and select a currency
		action.moveToElement(currencyToDropdown).click().build().perform();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		action.moveToElement(driver.findElement(By.xpath("//*[contains(text(), 'GBP')]")))
				.click(driver.findElement(By.xpath("//*[contains(text(), 'GBP')]"))).build().perform();

		String getcurrencyToValue = driver
				.findElement(By.xpath("//div/label[@for='to']//..//div/span[@class='dropdown-currencyCode']"))
				.getText();
		System.out.println("currency value 2: " + getcurrencyToValue);

		// enter value for currency exchange
		amountField.sendKeys(String.valueOf(currencyValue));

		submitButton.click();

	}

}
