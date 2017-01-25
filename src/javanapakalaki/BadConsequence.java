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
public abstract class BadConsequence {
    public static final int MAXTREASURES = 10;
    
    private String text;
    private int levels;
    private boolean death;

   public BadConsequence(String text, int levels){
        this.text = text;
        this.levels = levels;
        this.death = death;
    }
   
    public abstract boolean isEmpty();
    
    public String getText(){
        return text; 
    }
    
    public int getLevels(){
        return levels; 
    }
    
    public boolean getDeath(){
        return death;
    }
    
    protected void setDeath(boolean death){
        this.death = death;
    }
    
    public abstract void substractVisibleTreasures(Treasure t);
    
    public abstract void substractHiddenTreasures(Treasure t);

    public abstract BadConsequence adjustToFitTreasureLists(ArrayList<Treasure> v, ArrayList<Treasure> h);

    @Override
    public String toString(){
        return "\nText = " + text + ";\nlevels = " + Integer.toString(levels) + "\nDeath = " + death;
    }
    
 
    
}
