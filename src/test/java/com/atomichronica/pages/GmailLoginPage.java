package com.atomichronica.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class GmailLoginPage extends GmailAbstractPage {
	
	private final static String LOGIN_ID = "identifierId";
	private final static String LOGIN = "tatyanasmirnova0314";
	private final static String NEXT_BTN_1 = "identifierNext";
	private final static String PASSWORD_NAME = "password";
	private final static String PASSWORD = "iPipelineTest";
	private final static String NEXT_BTN_2 = ".RveJvd.snByac";

	@FindBy(id = LOGIN_ID)
	private WebElement login;

	@FindBy(id = NEXT_BTN_1)
	private WebElement nextBtn1;

	@FindBy(name = PASSWORD_NAME)
	private WebElement password;

	@FindBy(css = NEXT_BTN_2)
	private WebElement nextBtn2;

	public GmailLoginPage(WebDriver driver) {
		super(driver);
	}
	
	public GmailHomePage login() {
		login.sendKeys(LOGIN);
		nextBtn1.click();
		password.sendKeys(PASSWORD);
		waiter.until(ExpectedConditions.elementToBeClickable(By.cssSelector(NEXT_BTN_2)));
		nextBtn2.click();
		return new GmailHomePage(driver);
	}
}
