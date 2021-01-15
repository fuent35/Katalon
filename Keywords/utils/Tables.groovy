package utils

import org.openqa.selenium.By
import org.openqa.selenium.WebElement

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webui.common.WebUiCommonHelper

public class Tables {
	@Keyword
	public static printTable(TestObject tableObject){
		List<WebElement> rows = WebUiCommonHelper.findWebElements(tableObject, 60);
		List<WebElement> rows2 = rows[0];
		println "all: " + rows;
		println "0: " + rows2;
	}
}
