/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javanapakalaki;
import java.util.*;
import static javanapakalaki.BadConsequence.MAXTREASURES;

/**
 *
 * @author selu
 */
public class CardDealer {
    private static final CardDealer instance = new CardDealer();
    private ArrayList<Monster> unusedMonsters = new ArrayList();
    private static ArrayList<Monster> usedMonsters = new ArrayList();
    private static ArrayList<Treasure> unusedTreasures = new ArrayList();
    private static ArrayList<Treasure> usedTreasures = new ArrayList();
    private ArrayList<Cultist> unusedCultists = new ArrayList();
    private CardDealer(){}
    
    private void initTreasureCardDeck(){
        ///Inicializa el mazo de cartas de Tesoros(unusedTreasures)con todas
        ///las cartas de tesoros proporcionadas en el documento de cartas de tesoros.
        unusedTreasures.add(new Treasure("¡Sí mi amo!", 4, TreasureKind.HELMET));
        unusedTreasures.add(new Treasure("Botas de investigación", 3,TreasureKind.SHOES));
        unusedTreasures.add(new Treasure("Capucha de Cthulhu", 3, TreasureKind.HELMET ));
        unusedTreasures.add(new Treasure("A prueba de babas", 2, TreasureKind.ARMOR));
        unusedTreasures.add(new Treasure("Botas de lluvia ácida",1, TreasureKind.BOTHHANDS));
        unusedTreasures.add(new Treasure("Casco minero", 2, TreasureKind.HELMET));
        unusedTreasures.add(new Treasure("Ametralladora ACME", 4, TreasureKind.BOTHHANDS));
        unusedTreasures.add(new Treasure("Camiseta de la ETSIIT", 1, TreasureKind.ARMOR));
        unusedTreasures.add(new Treasure("Clavo de rail ferroviario", 3, TreasureKind.ONEHAND));
        unusedTreasures.add(new Treasure("Cuchillo de sushi arcano", 2, TreasureKind.ONEHAND));
        unusedTreasures.add(new Treasure("Fez alópodo", 3, TreasureKind.HELMET));
        unusedTreasures.add(new Treasure("Hacha prehistórica", 2, TreasureKind.ONEHAND));
        unusedTreasures.add(new Treasure("El aparato del Pr. Tesla", 4, TreasureKind.ARMOR));
        unusedTreasures.add(new Treasure("Gaita", 4, TreasureKind.BOTHHANDS));
        unusedTreasures.add(new Treasure("Insecticida", 2, TreasureKind.ONEHAND));
        unusedTreasures.add(new Treasure("Escopeta de 3 cañones", 4, TreasureKind.BOTHHANDS));
        unusedTreasures.add(new Treasure("Garabato Mistico", 2, TreasureKind.ONEHAND));
        unusedTreasures.add(new Treasure("La rebeca metálica",2, TreasureKind.ARMOR));
        unusedTreasures.add(new Treasure("Lanzallamas", 4, TreasureKind.BOTHHANDS));
        unusedTreasures.add(new Treasure("Necro-comicón", 1, TreasureKind.ONEHAND ));
        unusedTreasures.add(new Treasure("Necronomicón", 5, TreasureKind.BOTHHANDS));
        unusedTreasures.add(new Treasure("Linterna a 2 manos", 3, TreasureKind.BOTHHANDS));
        unusedTreasures.add(new Treasure("Necro-gnomicón", 2, TreasureKind.ONEHAND));
        unusedTreasures.add(new Treasure("Necrotelecom", 2, TreasureKind.HELMET));
        unusedTreasures.add(new Treasure("Mazo de los antiguos", 3, TreasureKind.ONEHAND));
        unusedTreasures.add(new Treasure("Necro-playboycon", 3,  TreasureKind.ONEHAND));
        unusedTreasures.add(new Treasure("Porra preternatural", 2, TreasureKind.ONEHAND));
        unusedTreasures.add(new Treasure("Shogulador", 1, TreasureKind.BOTHHANDS));
        unusedTreasures.add(new Treasure("Varita de atizamiento", 3, TreasureKind.ONEHAND));
        unusedTreasures.add(new Treasure("Tentáculo de pega", 2, TreasureKind.HELMET));
        unusedTreasures.add(new Treasure("Zapato deja-amigos", 1, TreasureKind.SHOES));

    }
    
