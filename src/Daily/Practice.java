package Daily;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.TimeUnit;
import java.util.Set;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Practice {

	private static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://demo.opencart.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		Practice.login();

		Practice.searchProduct("iphone");

		Practice.clickComponents();

		Practice.clickIpad();

		Practice.sortPrice();

		Practice.clickAddCompare();

		Practice.clickProductCompare();

		Practice.clickPhoneLink();

		Practice.clickAddToCart();

		Practice.clickShoppingCart();

		Practice.clickCheckOut();

		Practice.clickOrderHistory();

		Practice.clickNewsLetter();

		Practice.clickSpecials();

		Practice.clickList();

		Practice.clickLogout();

		Thread.sleep(5000);
		// driver.close();
	}
	
	
	
	
	
	
	
	
	

	public static void login() {
		driver.findElement(By.xpath("//div[@id='top-links']//li[@class='dropdown']/a[@title='My Account']")).click();

		driver.findElement(By.xpath("//ul[@class='dropdown-menu dropdown-menu-right']//a[text()='Login']")).click();

		driver.findElement(By.xpath("//div[@class='well']//input[@name='email']")).sendKeys("srikanth875@gmail.com");

		driver.findElement(By.xpath("//div[@class='well']//div[@class='form-group']/input[@name='password']"))
				.sendKeys("Prince%456");

		driver.findElement(By.xpath("//div[@class='well']//input[@value='Login']")).click();

	}

	public static void searchProduct(String product) {
		driver.findElement(By.xpath("//input[@name='search' and @placeholder='Search']")).sendKeys(product);

		Actions actions = new Actions(driver);

		actions.sendKeys(Keys.ENTER).perform();

	}

	public static void clickComponents() {
		driver.findElement(
				By.xpath("//div[@class='collapse navbar-collapse navbar-ex1-collapse']//li/a[text()='Components']"))
				.click();

		driver.findElement(By.xpath("//ul[@class='list-unstyled']/li//a[text()='Monitors (2)']")).click();
	}

	public static void clickIpad() {
		driver.findElement(By.xpath("//ul[@class='nav navbar-nav']/li/a[text()='Phones & PDAs']")).click();
	}

	public static void sortPrice() {
		List<WebElement> priceSort = driver.findElements(By.xpath(
				"//div[@class='row']/div[@class='product-layout product-grid col-lg-4 col-md-4 col-sm-6 col-xs-12']//p[@class='price']/span"));

		List<Integer> list = new ArrayList<>();
		for (WebElement ele : priceSort) {
			String price = ele.getText();
			String[] spl = price.split(" ");
			for (String e : spl) {
				if (e.contains("$")) {
					String amount = e;
					int length = amount.length();
					String amt = amount.substring(1, length - 3);
					int sortPrice = Integer.parseInt(amt);
					list.add(sortPrice);
				}

			}

		}

		Collections.sort(list);

		for (int sort : list) {
			System.out.println("sorting the prices: " + sort);
		}
	}

	public static void clickAddCompare() {
		List<WebElement> addCompare = driver
				.findElements(By.xpath("//div[@class='button-group']//i[@class='fa fa-exchange']"));
		for (WebElement ele : addCompare) {
			ele.click();
		}

	}

	public static void clickProductCompare() {
		driver.findElement(By.xpath("//div[@id='content']//a[text()='Product Compare (0)']")).click();

	}

	public static void clickPhoneLink() {
		driver.findElement(By.xpath("(//table[@class='table table-bordered']//a)[1]")).click();

	}

	public static void clickAddToCart() {
		driver.findElement(By.xpath("//div[@id='product']//button[text()='Add to Cart']")).click();
	}

	public static void clickShoppingCart() {
		driver.findElement(By.xpath("//ul[@class='list-inline']//li//a[@title='Shopping Cart']")).click();
	}

	public static void clickCheckOut() {
		driver.findElement(By.xpath("//ul[@class='list-inline']//li//a[@title='Checkout']")).click();
	}

	public static void clickOrderHistory() {
		driver.findElement(By.xpath("//ul[@class='list-inline']//li/a[@title='My Account']")).click();
		driver.findElement(By.xpath("//ul[@class='dropdown-menu dropdown-menu-right']//li/a[text()='Order History']"))
				.click();
	}

	public static void clickNewsLetter() {
		driver.findElement(By.xpath("//div[@class='list-group']/a[text()='Newsletter']")).click();
	}

	public static void clickSpecials() {
		driver.findElement(By.xpath("//ul[@class='list-unstyled']/li/a[text()='Specials']")).click();
	}

	public static void clickList() {
		driver.findElement(By.xpath("//div[@class='btn-group btn-group-sm']/button[@id='list-view']")).click();
	}

	public static void clickLogout() {
		driver.findElement(By.xpath("//ul[@class='list-inline']/li//span[@class='caret']")).click();
		driver.findElement(By.xpath("//ul[@class='dropdown-menu dropdown-menu-right']/li/a[text()='Logout']")).click();
	}

}
