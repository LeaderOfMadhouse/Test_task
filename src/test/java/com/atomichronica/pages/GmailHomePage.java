package com.atomichronica.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GmailHomePage extends GmailAbstractPage {
	
	private final static String COMPOSE_BTN = "//div[@class='T-I J-J5-Ji T-I-KE L3']";
	private final static String INBOX_BTN_XPATH = "//div[@class='TN bzz aHS-bnt']";
		
	@FindBy(xpath = COMPOSE_BTN)
	private WebElement composeBtn;
	
	@FindBy(xpath = INBOX_BTN_XPATH)
	private WebElement inboxBtn;
	
	public GmailHomePage(WebDriver driver) {
		super(driver);
	}
	
	public GmailDraftCreationPage compose() {
		composeBtn.click();
		return new GmailDraftCreationPage(driver);
	}
	
	public GmailInboxPage navigationToInboxMails() {
		inboxBtn.click();
		return new GmailInboxPage(driver);
	}
}
