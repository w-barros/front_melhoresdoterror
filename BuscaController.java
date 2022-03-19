package br.com.alura.mvc.mudi.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.alura.mvc.mudi.dto.RequisicaoNovaBusca;
import br.com.alura.mvc.mudi.dto.RequisicaoNovoPedido;
import br.com.alura.mvc.mudi.model.Filme;
import br.com.alura.mvc.mudi.model.Pedido;
import br.com.alura.mvc.mudi.model.StatusPedido;
import br.com.alura.mvc.mudi.model.User;
import br.com.alura.mvc.mudi.repository.FilmeRepository;
import br.com.alura.mvc.mudi.repository.PedidoRepository;
import br.com.alura.mvc.mudi.repository.UserRepository;

@Controller
@RequestMapping("busca")
public class BuscaController {
	
	@Autowired
	private FilmeRepository filmeRepository;


	
	@PostMapping("busca")
	public String novo(@Valid RequisicaoNovaBusca requisicao, BindingResult result, Model model) {
		if(result.hasErrors()) {
			return "home";
		}
		
		Sort sort = Sort.by("nota_imdb").descending();
	
		List<Filme> filmes = filmeRepository.buscaPorGeneroSubgeneroEData(requisicao.getGenero(), requisicao.getSubgenero(), requisicao.getDataInicial(), requisicao.getDataFinal(), sort);
		model.addAttribute("filmes", filmes);
		return "busca";
	}
}
