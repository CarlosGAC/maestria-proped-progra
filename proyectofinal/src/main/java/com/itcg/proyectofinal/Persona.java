/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itcg.proyectofinal;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
public class Persona {

    @Getter
    private long id;
    
    @Getter
    @Setter
    private String nombre;
    
    @Getter
    @Setter
    private String direccion;

    @Getter
    @Setter
    private String telefono;

    @Getter
    @Setter
    private String direccionElectronica;

    @Getter
    private String birthdayDay;
    
    @Getter
    private String birthdayMonth;

    
    private String getBirthday() {
        return birthdayDay + " de " + birthdayMonth;
    }
}
