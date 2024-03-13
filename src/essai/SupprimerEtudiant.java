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

/**
 *
 * @author BEST
 */
public class SupprimerEtudiant {
    public static void main(String[] args) {
        supprimer("1111");
    }
    public static String supprimer(String matricule){
        ListeEtudiants listeEtudiants =  new ListeEtudiants();
        Etudiant etudiant1 = new Etudiant();
        etudiant1.setMatricule(matricule);
        List<Etudiant> list_ = new ArrayList<>();
        list_.add(etudiant1);
        listeEtudiants.setEtudiants(list_);
        EnregistrementXML enr = new EnregistrementXML();
        String reponse = enr.deleteEtudiant(listeEtudiants);
        return reponse;
    }
}
