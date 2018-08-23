package br.com.fiap.spring.dao;

import java.util.List;

import br.com.fiap.spring.exception.CommitException;
import br.com.fiap.spring.exception.KeyNotFoundException;


public interface GenericDAO<T,K> {

	void inserir(T entidade);
	
	List<T> listar();
	
	void atualizar(T entidade);
	
	void remover(K codigo) throws KeyNotFoundException;
	
	T pesquisar(K codigo);
		
}



