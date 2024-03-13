/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database;

import bean.ListeEtudiants;
import java.awt.Color;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import javax.swing.*;
import javax.swing.SwingUtilities;
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
    private JLabel jLabel5;
    private JTextArea jTextArea1;
    private String textArea;
    
    public SocketDatabaseListener(){
                Runnable monitor = () -> {
            while (true) {
                try {
                    Socket socket = new Socket();
                    socket.connect(new InetSocketAddress(DB_HOST, DB_PORT), 5000); // Timeout de 5 secondes
                    if (socket.isConnected()) {
                        System.out.println("Connexion active à la base de données !");
                        updateLabel(true);
                        insertionData();
                        updateData();
                        deleteData();
                        statusConection = true;
                    }
                    socket.close();
                } catch (IOException e) {
                    System.out.println("Impossible de se connecter à la base de données : " + e.getMessage());
                    updateLabel(false);
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
    
    /**
     *
     * @param jLabel5
     * @param j
     */
    public void setJLabel(JLabel jLabel5, JTextArea jTextArea1) {
        this.jLabel5 = jLabel5;
        this.jTextArea1 = jTextArea1;
    }
    
    private void updateLabel(boolean isConnected) {
        SwingUtilities.invokeLater(() -> {
            if (isConnected) {
                jLabel5.setForeground(Color.GREEN);
                jLabel5.setText("base de donnees connecté!");
                this.textArea = "> Base de donnée activé\n";
                if(this.insertSuccefull){
                    this.textArea = this.textArea + "> Etudiant enregistree dans la base\n";
                }
                if(this.updateSuccefull){
                    this.textArea = this.textArea + "> Modification enregistree dans la base\n";
                }
                if(this.deleteSuccefull){
                    this.textArea = this.textArea + "> Supression appliquee dans la base\n";
                }
                jTextArea1.setText(textArea);
                
            } else {
                jLabel5.setForeground(Color.RED);
                jLabel5.setText("base de donnees déconnecté!");
                jTextArea1.setText("");
            }
        });
    }
    
    private void insertionData(){
        ConnexionDatabase con = new ConnexionDatabase();
        XMLtoDalabase data = new XMLtoDalabase();
        ListeEtudiants liste = data.recuperationListeEtudiantInsert();
        if(!liste.getEtudiants().isEmpty()){
            con.insererDonnees(liste);
            System.out.print("OK insert");
            this.insertSuccefull = true;
        }
        else{
            this.insertSuccefull = false;
            System.out.print("Acucun donnee a enregistrer");
        }
    }
    private void updateData(){
        ConnexionDatabase con = new ConnexionDatabase();
        XMLtoDalabase data = new XMLtoDalabase();
        ListeEtudiants liste = data.recuperationListeEtudiantUpdate();
        if(!liste.getEtudiants().isEmpty()){
            con.majDonnees(liste);
            System.out.print("OK update");
            this.updateSuccefull = true;
        }
        else{
            this.updateSuccefull = false;
            System.out.print("Acucun donnee a enregistrer");
        }
    }
    private void deleteData(){
        ConnexionDatabase con = new ConnexionDatabase();
        XMLtoDalabase data = new XMLtoDalabase();
        ListeEtudiants liste = data.recuperationListeEtudiantSupprimer();
        if(!liste.getEtudiants().isEmpty()){
            con.supprimerDonnees(liste);
            System.out.print("OK delete");
            this.deleteSuccefull = true;
        }
        else{
            this.deleteSuccefull = false;
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