    private void initMonsterCardDeck(){
         // 1º MONSTRUO - 3 BYAKHEES DE BONANZA
        SpecificBadConsequence badCon = new SpecificBadConsequence("Pierdes tu armadura visible y otra oculta", 0,
                                                   new ArrayList(Arrays.asList(TreasureKind.ARMOR)),
                                                   new ArrayList(Arrays.asList(TreasureKind.ARMOR)));
        Prize prize = new Prize(2, 1);
        unusedMonsters.add(new Monster("3 Byakhees de bonanza", 8, badCon, prize));

        // 2º MONSTRUO - TENOCHTILAN
        badCon = new SpecificBadConsequence("Embobados con el lindo primigenio te descartas de tu casco visible", 0,
                                    new ArrayList(Arrays.asList(TreasureKind.HELMET)),
                                    new ArrayList());
        prize = new Prize(1, 1);
        unusedMonsters.add(new Monster("Tenochtitlan" , 2, badCon, prize));

        // 3º MONSTRUO - EL SOPOR DE DUNWICH
        badCon = new SpecificBadConsequence("El primordial bostezo contagioso. Pierdes tu calzado visible", 0,
                                    new ArrayList(Arrays.asList(TreasureKind.SHOES)),
                                    new ArrayList());
        prize = new Prize(1, 1);
        unusedMonsters.add(new Monster("El sopor de Dunwich", 2, badCon, prize));

        // 4º MONSTRUO - DEMONIOS DE MAGALUF
        badCon = new SpecificBadConsequence("Te atrapan para llevarte de fiesta y te dejan caer a mitad del vuelo. Descarta una mano visible y otra oculta", 0,
                                    new ArrayList(Arrays.asList(TreasureKind.ONEHAND)),
                                    new ArrayList(Arrays.asList(TreasureKind.ONEHAND)));
        prize = new Prize(4, 1);
        unusedMonsters.add(new Monster("Demonios de Magaluf", 2, badCon, prize));

        // 5º MONSTRUO - EL GORRÓN EN EL UMBRAL
        NumericBadConsequence nBadCon = new NumericBadConsequence("Pierdes todos tus tesoros visibles", 0, MAXTREASURES, 0);
        prize = new Prize(3, 1);
        unusedMonsters.add(new Monster("El gorrón en el umbral", 13, nBadCon, prize));
        

        // 6º MONSTRUO - H.P. MUNCHCRAFT
        badCon = new SpecificBadConsequence("Pierdes la armadura visible", 0,
                                    new ArrayList(Arrays.asList(TreasureKind.ARMOR)),
                                    new ArrayList());
        prize = new Prize(2, 1);
        unusedMonsters.add(new Monster("H.P. Munchcraft", 6, badCon, prize));

        // 7º MONSTRUO - NECRÓFAGO
        badCon = new SpecificBadConsequence("Sientes bichos bajo la ropa. Descarta la armadura visible",
                                    0, new ArrayList(Arrays.asList(TreasureKind.ARMOR)),
                                    new ArrayList());
        prize = new Prize(1, 1);
        unusedMonsters.add(new Monster("Necrófago", 13, badCon, prize));

        // 8º MONSTRUO - EL REY DE ROSADO
        nBadCon = new NumericBadConsequence("Pierdes 5 niveles y 3 tesoros visibles", 5, 3, 0);
        prize = new Prize(3, 2);
        unusedMonsters.add(new Monster("El rey de rosado", 11, nBadCon, prize));
        
        // 9º MONSTRUO - FLECHER
        nBadCon = new NumericBadConsequence("Toses los pulmones y pierdes 2 niveles.", 2, 0, 0);
        prize = new Prize(1, 1);
        unusedMonsters.add(new Monster("Flecher", 2, nBadCon, prize));
        
        // 10º MONSTRUO - LOS HONDOS
        DeathBadConsequence dBadCon = new DeathBadConsequence("Estos monstruos resultan bastante superficiales y te aburren mortalmente. Estas muerto", true);
        prize = new Prize(2, 1);
        unusedMonsters.add(new Monster("Los hondos", 8, dBadCon, prize));
       
        // 11º MONSTRUO - SEMILLAS CTHULHU
        nBadCon = new NumericBadConsequence("Pierdes 2 niveles y 2 tesoros ocultos", 2, 0, 2);
        prize = new Prize(2, 1);
        unusedMonsters.add(new Monster("Semillas Cthulhu", 4, nBadCon, prize));
        
        // 12º MONSTRUO - DAMEARGO
        badCon = new SpecificBadConsequence("Te intentas escaquear. Pierdes una mano visible.", 0, new ArrayList(Arrays.asList(TreasureKind.ONEHAND)), new ArrayList());
        prize = new Prize(2, 1);
        unusedMonsters.add(new Monster("Dameargo", 1, badCon, prize));
        
        //13º MONSTRUO - POLLIPÓLIPO VOLANTE
        nBadCon = new NumericBadConsequence("Da mucho asquito. Pierdes 3 niveles", 3, 0, 0);
        prize = new Prize (2, 1);
        unusedMonsters.add(new Monster ("Pollipólipo volante", 3, nBadCon, prize));

        //14º MONSTRUO - YSKHTIHYSSG-GOTH
        dBadCon = new DeathBadConsequence("No le hace gracia que pronuncien mal su nombre. Estas muerto", true);
        prize = new Prize (3, 1);
        unusedMonsters.add(new Monster ("Yskhtihyssg-Goth", 14, dBadCon, prize));

        //15º MONSTRUO - FAMILIA FELIZ
        dBadCon = new DeathBadConsequence("La familia te atrapa. Estas muerto", true);
        prize = new Prize (3, 1);
        unusedMonsters.add(new Monster ("Familia Feliz", 1, dBadCon, prize));

        //16º MONSTRUO - ROBOGGOTH
        badCon = new SpecificBadConsequence("La quinta directiva primaria te obliga a perder 2 niveles y un tesoro 2manos visible",
                                    2, new ArrayList(Arrays.asList(TreasureKind.BOTHHANDS)),
                                    new ArrayList());
        prize = new Prize (2, 1);
        unusedMonsters.add(new Monster ("Roboggoth", 8, badCon, prize));

        // 17º MONSTRUO - EL ESPÍA SORDO
        badCon = new SpecificBadConsequence("Te asusta en la noche. Pierdes un casco visible", 0,
                                    new ArrayList(Arrays.asList(TreasureKind.HELMET)),
                                    new ArrayList());
        prize = new Prize(1, 1);
        unusedMonsters.add(new Monster("El espía sordo", 5, badCon, prize));

        //18º MONSTRUO - TONGUE
        nBadCon = new NumericBadConsequence("Menudo susto te llevas. Pierdes 2 niveles y 5 tesoros visibles.", 2, 5, 0);
        prize = new Prize (2, 1);
        unusedMonsters.add(new Monster ("Tongue", 19, nBadCon, prize));
        
        // 19º MONSTRUO - BICÉFALO
        nBadCon = new NumericBadConsequence("Te faltan manos para tanta cabeza. Pierdes 3 niveles y tus tesoros visibles de las manos.", 3, MAXTREASURES, 0);
        prize = new Prize(2,1);
        unusedMonsters.add(new Monster("Bicefalo", 21, nBadCon, prize));
        
        // -------------- CON SECTARIOS ----------------
        // 1º MONSTRUO - El mal indecible impronunciable | -2 contrasectarios
        badCon = new SpecificBadConsequence("Pierdes 1 mano visible", 0,
                                    new ArrayList(Arrays.asList(TreasureKind.ONEHAND)),
                                    new ArrayList());
        prize = new Prize(3, 1);
        unusedMonsters.add(new Monster("El mal indecible impronunciable", 10, badCon, prize, -2));
        
        // 2º MONSTRUO - Testigos oculares | + 2 contra sectarios
        nBadCon = new NumericBadConsequence("Pierdes tus tesoros visibles. Jajaja.", 0, MAXTREASURES, 0);
        prize = new Prize(2, 1);
        unusedMonsters.add(new Monster("Testigos oculares", 6, nBadCon, prize, 2));
        
        // 3º MONSTRUO - El gran cthulhu | + 4 contra sectarios
        dBadCon = new DeathBadConsequence("Hoy no es tu día de suerte. Mueres.", true);
        prize = new Prize(2, 5);
        unusedMonsters.add(new Monster("El gran cthulhu", 20, dBadCon, prize, 4));
        
        // 4º MONSTRUO - Serpiente Politico | - 2 contra sectarios
        nBadCon = new NumericBadConsequence("Tu gobierno te recorta 2 niveles.", 2, 0, 0);
        prize = new Prize(2, 1);
        unusedMonsters.add(new Monster("Serpiente Politico", 8, nBadCon, prize, -2));
        
        // 5º MONSTRUO - Felpuggoth | + 5 contra sectarios 
        badCon = new SpecificBadConsequence("Pierdes tu casco y tu armadura visible. Pierdes tus manos ocultas.", 0,
                                    new ArrayList(Arrays.asList(TreasureKind.HELMET, TreasureKind.ARMOR)),
                                    new ArrayList(Arrays.asList(TreasureKind.ONEHAND, TreasureKind.ONEHAND, TreasureKind.BOTHHANDS)));
        prize = new Prize(1, 1);
        unusedMonsters.add(new Monster("Felpuggoth", 2, badCon, prize, 5));
        
        // 6º MONSTRUO - Shoggoth | + 4 contra sectarios 
        nBadCon = new NumericBadConsequence("Pierdes 2 niveles.", 2, 0, 0);
        prize = new Prize(4, 2);
        unusedMonsters.add(new Monster("Shoggoth", 16, nBadCon, prize, 4));
        
        // 7º MONSTRUO - Lolitagooth | + 3 contra sectarios 
        nBadCon = new NumericBadConsequence("Pintalabios negro. Pierdes 2 niveles.", 2, 0, 0);
        prize = new Prize(1, 1);
        unusedMonsters.add(new Monster("Lolitagooth", 16, nBadCon, prize, 3));
    } 
    
