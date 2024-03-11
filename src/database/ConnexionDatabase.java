/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database;

/**
 *
 * @author BEST
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import bean.ListeEtudiants;
import bean.Etudiant;
import client.EnregistrementXML;


public class ConnexionDatabase {
    
    private Connection connexion;
    String url = "jdbc:mysql://localhost:3306/javaavance";
    String utilisateur = "root";
    String motDePasse = "";

    public ConnexionDatabase() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connexion = DriverManager.getConnection(url, utilisateur, motDePasse);
            System.out.println("Connexion à la base de données établie avec succès !");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Erreur lors de la connexion à la base de données.");
            e.printStackTrace();
        }
    }

    public void insererDonnees(ListeEtudiants liste) {
        try {
            String requeteInsertion = "INSERT INTO `etudiant`(`matricule`, `nom`, `adresse`, `bourse`) VALUES (?, ?, ?, ?)";
            PreparedStatement preparedStatement = connexion.prepareStatement(requeteInsertion);
            for(Etudiant etudiant: liste.getEtudiants()){
                int i = 1;
                preparedStatement.setObject(i, etudiant.getMatricule());
                i++;
                preparedStatement.setObject(i, etudiant.getNom());
                i++;
                preparedStatement.setObject(i, etudiant.getAdresse());
                i++;
                preparedStatement.setObject(i, etudiant.getBourse());
                preparedStatement.executeUpdate();
            }
            new EnregistrementXML().createXMLFileInsert();
            System.out.println("Données insérées avec succès !");
            fermerConnexion();
        } catch (SQLException e) {
            System.out.println("Erreur lors de l'insertion des données.");
            e.printStackTrace();
        }
    }
    
    public void supprimerDonnees(ListeEtudiants liste) {
        try {
            String requeteInsertion = "DELETE FROM `etudiant` WHERE matricule = ?";
            PreparedStatement preparedStatement = connexion.prepareStatement(requeteInsertion);
            for(Etudiant etudiant: liste.getEtudiants()){
                preparedStatement.setObject(1, etudiant.getMatricule());
                preparedStatement.executeUpdate();
            }
            new EnregistrementXML().createXMLFileDelete();
            System.out.println("Suppression avec succès !");
            fermerConnexion();
        } catch (SQLException e) {
            System.out.println("Erreur lors de l'insertion des données.");
            e.printStackTrace();
        }
    }
    
    public void majDonnees(ListeEtudiants liste) {
        try {
            String requeteInsertion = "UPDATE `etudiant` SET `nom`=?,`adresse`=?,`bourse`=? WHERE `matricule`=?";
            PreparedStatement preparedStatement = connexion.prepareStatement(requeteInsertion);
            for(Etudiant etudiant: liste.getEtudiants()){
                int i = 1;
                preparedStatement.setObject(i, etudiant.getNom());
                i++;
                preparedStatement.setObject(i, etudiant.getAdresse());
                i++;
                preparedStatement.setObject(i, etudiant.getBourse());
                i++;
                preparedStatement.setObject(i, etudiant.getMatricule());
                preparedStatement.executeUpdate();
            }
            new EnregistrementXML().createXMLFileUpdate();
            System.out.println("maj avec succès !");
            fermerConnexion();
        } catch (SQLException e) {
            System.out.println("Erreur lors de l'insertion des données.");
            e.printStackTrace();
        }
    }
    public void fermerConnexion() {
        try {
            if (connexion != null) {
                connexion.close();
                System.out.println("Connexion à la base de données fermée avec succès !");
            }
        } catch (SQLException e) {
            System.out.println("Erreur lors de la fermeture de la connexion à la base de données.");
            e.printStackTrace();
        }
    }

}
