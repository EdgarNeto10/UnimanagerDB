package pt.iade.unimaneger_db.models;

import java.util.List;


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
@Table(name = "disciplinas")

public class Unit {
    @Id @GeneratedValue
         (strategy = GenerationType.IDENTITY)
    private int dis_id;
    private String dis_nome;
    private int dis_creditos;

    @OneToMany @JoinColumn(name="pla_dis_id") @JsonIgnoreProperties("unit")
    private List<PlanoEstudo> plano_Estudos;
    
    @JsonIgnore private int  dis_dep_id;
    @ManyToOne @MapsId("dep_id") @JoinColumn(name = "dis_dep_id")  private Departamento departamento;
    
    public Unit() {}

    public int getDis_id() {
      return dis_id;
    }



    public String getDis_nome() {
      return dis_nome;
    }


    public int getDis_creditos() {
      return dis_creditos;
    }

    public List<PlanoEstudo> getPlano_Estudos() {
      return plano_Estudos;
    }

    public Departamento getDepartamento() {
      return departamento;
    }

    

    
}
