/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javanapakalaki;

import java.util.Random;

/**
 *
 * @author selu
 */
public class CultistPlayer extends Player{
    private static int totalCultistPlayers = 0;
    private Cultist myCultistCard;
    
    public CultistPlayer(Player p, Cultist c){
        super(p);
        totalCultistPlayers += 1;
        myCultistCard = c;
    }
    
    @Override
    protected int getCombatLevel(){
        int combatlevel = super.getCombatLevel() + (int) 0.7 * super.getCombatLevel();
        
        return combatlevel + myCultistCard.getGainedLevels() * totalCultistPlayers;
    }
    
    @Override
    protected int getOponentLevel(Monster m){
        return m.getCombatLevelAgainstCultistPlayer();
    }
    
    @Override
    protected boolean shouldConvert(){
        return false;
    }
    
    @Override
    protected Treasure giveMeATreasure(){
        Random aleatorio = new Random();
        Treasure tesoro = getVisibleTreasures().get( aleatorio.nextInt(getVisibleTreasures().size()) );
        super.getVisibleTreasures().remove(tesoro);
   
        return tesoro;
    }
    
    @Override
    protected boolean canYouGiveMeATreasure(){
       return getVisibleTreasures().size() > 0;
    }
    
    public int getTotalCultistPlayers(){
        return totalCultistPlayers;
    }
}
