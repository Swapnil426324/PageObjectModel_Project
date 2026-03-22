package com.pom.utilies;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class SelectUtils {

	public static void selectDropdown(WebElement element, String text) {
		Select select = new Select(element);
		select.selectByVisibleText(text);
	}
}
