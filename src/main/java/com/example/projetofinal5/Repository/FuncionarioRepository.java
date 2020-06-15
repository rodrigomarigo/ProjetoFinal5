package com.example.projetofinal5.Repository;

import com.example.projetofinal5.Entity.Funcionario;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Integer>{
    
}