package br.com.fiap.spring.dao.impl;

import org.springframework.stereotype.Repository;

import br.com.fiap.spring.dao.OrcamentoDAO;
import br.com.fiap.spring.model.Orcamento;

@Repository
public class OrcamentoDAOImpl 
			extends GenericDAOImpl<Orcamento, Integer> implements OrcamentoDAO{

}
