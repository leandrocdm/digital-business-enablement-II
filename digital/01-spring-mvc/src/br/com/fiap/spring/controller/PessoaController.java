package br.com.fiap.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.fiap.spring.model.Pessoa;

@Controller
@RequestMapping("pessoa")
public class PessoaController {

	@GetMapping("cadastrar")
	public String abrirFormulario() {
		return "pessoa/form";
	}

	@PostMapping("cadastrar")
	public String processarFormulario(Pessoa p) {
		System.out.println("Nome: "+p.getNome() + " Idade: " + p.getIdade()+ " É aposentado? " + p.isAposentado());
		return "pessoa/form";
	}
}




