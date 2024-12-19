package Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Deination {
	
	    WebDriver driver;

	    @Given("I open the Simple Form application")
	    public void i_open_the_simple_form_application() {
	       
	        driver = new ChromeDriver();
	        driver.manage().window().maximize();
	        driver.get("https://v1.training-support.net/selenium/simple-form");
	    }

	    @When("I fill in the form with the following details:")
	    public void i_fill_in_the_form_with_the_following_details(io.cucumber.datatable.DataTable dataTable) {
	        // Map the data from the table
	        java.util.Map<String, String> formData = dataTable.asMap(String.class, String.class);

	        // Fill the form
	        driver.findElement(By.id("firstName")).sendKeys(formData.get("firstName"));
	        driver.findElement(By.id("lastName")).sendKeys(formData.get("lastName"));
	        driver.findElement(By.id("email")).sendKeys(formData.get("email"));
	        driver.findElement(By.id("number")).sendKeys(formData.get("contact"));
	    }

	    @When("I click the submit button")
	    public void i_click_the_submit_button() {
	        driver.findElement(By.cssSelector(".ui.green.button")).click();
	    }

	    @Then("I should see the confirmation message")
	    public void i_should_see_the_confirmation_message() {
	        String message = driver.findElement(By.id("message")).getText();
	        Assert.assertTrue(message.contains("Thank You"), "Confirmation message mismatch!");
	        driver.quit();
	    }
	}

