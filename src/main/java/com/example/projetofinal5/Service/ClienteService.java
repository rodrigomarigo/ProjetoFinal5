package com.example.projetofinal5.Service;

import java.util.List;

import com.example.projetofinal5.Entity.Cliente;
import com.example.projetofinal5.Repository.ClienteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository repository;
    
    public List<Cliente> getClientes(){
        return repository.findAll();
    }

    public void salvar(Cliente cliente){
        repository.save(cliente);
    }

    public Cliente getClienteById(int id){
        return repository.findById(id).get();
    }
}