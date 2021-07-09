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
public class ContactEntry {

    @Getter
    private long id;
    
    @Getter
    private String name;
    
    @Getter
    private String address;

    @Getter
    private String phone;

    @Getter
    private String mailAddress;

    @Getter
    private String birthdayDay;
    
    @Getter
    private String birthdayMonth;

    
    private String getBirthday() {
        return birthdayDay + " de " + birthdayMonth;
    }
}
