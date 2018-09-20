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

import br.com.fiap.jpa.dao.BebidaDAO;
import br.com.fiap.jpa.exception.KeyNotFoundException;
import br.com.fiap.spring.model.Bebida;

@Controller
@RequestMapping("bebida")
public class BebidaController {

	@Autowired
	private BebidaDAO dao;
	
	@GetMapping("pesquisar")
	public ModelAndView buscar(String nome) {
		return new ModelAndView("bebida/lista")
				.addObject("bebidas", dao.buscarPorNome(nome) );
	}
	
	@Transactional
	@PostMapping("remover")
	public String excluir(int codigo, RedirectAttributes r) {
		try {
			dao.delete(codigo);
			r.addFlashAttribute("msg", "Bebida excluida");
		} catch (KeyNotFoundException e) {
			e.printStackTrace();
		}
		return "redirect:/bebida/listar";
	}
	
	@Transactional
	@PostMapping("editar")
	public String processarEdicao(Bebida bebida, RedirectAttributes r) {
		dao.update(bebida);		
		r.addFlashAttribute("msg", "Bebida atualizada!");
		return "redirect:/bebida/listar";
	}
	
	@GetMapping("editar/{id}")
	public ModelAndView abrirEdicao(@PathVariable("id") int codigo) {
		return new ModelAndView("bebida/edicao")
				.addObject("bebida", dao.read(codigo));
	}
	
	@GetMapping("listar")
	public ModelAndView abrirLista() {
		return new ModelAndView("bebida/lista")
				.addObject("bebidas", dao.list());
	}
	
	@GetMapping("cadastrar")
	public String abrirForm() {
		return "bebida/form";
	}
	
	@Transactional
	@PostMapping("cadastrar")
	public ModelAndView processarForm(Bebida bebida, RedirectAttributes r) {
		dao.create(bebida);
		//Adiciona uma mensagem no objeto que guarda informa��o ap�s redirect
		r.addFlashAttribute("msg", "Bebida cadastrada!");
		//Redirect envia para uma URL
		return new ModelAndView("redirect:/bebida/cadastrar");
				
	}
	
}





