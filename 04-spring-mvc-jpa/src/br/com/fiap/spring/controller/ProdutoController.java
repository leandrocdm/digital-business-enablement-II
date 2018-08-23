package br.com.fiap.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.fiap.spring.dao.ProdutoDAO;
import br.com.fiap.spring.model.Produto;

@Controller
@RequestMapping("produto")
public class ProdutoController {
	
	@Autowired
	private ProdutoDAO dao;
	
	@GetMapping("cadastrar")  
	public String cadastro() {
		return "produto/form";
	}
	
	@PostMapping("cadastrar")
	@Transactional
	public ModelAndView cadastro(Produto produto) {
		dao.inserir(produto);
		return new ModelAndView("produto/form")
				.addObject("msg", "O produto "+produto.getNome()+" foi cadastrado!");
	}
	
	@GetMapping("listar")
	public ModelAndView listar(){
		return new ModelAndView("produto/list").addObject("listar", dao.listar()); 
	}
	

}
