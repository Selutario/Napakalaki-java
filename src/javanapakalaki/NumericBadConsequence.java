/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javanapakalaki;

import java.util.ArrayList;

/**
 *
 * @author selu
 */
public class NumericBadConsequence extends BadConsequence {
    private int nVisibleTreasures;
    private int nHiddenTreasures;
    private boolean death; // VIVO = 0, MUERTO = 1
    
    public NumericBadConsequence(String text, int levels, int nVisible, int nHidden){
        super(text, levels);
        nVisibleTreasures = nVisible;
        nHiddenTreasures = nHidden;
    }

    @Override
    public BadConsequence adjustToFitTreasureLists(ArrayList<Treasure> v, ArrayList<Treasure> h) {
        NumericBadConsequence a_devolver = new NumericBadConsequence(getText(), getLevels(), 0, 0);
                   
        if (nHiddenTreasures > 0)
            a_devolver.nHiddenTreasures = (h.size() < nHiddenTreasures) ? h.size() : nHiddenTreasures;
            
        if (nVisibleTreasures > 0)
            a_devolver.nVisibleTreasures = (v.size() < nVisibleTreasures) ? v.size() : nVisibleTreasures;
        
        return a_devolver;
    }
    
    public int getVisibleTreasures(){
        return nVisibleTreasures; 
    }
    
    public int getHiddenTreasures(){
        return nHiddenTreasures; 
    }

    @Override
    public boolean isEmpty() {
        return (nVisibleTreasures == 0 && nHiddenTreasures == 0);
    }

    @Override
    public void substractVisibleTreasures(Treasure t) {
        if(nVisibleTreasures != 0)
            nVisibleTreasures--;
    }

    @Override
    public void substractHiddenTreasures(Treasure t) {
        if(nHiddenTreasures != 0)
            nHiddenTreasures--;
    }
   
    @Override
    public String toString(){
        return super.toString() +
                "\nn Visible Treasures= " + Integer.toString(nVisibleTreasures) + "\t" +
                "\nn Hidden Treasures = " + Integer.toString(nHiddenTreasures) + "\t";
    }
}
