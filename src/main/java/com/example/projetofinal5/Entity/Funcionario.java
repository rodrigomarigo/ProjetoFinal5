package com.example.projetofinal5.Entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.UniqueConstraint;

import org.springframework.lang.NonNull;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

@Entity
public class Funcionario implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @NonNull
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    
    @NonNull
    private String nome;

    @ManyToMany
    @JoinTable(
        name = "FuncionarioProcedimento",
        uniqueConstraints = @UniqueConstraint (columnNames = { "id_funcionario", "id_procedimento" }),
        joinColumns        = @JoinColumn(name = "id_funcionario"), 
        inverseJoinColumns = @JoinColumn(name = "id_procedimento")
    )
    private List<Procedimento> procedimentosRealizaveis;

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public List<Procedimento> getProcedimentosRealizaveis() {
        return this.procedimentosRealizaveis;
    }

    public void setProcedimentosRealizaveis(List<Procedimento> procedimentosRealizaveis) {
        this.procedimentosRealizaveis = procedimentosRealizaveis;
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", nome='" + getNome() + "'" +
            ", procedimentosRealizaveis='" + getProcedimentosRealizaveis() + "'" +
            "}";
    }
    


}