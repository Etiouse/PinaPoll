import com.kms.katalon.core.main.TestCaseMain
import com.kms.katalon.core.logging.KeywordLogger
import com.kms.katalon.core.testcase.TestCaseBinding
import com.kms.katalon.core.driver.internal.DriverCleanerCollector
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.webui.contribution.WebUiDriverCleaner
import com.kms.katalon.core.mobile.contribution.MobileDriverCleaner
import com.kms.katalon.core.cucumber.keyword.internal.CucumberDriverCleaner


DriverCleanerCollector.getInstance().addDriverCleaner(new com.kms.katalon.core.webui.contribution.WebUiDriverCleaner())
DriverCleanerCollector.getInstance().addDriverCleaner(new com.kms.katalon.core.mobile.contribution.MobileDriverCleaner())
DriverCleanerCollector.getInstance().addDriverCleaner(new com.kms.katalon.core.cucumber.keyword.internal.CucumberDriverCleaner())


RunConfiguration.setExecutionSettingFile('C:\\Users\\ETIENN~1.HUS\\AppData\\Local\\Temp\\Katalon\\20190502_141301\\execution.properties')

TestCaseMain.beforeStart()

        TestCaseMain.runWSVerificationScript(new TestCaseBinding('',[:]), 'import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI\nimport com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile\nimport com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW\nimport com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS\nimport static com.kms.katalon.core.testobject.ObjectRepository.findTestObject\nimport static com.kms.katalon.core.testdata.TestDataFactory.findTestData\nimport static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase\nimport static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint\nimport com.kms.katalon.core.model.FailureHandling as FailureHandling\nimport com.kms.katalon.core.testcase.TestCase as TestCase\nimport com.kms.katalon.core.testdata.TestData as TestData\nimport com.kms.katalon.core.testobject.TestObject as TestObject\nimport com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint\nimport internal.GlobalVariable as GlobalVariable\nimport org.openqa.selenium.Keys as Keys\n\nWebUI.openBrowser(\'\')\n\nWebUI.navigateToUrl(\'http://localhost:8080/\')\n\nWebUI.click(findTestObject(\'Page_PinaPoll/a_Sign up\'))\n\nWebUI.setText(findTestObject(\'Page_Sign up form/input_Registration Form_name\'), \'KatalonExisting\')\n\nWebUI.setText(findTestObject(\'Page_Sign up form/input_Registration Form_email\'), \'katalon@existing.ch\')\n\nWebUI.setEncryptedText(findTestObject(\'Page_Sign up form/input_Registration Form_password\'), \'4nvbrPglk7k=\')\n\nWebUI.click(findTestObject(\'Page_Sign up form/button_Sign up\'))\n\nWebUI.setText(findTestObject(\'Page_Sign up form/input_Registration Form_name\'), \'KatalonExisting\')\n\nWebUI.setText(findTestObject(\'Page_Sign up form/input_Registration Form_email\'), \'katalon@existing.ch\')\n\nWebUI.setEncryptedText(findTestObject(\'Page_Sign up form/input_Registration Form_password\'), \'4nvbrPglk7k=\')\n\nWebUI.click(findTestObject(\'Page_Sign up form/button_Sign up\'))\n\nWebUI.click(findTestObject(\'Page_Sign up form/div_Registration FormName already taken There is already a user registered with that email Sign upBack to login\'))\n\nWebUI.click(findTestObject(\'Page_Sign up form/form_Registration FormName already taken There is already a user registered with that email Sign upBack to login\'))\n\nWebUI.closeBrowser()\n\n', FailureHandling.STOP_ON_FAILURE, true)

