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
	//O problema aqui � que, sempre que criarmos novas classes de teste teremos que colocar aqui, o que pode ser pass�vel de esquecimento;
	//Outro contraponto � que, caso queiramos executar todos os testes de uma vez, ele executar� e ainda assim, executar� a suite depois
	//com todos os testes mapeados nela, o que acabar� duplicando a bateria de testes sem necessidade.
	//Mas com ele d� para organizar todos os testes que est�os endo feitos tamb�m, embora tenham esses contrapontos, depende de cada desenvolvedor

}
