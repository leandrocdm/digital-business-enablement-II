package br.com.fiap.spring.controller;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import br.com.fiap.spring.dao.OrcamentoDAO;
import br.com.fiap.spring.model.Orcamento;

@Controller
@RequestMapping("orcamento")
public class OrcamentoController {

	@Autowired
	private OrcamentoDAO dao;
	
	@GetMapping("cadastrar")
	public String abrirFormulario(Orcamento orcamento) {
		return "orcamento/cadastro";
	}
	
	@Transactional
	@PostMapping("cadastrar")
	public String processarForm(Orcamento orcamento, RedirectAttributes r) {		
		dao.create(orcamento);
		r.addFlashAttribute("msg", "Orçamento registrado!");
		return "redirect:/orcamento/cadastrar";
	}
	
}
