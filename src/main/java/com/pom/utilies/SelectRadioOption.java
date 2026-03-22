package com.pom.utilies;

import java.util.List;

import org.openqa.selenium.WebElement;

public class SelectRadioOption {
 
	public static void selectRadios(List<WebElement> radios, String text) {
		for (WebElement rd : radios) {
			if(rd.getAttribute("value").equals(text)) {
				rd.click();
				break;
			}
		}
	}
}
