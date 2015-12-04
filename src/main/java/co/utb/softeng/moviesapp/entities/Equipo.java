/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.utb.softeng.moviesapp.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import co.utb.softeng.moviesapp.services.impl.EquipoServiceImpl;
import java.text.SimpleDateFormat;
        
    

/**
 *
 * @author Juan Mantilla
 */
@Entity
@Table(name = "EQUIPOS")
public class Equipo implements Serializable {
    
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String ubicacion;
    private String horario;
    private String salon;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getSalon() {
        return salon;
    }

    public void setSalon(String salon) {
        this.salon = salon;
    } 
    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        
        this.horario = horario;
   }
        
} 

//String horario;
//
//    EquipoServiceImpl equipos = new EquipoServiceImpl();
//    SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd");
//    for (Equipo equipo: equipos.getAllEquipos()) {
//
//        String input = "2015-01-01";
//        int hora = Integer.parseInt(input.substring(-5, 2));
//        Date t; 
//        try { 
//            t = ft.parse(input); 
//            horario=t.toString(); 
//        } catch (ParseException e) { 
//            System.out.println("Unparseable using " + ft); 
//        }                        
//    }