package com.example;

import java.util.Date;

abstract public class Employe {
    private String name;
    private String sex;
    private int salary;
    private Metier metier;
    private Date dateEntry;
    private Date dateSortie;

    public Employe(String name, String sex, int salary, Metier metier, Date dateEntry) {
        this.name = name;
        this.sex = sex;
        this.salary = salary;
        this.metier = metier;
        this.dateEntry = dateEntry;
    }

    public int getSalary(){
        return salary;
    }

    public String getSex(){
        return sex;
    }

    public String getName(){
        return name;
    }

    public Metier getMetier(){
        return metier;
    }
    
    public String getMetierToString(){
        switch (metier) {
            case DEVELOPPER:
                if(this.salary == 0)
                    return "Stagiaire";
                return "Developpeur";
            case DIRECTOR:
                return "Directeur";
            case SYS_ADMIN:
                return "Administrateur systeme";
            case MANAGER:
                return "Manager";
        }
        return "undefined";
    }

    public void getHierarchie(){}

    public void QuitterEntreprise(Date d){
        this.dateSortie = d;
    }

    public boolean presentDansBoite(int year){
        if(dateSortie==null)
            return year >= dateEntry.getYear();
        return year <= dateSortie.getYear() && 
               year >= dateEntry.getYear();
    }

    public void setSalary(int d) {
        this.salary = d;
    }
}
