package br.com.fiap.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.fiap.spring.model.Apresentacao;

@Controller
@RequestMapping("apresentacao")
public class ApresentacaoController {

	@GetMapping("cadastrar")
	public String abrirForm() {
		return "apresentacao/form";
	}

	@PostMapping("cadastrar")
	public String processarForm(Apresentacao apresentacao) { 
		System.out.println("Grupo:" +apresentacao.getGrupo());
		System.out.println("Duracao:" +apresentacao.getDuracao());
		return "apresentacao/form";
	}
}
