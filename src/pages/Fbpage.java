package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Fbpage {

	@FindBy(id = "email")
	private WebElement emailBox;

	@FindBy(id = "pass")
	private WebElement passwordBox;

	@FindBy(xpath = "//button[text()='Log In']")
	private WebElement loginBtn;

	@FindBy(xpath = "//div[@class='j83agx80 l9j0dhe7']/div[@aria-label='Account']")
	private WebElement logoutMenu;

	@FindBy(xpath = "//div[@class='a8nywdso sj5x9vvc rz4wbd8a ecm0bbzt']//div/span")
	private WebElement logoutBtn;

	public void enterEmail() {
		emailBox.sendKeys("kumarsai862");
	}

	public void enterPassword() {
		passwordBox.sendKeys("sairokz");
	}

	public void clickLogin() {
		loginBtn.click();
	}

	public void clickLogout() {
		logoutMenu.click();
		logoutBtn.click();
	}

}
