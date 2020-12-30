package pt.iade.unimaneger_db.models;

import java.sql.Date;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name = "inscricoes")
@IdClass(InsId.class)


public class Inscricao {
    @Id @GeneratedValue
    (strategy = GenerationType.IDENTITY)
        @Column(name= "ins_id") private int id;
        @Column(name= "ins_dt_inscricao") private LocalDate data_incsricao;
        @Column(name= "ins_dt_avaliacao") private LocalDate data_avalicao;
        @Column(name= "ins_nota") private float  nota;

    
    @Id @Column(name ="ins_alu_id")
    
    @JsonIgnore private int alu_id;
    
    @ManyToOne @MapsId("alu_id") @JoinColumn(name="ins_alu_id")
    @JsonIgnoreProperties("inscricoes") 
    private Aluno aluno;

    
    @Id @Column(name ="ins_pla_cur_id")
    
    @JsonIgnore private int pla_cur_id;
    
    @ManyToOne @MapsId("pla_cur_id") @JoinColumn(name="ins_pla_cur_id")
    @JsonIgnoreProperties("inscricoes") 
    private PlanoEstudo planoEstudo;

    @Id @Column(name ="ins_pla_dis_id")
    
    @JsonIgnore private int pla_dis_id;
    
    @ManyToOne @MapsId("pla_dis_id") @JoinColumn(name= "ins_pla_dis_id")
    @JsonIgnoreProperties("inscricoes") 
    private PlanoEstudo planoEstudo2;
    
    public Inscricao(){}

    public int getId() {
        return id;
    }

   

    public LocalDate getData_incsricao() {
        return data_incsricao;
    }


    public LocalDate getData_avalicao() {
        return data_avalicao;
    }

    

    public float getNota() {
        return nota;
    }

    

    public int getAlu_id() {
        return alu_id;
    }

   

    public Aluno getAluno() {
        return aluno;
    }

    

    public int getPla_cur_id() {
        return pla_cur_id;
    }


    public PlanoEstudo getPlanoEstudo() {
        return planoEstudo;
    }

    

    public int getPla_dis_id() {
        return pla_dis_id;
    }

    

    public PlanoEstudo getPlanoEstudo2() {
        return planoEstudo2;
    }

    

    



}
