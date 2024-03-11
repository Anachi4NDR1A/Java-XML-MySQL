/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package server;

/**
 *
 * @author BEST
 */
                            
import java.io.*;
import java.net.*;
import bean.Etudiant;
public class Serveur {
    public Serveur(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(1234); // Création d'un serveur écoutant sur le port 1234
            Socket clientSocket = serverSocket.accept(); // Attente de connexion d'un client
            ObjectInputStream in = new ObjectInputStream(clientSocket.getInputStream());
            
            // Lecture de l'objet Etudiant envoyé par le client
            Etudiant etudiant = (Etudiant) in.readObject();
            
            // Traitement des données de l'objet Etudiant
            
            System.out.println("Données reçues : " + etudiant.toString());
            
            serverSocket.close(); // Fermeture du serveur
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
                          
