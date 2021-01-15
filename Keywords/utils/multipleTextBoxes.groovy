package utils

import org.openqa.selenium.WebElement

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webui.common.WebUiCommonHelper

public class multipleTextBoxes {

	@Keyword
	//def fillMultipleTexBoxes(TestObject listObject, List<String> inputValues){
	def fillMultipleTexBoxes(TestObject listObject, String inputValues){
		List<WebElement> list = WebUiCommonHelper.findWebElements(listObject, 60);

		//		for(int i=0; i<list.size();i++){
		//			list[i].sendKeys(inputValues[i].toString());
		list[0].sendKeys(inputValues);
		//		}
	}
}
