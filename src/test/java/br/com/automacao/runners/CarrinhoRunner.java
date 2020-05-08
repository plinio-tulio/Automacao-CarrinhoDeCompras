package br.com.automacao.runners;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/features/carrinho.feature",
		glue = "br.com.automacao.steps",
		tags = {"@funcionais"},
		plugin =  {"pretty", "html:target/reports/report-html", "json:target/reports/report-json/report.json"},
		monochrome = true,
		snippets = SnippetType.CAMELCASE,
		dryRun = false,
		strict = false
		)
public class CarrinhoRunner {

}