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
	
	private String imdbID;
	private String genero;
	private String subgenero;
	
	//Auto preenchidos
	private double nota_imdb;
	private String tmdbID;
	private String titulo;
	private String tituloBR;
	private String urlPoster;
	private String urlBackdrop;
	private String sinopse;
	private String sinopseBR;
	private String tagline;
	private LocalDate dataLancamento;
	private int anoLancamento;
	
	
	
	public Filme(String imdbID, String genero, String subgenero) throws JsonIOException, JsonSyntaxException, IOException {
		this.imdbID = imdbID;
		this.genero = genero;
		this.subgenero = subgenero;
		
		//OMDB API CALL
				String sURL = "http://www.omdbapi.com/?i=" + this.imdbID + "&apikey=252e2418";

			    // Connect to the URL using java's native library
			    URL url = new URL(sURL);
			    URLConnection request = url.openConnection();
			    request.connect();

			    // Convert to a JSON object to print data
			    @SuppressWarnings("deprecation")
				JsonParser jp = new JsonParser(); //from gson
			    @SuppressWarnings("deprecation")
				JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent())); //Convert the input stream to a json element
			    JsonObject rootobj = root.getAsJsonObject(); //May be an array, may be an object.
			    
			    
			   // String zipcode = rootobj.get("zip_code").getAsString(); //just grab the zipcode
			    this.titulo = rootobj.get("Title").getAsString();
			    this.urlPoster = rootobj.get("Poster").getAsString();
			   // this.urlBackdrop = "" + rootobj.get("backdrop_path").getAsString();
			    this.sinopse = rootobj.get("Plot").getAsString();
			   // this.tagline = rootobj.get("tagline").getAsString();
			   // this.dataLancamento = LocalDate.parse(rootobj.get("release_date").getAsString());
			    this.anoLancamento = rootobj.get("Year").getAsInt();
			    this.nota_imdb = rootobj.get("imdbRating").getAsDouble();
			    
		//TMDB API CALL
//		String sURL2 = "https://api.themoviedb.org/3/find/" + this.id_tmdb + "?api_key=8e42810d79151d48b5f8f0e8e4b848b0&language=" + "pt-BR" + "&external_source=imdb_id"; //just a string
//
//	    // Connect to the URL using java's native library
//	    URL url2 = new URL(sURL2);
//	    URLConnection request2 = url.openConnection();
//	    request2.connect();
//
//	    // Convert to a JSON object to print data
//	    @SuppressWarnings("deprecation")
//		JsonParser jp2 = new JsonParser(); //from gson
//	    @SuppressWarnings("deprecation")
//		JsonElement root2 = jp2.parse(new InputStreamReader((InputStream) request2.getContent())); //Convert the input stream to a json element
//	    JsonObject rootobj2 = root2.getAsJsonObject(); //May be an array, may be an object.
//	    
//	    
//	   // String zipcode = rootobj.get("zip_code").getAsString(); //just grab the zipcode
//	    this.tituloBR = rootobj2.get("Title").getAsString();
//	    this.urlBackdrop = "" + rootobj.get("backdrop_path").getAsString();
//	    this.sinopseBR = rootobj2.get("Plot").getAsString();
//	   // this.tagline = rootobj.get("tagline").getAsString();
//	   // this.dataLancamento = LocalDate.parse(rootobj.get("release_date").getAsString());
//	    this.anoLancamento = rootobj.get("Year").getAsInt();
//	    this.nota_imdb = rootobj.get("imdbRating").getAsInt();
	    
	    
	    
	}
	

		
	public Filme() {
		super();
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



	public String getTitulo() {
		return titulo;
	}



	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}



	public String getUrlPoster() {
		return urlPoster;
	}



	public void setUrlPoster(String urlPoster) {
		this.urlPoster = urlPoster;
	}



	public String getUrlBackdrop() {
		return urlBackdrop;
	}



	public void setUrlBackdrop(String urlBackdrop) {
		this.urlBackdrop = urlBackdrop;
	}



	public String getSinopse() {
		return sinopse;
	}



	public void setSinopse(String sinopse) {
		this.sinopse = sinopse;
	}



	public String getTagline() {
		return tagline;
	}



	public void setTagline(String tagline) {
		this.tagline = tagline;
	}



	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public String getId_tmdb() {
		return tmdbID;
	}
	public void setId_tmdb(String id_tmdb) {
		this.tmdbID = id_tmdb;
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
