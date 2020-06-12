package br.com.automacao.steps;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import br.com.automacao.core.DriverFactory;
import br.com.automacao.pages.CarrinhoPage;
import br.com.automacao.pages.CompraPage;
import br.com.automacao.pages.ConsultaPage;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;

public class CarrinhoSteps {

	private ConsultaPage consultaPage;
	private CompraPage compraPage;
	private CarrinhoPage carrinhoPage;

	@Before
	public void setUp() {
		DriverFactory.getDriver();
		consultaPage = new ConsultaPage();
		compraPage = new CompraPage();
		carrinhoPage = new CarrinhoPage();
	}

	@Dado("^que pesquiso pelo produto \"([^\"]*)\"$")
	public void quePesquisoPeloProduto(String nomeProduto) throws Throwable {
		consultaPage.acessarSistema();
		consultaPage.realizarConsulta(nomeProduto);
	}

	@Quando("^seleciono o produto \"([^\"]*)\"$")
	public void selecionoOProduto(String nomeProduto) throws Throwable {
		compraPage.selecionarProduto(nomeProduto);
	}

	@Quando("^realizo a inclusao do produto \"([^\"]*)\" no carrrinho$")
	public void realizoAInclusaoDoProdutoNoCarrrinho(String nomeProduto) throws Throwable {
		compraPage.incluirNoCarrinho();
	}

	@Quando("^informo o cep de destino com cep \"([^\"]*)\"$")
	public void informoOCepDeDestinoCom(String cep) throws Throwable {
		compraPage.informarCep(cep);
	}

	@Então("^tenho o produto \"([^\"]*)\" incluido no carrinho para compra$")
	public void tenhoOProdutoIncluidoNoCarrinhoParaCompra(String nomeProduto) throws Throwable {
		Assert.assertEquals(nomeProduto, carrinhoPage.obterProdutoCarinho());
	}

	@Então("^visualizo a mensagem de cep incorreto$")
	public void visualizoAMensagemDeCepIncorreto() throws Throwable {
		Assert.assertEquals("Preencha um CEP válido.", compraPage.obterMensagemValidacaoCep());
	}

	@Então("^visualizo a mensagem que o produto não possui estoque$")
	public void visualizoAMensagemQueOProdutoNãoPossuiEstoque() throws Throwable {
		Assert.assertEquals("Ops! Já vendemos o estoque", compraPage.obterMensagemEstoque());
	}

	@After(order = 1, value = { "@funcionais" })
	public void screenshot(Scenario cenario) {
		File file = ((TakesScreenshot) DriverFactory.getDriver()).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(file, new File("target/screenshots/" + cenario.getName() +".jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@After(order = 0, value = { "@funcionais" })
	public void fechaBrowser() throws InterruptedException {
		DriverFactory.killDriver();
		System.out.println("finalizando cenário de teste.");
	}

}