import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.Keys as Keys

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable as GlobalVariable

List<String> hello = new ArrayList()

hello = GlobalVariable.SpecimenList

WebUI.click(findTestObject('ProcessSpecimen/01_ProcessSpecimen'))

for(int i =0; i<= hello.size(); i++){
	TestObjectHelper.
	
	WebUI.sendKeys(findTestObject('ProcessSpecimen/02_SourceContainer'), hello[i])
	
	WebUI.sendKeys(findTestObject('ProcessSpecimen/02_SourceContainer'), Keys.chord(Keys.TAB))
	
	WebUI.scrollToElement(findTestObject('ProcessSpecimen/ReagentList'), 60)
}

WebUI.click(findTestObject('ProcessSpecimen/ReagentListBox'))

CustomKeywords.'utils.listbox.selectOption'(findTestObject('ProcessSpecimen/ReagentList'), 'Kit')

WebUI.click(findTestObject('ProcessSpecimen/AddReagentButton'))

WebUI.sendKeys(findTestObject('ProcessSpecimen/KitBarcode'), GlobalVariable.Kit)

WebUI.click(findTestObject('ProcessSpecimen/ReagentListBox'))

CustomKeywords.'utils.listbox.selectOption'(findTestObject('ProcessSpecimen/ReagentList'), 'Reagent')

WebUI.click(findTestObject('ProcessSpecimen/AddReagentButton'))

WebUI.sendKeys(findTestObject('ProcessSpecimen/ReagentBarcode'), GlobalVariable.Reagent)

WebUI.click(findTestObject('ReceiveSpecimen/09_AddComments'))

WebUI.sendKeys(findTestObject('ReceiveSpecimen/10_TextAddComments'), 'Comment set by the automated script.')

WebUI.click(findTestObject('ReceiveSpecimen/11_CommentOK'))

WebUI.scrollToElement(findTestObject('ReceiveSpecimen/Save'), 60)

WebUI.click(findTestObject('ReceiveSpecimen/Save'))

WebUI.waitForElementPresent(findTestObject('ProcessSpecimen/Print_BarcodesD_Dialog_Box'), 60)

WebUI.click(findTestObject('ProcessSpecimen/button_close'))

