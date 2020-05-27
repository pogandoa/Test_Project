import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import java.util.concurrent.TimeUnit as TimeUnit

import org.eclipse.persistence.internal.jaxb.CustomAccessorAttributeAccessor
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

CustomKeywords.'acciones.esperarPagina'(30)

CustomKeywords.'acciones.darClick'('//li[@id="menu-item-50"]/a')

CustomKeywords.'acciones.esperarPagina'(30)

CustomKeywords.'acciones.espera'(30)


CustomKeywords.'acciones.verficarElementoPresente'("//input[@type='submit']", 30)

if (CustomKeywords.'acciones.verificarTexto'('Login')) {

	CustomKeywords.'acciones.espera'(30)

	CustomKeywords.'acciones.ponerTexto'('//input[@id=\'username\']', GlobalVariable.Username)

	CustomKeywords.'acciones.ponerTexto'('//input[@id=\'password\']', GlobalVariable.Password)

	CustomKeywords.'acciones.espera'(30)

	CustomKeywords.'acciones.darClick'('//input[@type=\'submit\']')

	CustomKeywords.'acciones.esperarPagina'(30)

	CustomKeywords.'acciones.verificarTexto'('johndoe')

	CustomKeywords.'acciones.espera'(30)

}else{
	CustomKeywords.'acciones.espera'(348)
}


WebUI.closeBrowser()

