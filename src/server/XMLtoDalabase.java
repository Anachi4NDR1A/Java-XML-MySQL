/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package server;

/**
 *
 * @author BEST
 */

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import bean.*;

public class XMLtoDalabase {
    public XMLtoDalabase(){
        
    }
    private ListeEtudiants recup(String nameFile){
        String cheminFichier = nameFile;
        ListeEtudiants liste = new ListeEtudiants();
        // Créer une instance de SAXBuilder
        SAXBuilder saxBuilder = new SAXBuilder();

        // Liste pour stocker les étudiants
        List<Etudiant> listeEtudiants = new ArrayList<>();

        try {
            // Charger le fichier XML
            Document document = saxBuilder.build(new File(cheminFichier));

            // Récupérer l'élément racine
            Element racine = document.getRootElement();

            // Parcourir les éléments enfants et extraire les données
            List<Element> elementsEtudiant = racine.getChildren("etudiant");
            for (Element elementEtudiant : elementsEtudiant) {
                String matricule = elementEtudiant.getChildText("matricule");
                String nom = elementEtudiant.getChildText("nom");
                String adresse = elementEtudiant.getChildText("adresse");
                int bourse = Integer.parseInt(elementEtudiant.getChildText("bourse"));

                // Créer un objet Etudiant et l'ajouter à la liste
                Etudiant etudiant = new Etudiant(matricule, nom, adresse, bourse);
                listeEtudiants.add(etudiant);
            }

            // Créer un objet ListeEtudiants et y mettre la liste des étudiants
            
            liste.setEtudiants(listeEtudiants);

            // Afficher la liste des étudiants
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return liste;
    }
    
    public ListeEtudiants recuperationListeEtudiant(){
        String cheminFichier = "etudiant.xml";
        return recup(cheminFichier);
    }
    
    public ListeEtudiants recuperationListeEtudiantSupprimer(){
        String cheminFichier = "deleteEtudiant.xml";
        return recup(cheminFichier);
    }
    public ListeEtudiants recuperationListeEtudiantUpdate(){
        String cheminFichier = "updateEtudiant.xml";
        return recup(cheminFichier);
    }
    public ListeEtudiants recuperationListeEtudiantInsert(){
        String cheminFichier = "insertEtudiant.xml";
        return recup(cheminFichier);
    }
}
