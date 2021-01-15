package utils

import org.openqa.selenium.WebElement

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webui.common.WebUiCommonHelper

public class listbox {

	@Keyword
	def selectOption(TestObject listObject, String optionToSelect){
		List<WebElement> list = WebUiCommonHelper.findWebElements(listObject, 60);
		println "Option to select " + optionToSelect;
		for(int i=0; i<list.size();i++){
			println "Option in the list " + list[i].toString();
			
			if(list[i].text.equals(optionToSelect)){
				list[i].click();
			}
		}
	}
}