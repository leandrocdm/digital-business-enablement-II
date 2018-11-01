package br.com.fiap.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("contato")
public class ContatoController {

	@GetMapping("enviar")
	public String contato() {
		return "contato/form";
	}
	
	//M�todo que recupera as informa��es do formul�rio
	@PostMapping("enviar")
	public String contato(String mensagem, String nome) {
		System.out.println(nome + " " + mensagem);
		return "contato/form";
	}
	
}
