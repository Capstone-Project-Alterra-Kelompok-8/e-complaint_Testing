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
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

WebUI.openBrowser('')

WebUI.navigateToUrl('https://e-complaint-website.vercel.app/login')

WebUI.setText(findTestObject('Object Repository/Change and update status complaint with invalid step/Page_E-Complaint/input_Email_email'), 
    'admin_lebak@gmail.com')

WebUI.setEncryptedText(findTestObject('Object Repository/Change and update status complaint with invalid step/Page_E-Complaint/input_Password_password'), 
    '8SQVv/p9jVScEs4/2CZsLw==')

WebUI.click(findTestObject('Object Repository/Change and update status complaint with invalid step/Page_E-Complaint/span_Login'))

WebUI.click(findTestObject('Object Repository/Change and update status complaint with invalid step/Page_E-Complaint/a_Complaint'))

WebUI.click(findTestObject('Object Repository/Change and update status complaint with invalid step/Page_E-Complaint/button_Detail'))

WebUI.click(findTestObject('Object Repository/Change and update status complaint with invalid step/Page_E-Complaint/p_Aduan anda sedang diproses'))

WebUI.click(findTestObject('Object Repository/Change and update status complaint with invalid step/Page_E-Complaint/button_On Progress'))

WebUI.selectOptionByValue(findTestObject('Object Repository/Change and update status complaint with invalid step/Page_E-Complaint/select_PendingVerifikasiOn ProgressSelesaiDitolak'), 
    'Selesai', true)

WebUI.click(findTestObject('Object Repository/Change and update status complaint with invalid step/Page_E-Complaint/button_Cancel'))

