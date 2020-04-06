package com.stepdefinition;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;

public class AddCustomerSteps {
	

	

	@Given("user clicks on add customer button")
	public void user_clicks_on_add_customer_button() throws Throwable  {
		try {
		handleframe();
		}catch(Exception e) {
			
		}
	Hook.driver.findElement(By.xpath("(//a[text()='Add Customer'][1])")).click();
	
	}

	@When("user enters all the fields")
	public void user_enters_all_the_fields() throws Throwable {
		try {
			handleframe();
			}catch(Exception e) {
				
			}
		Hook.driver.findElement(By.xpath("//label[@for='done'][1]")).click();
		Hook.driver.findElement(By.id("fname")).sendKeys("joe");
		Hook.driver.findElement(By.id("lname")).sendKeys("josef");
		Hook.driver.findElement(By.id("email")).sendKeys("djd@gmail.com");
		Hook.driver.findElement(By.name("addr")).sendKeys("tambaram");
		Hook.driver.findElement(By.id("telephoneno")).sendKeys("9884739293");
		
	}
	@When("user enters all the fields with one dimensional")
	public void user_enters_all_the_fields_with_one_dimensional(DataTable customerdata) throws Throwable {
		try {
			handleframe();
			}catch(Exception e) {
				
			}
		List<String> data= customerdata.asList(String.class);
		Hook.driver.findElement(By.xpath("//label[@for='done'][1]")).click();
		Hook.driver.findElement(By.id("fname")).sendKeys(data.get(0));
		Hook.driver.findElement(By.id("lname")).sendKeys(data.get(1));
		Hook.driver.findElement(By.id("email")).sendKeys(data.get(2));
		Hook.driver.findElement(By.name("addr")).sendKeys(data.get(3));
		Hook.driver.findElement(By.id("telephoneno")).sendKeys(data.get(4));
	    
	}
	@When("user enters all the fields with one dimensional map")
	public void user_enters_all_the_fields_with_one_dimensional_map(DataTable customerdata) throws Throwable {
		Map<String, String> data = customerdata.asMap(String.class, String.class);
		
		try {
			handleframe();
			}catch(Exception e) {
				
			}
		Hook.driver.findElement(By.xpath("//label[@for='done'][1]")).click();
		Hook.driver.findElement(By.id("fname")).sendKeys(data.get("Fname"));
		Hook.driver.findElement(By.id("lname")).sendKeys(data.get("Lname"));
		Hook.driver.findElement(By.id("email")).sendKeys(data.get("Email"));
		Hook.driver.findElement(By.name("addr")).sendKeys(data.get("Address"));
		Hook.driver.findElement(By.id("telephoneno")).sendKeys(data.get("phno"));
	    
	}
	
	@When("user clicks on the submit button")
	public void user_clicks_on_the_submit_button() throws Exception {
		
	Hook.driver.findElement(By.xpath("//input[@value='Submit'][1]")).click();
		}

	@Then("user should be displayed customer ID is generated or not")
	public void user_should_be_displayed_customer_ID_is_generated_or_not() throws Throwable {
		try {
		handleframe();
		}catch(Exception e) {
			
		}
		org.junit.Assert.assertTrue(Hook.driver.findElement(By.xpath("//td[@align='center'][2]")).isDisplayed());
		String text = Hook.driver.findElement(By.xpath("(//td[@align='center'])[2]")).getText();
		   System.out.println(text);
		   

	}
public void handleframe() throws Throwable {
	Thread.sleep(3000);
	Hook.driver.switchTo().frame(Hook.driver.findElement(By.xpath("//*[@id=\"flow_close_btn_iframe\"]")));
	 Hook.driver.findElement(By.id("closeBtn")).click();
	 Hook.driver.switchTo().parentFrame();
}

}
