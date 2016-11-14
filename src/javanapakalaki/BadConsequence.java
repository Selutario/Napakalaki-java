/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javanapakalaki;

import java.util.ArrayList;

/**
 *
 * @author lopezjoseluis
 */
public class BadConsequence {
    public static final int MAXTREASURES = 10;
    
    private String text;
    private int levels;
    private int nVisibleTreasures;
    private int nHiddenTreasures;
    private boolean death; // VIVO = 0, MUERTO = 1
    private ArrayList<TreasureKind> specificHiddenTreasures = new ArrayList();
    private ArrayList<TreasureKind> specificVisibleTreasures = new ArrayList();

   public BadConsequence(String text, int levels, int nVisible, int nHidden){
        text = text;
        levels = levels;
        nVisibleTreasures = nVisible;
        nHiddenTreasures = nHidden;
        specificHiddenTreasures = new ArrayList();
        specificVisibleTreasures = new ArrayList();
        death = false;
    }
    
    public BadConsequence(String text, boolean death){
        this.text = text;
        this.death = death;
    }
   
    public BadConsequence(String text, int levels, ArrayList<TreasureKind> tVisible, 
            ArrayList<TreasureKind> tHidden){
        this.text = text;
        this.death = death;
        this.levels = levels;
        this.specificVisibleTreasures = tVisible;
        this.specificHiddenTreasures = tHidden;
    }
    
    //public BadConsequence adjustToFitTreasureLists(ArrayList<Treasure> v, ArrayList<Treasure> h){
        
    //}
    
    public boolean isEmpty(){
        return (nVisibleTreasures == 0 && nHiddenTreasures == 0 && specificHiddenTreasures.size() == 0 && specificVisibleTreasures.size() == 0);
    }
    
    String getText(){
        return text; 
    }
    
    int getLevels(){
        return levels; 
    }
    
    int getVisibleTreasures(){
        return nVisibleTreasures; 
    }
    
    int getHiddenTreasures(){
        return nHiddenTreasures; 
    }
    
    boolean getDeath(){
        return death; 
    }
    
    ArrayList<TreasureKind> getSHTreasures(){
        return specificHiddenTreasures;
    }
    
    ArrayList<TreasureKind> getSVTreasures(){
        return specificVisibleTreasures;
    }
    
    public void substractVisibleTreasures(Treasure t){
        
    }
    
    public void substractHiddenTreasures(Treasure t){
        
    }
    
    
    
    public String toString(){
        return "\nText = " + text + "; levels = " + Integer.toString(levels) + "n Visible Treasures= " + Integer.toString(nVisibleTreasures) + " n Hidden Treasures = " + Integer.toString(nHiddenTreasures) + " death = " + death;
    }
    
 
    
}
