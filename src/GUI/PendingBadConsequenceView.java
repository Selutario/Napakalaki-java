/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import javanapakalaki.BadConsequence;
import javanapakalaki.NumericBadConsequence;
import javanapakalaki.SpecificBadConsequence;

/**
 *
 * @author selu
 */
public class PendingBadConsequenceView extends javax.swing.JPanel {
    private BadConsequence pendingBadModel;
    
    /**
     * Creates new form PendingBadConsequenceView
     */
    public PendingBadConsequenceView() {
        initComponents();
    }
    
    public void setPendingBadConsequence(BadConsequence bc){
        pendingBadModel = bc;
        
        if(bc instanceof NumericBadConsequence){
            this.showVisibleTreasures.setText(String.valueOf( ((NumericBadConsequence) bc).getVisibleTreasures() ));
            this.showHidden.setText(String.valueOf( ((NumericBadConsequence) bc).getHiddenTreasures() ));
        }
        else if (bc instanceof SpecificBadConsequence){
            this.showVisibleTreasures.setText(String.valueOf( ((SpecificBadConsequence) bc).getSVTreasures() ));
            this.showHidden.setText(String.valueOf( ((SpecificBadConsequence) bc).getSHTreasures() ));  
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        visibleTreasures = new javax.swing.JPanel();
        showVisibleTreasures = new javax.swing.JLabel();
        levels = new javax.swing.JLabel();
        titleBC = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        showHidden = new javax.swing.JLabel();
        hiddenTreasures = new javax.swing.JLabel();

        setBackground(java.awt.SystemColor.window);

        visibleTreasures.setBackground(new java.awt.Color(254, 136, 136));
        visibleTreasures.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        showVisibleTreasures.setText("default");

        levels.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        levels.setText("VISIBLE TREASURES:");

        javax.swing.GroupLayout visibleTreasuresLayout = new javax.swing.GroupLayout(visibleTreasures);
        visibleTreasures.setLayout(visibleTreasuresLayout);
        visibleTreasuresLayout.setHorizontalGroup(
            visibleTreasuresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(visibleTreasuresLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(levels)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(showVisibleTreasures, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        visibleTreasuresLayout.setVerticalGroup(
            visibleTreasuresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(visibleTreasuresLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(visibleTreasuresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(showVisibleTreasures)
                    .addComponent(levels))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        titleBC.setFont(new java.awt.Font("DejaVu Sans", 1, 18)); // NOI18N
        titleBC.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleBC.setText("PENDING BAD CONSEQUENCE");

        jPanel10.setBackground(new java.awt.Color(254, 136, 136));
        jPanel10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        showHidden.setText("default");

        hiddenTreasures.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        hiddenTreasures.setText("HIDDEN TREASURES:");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(hiddenTreasures)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(showHidden, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(showHidden)
                    .addComponent(hiddenTreasures))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(visibleTreasures, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(titleBC, javax.swing.GroupLayout.DEFAULT_SIZE, 486, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(titleBC)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(visibleTreasures, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel hiddenTreasures;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JLabel levels;
    private javax.swing.JLabel pendingBad;
    private javax.swing.JLabel pendingBad1;
    private javax.swing.JLabel showHidden;
    private javax.swing.JLabel showPendingBad;
    private javax.swing.JLabel showPendingBad1;
    private javax.swing.JLabel showVisibleTreasures;
    private javax.swing.JLabel titleBC;
    private javax.swing.JPanel visibleTreasures;
    // End of variables declaration//GEN-END:variables
}