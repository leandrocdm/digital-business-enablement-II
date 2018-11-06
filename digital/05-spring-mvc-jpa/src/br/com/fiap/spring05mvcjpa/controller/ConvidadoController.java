package br.com.fiap.spring05mvcjpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.fiap.spring05mvcjpa.dao.ConvidadoDAO;
import br.com.fiap.spring05mvcjpa.model.Convidado;

@Controller
@RequestMapping("convidado")
public class ConvidadoController {

	@Autowired
	private ConvidadoDAO dao;

	private ModelAndView model;

	@GetMapping("cadastrar")
	public ModelAndView cadastrar() {
		model = new ModelAndView("cadastrar/cadastrar-convidado");
		model.addObject("convidado", new Convidado());
		return model;
	}

	@Transactional
	@PostMapping("cadastrar")
	public ModelAndView cadastrar(Convidado convidado, RedirectAttributes rdr) {
		model = new ModelAndView("redirect:/convidado/cadastrar");		
		try {
			dao.inserir(convidado);
			rdr.addFlashAttribute("msgSucesso", "Convidado "+convidado.getNome()+" cadastrado com sucesso!");
		} catch (Exception e) {
			rdr.addFlashAttribute("msgErro", "Erro ao tentar cadastrar o convidado!");
		}	
		return model;
	}

	@GetMapping("listar")
	public ModelAndView listarConvidados() {
		model = new ModelAndView("listar/lista-convidados");
		model.addObject("convidados", dao.listarEmOrdemAlfabetica());
		return model;
	}

	@Transactional
	@PostMapping("confirmar-presenca")
	public String confirmarPresenca(int codigo, RedirectAttributes redirectAttribute) {
		try {
			dao.confirmar(codigo);
			redirectAttribute.addFlashAttribute("msgSucesso", "Convidado confirmado com sucesso!");
		} catch (Exception e) {
			redirectAttribute.addFlashAttribute("msgErro", "Erro ao tentar confirmar a presença do convidado!");
		}
		return "redirect:/convidado/listar";
	}

	@Transactional
	@PostMapping("excluir-convidado")
	public String excluirConvidado(int codigo, RedirectAttributes redirectAttribute) {		
		try {
			dao.remover(codigo);
			redirectAttribute.addFlashAttribute("msgSucesso", "Convidado excluído com sucesso!");
		} catch (Exception e) {
			redirectAttribute.addFlashAttribute("msgErro", "Erro ao tentar excluir o convidado!");
		}	
		return "redirect:/convidado/listar";
	}

	@GetMapping("pesquisar")
	public ModelAndView pesquisar(String pesquisa) {		
		model = new ModelAndView("listar/lista-convidados");
		try {
			model.addObject("convidados", dao.pesquisarPor(pesquisa));
		} catch (Exception e) {
			model.addObject("msgErro", "Erro ao tentar listar os convidado!");
		}
		return model;
	}

	@GetMapping("editar-convidado/{id}")
	public ModelAndView abrirPaginaEditar(@PathVariable("id") int codigo) {
		model = null;	
		try {
			model = new ModelAndView("editar/editar-convidado");
			model.addObject("convidado",dao.pesquisar(codigo));
			return model;
		} catch (Exception e) {
			model.addObject("msgErro", "Erro ao tentar abrir a página de edição.");
			model = new ModelAndView("redirect:/convidado/listar");
			return model;
		}		
	}

	@Transactional
	@PostMapping("editar-convidado")
	public String editar(Convidado convidado, RedirectAttributes redirectAttribute) {	
		try {
			dao.atualizar(convidado);
			redirectAttribute.addFlashAttribute("msgSucesso", "Convidado editado com sucesso!");
		} catch (Exception e) {
			redirectAttribute.addFlashAttribute("msgErro", "Erro ao tentar editar o convidado!");
		}	
		return "redirect:/convidado/listar";
	}
}
