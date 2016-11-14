/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javanapakalaki;

/**
 *
 * @author lopezjoseluis
 */
public class Prize {
    private int levels;
    private int treasures;
    
    public Prize(int treasures, int levels){
        this.levels = levels;
        this.treasures = treasures;
    }
    
    int getLevels(){
        return levels; }
    
    void setLevels(int l){
        levels = l; }
    
    int getTreasures(){
        return treasures; }
    
    void setTreasures(int t){
        treasures = t; }
    
    public String toString(){
        return "\nTreasures = " + Integer.toString(treasures) + "; levels = " + Integer.toString(levels);
    }
}

