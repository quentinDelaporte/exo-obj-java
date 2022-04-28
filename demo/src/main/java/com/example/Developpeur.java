package com.example;

import java.util.Date;

public class Developpeur extends Employe {
  
    public Developpeur(String name, String sex, int salary, Date dateEntry) {
        super(name, sex, Math.max(80000, salary), Metier.DEVELOPPER, dateEntry);
    }

   
}
