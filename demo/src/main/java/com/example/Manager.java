package com.example;

import java.util.ArrayList;
import java.util.Date;

public class Manager extends Employe{
    private ArrayList<Employe> subOrdonnee;
    public Manager(String name, String sex, int salary, Date dateEntry) {
        super(name, sex, salary, Metier.MANAGER, dateEntry);
        this.subOrdonnee = new ArrayList<Employe>();
    }

    public ArrayList<Employe> getSubOrdonnee() {
        return this.subOrdonnee;
    }

    public void AddSubordinate(Employe e){
        if(e instanceof Developpeur)
            this.subOrdonnee.add(e);
    }
    
    @Override
    public int getSalary(){
        int total = 0;
        int nbEmployees = 0;
        for (Employe employe : subOrdonnee) {
            nbEmployees++;
            total += employe.getSalary();
        }
        return (int) ((nbEmployees > 0 ? total/nbEmployees : 0) * 1.1); 
    }
}