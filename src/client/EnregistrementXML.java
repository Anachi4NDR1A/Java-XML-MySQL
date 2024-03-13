package client;

import java.io.FileOutputStream;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;
import org.jdom2.input.SAXBuilder;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import bean.ListeEtudiants; 
import bean.Etudiant;                            
                            
public class EnregistrementXML {
    public  EnregistrementXML(){
        
    }
    private void createXMLFile(String nameFile) {
        try {
            // Créer un XMLOutputter avec un format
            Element racine = new Element("bibliotheque");
            Document document = new Document(racine);

            XMLOutputter xmlOutput = new XMLOutputter();
            xmlOutput.setFormat(Format.getPrettyFormat());

            // Écrire le document XML dans un fichier
            FileOutputStream insert = new FileOutputStream(nameFile);
            xmlOutput.output(document, insert);
            insert.close();
            System.out.println("Fichier XML créé avec succès !");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void createXMLFileDelete() {
        createXMLFile("deleteEtudiant.xml");
    }
    public void createXMLFileUpdate() {
        createXMLFile("updateEtudiant.xml");
    }
    public void createXMLFileInsert() {
        createXMLFile("insertEtudiant.xml");
    }
    public void createXMLFileAllEtudinant() {
        createXMLFile("etudiant.xml");
    }
    private void addElement(String nameFile, ListeEtudiants listeEtudiants, String action){
        try {
            // Créer un objet File avec le chemin spécifié
            File fichier = new File(nameFile);

            // Vérifier si le fichier existe
            if (!fichier.exists()) {
                if(action == "addAll"){
                    createXMLFileAllEtudinant();
                }
                if(action == "insert"){
                    createXMLFileInsert();
                }
                if(action == "update"){
                    createXMLFileUpdate();
                }
                if(action == "delete"){
                    createXMLFileDelete();
                }
            } 
            // Charger le fichier XML existant
            File inputFile = new File(nameFile);
            SAXBuilder saxBuilder = new SAXBuilder();
            Document document = saxBuilder.build(inputFile);

            // Récupérer l'élément racine
            Element racine = document.getRootElement();

            // Créer un nouvel élément livre
            for(Etudiant etudiant: listeEtudiants.getEtudiants()){
                Element nouveauEtudiant = new Element("etudiant");
                nouveauEtudiant.addContent(new Element("matricule").setText(etudiant.getMatricule()));
                nouveauEtudiant.addContent(new Element("nom").setText(etudiant.getNom()));
                nouveauEtudiant.addContent(new Element("adresse").setText(etudiant.getAdresse()));
                nouveauEtudiant.addContent(new Element("bourse").setText(String.valueOf(etudiant.getBourse())));
                // Ajouter le nouvel élément livre à l'élément racine
                racine.addContent(nouveauEtudiant);
            }
            
            // Sauvegarder les modifications dans un nouveau fichier XML
            XMLOutputter xmlOutput = new XMLOutputter();
            xmlOutput.setFormat(Format.getPrettyFormat());
            FileOutputStream fileOutput = new FileOutputStream(inputFile);
            xmlOutput.output(document, fileOutput);
            fileOutput.close();

            System.out.println("Enregistrement succès !");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void addElementForAllEtudiant( ListeEtudiants listeEtudiants){
         addElement("etudiant.xml", listeEtudiants,"addAll");
    }
    public void insertEtudiant( ListeEtudiants listeEtudiants){
         addElement("insertEtudiant.xml", listeEtudiants,"insert");
         addElementForAllEtudiant(listeEtudiants);
    }
    public String deleteEtudiant( ListeEtudiants listeEtudiants){
        addElement("deleteEtudiant.xml", listeEtudiants,"delete");
        String cheminFichier = "etudiant.xml";
        try {
            // Charger le fichier XML
            SAXBuilder saxBuilder = new SAXBuilder();
            Document document = saxBuilder.build(new File(cheminFichier));

            // Récupérer l'élément racine
            Element racine = document.getRootElement();
            for(Etudiant etudiant: listeEtudiants.getEtudiants()){
                String matricule = etudiant.getMatricule();
                // Supprimer un élément spécifique, par exemple, l'élément avec le matricule "123"
                supprimerElement(racine, matricule);
            }

            // Sauvegarder les modifications dans le fichier XML
            XMLOutputter xmlOutput = new XMLOutputter();
            xmlOutput.setFormat(Format.getPrettyFormat());
            FileOutputStream fileOutput = new FileOutputStream(cheminFichier);
            xmlOutput.output(document, fileOutput);
            fileOutput.close();

            System.out.println("Élément supprimé avec succès !");
            return "reussie";
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
    }

    public static void supprimerElement(Element racine, String matricule) {
        List<Element> elementsEtudiant = racine.getChildren("etudiant");
        for (Element elementEtudiant : elementsEtudiant) {
            String matriculeEtudiant = elementEtudiant.getChildText("matricule");
            if (matricule.equals(matriculeEtudiant)) {
                // Supprimer l'élément de la liste des enfants de l'élément racine
                racine.removeContent(elementEtudiant);
                return; // Quitter la boucle après la suppression de l'élément
            }
        }
    }
    public String updateEtudiant( ListeEtudiants listeEtudiants){
         addElement("updateEtudiant.xml", listeEtudiants,"update");
        String cheminFichier = "etudiant.xml";

        try {
            // Charger le fichier XML
            SAXBuilder saxBuilder = new SAXBuilder();
            Document document = saxBuilder.build(new File(cheminFichier));

            // Récupérer l'élément racine
            Element racine = document.getRootElement();

            // Modifier la valeur de la bourse pour l'étudiant avec le matricule "123"
             for(Etudiant etudiant: listeEtudiants.getEtudiants()){
                String matricule = etudiant.getMatricule();
                String nom = etudiant.getNom();
                String adresse = etudiant.getAdresse();
                int bourse = etudiant.getBourse();
                // Supprimer un élément spécifique, par exemple, l'élément avec le matricule "123"
                modifierValeurBourse(racine, matricule, nom, adresse, bourse);
            }
            // Sauvegarder les modifications dans le fichier XML
            XMLOutputter xmlOutput = new XMLOutputter();
            xmlOutput.setFormat(Format.getPrettyFormat());
            FileOutputStream fileOutput = new FileOutputStream(cheminFichier);
            xmlOutput.output(document, fileOutput);
            fileOutput.close();

            System.out.println("Information modifiée avec succès !");
            return "reussie";
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
    }

    @SuppressWarnings("empty-statement")
    public static void modifierValeurBourse(Element racine, String matricule, String nom, String adresse, int bourse) {
        List<Element> elementsEtudiant = racine.getChildren("etudiant");
        for (Element elementEtudiant : elementsEtudiant) {
            String matriculeEtudiant = elementEtudiant.getChildText("matricule");
            if (matricule.equals(matriculeEtudiant)) {
                // Modifier la valeur de la bourse
                Element elementBourse = elementEtudiant.getChild("bourse");
                elementBourse.setText(String.valueOf(bourse));
                Element elementBourse1 = elementEtudiant.getChild("nom");
                elementBourse1.setText(String.valueOf(nom));
                Element elementBourse2 = elementEtudiant.getChild("adresse");
                elementBourse2.setText(String.valueOf(adresse));
                /*return*/; 
            }
        }
    }
    
}
                          