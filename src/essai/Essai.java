/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package essai;

/**
 *
 * @author BEST
 */


import java.util.List;
import java.util.ArrayList;

import bean.Etudiant;
import bean.ListeEtudiants;
import client.EnregistrementXML;
import database.ConnexionDatabase;

import server.XMLtoDalabase;

public class Essai {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new EnregistrementXML().createXMLFileAllEtudinant();
        
        new EnregistrementXML().createXMLFileDelete();
        
        new EnregistrementXML().createXMLFileInsert();
        
        new EnregistrementXML().createXMLFileUpdate();
        
    }
    
}
