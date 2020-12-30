package pt.iade.unimaneger_db.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;


@Entity
@Table(name= "cursos")
public class Curso {
    @Id  @GeneratedValue
         (strategy = GenerationType.IDENTITY)
	
		 @Column(name= "cur_id") private int id;
	@Column(name= "cur_nome") private String nome;
	

	@OneToMany @JoinColumn(name="pla_cur_id") @JsonIgnoreProperties("curso")
    private List<PlanoEstudo> plano_Estudos;
	
	@OneToMany @JoinColumn(name="alu_cur_id") @JsonIgnoreProperties("curso")
    private List<Aluno> alunos;
	
	public Curso() {}
	
	
	
	public int getId() {
		return id;
	}
	
	public String getNome() {
		return nome;
	}

	public List<PlanoEstudo> getPlano_Estudos() {
		return plano_Estudos;
	}


	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}

	



    
}
