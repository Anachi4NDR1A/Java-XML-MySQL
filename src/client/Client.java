/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package client;

/**
 *
 * @author BEST
 */
                            
import java.io.*;
import java.net.*;

import bean.Etudiant;

public class Client {
    public Client(String[] args) {
        try {
            Socket socket = new Socket("localhost", 1234); // Connexion au serveur sur le port 1234
            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
            
            // Création d'un objet Etudiant à envoyer au serveur
            Etudiant etudiant = new Etudiant("123", "John Doe", "123 Main Street", 500);
            
            out.writeObject(etudiant); // Envoi de l'objet au serveur
            out.flush();
            
            socket.close(); // Fermeture de la connexion
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
                          
