package br.com.alura.mvc.mudi.model;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.net.URL;
import java.net.URLConnection;
import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;

@Entity
public class Filme {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String id_imdb;
	private String id_tmdb;
	private String genero;
	private String subgenero;
	private LocalDate dataLancamento;
	private double nota_imdb;
	
	//Auto preenchidos
	private String titulo;
	private String urlPoster;
	private String urlBackdrop;
	private String sinopse;
	private String tagline;
	
	
	
	public Filme(String id_imdb, String id_tmdb, LocalDate dataLancamento, String genero, String subgenero, double nota_imdb) throws JsonIOException, JsonSyntaxException, IOException {
		this.id_imdb = id_imdb;
		this.id_tmdb = id_tmdb;
		this.genero = genero;
		this.subgenero = subgenero;
		this.nota_imdb = nota_imdb;
		this.dataLancamento = dataLancamento;
		
		String sURL = "https://api.themoviedb.org/3/movie/" + this.id_tmdb + "?api_key=8e42810d79151d48b5f8f0e8e4b848b0&language=" + "pt-BR" ; //just a string

	    // Connect to the URL using java's native library
	    URL url = new URL(sURL);
	    URLConnection request = url.openConnection();
	    request.connect();

	    // Convert to a JSON object to print data
	    JsonParser jp = new JsonParser(); //from gson
	    JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent())); //Convert the input stream to a json element
	    JsonObject rootobj = root.getAsJsonObject(); //May be an array, may be an object.
	    
	    
	    String zipcode = rootobj.get("zip_code").getAsString(); //just grab the zipcode
	    this.titulo = rootobj.get("title").getAsString();
	    this.urlPoster = "https://image.tmdb.org/t/p/w154" + rootobj.get("poster_path").getAsString();
	    this.urlBackdrop = "" + rootobj.get("backdrop_path").getAsString();
	    this.sinopse = rootobj.get("overview").getAsString();
	    this.tagline = rootobj.get("tagline").getAsString();
	}
	

		
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getId_imdb() {
		return id_imdb;
	}
	public void setId_imdb(String id_imdb) {
		this.id_imdb = id_imdb;
	}
	public String getId_tmdb() {
		return id_tmdb;
	}
	public void setId_tmdb(String id_tmdb) {
		this.id_tmdb = id_tmdb;
	}
	public LocalDate getDataLancamento() {
		return dataLancamento;
	}
	public void setDataLancamento(LocalDate dataLancamento) {
		this.dataLancamento = dataLancamento;
	}

	public double getNota_imdb() {
		return nota_imdb;
	}
	public void setNota_imdb(double nota_imdb) {
		this.nota_imdb = nota_imdb;
	}
	
	
	
	
}
