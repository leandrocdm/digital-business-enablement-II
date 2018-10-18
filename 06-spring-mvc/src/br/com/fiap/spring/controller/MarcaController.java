package br.com.fiap.spring.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.fiap.jpa.dao.MarcaDAO;
import br.com.fiap.spring.model.Marca;

@Controller
@RequestMapping("marca")
public class MarcaController {

	@Autowired
	private MarcaDAO dao;
	
	@GetMapping("cadastrar")
	public String cadastrar(Marca marca) {
		return "marca/form";
	}
	
	@Transactional
	@PostMapping("cadastrar")
	public String cadastrar(@Valid Marca marca, BindingResult b, 
												RedirectAttributes r) {
		if (b.hasErrors()) {
			return "marca/form";
		}else {
			dao.inserir(marca);
			r.addFlashAttribute("msg", "Marca registrada!");
			return "redirect:/marca/cadastrar";
		}
	}
	
}







