package br.com.fiap.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.fiap.spring.model.Apresentacao;

@Controller
@RequestMapping("apresentacao")
public class ApresentacaoController {

	@GetMapping("cadastrar")
	public String abrirForm() {
		return "apresentacao/form";
	}

	@PostMapping("cadastrar")
	public ModelAndView processarForm(Apresentacao ap) { 
		return new ModelAndView("apresentacao/form")
				.addObject("msg", "O Grupo "+ap.getGrupo()+" foi cadastrado!");
	}

}
