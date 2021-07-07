/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itcg.proyectofinal;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class Persona {

    @Getter
    private long id;
    
    @Getter
    private String nombre;
    
    @Getter
    private String direccion;

    @Getter
    private String telefono;

    @Getter
    private String direccionElectronica;

    @Getter
    private String birthdayDay;
    
    @Getter
    private String birthdayMonth;

    
    private String getBirthday() {
        return birthdayDay + " de " + birthdayMonth;
    }
}
