package br.com.alura.mvc.mudi.controller;

import java.io.IOException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;

import br.com.alura.mvc.mudi.dto.RequisicaoNovoFilme;
import br.com.alura.mvc.mudi.dto.RequisicaoNovoPedido;
import br.com.alura.mvc.mudi.model.Filme;
import br.com.alura.mvc.mudi.model.Pedido;
import br.com.alura.mvc.mudi.model.User;
import br.com.alura.mvc.mudi.repository.FilmeRepository;
import br.com.alura.mvc.mudi.repository.PedidoRepository;
import br.com.alura.mvc.mudi.repository.UserRepository;

@Controller
//@RequestMapping("pedido")
@RequestMapping("/cadastrar")
public class CadastrarFilmeController {
	
	@Autowired
	private FilmeRepository filmeRepository;
	
	//@GetMapping("formulario")
	@GetMapping
	public String cadastrar(RequisicaoNovoFilme requisicao) {
		return "filme/cadastrar";
	}
	
	//originalmente era PostMapping aqui
	@GetMapping("/novo")
	public String novo(@Valid RequisicaoNovoFilme requisicao, BindingResult result) throws JsonIOException, JsonSyntaxException, IOException {
		System.out.println(requisicao.getGenero());
		System.out.println(requisicao.getSubgenero());
		System.out.println(requisicao.getImdbID());
		
		if(result.hasErrors()) {
			System.out.println("Erro no cadastro");
		//	return "pedido/formulario";
			return "filme/cadastrar";
		}
		
		Filme filme = requisicao.toFilme();
		filmeRepository.save(filme);
		return "redirect:/home";
	}
}
