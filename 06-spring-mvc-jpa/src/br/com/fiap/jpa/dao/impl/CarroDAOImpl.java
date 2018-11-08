package br.com.fiap.jpa.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.fiap.jpa.dao.CarroDAO;
import br.com.fiap.spring.model.Carro;

@Repository
public class CarroDAOImpl extends GenericDAOImpl<Carro, Integer>
														implements CarroDAO{
	@Override
	public List<Carro> pesquisarPor(String carro) {
		return em.createQuery("FROM T_06_SPRING_CARRO c WHERE UPPER NOME LIKE UPPER(:pCarro)", Carro.class).
				setParameter("pCarro", "%" + carro + "%").getResultList();
	}

}
