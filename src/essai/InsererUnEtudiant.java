/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package essai;

import bean.Etudiant;
import bean.ListeEtudiants;
import client.EnregistrementXML;
import java.util.ArrayList;
import java.util.List;
import server.XMLtoDalabase;

/**
 *
 * @author BEST
 */
public class InsererUnEtudiant {
     public static void main(String[] args) {
        insertion("125", "anachi2", 124, "Lot2");
    }
    public static String insertion(String matricule, String nom, int bourse, String adresse){
        boolean trouver = false;
        XMLtoDalabase data = new XMLtoDalabase();
        ListeEtudiants liste = data.recuperationListeEtudiant();
        for (Etudiant etudiant : liste.getEtudiants()) {
            System.out.println(etudiant.getMatricule());
            System.out.println("mtricuel:"+matricule);
            String matriculeCompare = etudiant.getMatricule();
            if(matriculeCompare.compareTo(matricule) == 0) {
                trouver = true;
                break;
            }
        }
        if(trouver == false){
            ListeEtudiants listeEtudiants =  new ListeEtudiants();
            Etudiant etudiant1 = new Etudiant();
            etudiant1.setMatricule(matricule);
            etudiant1.setNom(nom);
            etudiant1.setBourse(bourse);
            etudiant1.setAdresse(adresse);
            List<Etudiant> list_ = new ArrayList<>();
            list_.add(etudiant1);
            listeEtudiants.setEtudiants(list_);
            EnregistrementXML enregistrementXML =new EnregistrementXML();
            enregistrementXML.insertEtudiant(listeEtudiants);
            return "Enregistrement";
        }
        else{
            return "ExisteDeja";
        }
    }
}
