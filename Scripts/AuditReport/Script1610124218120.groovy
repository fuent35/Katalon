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
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable

WebUI.click(findTestObject('AuditReport/Reporting'))

WebUI.click(findTestObject('AuditReport/Audit Report'))

WebUI.waitForElementNotPresent(findTestObject('Extraction/Loader'), 60)

WebUI.sendKeys(findTestObject('AuditReport/Filter'), 'Add Sample XML Request')

WebUI.click(findTestObject('AuditReport/FilterBy'))

CustomKeywords.'utils.listbox.selectOption'(findTestObject('AuditReport/FilterByOptions'), 'Task')

WebUI.click(findTestObject('AuditReport/Fiter Button'))

WebUI.waitForElementNotPresent(findTestObject('Extraction/Loader'), 60)

WebUI.click(findTestObject('AuditReport/RowResult'))

WebUI.waitForElementNotPresent(findTestObject('Extraction/Loader'), 60)

WebUI.scrollToElement(findTestObject('AuditReport/State_Management_Tab'), 30)

WebUI.click(findTestObject('AuditReport/State_Management_Tab'))

WebUI.takeScreenshot()

CustomKeywords.'utils.Tables.printTable'(findTestObject('AuditReport/StateManagementTable'))

