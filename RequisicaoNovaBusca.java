package br.com.alura.mvc.mudi.dto;

import java.time.LocalDate;

public class RequisicaoNovaBusca {
	
	private String genero;
	private String subgenero;
	private LocalDate dataInicial;
	private LocalDate dataFinal;
	private String dataSelecionada;
	
	static LocalDate ano1970 = LocalDate.of(1970, 1, 1);
	static LocalDate ano1979 = LocalDate.of(1979, 12, 31);
	static LocalDate ano1980 = LocalDate.of(1980, 1, 1);
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

	public LocalDate getDataInicial() {
		return dataInicial;
	}

	public void setDataInicial(LocalDate dataInicial) {
		this.dataInicial = dataInicial;
	}

	public LocalDate getDataFinal() {
		return dataFinal;
	}

	public void setDataFinal(LocalDate dataFinal) {
		this.dataFinal = dataFinal;
	}

	static LocalDate ano1989 = LocalDate.of(1989, 12, 31);
	static LocalDate ano1990 = LocalDate.of(1990, 1, 1);
	static LocalDate ano1999 = LocalDate.of(1999, 12, 31);
	static LocalDate ano2000 = LocalDate.of(2000, 1, 1);
	static LocalDate ano2009 = LocalDate.of(2009, 12, 31);
	static LocalDate ano2010 = LocalDate.of(2010, 1, 1);
	static LocalDate ano2019 = LocalDate.of(2019, 12, 31);
	static LocalDate ano2020 = LocalDate.of(2020, 1, 1);
	static LocalDate ano2029 = LocalDate.of(2029, 12, 31);
	
	public RequisicaoNovaBusca(String genero, String subgenero, String dataSelecionada) {
		this.genero = genero;
		this.subgenero = subgenero;
		this.dataSelecionada = dataSelecionada;
		
		if (dataSelecionada == "1970")
		{
			this.dataInicial = ano1970;
			this.dataFinal = ano1979;
		}
		
		if (dataSelecionada == "1980")
		{
			this.dataInicial = ano1980;
			this.dataFinal = ano1989;
		}
		
		if (dataSelecionada == "1990")
		{
			this.dataInicial = ano1990;
			this.dataFinal = ano1999;
		}
		
		if (dataSelecionada == "2000")
		{
			this.dataInicial = ano2000;
			this.dataFinal = ano2009;
		}
		
		if (dataSelecionada == "2010")
		{
			this.dataInicial = ano2010;
			this.dataFinal = ano2019;
		}
		
		if (dataSelecionada == "2020")
		{
			this.dataInicial = ano2020;
			this.dataFinal = ano2029;
		}
		
	}

}
