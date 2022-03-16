package br.com.alura.mvc;

public class MelhoresDoTerror {

	
}


//HomeController
@Controller
@RequestMapping("/home")
public class HomeController {
	
	@GetMapping
	public String home(Model model) {
		return "home";
	}
}

//BuscaController
@Controller
@RequestMapping("/busca")
public class HomeController {
	
	@GetMapping
	public String home(Model model) {
		List<Filme> filmesEncontrados = filmeRepository.??????
		model.addAttribute("filmesEncontrados", filmesEncontrados);
		return "busca";
	}
}

//LoginController
@Controller
public class LoginController {
	
	@GetMapping
	@RequestMapping("/login")
	public String login() {
		return "login";
	}
}


//FilmeRepository

