/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.repositorios;

import com.example.demo.modelos.Alumnos;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author uth
 */
public interface AlumnoRepositorio extends CrudRepository<Alumnos, Long> {
    
}
