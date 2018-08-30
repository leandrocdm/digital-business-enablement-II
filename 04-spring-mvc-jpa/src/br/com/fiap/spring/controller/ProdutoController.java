package br.com.fiap.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.fiap.spring.dao.ProdutoDAO;
import br.com.fiap.spring.exception.KeyNotFoundException;
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
	public ModelAndView cadastro(Produto produto, RedirectAttributes r) {
		dao.inserir(produto);
		r.addFlashAttribute(
				"msgCadastro", "O produto "+produto.getNome()+" foi cadastrado com sucesso!");
		return new ModelAndView("redirect:/produto/cadastrar");

	}

	@GetMapping("listar")
	public ModelAndView listar(){
		return new ModelAndView("produto/list").addObject("listar", dao.listar()); 
	}

	@GetMapping("editar/{id}")
	public ModelAndView editar(@PathVariable("id") int id) {
		Produto produto = dao.pesquisar(id);
		return new ModelAndView("produto/editar").addObject("produto", produto);
	}

	@PostMapping("editar")
	@Transactional
	public ModelAndView editar(Produto produto, RedirectAttributes r){ 
		dao.atualizar(produto);
		r.addFlashAttribute("msgEdicao", "Produto editado com sucesso!");
		return new ModelAndView("redirect:/produto/listar"); 

	}

	@GetMapping("excluir/{id}")
	@Transactional
	public ModelAndView excluir(@PathVariable("id")int id, RedirectAttributes r) throws KeyNotFoundException {
		dao.remover(id);
		r.addFlashAttribute("msgDelete", "Produto excluido com sucesso");
		return new ModelAndView("redirect:/produto/listar");
	}

}
