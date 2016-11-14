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
    private static ArrayList<Monster> vector_resultado = new ArrayList();
    private static ArrayList<Monster> resultado = new ArrayList();
    
    private Napakalaki(){}
    private void initPlayers(ArrayList<String> names){}
    //private Player nextPlayer(){}
    //private boolean nextTurnAllowed(){return /*#####*/}
    private void setEnemies(){}
    
    
    
    public static Napakalaki getInstance(){return instance;}
    //public CombatResult developCombat(){}
    public void discardVisibleTreasures(ArrayList<TreasureKind> treasures){}
    public void discardHiddenTreasures(ArrayList<TreasureKind> treasures){}
    public void makeTreasuresVisible(ArrayList<TreasureKind> treasures){}
    public void initGame(ArrayList<String> players){}
    //public Player getCurrentPlayer(){}
    //public Monster getCurrentMonsterT(){}
    //public boolean nextTurn(){}
    //public boolean endOfGame(CombatResult result){}
   

    
    // Devolver monstruos con nivel de combate superior a 10
    /*public static ArrayList<Monster> superior_diez(){
        
        for(int i = 0; i < monstruos.size(); i++)
            if(monstruos.get(i).getLevel() > 10)
                vector_resultado.add(monstruos.get(i));
                
        
        return vector_resultado;
    }
    
    
    // Devuelve SÓLO monstruos que pierden niveles en su mal rollo.
    public static ArrayList<Monster> perder_niveles(){
        
        for(int i = 0; i < monstruos.size(); i++)
            if(monstruos.get(i).getBc().getLevels() > 0 && monstruos.get(i).getBc().getHiddenTreasures() == 0 && monstruos.get(i).getBc().getVisibleTreasures() == 0 )
                vector_resultado.add(monstruos.get(i));
                
        return vector_resultado;
    }
    
    
    // Devuelve SÓLO monstruos que pierden niveles en su mal rollo.
    public static ArrayList<Monster> ganar_niveles(){
        
        for(int i = 0; i < monstruos.size(); i++)
            if(monstruos.get(i).getPrize().getLevels() > 1 )
                vector_resultado.add(monstruos.get(i));
                
        return vector_resultado;
    }
    
    
    
    // Devuelve monstruos que pierden tesoro especificado
    public static ArrayList<Monster> perder_tesoro(TreasureKind tesoro){
        //ArrayList<Monster> array = new ArrayList();
        
        for(int i = 0; i <  MAX_VALUE; i++){
            ArrayList<TreasureKind> hidden_treasure = monstruos.get(i).getBc().getSHTreasures();
            ArrayList<TreasureKind> visible_treasure = monstruos.get(i).getBc().getSVTreasures();
            boolean aniadido = false;
            
            for(int j = 0; j < hidden_treasure.size() && !aniadido; j++){
                if(hidden_treasure.get(j) == tesoro){
                    vector_resultado.add(monstruos.get(i));
                    aniadido = true;
                }
            }
            
            for(int j = 0; j < visible_treasure.size() && !aniadido; j++){
                if(visible_treasure.get(j) == tesoro){
                    vector_resultado.add(monstruos.get(i));
                    aniadido = true;
                }
            }
        }
                 
        return vector_resultado;
    }*/
    
    
    // ----------------------------------------------------------------------------------------------- \\
    
    public static void main(String[] args) {
        /*Napakalaki.crear_monstruos();
        
        System.out.print("Qué desea ver: ");
        
        System.out.print("\n\t0 - Monstruos con nivel de combate superior a 10");
        System.out.print("\n\t1 - Monstruos con mal rollo que implica pérdida de niveles únicamente");
        System.out.print("\n\t2 - Monstruos con ganancia de nivel superiro a 1");
        System.out.print("\n\t3 - Monstruos que pierden el tesoro Armadura");
        System.out.print("\n\t4 - Monstruos que pierden el tesoro de Una mano");
        System.out.print("\n\t5 - Monstruos que pierden el tesoro de Dos manos");
        System.out.print("\n\t6 - Monstruos que pierden el tesoro Casco");
        System.out.print("\n\t7 - Monstruos que pierden el tesoro Botas");
        System.out.print("\n\t-1 - Salir\n\n");
        
        Scanner capt = new Scanner(System.in);
        int opcion = capt.nextInt();
        
        while(opcion != -1){
     
            switch (opcion) {
                case 0:
                    resultado = Napakalaki.superior_diez();
                    for(int i = 0; i < resultado.size(); i++)
                        System.out.print(resultado.get(i));
                    break;
                case 1:
                    resultado = Napakalaki.perder_niveles();
                    for(int i = 0; i < resultado.size(); i++)
                        System.out.print(resultado.get(i));
                    break;
                case 2:
                    resultado = Napakalaki.ganar_niveles();
                    for(int i = 0; i < resultado.size(); i++)
                        System.out.print(resultado.get(i));
                    break;
                case 3:
                    resultado = Napakalaki.perder_tesoro(TreasureKind.ARMOR);
                    for(int i = 0; i < resultado.size(); i++)
                        System.out.print(resultado.get(i));
                    break;
                case 4:
                    resultado = Napakalaki.perder_tesoro(TreasureKind.ONEHAND);
                    for(int i = 0; i < resultado.size(); i++)
                        System.out.print(resultado.get(i));
                    break;
                case 5:
                    resultado = Napakalaki.perder_tesoro(TreasureKind.BOTHHANDS);
                    for(int i = 0; i < resultado.size(); i++)
                        System.out.print(resultado.get(i));
                    break;
                case 6:
                    resultado = Napakalaki.perder_tesoro(TreasureKind.HELMET);
                    for(int i = 0; i < resultado.size(); i++)
                        System.out.print(resultado.get(i));
                    break;
                case 7:
                    resultado = Napakalaki.perder_tesoro(TreasureKind.SHOES);
                    for(int i = 0; i < resultado.size(); i++)
                        System.out.print(resultado.get(i));
                    break;
                default:
                    break;
            }
            System.out.print("\n");
            opcion = capt.nextInt();
        }*/
        
           Dice dado = new Dice();
           
           System.out.print(dado + "\n");
           dado.nextNumber();
           System.out.print(dado);
    }
}
       
        
        
        
           