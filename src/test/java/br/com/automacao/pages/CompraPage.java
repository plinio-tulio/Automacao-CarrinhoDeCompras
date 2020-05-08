package br.com.automacao.pages;

import org.openqa.selenium.By;

import br.com.automacao.core.BasePage;

public class CompraPage extends BasePage {

	public void selecionarProduto(String nomeProduto) {
		scrollClique(By.xpath("//img[@alt='" + nomeProduto + "']"));
	}

	public void incluirNoCarrinho() {
		scrollClique(By.id("btn-buy"));
		scrollClique(By.id("btn-continue"));
	}

	public String obterMensagemEstoque() {
		return obterTexto(By.xpath("//span[@id='title-stock']"));
	}

	public void informarCep(String cep) {
		escrever(By.id("freight-field"), cep);
		scrollClique(By.id("freight-field-button"));
	}

	public String obterMensagemValidacaoCep() {
		return obterTexto(By.cssSelector(".TextAlert-sc-15dx5po-3"));
	}

}