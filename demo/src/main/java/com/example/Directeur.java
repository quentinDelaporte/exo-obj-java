package com.example;

import java.util.ArrayList;
import java.util.Date;

public class Directeur extends Employe {
    private ArrayList<Employe> employes = new ArrayList<Employe>();

    public Directeur(String name, String sex, int salary, Date dateEntry) {
        super(name, sex, salary, Metier.DIRECTOR, dateEntry);
    }

    public void AddEmploye(Employe e){
        employes.add(e);
    }

    public ArrayList<Employe> getEmployes() {
        return employes;
    }


}
