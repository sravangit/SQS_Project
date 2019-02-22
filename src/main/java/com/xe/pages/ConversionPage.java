package com.xe.pages;

import java.text.DecimalFormat;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.xe.util.Base;





public class ConversionPage extends Base {
	
	@FindBy(how = How.XPATH, using = "//span[contains(@class, 'converterresult-unitConversion')][2]")
	static WebElement conversionrate;
	
	@FindBy(how = How.XPATH, using = "//input[@name='Amount']")
	static WebElement value;
	
	@FindBy(how = How.XPATH, using = "//div[@class='converterresult-conversionTo']/span[contains(@class,'toAmount')]")
	static WebElement actualConversionValue;
	
	String getcurrencyFromValue = "EUR";
	String getcurrencyToValue = "GBP";
	
	public ConversionPage() {
		// using PageFactory class to initialize page object elements
		PageFactory.initElements(driver, this);
	}

	
	public void afterCoversion() {
		
		
		  //get the title of the page to display the currency exchange between 2 types of currecies
		  String expectedTitle = "XE Currency Converter: EUR to GBP";
		  String actualTitle = "XE Currency Converter: " +getcurrencyFromValue+ " to " +getcurrencyToValue;
		  Assert.assertEquals(actualTitle, expectedTitle, "currency exchange between 2 currencies are displayed");
		  
		  //check final result after conversion 
		  String conversionvalue = conversionrate.getText();
		  String conversionratesplit = conversionvalue.split(" ")[3];
		  System.out.println("current currency exchange: "+conversionratesplit);
		  double getCurrencyExchange = Double.valueOf(conversionratesplit);
		  DecimalFormat df = new DecimalFormat("###.#####");
		  double currentCurrencyExchange = Double.valueOf(df.format(getCurrencyExchange));
		  
		  double enteredValue = Double.valueOf(value.getAttribute("value"));
		  System.out.println("entered value1: "+enteredValue);
		  
		  double expectedvalue = enteredValue * currentCurrencyExchange;
		  System.out.println("expected value: "+expectedvalue);
		  
		  double finalvalue = Math.round(expectedvalue*100.0)/100.0;
		  System.out.println("rounded value: "+finalvalue);
		  
		  String actualvalue = actualConversionValue.getText();
		  String getactualvalueDouble = actualvalue.toString().replaceAll(",", "");
		  double finalresult = Double.valueOf(getactualvalueDouble);
		  double actualroundedValue = Math.round(finalresult*100.0)/100.0;
		  System.out.println("actual result after rounding: " +actualroundedValue);

		  //verifying if final result displayed is as expected
		  Assert.assertEquals(actualroundedValue, finalvalue);
				
		  System.out.println("----- Test Completed ------------");
	}
}
