package br.com.automacao.core;

import static br.com.automacao.core.DriverFactory.getDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.function.Function;

public class BasePage {

	private final String BaseURL = "https://americanas.com.br";

	public void acessarSistema() {
		getDriver().get(BaseURL);
	}

	public void acessar(String texto) {
		getDriver().get(texto);
	}

	public void escrever(By by, String texto) {
		getDriver().findElement(by).sendKeys(texto);
	}

	public String obterTexto(By by) {
		return getDriver().findElement(by).getText();
	}

	public void clique(By by) {
		getDriver().findElement(by).click();
	}

	public static void scrollClique(By element) {
		WebElement ele = getDriver().findElement(element);
		((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);",
				getDriver().findElement(element));
		JavascriptExecutor executor = (JavascriptExecutor) getDriver();
		executor.executeScript("arguments[0].click();", ele);
	}

	public static void scrollDown() {
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}

	public void aguardarElementoVisivel(By element){
		WebDriverWait wait = new WebDriverWait(getDriver(), 10);
		wait.until(ExpectedConditions.visibilityOf(getDriver().findElement(element)));
	}

	public void aguardarPaginaCarregar() {
		WebDriverWait wait = new WebDriverWait(getDriver(), 30);
		wait.until(new Function<WebDriver, Boolean>() {
			public Boolean apply(WebDriver driver) {
				System.out.println("Current Window State       : "
						+ String.valueOf(((JavascriptExecutor) driver).executeScript("return document.readyState")));
				return String
						.valueOf(((JavascriptExecutor) driver).executeScript("return document.readyState"))
						.equals("complete");
			}
		});
	}

}