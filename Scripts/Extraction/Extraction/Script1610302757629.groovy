import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.common.WebUiCommonHelper as WebUiCommonHelper
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

'Expand Workflow Section from the Menu'
WebUI.click(findTestObject('Extraction/01_Workflow'))

'Select Extraction Task from the menu'
WebUI.click(findTestObject('Extraction/02_Extraction'))

'Wait until Extraction Type Select Box is clickable.'
WebUI.waitForElementClickable(findTestObject('Extraction/03_Extraction_Type'), 60)

'Click on Extraction Type Select Box'
WebUI.click(findTestObject('Extraction/03_Extraction_Type'))

'Select Option from the Select Box.'
CustomKeywords.'utils.listbox.selectOption'(findTestObject('Extraction/Page_PetDx/ExtractionLit'), 'Plasma')

'Type Number of Extractions'
WebUI.setText(findTestObject('Extraction/05_Number_Of_Extractions'), GlobalVariable.NumberOfExtractions)

WebUI.sendKeys(findTestObject('Extraction/05_Number_Of_Extractions'), Keys.chord(Keys.TAB))

GlobalVariable.CollectionTube = CustomKeywords.'querys.Sentences.getNextSecuenceFormated'('CollectionTube', 'TC')

CustomKeywords.'utils.multipleTextBoxes.fillMultipleTexBoxes'(findTestObject('Extraction/06_Collection_Tube'), GlobalVariable.CollectionTube)

WebUI.click(findTestObject('Extraction/07_Reagent'))

CustomKeywords.'utils.listbox.selectOption'(findTestObject('Extraction/08_Reagent_List'), 'Kit')

WebUI.click(findTestObject('Extraction/09_Add_Reagent'))

WebUI.sendKeys(findTestObject('Extraction/10_Kit_Reagent_Barcode'), GlobalVariable.Kit)

WebUI.click(findTestObject('Extraction/07_Reagent'))

CustomKeywords.'utils.listbox.selectOption'(findTestObject('Extraction/08_Reagent_List'), 'Reagent')

WebUI.click(findTestObject('Extraction/09_Add_Reagent'))

WebUI.sendKeys(findTestObject('Extraction/11_Reagent_Barcode'), GlobalVariable.Reagent)

WebUI.scrollToElement(findTestObject('Extraction/17_Save'), 15)

WebUI.click(findTestObject('Extraction/14_Add Comments'))

WebUI.waitForElementPresent(findTestObject('Extraction/15_Comment_Area'), 60)

WebUI.sendKeys(findTestObject('Extraction/15_Comment_Area'), 'Automated Comment.')

WebUI.click(findTestObject('Extraction/16_Button_OK'))

WebUI.click(findTestObject('Extraction/17_Save'))

WebUI.waitForElementPresent(findTestObject('Extraction/18_Confirm'), 180)

WebUI.click(findTestObject('Extraction/18_Confirm'))

WebUI.click(findTestObject('Extraction/19_Close'))

