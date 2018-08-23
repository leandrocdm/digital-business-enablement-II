package br.com.fiap.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.fiap.spring.model.Carro;

@Controller
@RequestMapping("carro")
public class CarroController {
	
	
	@GetMapping("cadastrar")
	public String getCadastro() {
		return "carro/form";
	}
	
	@PostMapping("cadastrar")
	public ModelAndView processarCadastro(Carro carro) {
		ModelAndView retorno = new ModelAndView("carro/sucesso");
		retorno.addObject("carro", carro);
		return retorno;
	}
	

}
