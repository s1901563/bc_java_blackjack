
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author s1901563
 */
public class PelaajanKasi {
    
    private ArrayList<Kortti> kortit = new ArrayList<>();

//    public PelaajanKasi() {
//    }
    
    public void otaKortti(Kortti kortti) {
        kortit.add(new Kortti(kortti.getMaa(),kortti.getArvo()));
    }
    
    public Integer selvitaSumma() {
        int summa = 0;
        int aces = 0;
        for (int i = 0; i < kortit.size(); i++) {
            
            //kortin arvo 1 (ässä): käden summaan lisätään 11
            if (kortit.get(i).getArvo() == 1) {
                aces++;
                summa += 11;
            }
            //kortin arvo 11-13: käden summaan lisätään 10
            else if (kortit.get(i).getArvo() > 10) {
                summa += 10;
            }
            //kortin arvo 2-10: käden summaan lisätään kortin numeroa vastaava arvo(2 lisätään 2, 3 lisätään 3.)
            else {
                summa += kortit.get(i).getArvo();                
            }
            
        }
        if (aces > 1) { 
            summa -= 10;
        }
        return summa;
    }

    public boolean ifBlackjack() {
        return (kortit.get(0).getArvo() == 1 && kortit.get(1).getArvo() > 9) || (kortit.get(0).getArvo() > 9 && kortit.get(1).getArvo() == 1);
    }
    
    public String tulostaKasi() {
        String kasi = "";
        for (Kortti kortti: kortit) {
            kasi += kortti.getMaa() + "" + Korttipakka.getKortinNimi(kortti.getArvo()) + " ";
        }
        return kasi;
    }
    
    @Override
    public String toString() {
        return "PelaajanKasi{" + "kortit=" + kortit + '}';
    }
    
}
