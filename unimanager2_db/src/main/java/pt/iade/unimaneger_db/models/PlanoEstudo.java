package pt.iade.unimaneger_db.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "planoestudos")
@IdClass(PlanEstd_Id.class)


public class PlanoEstudo {

  @Id @Column(name ="pla_cur_id")
    
    @JsonIgnore private int cur_id;
    
    @ManyToOne @MapsId("cur_id") @JoinColumn(name="pla_cur_id")
    @JsonIgnoreProperties("planoestudos") 
    private Curso curso;

    
    @Id @Column(name ="pla_dis_id")
    
    @JsonIgnore private int dis_id;
    
    @ManyToOne @MapsId("dis_id") @JoinColumn(name="pla_dis_id")
    @JsonIgnoreProperties("planoestudos") 
    private Unit unidade;

    @Column(name= "pla_semestre") private int semestre;


  /*
    @OneToMany @JoinColumn(name="ins_pla_cur_id") @JsonIgnoreProperties("planoestudo")
    private List<Inscricao> inscricoes;
  
    @OneToMany @JoinColumn(name="ins_pla_dis_id") @JsonIgnoreProperties("planoestudo")
    private List<Inscricao> inscricoes2;
  
  */
  
  public PlanoEstudo() {}

  public int getCur_id() {
    return cur_id;
  }

 

  public Curso getCurso() {
    return curso;
  }



  public int getDis_id() {
    return dis_id;
  }


  public Unit getUnidade() {
    return unidade;
  }

 
  public int getSemestre() {
    return semestre;
  }


  /*
  public List<Inscricao> getInscricoes() {
    return inscricoes;
  }


  public List<Inscricao> getInscricoes2() {
    return inscricoes2;
  }

  */



  



}
