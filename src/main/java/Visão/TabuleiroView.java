/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Visão;

import Controle.ControladorDoGame;
import Modelo.Tabuleiro;
import java.awt.Color;
import java.awt.Point;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JToggleButton;

/**
 *
 * @author Gabriel
 */
public class TabuleiroView extends javax.swing.JFrame {

    protected JToggleButton campoGrafico[][];
    private Point lastClicked;

    /**
     * Creates new form TabuleiroView
     */
    public TabuleiroView() {
        campoGrafico = new JToggleButton[28][28];
        initComponents();
        initCampo();
        lastClicked = null;
        pack();
        setLocationRelativeTo(null);
        setResizable(false);
        setTitle("DRAL");
        chamarCard();
        atualizarCampo();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel2.setLayout(new java.awt.GridLayout(28, 28));
        jPanel1.add(jPanel2, java.awt.BorderLayout.CENTER);

        jPanel3.setBackground(new java.awt.Color(0, 0, 102));
        jPanel3.setLayout(new java.awt.GridBagLayout());

        jLabel1.setFont(new java.awt.Font("DilleniaUPC", 1, 112)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 0, 0));
        jLabel1.setText("Dral");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(41, 357, 43, 379);
        jPanel3.add(jLabel1, gridBagConstraints);

        jPanel1.add(jPanel3, java.awt.BorderLayout.PAGE_START);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 870, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 787, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void chamarCard() {
        PlayerCard cardA = new PlayerCard();
        cardA.setLocation(getX()+getWidth(), getY());
        cardA.setResizable(false);
        cardA.setVisible(true);
    }

    private void initCampo() {
        for (int i = 0; i < campoGrafico.length; i++) {
            for (int j = 0; j < campoGrafico[0].length; j++) {
                campoGrafico[i][j] = new JToggleButton();
                campoGrafico[i][j].setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
                campoGrafico[i][j].setBackground(Color.green);
                campoGrafico[i][j].addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        clique(evt);
                    }
                });
            }
        }
        addEmjPanel2();
    }

    private void addEmjPanel2() {
        for (int i = 0; i < campoGrafico.length; i++) {
            for (int j = 0; j < campoGrafico[0].length; j++) {
                jPanel2.add(campoGrafico[j][i]);
            }
        }
    }

    private void clique(java.awt.event.ActionEvent evt) {
        Point ponto = getSelectedPoint(campoGrafico);
        campoGrafico[ponto.x][ponto.y].setSelected(false);
        if (Tabuleiro.getObject().getTabuleiro()[ponto.x][ponto.y].getPersonagem() != null && lastClicked == null) {
            lastClicked = ponto;
        } else if (lastClicked == ponto) {
            lastClicked = null;
        } else if (lastClicked != null
                && Tabuleiro.getObject().getTabuleiro()[ponto.x][ponto.y].getPersonagem() == null) {
            ControladorDoGame.getObject().jogarTurno(lastClicked, ponto);
            lastClicked = null;
        }
        campoGrafico = atualizarCampo();

    }

    public JToggleButton[][] getCampoGrafico() {
        return campoGrafico;
    }

    private Point getSelectedPoint(JToggleButton[][] campoGrafico) {
        for (int i = 0; i < campoGrafico.length; i++) {
            for (int j = 0; j < campoGrafico[0].length; j++) {
                if (campoGrafico[i][j].isSelected()) {
                    return new Point(i, j);
                }
            }
        }
        return null;
    }

    private JToggleButton[][] atualizarCampo() {
        for (int i = 0; i < campoGrafico.length; i++) {
            for (int j = 0; j < campoGrafico[0].length; j++) {
                if (null == Tabuleiro.getObject().getTabuleiro()[i][j].getPersonagem()) {
                    campoGrafico[i][j].setIcon(null);
                } else {
                    atualizarPecas(new Point(i, j));
                }
            }
        }
        return campoGrafico;
    }

    private void atualizarPecas(Point ponto) {
        String classe = Tabuleiro.getObject().getTabuleiro()[ponto.x][ponto.y].getPersonagem().toString();
        if (classe.equals("Guerreiro")) {
            campoGrafico[ponto.x][ponto.y].setIcon(new ImageIcon(getClass().getResource("/Guerreiro(By Meilun).png")));
        } else if (classe.equals("Arqueiro")) {
            campoGrafico[ponto.x][ponto.y].setIcon(new ImageIcon(getClass().getResource("/Arqueiro(By Meilun).png")));
        } else if (classe.equals("Bardo")) {
            campoGrafico[ponto.x][ponto.y].setIcon(new ImageIcon(getClass().getResource("/Bardo(By Meilun).png")));
        } else if (classe.equals("Assassino")) {
            campoGrafico[ponto.x][ponto.y].setIcon(new ImageIcon(getClass().getResource("/Assassin(By Meilun).png")));
        } else {
            campoGrafico[ponto.x][ponto.y].setIcon(new ImageIcon(getClass().getResource("/Clerigo(By Meilun).png")));
        }
    }

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(TabuleiroView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TabuleiroView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TabuleiroView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TabuleiroView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TabuleiroView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    // End of variables declaration//GEN-END:variables

}
