import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import java.util.concurrent.TimeUnit as TimeUnit
import org.openqa.selenium.*
//import org.openqa.selenium.chrome
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.WebElement as WebElement
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

WebUI.openBrowser(GlobalVariable.Url)

//WebUI.navigateToUrl("http://practice.automationtesting.in/")
CustomKeywords.'acciones.espera'(30)

CustomKeywords.'acciones.darClick'('//li[@id="menu-item-50"]/a')

CustomKeywords.'acciones.espera'(15)

//CustomKeywords.'acciones.selectItem'('Sort by price: high to low')
CustomKeywords.'acciones.ponerTexto'("//input[@id='username']", GlobalVariable.Username)
CustomKeywords.'acciones.ponerTexto'("//input[@id='password']",GlobalVariable.Password)

CustomKeywords.'acciones.darClick'("//input[@type='submit']")



