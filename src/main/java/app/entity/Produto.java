package app.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@NotBlank(message = "O campo Nome não pode estar em branco")
	private String nome;
	@NotNull(message = "O campo Valor não pode ser nulo")
	private double valor;
	@NotBlank(message = "O campo Marca não pode estar em branco")
	private String marca;
	

	/**
	 * Relacionamento Many-to-Many entre esta entidade e Venda.
	 * Cada instância pode estar associada a várias vendas, referenciadas por "produto" em Venda.
	 */

	@ManyToMany(mappedBy = "produto")
	@JsonIgnoreProperties("produto")
	private List<Venda> vendas;



}
