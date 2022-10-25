package br.ydamasceno.servicos;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;



@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class OrdemTest {
	
	public static int contador = 0;

	@Test
	public void testeInicial() {
		contador = 1;
	}
	
	//Haver� erro, pois um m�todo depende do outro e ao serem executados os testes, um inicia numa ordem diferente do outro
	
	@Test
	public void verifica() {
		Assert.assertEquals(1, contador);
	}
	
	//Como garantir a ordem, retira o "@Test" dos testes e coloca apenas nesse.
	//Pontos negativos:
		//Perda de rastreabilidade, pois se houver erro, ser� marcado o escopo maior e n�o exatamente o teste em que houve a falha
		//Para isso usamos a annotation: "@fixMethodOrder" com o MethodSorters.NAME_ASCENDING, pois ele vai organizar por ordem alfab�tica

//	@Test
//	public void testeGeral() {
//		testeInicial();
//		verifica();
//	}
	
}
