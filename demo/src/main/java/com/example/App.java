package com.example;

import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

public class App 
{
    public static void main( String[] args )
    {
        Directeur directeur = new Directeur("Quentin", "Homme", 80000, new Date(2013,05,11));
        Manager manager = new Manager("Julien", "Homme", 80000, new Date(2013,05,11));

        Developpeur e1 = new Developpeur("Ephrem", "Homme", 90000, new Date(2013,05,11));
        Developpeur e2 = new Developpeur("Theo", "Homme", 80000, new Date(2017,05,11));
        Developpeur e3 = new Developpeur("Clement", "Homme", 120000, new Date(2015,05,11));
        Stagiaire e4 = new Stagiaire("Stagiaire", "Homme", 0, new Date(2013,05,11));
        Stagiaire e5 = new Stagiaire("Stagiaire", "Homme", 0, new Date(2013,05,11));
        Stagiaire e6 = new Stagiaire("Stagiaire", "Homme", 0, new Date(2013,05,11));
        Stagiaire e7 = new Stagiaire("Stagiaire", "Homme", 0, new Date(2013,05,11));

        manager.AddSubordinate(e1);
        manager.AddSubordinate(e2);
        manager.AddSubordinate(e3);
        manager.AddSubordinate(e4);
        manager.AddSubordinate(e5);
        manager.AddSubordinate(e6);
        manager.AddSubordinate(e7);

        directeur.AddEmploye(manager);
        for (Employe e : manager.getSubOrdonnee()) {
            directeur.AddEmploye(e);
        }

        System.out.println(getMoySalary("Homme", manager.getSubOrdonnee(), 2021));
        // displayManagerAndEquip(manager);
        //  AfficherOrganigramme(directeur, 2015);
         AfficherOrganigrammeLicenciement100KAnnuel(directeur, 2022);
         AfficherOrganigrammeLicenciement100KAnnuel(directeur, 2023);
    }

    public static float getMoySalary(String sex, ArrayList<Employe> employees, int year){
        int total = 0;
        int nbEmployees = 0;
        for (Employe employe : employees) {
            if(Objects.equals(employe.getSex(), sex)){
                if(!(employe instanceof Stagiaire)){
                    if(employe.presentDansBoite(year)){
                        nbEmployees++;
                        total += employe.getSalary();
                    }
                }
            }
        }
        return nbEmployees > 0 ? total/nbEmployees : 0;
    }

    public static void displayManagerAndEquip(Manager m){
        System.out.println("Manager: " + m.getName());
        System.out.println("Subordonnées:");
        for (Employe employe : m.getSubOrdonnee()) {
            System.out.println("-" + employe.getName());
        }
    }

    public static void AfficherOrganigramme(Directeur d){
        System.out.println("Directeur :" + d.getName() + " - " + d.getMetier());
        System.out.println("|");
        for (Employe employe : d.getEmployes()) {
            if(employe.getMetier() == Metier.MANAGER){
                System.out.println("|---" + employe.getName() + " - " + employe.getMetier());
                System.out.println("|   |");
                if(employe instanceof Manager){
                    Manager m = (Manager) employe;
                    for (Employe e : m.getSubOrdonnee()) {
                        System.out.println("|   |---" + e.getName() + " - " + e.getMetier());
                    }
                }
            }
        }
        
    }

    public static void AfficherOrganigramme(Directeur d, int year){
        if(d.presentDansBoite(year)){
            System.out.println("Directeur :" + d.getName() + " - " + d.getMetier());
            System.out.println("|");
            for (Employe employe : d.getEmployes()) {
                if(employe.getMetier() == Metier.MANAGER && employe.presentDansBoite(year)){
                    System.out.println("|---" + employe.getName() + " - " + employe.getMetier());
                    System.out.println("|   |");
                    if(employe instanceof Manager){
                        Manager m = (Manager) employe;
                        for (Employe e : m.getSubOrdonnee()) {
                            if( e instanceof Developpeur && 
                                e.presentDansBoite(year))
                                    System.out.println("|   |---" + e.getName() + " - " + e.getMetier());
                        }
                    }
                }
            }
        }
    }

    public static void AfficherOrganigrammeLicenciement100KAnnuel(Directeur d, int year){
        if(d.presentDansBoite(year)){
            System.out.println("Directeur :" + d.getName() + " - " + d.getMetier());
            System.out.println("|");
            for (Employe employe : d.getEmployes()) {
                if(employe.getMetier() == Metier.MANAGER && employe.presentDansBoite(year)){
                    System.out.println("|---" + employe.getName() + " - " + employe.getMetier());
                    System.out.println("|   |");
                    if(employe instanceof Manager){
                        Manager m = (Manager) employe;
                        for (Employe e : m.getSubOrdonnee()) {
                            if( e instanceof Developpeur && 
                                e.presentDansBoite(year) && 
                                e.getSalary() < 100000){
                                    e.setSalary((int)(e.getSalary()*1.1 > 100000 ? 100000 : e.getSalary()*1.1));
                                    System.out.println("|   |---" + e.getName() + " - " + e.getMetier() + " - " + e.getSalary());
                                } else {
                                    e.QuitterEntreprise(new Date(year,01,01));
                                }
                        }
                    }
                }
            }
        }
    }
}
