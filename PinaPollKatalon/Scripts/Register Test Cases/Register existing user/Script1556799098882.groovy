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

WebUI.navigateToUrl('http://localhost:8080/')

WebUI.click(findTestObject('Page_PinaPoll/a_Sign up'))

WebUI.setText(findTestObject('Object Repository/Page_Sign up form/input_Registration Form_name (5)'), 'KatalonExisting')

WebUI.setText(findTestObject('Object Repository/Page_Sign up form/input_Registration Form_email (5)'), 'katalon@existing.ch')

WebUI.setEncryptedText(findTestObject('Object Repository/Page_Sign up form/input_Registration Form_password (5)'), '4nvbrPglk7k=')

WebUI.click(findTestObject('Object Repository/Page_Sign up form/button_Sign up (4)'))

WebUI.setText(findTestObject('Object Repository/Page_Sign up form/input_Registration Form_name (5)'), 'KatalonExisting')

WebUI.setText(findTestObject('Object Repository/Page_Sign up form/input_Registration Form_email (5)'), 'katalon@existing.ch')

WebUI.setEncryptedText(findTestObject('Object Repository/Page_Sign up form/input_Registration Form_password (5)'), '4nvbrPglk7k=')

WebUI.click(findTestObject('Object Repository/Page_Sign up form/button_Sign up (4)'))

WebUI.click(findTestObject('Object Repository/Page_Sign up form/div_Registration FormName already taken There is already a user registered with that email Sign upBack to login'))

WebUI.click(findTestObject('Object Repository/Page_Sign up form/form_Registration FormName already taken There is already a user registered with that email Sign upBack to login'))

WebUI.closeBrowser()

