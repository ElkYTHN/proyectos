/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.controladores;

import com.example.demo.modelos.Doctores;
import com.example.demo.servicios.doctoresServicio;
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
public class doctoresUIcontrolador {
 @Autowired
 private doctoresServicio servicio;
 
 @RequestMapping("/doctores")
 public String index(Model model){
     setParametro(model,"lista", servicio.getTodos());
     return "doctores";
 }
 
 @GetMapping("/crear")
 public String irCrear(Model model){
     setParametro(model,"crearDoctor", new Doctores());
     return "crearDoctor";
 }
 
 @GetMapping("/actualizar/{id_doctor}")
 public String irActualizar(@PathVariable("id") Long id_doctor, Model model){
     setParametro(model,"crearDoctor",servicio.getValor(id_doctor));
     return "crearDoctor";
 }
 
 @PostMapping("/guardar")
 public String guardar(Doctores doctores, Model model){
     servicio.guardar(doctores);
     return "redirect:/doctores";
 }
 
 @GetMapping("/eliminar/{id_doctor}")
 public String eliminar(@PathVariable("id_doctor") Long id_doctor, Model model){
     servicio.eliminar(id_doctor);
     return "redirect:/doctores";
 }
 public void setParametro(Model model, String atributo, Object valor){
     model.addAttribute(atributo, valor);
 }
}
