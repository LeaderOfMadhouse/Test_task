package com.atomichronica.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GmailInboxPage extends GmailAbstractPage {
	
	private final static String INBOX_OPEN_XPATH = "//td[@class='PF xY']";
	private final static String BODY_XPATH = "//div[@role='listitem']//div[@dir='ltr']";
	private final static String INBOX_AMOUNT_XPATH = "//div[@gh='tm']//span[@class='Dj']/span[@class='ts']";
	private int inboxAmtBfr;
	private int inboxAmtAftr;
	
	@FindBy(xpath = BODY_XPATH)
	private WebElement body;
	
	@FindBy(xpath = INBOX_OPEN_XPATH)
	private WebElement inboxMail;
	
	@FindBy(xpath = INBOX_AMOUNT_XPATH)
	private WebElement inboxAmnt;
	
	public GmailInboxPage(WebDriver driver) {
		super(driver);
	}
	
	public int verifyingInboxAmtBfr() {
		String inboxAmount = inboxAmnt.getText();
		inboxAmtBfr = Integer.parseInt(inboxAmount);
		return inboxAmtBfr;
	}
	
	public int verifyingInboxAmtAftr() throws InterruptedException {
		Thread.sleep(2000);
		String inboxAmount = inboxAmnt.getText();
		inboxAmtAftr = Integer.parseInt(inboxAmount);
		return inboxAmtAftr;
	}
	
	public String verifyingBody() {
		inboxMail.click();
		body.getText();
		return new String(body.getText());
	}
}
