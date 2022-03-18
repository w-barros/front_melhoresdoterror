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
		
		//Sort para os resultados
		Sort sort = Sort.by("notaIMDB").descending;
		
		List<Filme> filmesEncontrados = filmeRepository.procuraPorGeneroSubgeneroData(Genero genero, Subgenero subgenero, LocalDate decada, So)
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

@Repository
public interface FilmeRepository extends JpaRepository<Filme, Long> {
	
	List<Filme> procuraPorGeneroSubgeneroData(Genero genero, Subgenero subgenero, LocalDate decada)
	
}

