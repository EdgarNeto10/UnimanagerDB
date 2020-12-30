package pt.iade.unimaneger_db.models;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name = "alunos")

public class Aluno {
    @Id @GeneratedValue
(strategy = GenerationType.IDENTITY)
    @Column(name= "alu_id") private int id;
    @Column(name= "alu_nome") private String nome; 
    @Column(name= "alu_local") private String morada;
    @Column(name= "alu_dnsc") private LocalDate dataNascimento;
    @Column(name= "alu_sexo") private char sexo;
    @Column(name= "alu_email") private String email;   

    @JsonIgnore private int  alu_cur_id;
    @ManyToOne @MapsId("cur_id") @JoinColumn(name = "alu_cur_id")  private Curso curso;

    @OneToMany @JoinColumn(name="ins_alu_id") @JsonIgnoreProperties("aluno")
    private List<Inscricao> inscricoes;


    public Aluno() {}

    public int getId() {
        return id;
    }

    
    public String getNome() {
        return nome;
    }

    

    public String getMorada() {
        return morada;
    }

    

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    

    public char getSexo() {
        return sexo;
    }

  
    public String getEmail() {
        return email;
    }

  

    public Curso getCurso() {
        return curso;
    }

 

    public List<Inscricao> getInscricoes() {
        return inscricoes;
    }
 
}