    private void shuffleTreasures(){
        Collections.shuffle(unusedTreasures);
    }
    
    private void shuffleMonsters(){
        Collections.shuffle(unusedMonsters);
    }
    
    
     public static CardDealer getInstance(){
         return instance;
     }

    // Devuelve el siguiente tesoro que hay en el mazo de tesoros (unusedTreasures) y lo elimina
    // de él. Si al iniciar el método el mazo unusedTreasures estuviese vacío, pasa el mazo de
    // descartes (usedTreasures) al mazo de tesoros (unusedTreasures) y barájalo, dejando el mazo de descartes vacío.
     public Treasure nextTreasure(){
        Treasure siguiente_t;
        
        if(unusedTreasures.isEmpty()){
             for(int i = 0; i < usedTreasures.size(); i++){
                 unusedTreasures.add(usedTreasures.get(i));
                 usedTreasures.remove(i);
             }
                 
             shuffleTreasures();
         }
         
        siguiente_t = unusedTreasures.get(0);
        unusedTreasures.remove(0);
         
        return siguiente_t;
     }
     
     public Monster nextMonster(){
        Monster siguiente_m;
        
        if(unusedMonsters.isEmpty()){
            unusedMonsters = usedMonsters;
            usedMonsters = new ArrayList();
            shuffleMonsters();
        }
         
        siguiente_m = unusedMonsters.get(0);
        unusedMonsters.remove(0);
         
        return siguiente_m;
     }
     
     
    public void giveTreasureBack(Treasure t){
         usedTreasures.add(t);
     }
     
    public void giveMonsterBack(Monster m){
         usedMonsters.add(m);
     }
     
    private void shuffleCultist(){
         Collections.shuffle(unusedCultists);
     }
     
    private void initCultistCardDeck(){
         unusedCultists.add(new Cultist("Sectario", 1));
         unusedCultists.add(new Cultist("Sectario", 2));
         unusedCultists.add(new Cultist("Sectario", 1));
         unusedCultists.add(new Cultist("Sectario", 2));
         unusedCultists.add(new Cultist("Sectario", 1));
         unusedCultists.add(new Cultist("Sectario", 1));
     }
     
    public Cultist nextCultist(){
        Cultist siguiente_c = null;
        
        if(!unusedCultists.isEmpty()){
            siguiente_c = unusedCultists.get(0);
            unusedCultists.remove(siguiente_c);
        }

        return siguiente_c;
    }
    
    public void initCards(){
         this.initTreasureCardDeck();
         this.initMonsterCardDeck();
         this.initCultistCardDeck();
         this.shuffleMonsters();
         this.shuffleTreasures();
         this.shuffleCultist();
     }
}
