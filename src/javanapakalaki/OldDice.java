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
public class OldDice {
    private static final OldDice instance = new OldDice();
    
    OldDice(){}
    
    public static OldDice getInstance(){
        return instance;
    }
    
    public int nextNumber(){
        Random dado = new Random();
        int valorDado = dado.nextInt(6)+1;
        
        return valorDado;
    }
    
}
