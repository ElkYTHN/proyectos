/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.controladores;

import com.example.demo.modelos.Alumnos;
import com.example.demo.servicios.AlumnoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author uth
 */
@Controller
public class AlumnoUIControlador {
 @Autowired
 private AlumnoServicio servicio;
 
 @RequestMapping("/")
 public String index(Model model){
     setParametro(model,"lista", servicio.getTodos());
     return "index";
 }
 
 @GetMapping("/crear")
 public String irCrear(Model model){
     setParametro(model,"alumno", new Alumnos());
     return "alumno";
 }
 
 @GetMapping("/actualizar/{id}")
 public String irActualizar(@PathVariable("id") Long id, Model model){
     setParametro(model,"alumno",servicio.getValor(id));
     return "alumno";
 }
 
 @PostMapping("/guardar")
 public String guardar(Alumnos alumno, Model model){
     servicio.guardar(alumno);
     return "redirect:/";
 }
 
 @GetMapping("/eliminar/{id}")
 public String eliminar(@PathVariable("id") Long id, Model model){
     servicio.eliminar(id);
     return "redirect:/";
 }
 public void setParametro(Model model, String atributo, Object valor){
     model.addAttribute(atributo, valor);
 }
}
