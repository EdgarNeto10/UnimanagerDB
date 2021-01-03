package pt.iade.unimaneger_db.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name = "departamentos")

public class Departamento {
    @Id @GeneratedValue
    (strategy = GenerationType.IDENTITY)
        @Column(name= "dep_id") private int id;
        @Column(name= "dep_nome") private String nome; 
        @Column(name= "dep_sigla") private char sigla;

        
        @OneToMany @JoinColumn(name="dis_dep_id") @JsonIgnoreProperties("departamento") private List<Unit> unidades;
    

        public Departamento(){}
        
        public int getId() {
            return id;
        }

        public String getNome() {
            return nome;
        }

        public char getSigla() {
            return sigla;
        }  

    

        public List<Unit> getUnidades() {
            return unidades;
        }

    

        
    

}
