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
public class Monster {
    private String name;
    private int CombatLevel;
    private Prize prize;
    private BadConsequence badConsequence;
    
    public Monster(String name, int level, BadConsequence badConsequence, Prize prize){
        this.name = name;
        CombatLevel = level;
        this.badConsequence = badConsequence;
        this.prize = prize;
    }
    
    String getName(){
        return name;
    }
    
    // getLevel == getCombatLevel (en diapositivas)
    int getLevel(){
        return CombatLevel;
    }
    
    Prize getPrize(){
        return prize;
    }
    
    BadConsequence getBc(){
        return badConsequence;
    }
    
    public String toString(){
        return "\nName = " + name + "; Combat level = " + Integer.toString(CombatLevel);
    }
    
    public int getLevelsGained(){
        return prize.getLevels();
    }
    
    public int getTreasuresGained(){
        return prize.getTreasures();
    }
    
}
