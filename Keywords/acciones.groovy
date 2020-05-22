import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import java.util.concurrent.TimeUnit

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testcase.TestCaseFactory
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords

import internal.GlobalVariable

import MobileBuiltInKeywords as Mobile
import WSBuiltInKeywords as WS
import WebUiBuiltInKeywords as WebUI
import groovyjarjarasm.asm.tree.TryCatchBlockNode

import org.openqa.selenium.chrome.*
import org.openqa.selenium.WebElement
import org.openqa.selenium.WebDriver
import org.openqa.selenium.By

import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.webui.driver.DriverFactory

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObjectProperty
import com.kms.katalon.core.trymonad.Try
import com.kms.katalon.core.mobile.helper.MobileElementCommonHelper
import com.kms.katalon.core.util.KeywordUtil

import com.kms.katalon.core.webui.exception.WebElementNotFoundException


class acciones {
	
	
	/**
	 * Refresh browser
	 */
	@Keyword
	def refreshBrowser() {
		KeywordUtil.logInfo("Refreshing")
		WebDriver webDriver = DriverFactory.getWebDriver()
		webDriver.navigate().refresh()
		KeywordUtil.markPassed("Refresh successfully")
		webDriver.findElement(null)
	}

	/**
	 * Click element
	 * @param to Katalon test object
	 */
	@Keyword
	def clickElement(TestObject to) {
		try {
			WebElement element = WebUiBuiltInKeywords.findWebElement(to);
			KeywordUtil.logInfo("Clicking element")
			element.click()
			KeywordUtil.markPassed("Element has been clicked")
		} catch (WebElementNotFoundException e) {
			KeywordUtil.markFailed("Element not found")
		} catch (Exception e) {
			KeywordUtil.markFailed("Fail to click on element")
		}
	}
	
	
	/**
	 * Click en un element usando XPath selector
	 * @param WebDriver
	 * @param String
	 * @author Pedro Ogando
	 */
	@Keyword
	def darClick(String xpath) {
		
		try {			
			WebDriver driver = DriverFactory.getWebDriver()
			KeywordUtil.logInfo("Clicking element")		
			driver.findElement(By.xpath(xpath)).click()		
			KeywordUtil.markPassed("Se ha hecho clic en el elemento.")
		} catch (WebElementNotFoundException e) {
			KeywordUtil.markFailed("Elemento no encontrado")
		} catch (Exception e) {
			KeywordUtil.markFailed("Error al hacer clic en el elemento")
		}
	}
	
	/**
	 * Click en un elemento Link usando XPath Selector
	 * @param WebDriver
	 * @param String
	 * @author Pedro Ogando
	 * 
	 **/
	@Keyword
	def darClickLink(String linkText){
		try{
			WebDriver driver = DriverFactory.getWebDriver()
			driver.findElement(By.xpath("//a[contains(text(),'"+ linkText +"')]")).click()
			KeywordUtil.markPassed("Se ha hecho clic en el elemento.")
		}catch(WebElementNotFoundException e){
			KeywordUtil.markFailed("Elemento no encontrado")
		}catch(Exception e){
			KeywordUtil.markFailed("Error al hacer clic en el elemento")
		}
	}
	

	/**
	 * Realiza una espera
	 * @param String
	 * @param WebDriver
	 * @author Pedro Ogando
	 * **/
	@Keyword
	def espera(Integer seg){
		WebDriver driver = DriverFactory.getWebDriver()
		driver.manage().timeouts().implicitlyWait(seg, TimeUnit.SECONDS)
	}	
	
	/**
	 * Selecciona un elemento de una lista desplegable
	 * @param WebDriver
	 * @param String
	 * @author Pedro Ogando
	 * **/
	@Keyword
	def selectItem(String nameItem){
		try{
			WebDriver driver = DriverFactory.getWebDriver()
			driver.findElement(By.xpath("//option[contains(text(),'"+ nameItem +"')]")).click()
			KeywordUtil.markPassed("Se ha seleccionado en el elemento.")
		}catch(WebElementNotFoundException e){
			KeywordUtil.markFailed("Elemento no encontrado")
		}catch(Exception e){
			KeywordUtil.markFailed("Error al seleccionar el elemento")
		}
	}
	
	/**
	 * Introduce un texto en un TextBox
	 * @param WebDriver
	 * @param String
	 * @author Pedro Ogando
	 * **/	
	@Keyword
	def ponerTexto(String xpath, String text){
		try{
			WebDriver driver = DriverFactory.getWebDriver()
			driver.findElement(By.xpath(xpath)).sendKeys(text)
			KeywordUtil.markPassed("Se ha colocado el texto en el elemento.")
		}catch(WebElementNotFoundException e){
			KeywordUtil.markFailed("Elemento no encontrado")
		}catch(Exception){
			KeywordUtil.markFailed("Error al colocado el texto en el elemento")
		}
	}

	
	/**
	 * Get all rows of HTML table
	 * @param table Katalon test object represent for HTML table
	 * @param outerTagName outer tag name of TR tag, usually is TBODY
	 * @return All rows inside HTML table
	 */
	@Keyword
	def List<WebElement> getHtmlTableRows(TestObject table, String outerTagName) {
		WebElement mailList = WebUiBuiltInKeywords.findWebElement(table)
		List<WebElement> selectedRows = mailList.findElements(By.xpath("./" + outerTagName + "/tr"))
		return selectedRows
	}
}