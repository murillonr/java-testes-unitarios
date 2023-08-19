package br.com.projeto_aplicado.tdd.service;

import java.math.BigDecimal;

import br.com.projeto_aplicado.tdd.modelo.Desempenho;
import br.com.projeto_aplicado.tdd.modelo.Funcionario;

public class ReajusteService {

	public void concederReajuste(Funcionario funcionario, Desempenho desempenho) {
		BigDecimal reajuste = desempenho.percentualReajuste();
		funcionario.reajustarSalario(reajuste);
	}

}
