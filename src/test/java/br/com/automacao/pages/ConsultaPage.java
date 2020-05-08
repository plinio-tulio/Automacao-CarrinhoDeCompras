package br.com.automacao.pages;

import org.openqa.selenium.By;

import br.com.automacao.core.BasePage;

public class ConsultaPage extends BasePage {

	public void realizarConsulta(String nomeProduto) {
		escrever(By.id("h_search-input"), nomeProduto);
		clique(By.id("h_search-btn"));
	}

}