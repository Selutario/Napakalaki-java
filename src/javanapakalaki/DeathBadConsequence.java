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
public class DeathBadConsequence extends NumericBadConsequence {   
    public DeathBadConsequence(String text, boolean death){
        super(text, Player.MAXLEVEL, MAXTREASURES, MAXTREASURES);
        super.setDeath(true);
    }
}