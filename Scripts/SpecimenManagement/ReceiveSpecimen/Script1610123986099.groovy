import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.Keys as Keys

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable as GlobalVariable

'Expand Specimen Manangement Menu'
WebUI.click(findTestObject('ReceiveSpecimen/01_SpecimenManagement'))

WebUI.click(findTestObject('ReceiveSpecimen/02_ReceiveSpecimen'))

WebUI.waitForElementNotPresent(findTestObject('ReceiveSpecimen/Loader'), 60)

WebUI.sendKeys(findTestObject('ReceiveSpecimen/03_SpecimenID'), GlobalVariable.SpecimenID)

WebUI.sendKeys(findTestObject('ReceiveSpecimen/03_SpecimenID'), Keys.chord(Keys.TAB))

WebUI.click(findTestObject('ReceiveSpecimen/04_ProductionRadio'))

WebUI.click(findTestObject('ReceiveSpecimen/05_ContainerListBox'))

CustomKeywords.'utils.listbox.selectOption'(findTestObject('ReceiveSpecimen/06_ContainerList'), 'MagBio Tube')

WebUI.click(findTestObject('ReceiveSpecimen/07_AddContainerButton'))

WebUI.sendKeys(findTestObject('ReceiveSpecimen/08_ContainerCount'), '96')

WebUI.click(findTestObject('ReceiveSpecimen/09_AddComments'))

WebUI.sendKeys(findTestObject('ReceiveSpecimen/10_TextAddComments'), 'Comment set by the automated script.')

WebUI.click(findTestObject('ReceiveSpecimen/11_CommentOK'))

WebUI.scrollToElement(findTestObject('ReceiveSpecimen/Save'), 30)

WebUI.click(findTestObject('ReceiveSpecimen/Save'))

WebUI.click(findTestObject('ReceiveSpecimen/13_button_close'))

GlobalVariable.SpecimenList = CustomKeywords.'utils.FillSpecimenList.fillList'(GlobalVariable.SpecimenID)

