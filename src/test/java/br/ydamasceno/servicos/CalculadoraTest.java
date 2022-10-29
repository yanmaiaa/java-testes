package br.ydamasceno.servicos;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.ydamasceno.exceptions.NaoPodeDividirPorZeroException;

public class CalculadoraTest {
	
	
	private Calculadora calc;
	
	@Before //instanciando antes de fazer os testes para evitar sempre estar repetindo ela em cada método
	public void setUp() {
		calc = new Calculadora();
	}
	
	@Test
	public void somarDoisValores() {
		//cenario
		int a = 5;
		int b = 3;
		
		//acao
		int resultado = calc.somar(a,b);
				
		//verificacao
		Assert.assertEquals(8, resultado);
		
		
	}
	
	@Test
	public void subtrairDoisValores() {
		//cenario
		int a = 8;
		int b = 5;
		
		//acao
		int resultado = calc.subtrair(a,b);
		
		
		//verificacao
		Assert.assertEquals(3, resultado);
		
		
	}
	
	@Test
	public void dividirDoisValores() throws NaoPodeDividirPorZeroException {
		//cenario
		int a = 6;
		int b = 3;
		
		//acao
		int resultado = calc.dividir(a,b);
		
		//verificacao
		Assert.assertEquals(2, resultado);		
		
	}
	
	@Test(expected = NaoPodeDividirPorZeroException.class)
	public void lancarExceptionAoDividirPorZero() throws NaoPodeDividirPorZeroException {
		//cenario
		int a = 10;
		int b = 0;
		
		//acao
		calc.dividir(a, b);
		
	}

}
