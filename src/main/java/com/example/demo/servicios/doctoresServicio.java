/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.servicios;


import com.example.demo.modelos.Doctores;
import com.example.demo.repositorios.doctoresRepositorio;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author uth
 */
@Service
public class doctoresServicio {
    @Autowired
    private doctoresRepositorio repositorio;
    
    public Doctores guardar(Doctores entidad){
        return repositorio.save(entidad);
    }
    
    public void eliminar(Long id_doctor){
        repositorio.deleteById(id_doctor);
    }
    
    public Optional<Doctores> getValor(Long id_doctor){
        return repositorio.findById(id_doctor);
    }
    
    public List<Doctores> getTodos(){
        return (List<Doctores>)repositorio.findAll();
    }

}
