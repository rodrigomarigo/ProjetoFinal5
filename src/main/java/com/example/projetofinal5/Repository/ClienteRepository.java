package com.example.projetofinal5.Repository;

import com.example.projetofinal5.Entity.Cliente;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
    
}