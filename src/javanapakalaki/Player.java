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
public class Player {
    private final int MAXLEVEL = 10;
    
    private String name;
    private int level;
    private boolean dead = true; // VIVO = 0, MUERTO = 1
    private boolean canISteal = true;
    private Player enemy;
    private BadConsequence pendingBadConsequence;
    private ArrayList<Treasure> hiddenTreasures = new ArrayList();
    private ArrayList<Treasure> visibleTreasures = new ArrayList();
    
    public Player(String name){
        
    }
    
    public String getName(){
        return name;
    }
    
    private void bringToLife(){
        dead = false;
    }
    
    private int getCombatLevel(){
        int bonus_total = 0;
        
        for(int i = 0; i < hiddenTreasures.size(); i++)
            bonus_total += hiddenTreasures.get(i).getBonus();
        
        for(int i = 0; i < visibleTreasures.size(); i++)
            bonus_total += visibleTreasures.get(i).getBonus();
        
        return level + bonus_total;
    }
    
    private void incrementeLevels(int l){
        level = level + l;
    }
    
    private void decrementLevels(int l){
        if(l <= level)
            level = level - l;
    }
    
    private void setPendingBadConsequence(BadConsequence b){
        pendingBadConsequence = b;
    }
    
    private void applyPrize(Monster m){
        
    }
    
    private void applyBadConsequence(Monster m){
        
    }
    
    //private boolean canMakeTreasureVisible(Treasure t){
        
    //}
    
    private int howManyVisibleTreasure(TreasureKind tKind){
        int contador = 0;
        
        for(int i = 0; i < visibleTreasures.size(); i++)
            if(visibleTreasures.get(i).getType() == tKind)
                contador++;
        
        return contador;
    }
    
    private void dielfNoTreasures(){
        if(hiddenTreasures.size() == 0 && visibleTreasures.size() == 0)
            dead = true;
    }
    
    public boolean isDead(){
        return dead;
    }
    
    //public ArrayList<Treasure> getHiddenTreasures(){
        
    //}
    
    //public ArrayList<Treasure> getVisibleTreasures(){
        
    //}
    
    //public CombatResult combat(Monster m){
        
    //}
    
    public void makeTreasureVisible(Treasure t){
        
    }
    
    public void discardVisibleTreasure(Treasure t){
        
    }
    
    public void discardHiddenTreasure(Treasure t){
        
    }
    
    // Devuelve true cuando el jugador no tiene ningún mal rollo que cumplir y no tiene
    // mas de 4 tesoros ocultos, y false en caso contrario.
    public boolean validState(){
        boolean valido = false;
        
        if(pendingBadConsequence != null)
            if (hiddenTreasures.size() <= 4 && pendingBadConsequence.isEmpty())
                valido = true;
            
        return valido;
    }
    
    public void initTreasures(){
        
    }
    
    public int getLevels(){
        return level;
    }
    
    //public Treasures stealTreasure(){
        
    //}
    
    //public void setEnemy(Player enemy){
        
    //}
    
    //private Treasure giveMeATreasure(){
        
    //}
    
    public boolean canISteal(){
        return canISteal;
    }
    
    private boolean canYouGiveMeATreasure(){
        return (hiddenTreasures.size() > 0 || visibleTreasures.size() > 0);
    }
    
    private void haveStolen(){
        // Cambia el atributo canISteal a false cuando el jugador roba un tesoro.
        canISteal = false;
    }
    
    public void discardAllTreasures(){
        
    }
}
