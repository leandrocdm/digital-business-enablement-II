package br.com.fiap.spring.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name="T_06_SPRING_MARCA")
@SequenceGenerator(name="marca", sequenceName="SQ_06_SPRING__MARCA",allocationSize=1)
public class Marca {

	@Id
	@GeneratedValue(generator="marca",strategy=GenerationType.SEQUENCE)
	private int codigo;
	
	@NotBlank(message="O nome � obrigat�rio")
	private String nome;
	
	@OneToMany(mappedBy="marca")
	private List<Carro> carros;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public List<Carro> getCarros() {
		return carros;
	}

	public void setCarros(List<Carro> carros) {
		this.carros = carros;
	}
	
}
