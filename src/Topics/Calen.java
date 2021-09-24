package Topics;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Calen {

	private static WebDriver driver;

	public static String[] getMonthYear(String montheYearval) {
		return montheYearval.split(" ");
	}

	public static void selectDate(String exMonth, String exYear) throws InterruptedException {
		String montheYearval = driver.findElement(By.xpath("(//div[@class='DayPicker-Caption'])[1]")).getText();
		System.out.println(montheYearval);
		String expDayMonYear = "Jul 17 2022";

		while (!(getMonthYear(montheYearval)[0].equals(exMonth) && getMonthYear(montheYearval)[1].equals(exYear))) { // inside
																														// loop
																														// (

			driver.findElement(By.xpath("//span[@aria-label='Next Month']")).click();
			montheYearval = driver.findElement(By.xpath("(//div[@class='DayPicker-Caption'])[1]")).getText();

		}
		Thread.sleep(3000);

		driver.findElement(
				By.xpath("//div[@class='DayPicker-Body']//div[contains(@aria-label,'" + expDayMonYear + "')]")).click();
	}

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.makemytrip.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.findElement(
				By.xpath("//ul[@class='userSection pushRight']/li[contains(@class,'makeFlex hrtlCenter font')]"))
				.click();

		driver.findElement(By.xpath("//label[@for='departure']")).click();

		new WebDriverWait(driver, 20).until(
				ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='datePickerContainer']")));

		selectDate("July", "2022");
		
		
		
		// WebDriverWait wait = new WebDriverWait(driver, 20);
		// wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@class='datePickerContainer']"))));

		Thread.sleep(3000);

		driver.close();

	}
}









/*
 * Make my trip String montheYearval =
 * driver.findElement(By.xpath("(//div[@class='DayPicker-Caption'])[1]")).
 * getText();
 * 
 * System.out.println(montheYearval);
 * 
 * String month = montheYearval.split(" ")[0].trim(); String year =
 * montheYearval.split(" ")[1].trim();
 * 
 * while (!(month.equals("July") && year.equals("2022"))) { // ! means if entire
 * condition satisfy then come // inside loop (
 * 
 * driver.findElement(By.xpath("//span[@aria-label='Next Month']")).click();
 * montheYearval =
 * driver.findElement(By.xpath("(//div[@class='DayPicker-Caption'])[1]")).
 * getText();
 * 
 * month = montheYearval.split(" ")[0].trim(); year =
 * montheYearval.split(" ")[1].trim();
 * 
 * } Thread.sleep(3000);
 * 
 * driver.findElement(By.
 * xpath("//div[@class='DayPicker-Body']//div[contains(@aria-label,'Jul 17 2022')]"
 * )).click();
 * 
 * Thread.sleep(3000);
 */