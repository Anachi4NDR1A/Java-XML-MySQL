/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package JavaA;

/**
 *
 * @author ANDRIANANTENAINA
 */
import javax.swing.table.DefaultTableModel;
import java.util.List;
import bean.Etudiant;
import database.SocketDatabaseListener;
import essai.InsererUnEtudiant;
import essai.ModifierUnEtudiant;
import essai.RecuperationDesDonnees;
import essai.SupprimerEtudiant;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
public class Front extends javax.swing.JFrame {
    /**
     * Creates new form Front
     */
    private SocketDatabaseListener socketListener;
    
    public Front() {
        initComponents();
        //input 
        matriculeH.setVisible(false);
        jTextArea1.setEditable(false);
        
        //affichage donnee
        ajouterDonnees();
        
        //socket
        socketListener = new SocketDatabaseListener();
        socketListener.setJLabel(jLabel5,jTextArea1);
        
        //listener
        initListSelectionListener();
    }
    
    public void ajouterDonnees() {
        // Obtenez le modèle de tableau de votre JTable
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();

        // Effacez toutes les lignes existantes du modèle de tableau
        model.setRowCount(0);

        // Obtenez les données des étudiants
        List<Etudiant> listeEtudiants = RecuperationDesDonnees.toutLesDonnees();

        // Ajoutez les données au modèle de tableau
        for (Etudiant etudiant : listeEtudiants) {
            model.addRow(new Object[]{etudiant.getMatricule(), etudiant.getNom(), etudiant.getBourse(), etudiant.getAdresse()});
        }
    }
    public void clearImp(){
        matriculeH.setText("");
        jTextField2.setText("");
        jTextField3.setText("");
        jTextField4.setText("");
        jTextField5.setText("");
    }
        
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        matriculeH = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jButton4 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Matricule", "Nom", "Bourse", "Adresse"
            }
        ));
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setMinWidth(65);
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(65);
            jTable1.getColumnModel().getColumn(0).setMaxWidth(65);
            jTable1.getColumnModel().getColumn(2).setMinWidth(70);
            jTable1.getColumnModel().getColumn(2).setPreferredWidth(70);
            jTable1.getColumnModel().getColumn(2).setMaxWidth(70);
        }

        matriculeH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                matriculeHActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Matricule");

        jTextField2.setBackground(new java.awt.Color(200, 202, 205));
        jTextField2.setFont(new java.awt.Font("Montserrat", 1, 14)); // NOI18N
        jTextField2.setForeground(new java.awt.Color(40, 39, 42));

        jLabel2.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Nom");

        jTextField3.setBackground(new java.awt.Color(200, 202, 205));
        jTextField3.setFont(new java.awt.Font("Montserrat", 1, 14)); // NOI18N
        jTextField3.setForeground(new java.awt.Color(40, 39, 42));

        jLabel3.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Bourse");

        jTextField4.setBackground(new java.awt.Color(200, 202, 205));
        jTextField4.setFont(new java.awt.Font("Montserrat", 1, 14)); // NOI18N
        jTextField4.setForeground(new java.awt.Color(40, 39, 42));

        jLabel4.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Adresse");

        jTextField5.setBackground(new java.awt.Color(200, 202, 205));
        jTextField5.setFont(new java.awt.Font("Montserrat", 1, 14)); // NOI18N
        jTextField5.setForeground(new java.awt.Color(40, 39, 42));

        jButton1.setBackground(new java.awt.Color(86, 86, 138));
        jButton1.setFont(new java.awt.Font("Montserrat", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Ajouter");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(173, 133, 87));
        jButton2.setFont(new java.awt.Font("Montserrat", 1, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Modifier");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(128, 86, 87));
        jButton3.setFont(new java.awt.Font("Montserrat", 1, 14)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Supprimer");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));

        jPanel2.setBackground(new java.awt.Color(237, 232, 255));

        jTextArea1.setBackground(new java.awt.Color(237, 232, 255));
        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Montserrat", 1, 14)); // NOI18N
        jTextArea1.setForeground(new java.awt.Color(0, 0, 0));
        jTextArea1.setRows(5);
        jScrollPane3.setViewportView(jTextArea1);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3)
                .addContainerGap())
        );

        jButton4.setBackground(new java.awt.Color(255, 98, 34));
        jButton4.setFont(new java.awt.Font("Montserrat", 1, 14)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("Annuler");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 511, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jButton3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jButton1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGap(19, 19, 19))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addContainerGap()))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(matriculeH, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(155, 155, 155))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(matriculeH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Main", jPanel1);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 926, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 506, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("INFO", jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // Ajouter un etudiant
        if(jTextField2.getText().isEmpty() && jTextField3.getText().isEmpty() && jTextField4.getText().isEmpty() && jTextField5.getText().isEmpty()){
            jTextArea1.setText("> Veuillez remplire tous les case");
        }else{
            try {
                // Tentative de conversion de la chaîne en entier
                int bourse = Integer.parseInt(jTextField4.getText());
                // Appel de la méthode insertion avec les valeurs récupérées
                String reponse = InsererUnEtudiant.insertion(jTextField2.getText(), jTextField3.getText(), bourse, jTextField5.getText());
                if(reponse.equals("Enregistrement")){
                    jTextArea1.setText("> Enregistrement réussi");
                }else{
                    jTextArea1.setText("> L'étudiant existe déjà");
                }
                clearImp();
                ajouterDonnees();
            } catch (NumberFormatException e) {
                // Gestion de l'exception si la conversion échoue
                jTextArea1.setText("> Veuillez modifier le montant de la bourse (erreur de format)");
            } catch (Exception e) {
                // Gestion de toute autre exception générée par la méthode insertion
                jTextArea1.setText("> Une erreur s'est produite lors de l'insertion de l'étudiant : " + e.getMessage());
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // Modification
        if(matriculeH.getText().isEmpty()){
           jTextArea1.setText("> veuillez selectioner un étudiant"); 
        }else if(jTextField2.getText().isEmpty() && jTextField3.getText().isEmpty() && jTextField4.getText().isEmpty() && jTextField5.getText().isEmpty()){
            jTextArea1.setText("> Veuillez remplire tous les case");
        }else{
            try {
                // Tentative de conversion de la chaîne en entier
                int bourse = Integer.parseInt(jTextField4.getText());
                // Appel de la méthode insertion avec les valeurs récupérées
                String reponse = ModifierUnEtudiant.mofif(matriculeH.getText(), jTextField3.getText(), jTextField5.getText(), bourse);
                if(reponse.equals("reussie")){
                    jTextArea1.setText("> Modification réussi");
                }else{
                    jTextArea1.setText("> Modification a echouer");
                }
                clearImp();
                ajouterDonnees();
            } catch (NumberFormatException e) {
                // Gestion de l'exception si la conversion échoue
                jTextArea1.setText("> Veuillez modifier le montant de la bourse (erreur de format)");
            } catch (Exception e) {
                // Gestion de toute autre exception générée par la méthode insertion
                jTextArea1.setText("> Une erreur s'est produite lors de l'insertion de l'étudiant : " + e.getMessage());
            }
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // Supression
        if(matriculeH.getText().isEmpty()){
           jTextArea1.setText("> veuillez selectioner un étudiant"); 
        }else{
            try {
                // Tentative de conversion de la chaîne en entier
                int bourse = Integer.parseInt(jTextField4.getText());
                // Appel de la méthode insertion avec les valeurs récupérées
                String reponse = SupprimerEtudiant.supprimer(matriculeH.getText());
                
                if(reponse.equals("reussie")){
                    jTextArea1.setText("> Suppression réussi");
                }else{
                    jTextArea1.setText("> Suppression a echouer");
                }
                clearImp();
                ajouterDonnees();
            } catch (NumberFormatException e) {
                // Gestion de l'exception si la conversion échoue
                jTextArea1.setText("> Veuillez modifier le montant de la bourse (erreur de format)");
            } catch (Exception e) {
                // Gestion de toute autre exception générée par la méthode insertion
                jTextArea1.setText("> Une erreur s'est produite lors de l'insertion de l'étudiant : " + e.getMessage());
            }
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void matriculeHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_matriculeHActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_matriculeHActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // bouton annuler
        clearImp();
    }//GEN-LAST:event_jButton4ActionPerformed

    /**
     * @param args the command line arguments
     */
    private void initListSelectionListener() {
        jTable1.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    // Code pour récupérer les données de la ligne sélectionnée et les afficher dans les champs de texte
                    int selectedRow = jTable1.getSelectedRow();
                    if (selectedRow != -1) {
                        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
                        Object matricule = model.getValueAt(selectedRow, 0);
                        Object nom = model.getValueAt(selectedRow, 1);
                        Object bourse = model.getValueAt(selectedRow, 2);
                        Object adresse = model.getValueAt(selectedRow, 3);
                        
                        matriculeH.setText(matricule.toString());
                        jTextField2.setText(matricule.toString());
                        jTextField3.setText(nom.toString());
                        jTextField4.setText(bourse.toString());
                        jTextField5.setText(adresse.toString());
                    }
                }
            }
        });
    }
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Front.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Front.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Front.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Front.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Front().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField matriculeH;
    // End of variables declaration//GEN-END:variables
}
