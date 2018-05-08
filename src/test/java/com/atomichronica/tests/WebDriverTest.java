package com.atomichronica.tests;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.atomichronica.pages.GmailHomePage;
import com.atomichronica.pages.GmailInboxPage;
import com.atomichronica.pages.GmailLoginPage;

public class WebDriverTest {

	private final static String URL = "https://gmail.com/";
	private final static String EXPECTED_MESSAGE_TEXT = "Hello, world!";
	private WebDriver driver;
	private int inboxBfr;
	private int inboxAftr;
	private String messageText;

	@BeforeClass
	public void setUp() throws MalformedURLException {
		ChromeOptions options = new ChromeOptions();
		driver = new ChromeDriver(options);
		options.setCapability("platformName", Platform.WINDOWS);
		driver.get(URL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	@Test(description = "mail delivering")
	public void deliveringMail() throws InterruptedException {
		new GmailLoginPage(driver).login();
		inboxBfr = new GmailInboxPage(driver).verifyingInboxAmtBfr();
		new GmailHomePage(driver).compose().draftCreation().sendMail().navigationToInboxMails();
		inboxAftr = new GmailInboxPage(driver).verifyingInboxAmtAftr();
		Assert.assertEquals(inboxAftr, inboxBfr + 1);
	}

	@Test(description = "message text verifying", dependsOnMethods = { "deliveringMail" })
	public void textVerifying() {
		messageText = new GmailInboxPage(driver).verifyingBody();
		Assert.assertEquals(messageText, EXPECTED_MESSAGE_TEXT);
	}

	@AfterClass
	public void loggOff() {
		driver.quit();
	}
}
