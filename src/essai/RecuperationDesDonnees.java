/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package essai;

/**
 *
 * @author BEST
 */
import java.util.ArrayList;
import java.util.List;
import bean.Etudiant;
import server.XMLtoDalabase;
import bean.ListeEtudiants;

public class RecuperationDesDonnees {
    /*public static void main(String[] args) {
       toutLesDonnees();
    }*/
    public static List<Etudiant> toutLesDonnees() { 
        XMLtoDalabase data = new XMLtoDalabase();
        ListeEtudiants liste = data.recuperationListeEtudiant();
        System.out.println("Liste des étudiants :");
        List<Etudiant> listeEtudiants = new ArrayList<>();
        for (Etudiant etudiant : liste.getEtudiants()) {
            System.out.println(etudiant);
            listeEtudiants.add(etudiant);
        }
        return listeEtudiants;
    } 
    public static void toutDonneesSupprimer(){ 
        XMLtoDalabase data = new XMLtoDalabase();
        ListeEtudiants liste = data.recuperationListeEtudiantSupprimer();
        System.out.println("Liste des étudiants :");
        for (Etudiant etudiant : liste.getEtudiants()) {
            System.out.println(etudiant);
        }
    }
    public static void toutDonneesInserer(){ 
        XMLtoDalabase data = new XMLtoDalabase();
        ListeEtudiants liste = data.recuperationListeEtudiantInsert();
        System.out.println("Liste des étudiants :");
        for (Etudiant etudiant : liste.getEtudiants()) {
            System.out.println(etudiant);
        }
    } 
    public static void toutDonneesUptate(){ 
        XMLtoDalabase data = new XMLtoDalabase();
        ListeEtudiants liste = data.recuperationListeEtudiantUpdate();
        System.out.println("Liste des étudiants :");
        for (Etudiant etudiant : liste.getEtudiants()) {
            System.out.println(etudiant);
        }
    } 
}
