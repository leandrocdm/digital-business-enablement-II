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

import br.com.fiap.jpa.dao.ProdutoDAO;
import br.com.fiap.jpa.exception.KeyNotFoundException;
import br.com.fiap.jpa.model.Produto;

@Controller
@RequestMapping("produto")
public class ProdutoController {
	
	@Autowired
	private ProdutoDAO dao;
	
	@GetMapping("buscar")
	public ModelAndView pesquisarPorNome(String nomeProduto) {
		return new ModelAndView("produto/lista")
				.addObject("produtos", dao.buscarPorNome(nomeProduto));
	}
	
	@Transactional
	@PostMapping("excluir")
	public String apagar(int id, RedirectAttributes r) {
		//Apagar do banco de dados
		try {
			dao.remover(id);
			r.addFlashAttribute("msg", "Produto excluido");
		} catch (KeyNotFoundException e) {
			e.printStackTrace();
		}
		return "redirect:/produto/listar";
	}

	@Transactional
	@PostMapping("editar")
	public String processaEdicao(Produto produto, RedirectAttributes r) {
		//Atualiza no banco de dados
		dao.atualizar(produto);
		//Mensagem de sucesso
		r.addFlashAttribute("msg", "Produto atualizado");
		//Redireciona para a listagem
		return "redirect:/produto/listar";
	}
	
	@GetMapping("editar/{id}")
	public ModelAndView abrirEdicao(@PathVariable("id") int id) {
		//Retorna a página com os valores do produto para o formulário HTML
		return new ModelAndView("produto/edicao")
				.addObject("produto", dao.pesquisar(id));
	}
	
	@GetMapping("listar")
	public ModelAndView listar() {
		return new ModelAndView("produto/lista")
				//Envia a lista de produtos para a tela
				.addObject("produtos", dao.listar());
	}
	
	@GetMapping("cadastrar")
	public String abrirForm() {
		return "produto/form";
	}
	
	@Transactional
	@PostMapping("cadastrar")
	public ModelAndView processarForm(Produto produto, RedirectAttributes r) {
		dao.inserir(produto);
		//Adiciona a mensagem no objeto que mantém a informação após redirect
		r.addFlashAttribute("msg", "Produto cadastrado!");
		//Redirect para uma URL e não uma página
		return new ModelAndView("redirect:/produto/cadastrar");
	}
	
}