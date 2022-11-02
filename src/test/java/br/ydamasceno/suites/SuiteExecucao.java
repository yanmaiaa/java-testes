package br.ydamasceno.suites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import br.ydamasceno.servicos.CalculadoraTest;
import br.ydamasceno.servicos.CalculoValorLocacaoTest;
import br.ydamasceno.servicos.LocacaoServiceTest;

@RunWith(Suite.class)
@SuiteClasses({
	CalculadoraTest.class,
	CalculoValorLocacaoTest.class,
	LocacaoServiceTest.class
})
public class SuiteExecucao {
	//O problema aqui é que, sempre que criarmos novas classes de teste teremos que colocar aqui, o que pode ser passível de esquecimento;
	//Outro contraponto é que, caso queiramos executar todos os testes de uma vez, ele executará e ainda assim, executará a suite depois
	//com todos os testes mapeados nela, o que acabará duplicando a bateria de testes sem necessidade.
	//Mas com ele dá para organizar todos os testes que estãos endo feitos também, embora tenham esses contrapontos, depende de cada desenvolvedor

}
