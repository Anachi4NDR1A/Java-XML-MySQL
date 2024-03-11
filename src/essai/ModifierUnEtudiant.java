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
public class ModifierUnEtudiant {
    public static void main(String[] args) {
        mofif("123","boussa", "lot", 100);
    }
    public static void mofif(String matricule, String nom, String adresse, int bourse){
        ListeEtudiants listeEtudiants =  new ListeEtudiants();
        Etudiant etudiant1 = new Etudiant();
        etudiant1.setMatricule(matricule);
        etudiant1.setNom(nom);
        etudiant1.setAdresse(adresse);
        etudiant1.setBourse(bourse);
        List<Etudiant> list_ = new ArrayList<>();
        list_.add(etudiant1);
        listeEtudiants.setEtudiants(list_);
        EnregistrementXML enr = new EnregistrementXML();
        enr.updateEtudiant(listeEtudiants);
        
    }
}
