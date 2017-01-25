/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javanapakalaki;
import java.util.ArrayList;
import java.util.Random;
import GUI.Dice;

/**
 *
 * @author selu
 */
public class Player {
    public static final int MAXLEVEL = 10;
    
    private String name;
    private int level;
    private boolean dead;
    private boolean canISteal;
    protected Player enemy;
    protected BadConsequence pendingBadConsequence;
    private ArrayList<Treasure> hiddenTreasures;
    private ArrayList<Treasure> visibleTreasures;
    
    public Player(String name){
        this.name = name;
        this.level = 1;
        this.hiddenTreasures = new ArrayList();
        this.visibleTreasures = new ArrayList();
        this.dead = true;
        this.canISteal = true;
    }
    
    public Player(Player p){
        this.name = p.getName();
        this.level = p.getLevels();
        this.hiddenTreasures = new ArrayList(p.getHiddenTreasures());
        this.visibleTreasures = new ArrayList(p.getVisibleTreasures());
        this.dead = p.dead;
        this.canISteal = p.canISteal;
        this.enemy = p.enemy;
        this.pendingBadConsequence = p.pendingBadConsequence;
    }
    
    public String getName(){
        return name;
    }
    
    private void bringToLife(){
        dead = false;
    }
    
    protected int getCombatLevel(){
        int bonus_total = 0;
        
        for(int i = 0; i < visibleTreasures.size(); i++)
            bonus_total += visibleTreasures.get(i).getBonus();
        
        return level + bonus_total;
    }
    
    private void incrementLevels(int l){
        level = level + l;
        
        if (level > MAXLEVEL)
            level = MAXLEVEL;
    }
    
    private void decrementLevels(int l){
        level = level - l;
        
        if (level <= 0)
            level = 1;
    }
    
    private void setPendingBadConsequence(BadConsequence b){
        pendingBadConsequence = b;
    }
    
    public BadConsequence getPendingBadConsequence(){
        return pendingBadConsequence;
    }
    
    private void applyPrize(Monster m){
        int nLevels, nTreasures;
        CardDealer dealer;
        
        nLevels = m.getLevelsGained();
        nTreasures = m.getTreasuresGained();
        this.incrementLevels(nLevels);
        
        if(nTreasures > 0){
            Treasure treasure;
            
            dealer = CardDealer.getInstance();
            
            for(int i = 0; i < nTreasures; i++){
                treasure = dealer.nextTreasure();
                hiddenTreasures.add(treasure);
            }
        }
    }
    
    private void applyBadConsequence(Monster m){
        BadConsequence badConsequence, pendingBad;
        int nLevels;
        
        badConsequence = m.getBc();
        nLevels = badConsequence.getLevels();
        
        decrementLevels(nLevels);
        pendingBad = badConsequence.adjustToFitTreasureLists(visibleTreasures, hiddenTreasures);
        setPendingBadConsequence(pendingBad);
    }
    
    private boolean canMakeTreasureVisible(Treasure t ){
        int n_onehand = this.howManyVisibleTreasures(TreasureKind.ONEHAND), 
            n_bothhands = this.howManyVisibleTreasures(TreasureKind.BOTHHANDS);
        boolean canMakeVisible = true;
       
        if(t.getType() != TreasureKind.ONEHAND){
            for(int i = 0; i < visibleTreasures.size() && canMakeVisible; i++)
                if(t.getType() == visibleTreasures.get(i).getType())
                    canMakeVisible = false;
        }

        if (t.getType() == TreasureKind.ONEHAND && (n_onehand > 1 || n_bothhands != 0))
            canMakeVisible = false;
        
        if (t.getType() == TreasureKind.BOTHHANDS && n_onehand != 0)
            canMakeVisible = false;
        
        return canMakeVisible;
    }
    
    private int howManyVisibleTreasures(TreasureKind tKind){
        int contador = 0;
        
        for(int i = 0; i < visibleTreasures.size(); i++)
            if(visibleTreasures.get(i).getType() == tKind)
                contador++;
        
        return contador;
    }
    
    private void dieIfNoTreasures(){
        if(hiddenTreasures.size() == 0 && visibleTreasures.size() == 0)
            dead = true;
    }
    
    public boolean isDead(){
        return dead;
    }
    
    public ArrayList<Treasure> getHiddenTreasures(){
        return hiddenTreasures;
    }
    
    public ArrayList<Treasure> getVisibleTreasures(){
        return visibleTreasures;
    }
    
