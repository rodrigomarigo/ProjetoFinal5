package com.example.projetofinal5.Entity;

import java.io.Serializable;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.lang.NonNull;

@Entity
public class Horario implements Serializable{
    private static final long serialVersionUID = 1L;
    
    @Id
    @NonNull
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

    @NonNull
    private Funcionario funcionario;

    @NonNull
    private Procedimento procedimento;

    // @NonNull
    // @Basic
    // @Column(name = "horario", columnDefinition = "DATE")
    // private LocalDate horario;

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return this.cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Funcionario getFuncionario() {
        return this.funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public Procedimento getProcedimento() {
        return this.procedimento;
    }

    public void setProcedimento(Procedimento procedimento) {
        this.procedimento = procedimento;
    }

    // public LocalDate getHorario() {
    //     return this.horario;
    // }

    // public void setHorario(LocalDate horario) {
    //     this.horario = horario;
    // }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", cliente='" + getCliente() + "'" +
            ", funcionario='" + getFuncionario() + "'" +
            ", procedimento='" + getProcedimento() + "'" +
            // ", horario='" + getHorario() + "'" +
            "}";
    }

}