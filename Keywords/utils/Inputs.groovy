package utils

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import internal.GlobalVariable

public class Inputs {
	private String addSampleXMLRequest;

	public String getAddSampleXMLRequest(String specimenID) {
		setAddSampleXMLRequest(specimenID);
		return addSampleXMLRequest;
	}

	private void setAddSampleXMLRequest(String specimenID) {
		this.addSampleXMLRequest = "<linx action=\"save\" clientType=\"LIMS SWS\" clientVersion=\"none\" device=\"Katalon\" host=\"10.2.1.197\" " +
				"password=\"linx123\" port=\"80\" task=\"Add Sample XML Request\" user=\"linx\" workflow=\"Astro\">\r\n" +
				"  <items>\r\n" +
				"    <SpecimenID>" + specimenID + "</SpecimenID>\r\n" +
				"  </items>\r\n" +
				"  <customData>\r\n" +
				"    <PetID>" + specimenID + "_" +specimenID + "</PetID>\r\n" +
				"    <DrawDateTime>2020-11-30 10:55:10</DrawDateTime>\r\n" +
				"    <statusText>AwaitingSample</statusText>\r\n" +
				"  </customData>\r\n" +
				"</linx>\r\n";
	}
}