package com.example.projetofinal5.Service;

import java.util.List;

import com.example.projetofinal5.Entity.Funcionario;
import com.example.projetofinal5.Repository.FuncionarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FuncionarioService {
    @Autowired
    private FuncionarioRepository repository;

    public List<Funcionario> getFuncionarios(){
        return repository.findAll();
    }

    public void salvar(Funcionario funcionario){
        repository.save(funcionario);
    }

    public Funcionario getFuncionarioById(int id){
        return repository.findById(id).get();
    }
}