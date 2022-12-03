package br.ydamasceno.builder;

import br.ydamasceno.entidades.Filme;

public class FilmeBuilder {
	
	private Filme filme;
	
	private FilmeBuilder() {
		
	}
	
	public static FilmeBuilder umFilme() {
		FilmeBuilder builder = new FilmeBuilder();
		builder.filme = new Filme();
		builder.filme.setEstoque(2);
		builder.filme.setNome("Filme 1");
		builder.filme.setPrecoLocacao(4.0);
		return builder;
	}
	
	//Método de construção
	public FilmeBuilder semEstoque() {
		filme.setEstoque(0);
		return this;
	}
	
	//Metodo de construção para alterar o valor do filme
	public FilmeBuilder comValor(Double valor) {
		filme.setPrecoLocacao(valor);
		return this;
	}
	
	public Filme agora() {
		return filme;
	}

}
