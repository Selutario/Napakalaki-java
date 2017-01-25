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
    private int levelChangeAgaintsCulstistPlayer;
    
    public Monster(String name, int level, BadConsequence badConsequence, Prize prize){
        this.name = name;
        CombatLevel = level;
        this.badConsequence = badConsequence;
        this.prize = prize;
        levelChangeAgaintsCulstistPlayer = 0;
    }
    
    public Monster(String name, int level, BadConsequence badConsequence, Prize prize, int lC){
        this.name = name;
        CombatLevel = level;
        this.badConsequence = badConsequence;
        this.prize = prize;
        levelChangeAgaintsCulstistPlayer = lC;
    }
    
    public String getName(){
        return name;
    }
    
    // getLevel == getCombatLevel (en diapositivas)
    public int getLevel(){
        return CombatLevel;
    }
    
    public Prize getPrize(){
        return prize;
    }
    
    public BadConsequence getBc(){
        return badConsequence;
    }
   
    
    public int getLevelsGained(){
        return prize.getLevels();
    }
    
    public int getTreasuresGained(){
        return prize.getTreasures();
    }
    
    public int getCombatLevelAgainstCultistPlayer(){
        return CombatLevel + levelChangeAgaintsCulstistPlayer;
    }
    
    public String toString(){
        return "\nName = " + name + "; Combat level = " + Integer.toString(CombatLevel) + "\nPrize: " + prize.toString() + "\nBadConsequence: " + badConsequence.toString();
    }
}
