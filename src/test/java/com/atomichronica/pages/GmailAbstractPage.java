package com.atomichronica.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class GmailAbstractPage {

	private final static long TIME_OUT_IN_SEC = 20;
	protected WebDriver driver;
	WebDriverWait waiter;
	Actions action;

	public GmailAbstractPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		waiter = new WebDriverWait(driver, TIME_OUT_IN_SEC);
		action = new Actions(driver);
	}
}
