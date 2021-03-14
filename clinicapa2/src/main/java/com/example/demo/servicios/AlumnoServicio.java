/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.servicios;

import com.example.demo.modelos.Alumnos;
import com.example.demo.repositorios.AlumnoRepositorio;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author uth
 */
@Service
public class AlumnoServicio {
    @Autowired
    private AlumnoRepositorio repositorio;
    
    public Alumnos guardar(Alumnos entidad){
        return repositorio.save(entidad);
    }
    
    public void eliminar(Long id){
        repositorio.deleteById(id);
    }
    
    public Optional<Alumnos> getValor(Long id){
        return repositorio.findById(id);
    }
    
    public List<Alumnos> getTodos(){
        return (List<Alumnos>)repositorio.findAll();
    }
}