    public CombatResult combat(Monster m){
        int myLevel = this.getCombatLevel();
        int monsterLevel = this.getOponentLevel(m);
        CombatResult combatResult;
        
        if(!canISteal){
            Dice dice = Dice.getInstance();
            int number = dice.nextNumber();
            
            if(number < 3){
                int enemyLevel = enemy.getCombatLevel();
                monsterLevel += enemyLevel;
            }
        }
            
        if(myLevel > monsterLevel){
            this.applyPrize(m);

            if(level >= MAXLEVEL)
                combatResult = CombatResult.WINGAME;
            else
                combatResult = CombatResult.WIN;
        }
        else{
            this.applyBadConsequence(m);
            combatResult = CombatResult.LOSE;
            
            if (this.shouldConvert())
                combatResult = CombatResult.LOSEANDCONVERT;         
        }
            
   
        return combatResult;
    }
    
    public void makeTreasureVisible(Treasure t){
        boolean canI;
        
        canI = this.canMakeTreasureVisible(t);
        if(canI){
            visibleTreasures.add(t);
            hiddenTreasures.remove(t);
        }
    }
    
    public void discardVisibleTreasure(Treasure t){
        visibleTreasures.remove(t);
        
        if((pendingBadConsequence != null) && (!pendingBadConsequence.isEmpty()))
            pendingBadConsequence.substractVisibleTreasures(t);
        
        CardDealer.getInstance().giveTreasureBack(t);
        this.dieIfNoTreasures();
    }
    
    public void discardHiddenTreasure(Treasure t){
        hiddenTreasures.remove(t);
        
        if((pendingBadConsequence != null) && (!pendingBadConsequence.isEmpty()))
            pendingBadConsequence.substractHiddenTreasures(t);
        
        CardDealer.getInstance().giveTreasureBack(t);
        this.dieIfNoTreasures();
    }
    
    // Devuelve true cuando el jugador no tiene ningún mal rollo que cumplir y no tiene
    // mas de 4 tesoros ocultos, y false en caso contrario.
    public boolean validState(){
        boolean valido;
        
        if(pendingBadConsequence != null){
            valido = hiddenTreasures.size() <= 4 && pendingBadConsequence.isEmpty();
        }
        else
            valido = true;
            
        return valido;
    }
    
    public void initTreasures(){
        CardDealer dealer = CardDealer.getInstance();
        Dice dice = Dice.getInstance();
        bringToLife();
        
        Treasure treasure = dealer.nextTreasure();
        hiddenTreasures.add(treasure);
        int number = dice.nextNumber();

        if(number > 1){
            treasure = dealer.nextTreasure();
            hiddenTreasures.add(treasure);
        }

        if(number == 6){
            treasure = dealer.nextTreasure();
            hiddenTreasures.add(treasure);
        }
    }

    
    public int getLevels(){
        return level;
    }
    
    public Treasure stealTreasure(){
        boolean canI, canYou;
        Treasure treasure = null;
        
        canI = this.canISteal();
        
        if(canI){
            canYou = enemy.canYouGiveMeATreasure();
            
            if(canYou){
                treasure = enemy.giveMeATreasure();
                hiddenTreasures.add(treasure);
                this.haveStolen();
            }
        }

       return treasure;
    }
    
    public void setEnemy(Player enemy){
        this.enemy = enemy;
    }
    
    public Player getEnemy(){
        return enemy;
    }
    
    protected Treasure giveMeATreasure(){
        int indice_tesoro;
        Treasure tesoro = null;
        
        if(hiddenTreasures.size() != 0){
            Random aleatorio = new Random();
            indice_tesoro = aleatorio.nextInt(hiddenTreasures.size());
            tesoro = hiddenTreasures.get(indice_tesoro);
            hiddenTreasures.remove(tesoro);
        }
        
        return tesoro;
    }
    
    public boolean canISteal(){
        return canISteal;
    }
    
    protected boolean canYouGiveMeATreasure(){
        return !hiddenTreasures.isEmpty();
    }
    
    private void haveStolen(){
        // Cambia el atributo canISteal a false cuando el jugador roba un tesoro.
        canISteal = false;
    }
    
    public void discardAllTreasures(){
        Treasure treasure;
        ArrayList<Treasure> visibleCopy = new ArrayList(visibleTreasures),
                            hiddenCopy = new ArrayList(hiddenTreasures);
        
        for(int i = 0; i < visibleCopy.size(); i++){
            treasure = visibleCopy.get(i);
            this.discardVisibleTreasure(treasure);
        }
        
        for(int i = 0; i < hiddenCopy.size(); i++){
            treasure = hiddenCopy.get(i);
            this.discardHiddenTreasure(treasure);
        }
    }
    
    protected int getOponentLevel(Monster m){
        return m.getLevel();
    }
    
    protected boolean shouldConvert(){
        Dice dice = Dice.getInstance();
        int dado = dice.nextNumber();
        
        return (dado == 6);
    }
    
   

}
