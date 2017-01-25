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
public class SpecificBadConsequence extends BadConsequence{
    private ArrayList<TreasureKind> specificHiddenTreasures = new ArrayList();
    private ArrayList<TreasureKind> specificVisibleTreasures = new ArrayList();
    
    public SpecificBadConsequence(String text, int levels, ArrayList<TreasureKind> tVisible, 
                                  ArrayList<TreasureKind> tHidden){
        super(text, levels);
        this.specificVisibleTreasures = tVisible;
        this.specificHiddenTreasures = tHidden;
    }
    
    @Override
    public BadConsequence adjustToFitTreasureLists(ArrayList<Treasure> v, ArrayList<Treasure> h){
        ArrayList<TreasureKind> copiaHidden = new ArrayList(this.specificHiddenTreasures),
                                copiaVisible = new ArrayList(this.specificVisibleTreasures);
        SpecificBadConsequence a_devolver = new SpecificBadConsequence(getText(), getLevels(), new ArrayList(), new ArrayList());
        //a_devolver.death = this.death;
        
        if (specificHiddenTreasures.size() > 0){
            for (int i = 0; i < h.size(); i++){
                if ( copiaHidden.contains( h.get(i).getType() ) ){
                    a_devolver.specificHiddenTreasures.add(h.get(i).getType());
                    copiaHidden.remove(h.get(i).getType());
                }
            }
        }
        
        if (specificVisibleTreasures.size() > 0){            
            for (int i = 0; i < v.size(); i++){
                if ( copiaVisible.contains( v.get(i).getType() ) ){
                    a_devolver.specificVisibleTreasures.add(v.get(i).getType());
                    copiaVisible.remove(v.get(i).getType());
                }
            }
        }
        
        return a_devolver;
    }
    
    public ArrayList<TreasureKind> getSHTreasures(){
        return specificHiddenTreasures;
    }
    
    public ArrayList<TreasureKind> getSVTreasures(){
        return specificVisibleTreasures;
    }

    @Override
    public boolean isEmpty() {
        return (specificHiddenTreasures.size() == 0 && specificVisibleTreasures.size() == 0);
    }

    @Override
    public void substractVisibleTreasures(Treasure t) {
        specificVisibleTreasures.remove(t.getType());
    }

    @Override
    public void substractHiddenTreasures(Treasure t) {
        specificHiddenTreasures.remove(t.getType());
    }
    
    @Override
    public String toString(){
        return super.toString() +
                "\n Visible Treasures= " + specificVisibleTreasures +
                "\n Hidden Treasures = " +  specificHiddenTreasures;
    }
}
