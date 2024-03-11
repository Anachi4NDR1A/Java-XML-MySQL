/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database;

import bean.Etudiant;
import bean.ListeEtudiants;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import server.XMLtoDalabase;


/**
 *
 * @author BEST
 */
public class SocketDatabaseListener {
    private static final String DB_HOST = "localhost";
    private static final int DB_PORT = 80; 
    private boolean statusConection;
    private boolean updateSuccefull = false;
    private boolean insertSuccefull = false;
    private boolean deleteSuccefull = false;
    public SocketDatabaseListener(){
                Runnable monitor = () -> {
            while (true) {
                try {
                    Socket socket = new Socket();
                    socket.connect(new InetSocketAddress(DB_HOST, DB_PORT), 5000); // Timeout de 5 secondes
                    if (socket.isConnected()) {
                        System.out.println("Connexion active à la base de données !");
                        insertionData();
                        updateData();
                        deleteData();
                        statusConection = true;
                    }
                    socket.close();
                } catch (IOException e) {
                    System.out.println("Impossible de se connecter à la base de données : " + e.getMessage());
                    statusConection = false;
                }

                // Attendre un certain temps avant de vérifier à nouveau la connexion
                try {
                    Thread.sleep(5000); // Attendre 5 secondes
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Thread monitorThread = new Thread(monitor);
        monitorThread.start();
    }
    private void insertionData(){
        ConnexionDatabase con = new ConnexionDatabase();
        XMLtoDalabase data = new XMLtoDalabase();
        ListeEtudiants liste = data.recuperationListeEtudiantInsert();
        if(liste != null){
            con.insererDonnees(liste);
            System.out.print("OK insert");
            this.insertSuccefull = true;
        }
        else{
            System.out.print("Acucun donnee a enregistrer");
        }
    }
    private void updateData(){
        ConnexionDatabase con = new ConnexionDatabase();
        XMLtoDalabase data = new XMLtoDalabase();
        ListeEtudiants liste = data.recuperationListeEtudiantUpdate();
        if(liste != null){
            con.majDonnees(liste);
            System.out.print("OK update");
            this.updateSuccefull = true;
        }
        else{
            System.out.print("Acucun donnee a enregistrer");
        }
    }
    private void deleteData(){
        ConnexionDatabase con = new ConnexionDatabase();
        XMLtoDalabase data = new XMLtoDalabase();
        ListeEtudiants liste = data.recuperationListeEtudiantSupprimer();
        if(liste != null){
            con.supprimerDonnees(liste);
            System.out.print("OK delete");
            this.deleteSuccefull = true;
        }
        else{
            System.out.print("Acucun donnee a enregistrer");
        }
    }
    public boolean getStatusConection(){
        return this.statusConection;
    }
    public boolean getInsertSuccefull(){
        return this.statusConection;
    }
    public boolean getUpdateData(){
        return this.statusConection;
    }
    public boolean getDeleteSuccefull(){
        return this.statusConection;
    }
}
