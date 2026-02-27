package stepdefinitions;

	import java.io.File;
	import org.openqa.selenium.Alert;
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;

	import io.cucumber.java.en.*;
	import utilities.DriverFactory;

	public class PharmacySteps {


	    WebDriver driver;

	    @Given("user opens the pharmacy application")
	    public void openApplication() throws InterruptedException {
	        driver = DriverFactory.initDriver();

	        File file = new File("src/test/resources/pharmacy-app/pharmacy.html");
	        driver.get(file.getAbsolutePath());

	        Thread.sleep(2000);
	    }

	    @When("user logs in with valid credentials")
	    public void login() throws InterruptedException {
	        driver.findElement(By.id("username")).sendKeys("pharmacyuser");
	        Thread.sleep(2000);

	        driver.findElement(By.id("password")).sendKeys("password123");
	        Thread.sleep(2000);

	        driver.findElement(By.id("loginBtn")).click();
	        Thread.sleep(2000);

	        Alert alert = driver.switchTo().alert();
	        System.out.println(alert.getText());
	        alert.accept();

	        Thread.sleep(2000);
	    }

	    @When("user searches for a medicine")
	    public void searchMedicine() throws InterruptedException {
	        driver.findElement(By.id("searchBox")).sendKeys("Paracetamol");
	        Thread.sleep(2000);

	        driver.findElement(By.id("searchBtn")).click();
	        Thread.sleep(2000);

	        Alert alert = driver.switchTo().alert();
	        System.out.println(alert.getText());
	        alert.accept();

	        Thread.sleep(2000);
	    }

	    @When("user adds medicine to cart")
	    public void addToCart() throws InterruptedException {
	        driver.findElement(By.id("addToCart")).click();
	        Thread.sleep(2000);

	        Alert alert = driver.switchTo().alert();
	        System.out.println(alert.getText());
	        alert.accept();

	        Thread.sleep(2000);
	    }

	    @Then("user places the order successfully")
	    public void placeOrder() throws InterruptedException {
	        driver.findElement(By.id("checkout")).click();
	        Thread.sleep(2000);

	        Alert alert = driver.switchTo().alert();
	        System.out.println(alert.getText());
	        alert.accept();

	        Thread.sleep(2000);
	        driver.quit();
	    }
	}