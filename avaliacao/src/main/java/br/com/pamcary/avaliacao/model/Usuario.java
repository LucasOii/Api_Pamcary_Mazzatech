package br.com.pamcary.avaliacao.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "tb_usuario")
public class Usuario {
	
	@Id //PRIMARY KEY (ID)
	@GeneratedValue(strategy = GenerationType.IDENTITY) //  AUTO INCREMENT 
	private Long id;
	
	@NotBlank(message = "O nome é obrigatório!")
	@Size(min = 5, max = 100, message = "Deve conter no min 5 e max 100")
	private String nome;
		
	@CPF
	@NotBlank(message = "O CPF é obrigatório!")
	@Size(min = 12, max = 14, message = "O CPF deve conter 11 digitos, ex:000.111.222-12")
	private String cpf;
		
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dataNascimento;
		
	@UpdateTimestamp
	private LocalDateTime data;
	
	//@Temporal(TemporalType.TIMESTAMP)
	//private Date lastUpdate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public LocalDateTime getData() {
		return data;
	}

	public void setData(LocalDateTime data) {
		this.data = data;
	}
	
}
