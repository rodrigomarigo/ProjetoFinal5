package com.example.projetofinal5.Service;

import java.util.List;

import com.example.projetofinal5.Entity.Horario;
import com.example.projetofinal5.Repository.HorarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HorarioService {
    @Autowired
    private HorarioRepository repository;

    public List<Horario> getHorarios(){
        return repository.findAll();
    }
    
    public void salvar(Horario horario){
        repository.save(horario);
    }

    public Horario getHorarioById(int id){
        return repository.findById(id).get();
    }

}