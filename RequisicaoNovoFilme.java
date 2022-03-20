package br.com.alura.mvc.mudi.dto;

import java.io.IOException;

import javax.validation.constraints.NotBlank;

import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;

import br.com.alura.mvc.mudi.model.Filme;
import br.com.alura.mvc.mudi.model.Pedido;
import br.com.alura.mvc.mudi.model.StatusPedido;

public class RequisicaoNovoFilme {
	
	@NotBlank
	private String imdbID;
	
	public String getImdbID() {
		return imdbID;
	}



	public void setImdbID(String imdbID) {
		this.imdbID = imdbID;
	}



	public String getGenero() {
		return genero;
	}



	public void setGenero(String genero) {
		this.genero = genero;
	}



	public String getSubgenero() {
		return subgenero;
	}



	public void setSubgenero(String subgenero) {
		this.subgenero = subgenero;
	}



	@NotBlank
	private String genero;
	
	@NotBlank
	private String subgenero;
	
	
	
	public Filme toFilme() throws JsonIOException, JsonSyntaxException, IOException {
		Filme filme = new Filme(this.imdbID, this.genero, this.subgenero);
		return filme;
	}
	
	
}
