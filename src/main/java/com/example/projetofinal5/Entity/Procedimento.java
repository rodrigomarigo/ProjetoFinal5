package com.example.projetofinal5.Entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.UniqueConstraint;
import javax.persistence.JoinColumn;

import org.springframework.lang.NonNull;

@Entity
public class Procedimento implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    @NonNull
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;

    @NonNull
    private String nome;

    //armazena lista de funcionarios que realizam esse procedimento
    @ManyToMany
    @JoinTable(
        name = "FuncionarioProcedimento",
        uniqueConstraints = @UniqueConstraint (columnNames = { "id_funcionario", "id_procedimento" }),
        joinColumns        = @JoinColumn(name = "id_procedimento"), 
        inverseJoinColumns = @JoinColumn(name = "id_funcionario")
    )
    private List<Funcionario> funcionarios;

    //em minutos
    @NonNull
    private int duracao;


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

    public List<Funcionario> getFuncionarios() {
        return this.funcionarios;
    }

    public void setFuncionarios(List<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }

    public int getDuracao() {
        return this.duracao;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }


    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", nome='" + getNome() + "'" +
            ", funcionarios='" + getFuncionarios() + "'" +
            ", duracao='" + getDuracao() + "'" +
            "}";
    }

}