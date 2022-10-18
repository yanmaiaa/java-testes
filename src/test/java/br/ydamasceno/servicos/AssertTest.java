package br.ydamasceno.servicos;

import org.junit.Assert;
import org.junit.Test;

import br.ydamasceno.entidades.Usuario;


public class AssertTest {
	
	@Test
	public void test() {
		Assert.assertTrue(true); //Para testar se uma expressão é true ou false
		Assert.assertFalse(false);
		
		Assert.assertEquals(1, 1);
		//o Delta abaixo é uma margem de erro de comparação
		Assert.assertEquals(0.51, 0.51, 0.01); //0.01 é um delta de comparação, pois somente os dois juntos já está depreciado e não funciona adequadamente
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
		
		Assert.assertEquals(u1, u2); //Dará erro no assertEquals se não tiver o método equals dentro da classe
		
		//Comparar se os objetos tem a mesma instância:
		Assert.assertSame(u2, u2);
		
	}

}
