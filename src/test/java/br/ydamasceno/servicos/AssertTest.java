package br.ydamasceno.servicos;

import org.junit.Assert;
import org.junit.Test;

import br.ydamasceno.entidades.Usuario;


public class AssertTest {
	
	@Test
	public void test() {
		Assert.assertTrue(true); //Para testar se uma express�o � true ou false
		Assert.assertFalse(false);
		
		Assert.assertEquals(1, 1);
		//o Delta abaixo � uma margem de erro de compara��o
		Assert.assertEquals(0.51, 0.51, 0.01); //0.01 � um delta de compara��o, pois somente os dois juntos j� est� depreciado e n�o funciona adequadamente
		Assert.assertEquals(Math.PI, 3.14, 0.01);
		
		int i = 5;
		Integer i2 = 5;
		//Testes com tipos primitivos e objetos;
		Assert.assertEquals(Integer.valueOf(i), i2);
		Assert.assertEquals(i, i2.intValue());
		
		//Testes com String
		//Assert.assertEquals("bola", "Bola"); 
		Assert.assertTrue("bola".equalsIgnoreCase("Bola"));
		
		//Teste de igualdade entre objetos
		Usuario u1 = new Usuario("Usuario 1");
		Usuario u2 = new Usuario("Usuario 1");
		
		Assert.assertEquals(u1, u2); //Dar� erro no assertEquals se n�o tiver o m�todo equals dentro da classe
		
		//Comparar se os objetos tem a mesma inst�ncia:
		Assert.assertSame(u2, u2);
		
	}

}
