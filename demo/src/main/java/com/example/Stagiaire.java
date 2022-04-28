package com.example;

import java.util.Date;

public class Stagiaire extends Employe {
  
    public Stagiaire(String name, String sex, int salary, Date dateEntry) {
        super(name, sex, Math.min(0, salary), Metier.DEVELOPPER, dateEntry);
    }

   
}
