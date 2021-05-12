package br.com.lucas.page;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import br.com.lucas.core.BasePage;
import static br.com.lucas.core.DriverFactory.*;

public class MovimentacaoPage extends BasePage {
	
	public void setMovimentacaoReceita() {
		selecionaOCombo("tipo", "Receita");	
	}
	
	public void setMovimentacaoDespesa() {
		selecionaOCombo("tipo", "Despesa");
	}
	
	public void setDataMovimentacao(String data) {
		escrever("data_transacao", data);
	}
	
	public void setDataPagamento(String dataPagamento) {
		escrever("data_pagamento", dataPagamento);
	}
	
	public void setDescricao(String descricao) {
		escrever("descricao", descricao);
	}
	
	public void setInteressado(String interessado) {
		escrever("interessado", interessado);
	}
	
	public void setDigitarValor(String valor) {
		escrever("valor", valor);
	}
	
	public void setConta(String nomeConta) {
		selecionaOCombo("conta", nomeConta);
	}
	
	public void setStatusPago() {
		clicarRadio("status_pago");
	}
	
	public void setStatusPendente() {
		clicarRadio("status_pendente");
	}
	
	public void salvar() {
		clicarBotao(By.xpath("//button[.='Salvar']"));
	}

	public String obterMensagemSucesso(){
		return obterTexto(By.xpath("//div[@class='alert alert-success']"));
	}
	
	public List<String> obterErros(){
		List<WebElement> erros = getDriver().findElements(By.xpath(".//div[@class='alert alert-danger']//li"));
		List<String> retorno = new ArrayList<String>();
		for(WebElement erro : erros) {
			retorno.add(erro.getText());
		}
		return retorno;
	}
}
