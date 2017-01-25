/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javanapakalaki;
import java.util.*;
import java.util.Scanner;


/**
 *
 * @author lopezjoseluis
 */
public class Napakalaki {
    private static final int MAX_VALUE = 19;
    
    private static final Napakalaki instance = new Napakalaki();
    private Player currentPlayer;
    private ArrayList<Player> players;
    private CardDealer dealer;
    private Monster currentMonster;
    
    private Napakalaki(){
        players = new ArrayList();
        dealer = CardDealer.getInstance();
    }
    
    private void initPlayers(ArrayList<String> names){
        players = new ArrayList();
      
        for(int i = 0; i < names.size(); i++)
            players.add(new Player(names.get(i)) );
    }
    
    private Player nextPlayer(){
        int indice;
        
        if(currentPlayer == null){
            Random turno = new Random();
            indice = turno.nextInt(players.size() - 1);
        }
        else
            indice = (players.indexOf(currentPlayer) + 1) % players.size();
         
        return players.get(indice);
    }
    
    private boolean nextTurnIsAllowed(){
        if(currentPlayer == null)
            return true;
        else 
            return currentPlayer.validState();

    }
    
    private void setEnemies(){
        Random enemigo = new Random();
        int indice_enemigo,
            i = 0;
        
        while(i < players.size()){
            indice_enemigo = enemigo.nextInt(players.size() - 1);
            
            //if(indice_enemigo != players.indexOf(i)){
            if(indice_enemigo != i){
               players.get(i).setEnemy( players.get(indice_enemigo) );
               i++; 
            }
        }
    }
    
    public static Napakalaki getInstance(){
        return instance;
    }
    
    public CombatResult developCombat(){
        CombatResult combatResult;
        dealer.giveMonsterBack(currentMonster);
        
        combatResult = currentPlayer.combat(currentMonster);
        
        if (combatResult == CombatResult.LOSEANDCONVERT){
            Cultist cartaCultista = dealer.nextCultist();
            CultistPlayer cultist = new CultistPlayer(currentPlayer, cartaCultista);
            
            for(int i = 0; i < players.size(); i++)
                if(players.get(i).getEnemy() == currentPlayer)
                    players.get(i).setEnemy(cultist);
            
            players.add(players.indexOf(currentPlayer), cultist);
            currentPlayer = cultist;
            
        }

         
        
        return combatResult;
    }
    
    public void discardVisibleTreasures(ArrayList<Treasure> treasures){
        Treasure treasure;
        
        for(int i = 0; i < treasures.size(); i++){
            treasure = treasures.get(i);
           
            currentPlayer.discardVisibleTreasure(treasure);
        }
    }
   
    public void discardHiddenTreasures(ArrayList<Treasure> treasures){
        Treasure treasure;
        
        for(int i = 0; i < treasures.size(); i++){
            treasure = treasures.get(i);
  
            currentPlayer.discardHiddenTreasure(treasures.get(i));
        }
    }

    
    
    public void makeTreasuresVisible(ArrayList<Treasure> treasures){
        Treasure treasure;
        
        for(int i = 0; i < treasures.size(); i++){
            treasure = treasures.get(i);
            currentPlayer.makeTreasureVisible(treasure); // Maketreasurevisible
        }
    }
    
    public void initGame(ArrayList<String> players){     
        initPlayers(players);
        setEnemies();
        dealer.initCards();
        
        nextTurn();
    }
    
    public Player getCurrentPlayer(){
        return currentPlayer;
    }
    
    public Monster getCurrentMonster(){
        return currentMonster;
    }
    
    public boolean nextTurn(){
        boolean stateOK;
        stateOK = this.nextTurnIsAllowed();
        boolean dead;
        
        if(stateOK){
            currentMonster = dealer.nextMonster();
            currentPlayer = nextPlayer();
            dead = currentPlayer.isDead();
            
            if(dead)
                currentPlayer.initTreasures();
        }
       
      return stateOK;
    }
    
    public boolean endOfGame(CombatResult result){
        return result == CombatResult.WINGAME;
    }
   
  
}
       
        
        
        
           
