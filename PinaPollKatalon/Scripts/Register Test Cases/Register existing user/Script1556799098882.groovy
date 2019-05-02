import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

WebUI.openBrowser('')

WebUI.navigateToUrl('http://localhost:8080/registration')

WebUI.setText(findTestObject('Object Repository/Page_/input_Registration Form_name (2)'), 'TestUser')

WebUI.setText(findTestObject('Object Repository/Page_/input_Registration Form_email (2)'), 'a@aa.aa')

WebUI.setEncryptedText(findTestObject('Object Repository/Page_/input_Registration Form_password (2)'), '4nvbrPglk7k=')

WebUI.click(findTestObject('Object Repository/Page_/button_Sign up (2)'))

WebUI.setText(findTestObject('Object Repository/Page_/input_Registration Form_name (2)'), 'TestUser')

WebUI.setText(findTestObject('Object Repository/Page_/input_Registration Form_email (2)'), 'a@aa.aa')

WebUI.setEncryptedText(findTestObject('Object Repository/Page_/input_Registration Form_password (2)'), '4nvbrPglk7k=')

WebUI.click(findTestObject('Object Repository/Page_/button_Sign up (2)'))

WebUI.click(findTestObject('Object Repository/Page_/div_Name already taken'))

WebUI.click(findTestObject('Object Repository/Page_/div_There is already a user registered with that email'))

WebUI.closeBrowser()

