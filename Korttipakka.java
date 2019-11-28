
import java.util.ArrayList;
import java.util.Arrays;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author s1901563
 */
public class Korttipakka {
    
    private ArrayList<Kortti> pakka = new ArrayList<>();

    public Korttipakka() {
         
        ArrayList<String> maat = new ArrayList<>(Arrays.asList("pata", "risti", "hertta", "ruutu"));
        
        for (int i = 0; i < 4; i++) {
            for (int c = 1; c <= 13; c++) {
                pakka.add(new Kortti(maat.get(i),c));
            }
        }
    }

    public ArrayList<Kortti> sekoita() {
        
        for (int i = 0; i < pakka.size(); i++) {
            int rand = (int) (Math.random() * 52);
            //New temporary Kortti object used to store the card value from pakka which is being replaced
            //Kortti tmp = new Kortti(pakka.get(i).getMaa(),pakka.get(i).getArvo()); //used first to clone obj
            Kortti tmp = pakka.get(i); //works, too. ??? 
            pakka.set(i, pakka.get(rand)); //used cloned tmp obj first believing that here tmp will be affected. 
            pakka.set(rand, tmp); 
        }
        return pakka;
    }
    
    public Kortti jaaKortti() {
        Kortti current = pakka.get(0);
        pakka.remove(0);
        return current;
    }
    
    @Override
    public String toString() {
        return "Korttipakka{" + "pakka=" + pakka + '}';
    }
}
