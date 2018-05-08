package com.atomichronica.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GmailDraftCreationPage extends GmailAbstractPage{
		
	private final static String ADDRESSEE_XPATH = "//div[@class='oj']//textarea[@aria-label='To']";
	private final static String SUBJECT_XPATH = "//div[@class='aoD az6']/input[@name='subjectbox']";
	private final static String MESSAGE_XPATH = "//div[@aria-label='Message Body']";
	private final static String ADDRESSEE = "tatyanasmirnova0314@gmail.com";
	private final static String SUBJECT = "Test mail";
	private final static String MESSAGE = "Hello, world!"; 
	private final static String SEND_BTN = "//div[@class='J-J5-Ji btA']/div[@role='button']";
	
	@FindBy(xpath = ADDRESSEE_XPATH)
	private WebElement addressee;
		
	@FindBy(xpath = SUBJECT_XPATH)
	private WebElement subject;
	
	@FindBy(xpath = MESSAGE_XPATH)
	private WebElement message;
		
	@FindBy(xpath = SEND_BTN)
	private WebElement sendBtn;
					
	public GmailDraftCreationPage(WebDriver driver) {
		super(driver);
		}
	
	public GmailDraftCreationPage draftCreation() {
		action.sendKeys(addressee,ADDRESSEE).click(subject).sendKeys(subject,SUBJECT).sendKeys(message,MESSAGE).build().perform();
		return new GmailDraftCreationPage(driver);
	}
	
	public GmailHomePage sendMail() {
	    sendBtn.click();
	    return new GmailHomePage(driver);
	}
}
