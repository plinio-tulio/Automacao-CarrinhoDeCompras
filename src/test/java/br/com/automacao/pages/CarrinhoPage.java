package br.com.automacao.pages;

import org.openqa.selenium.By;

import br.com.automacao.core.BasePage;

public class CarrinhoPage extends BasePage {

	public String obterProdutoCarinho() {
		return obterTexto(By.xpath("//h2[@class='basket-productTitle']"));
	}

}