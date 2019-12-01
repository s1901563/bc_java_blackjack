
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author s1901563
 */
public class BlackJack {
    public static void main(String[] args) {

        Scanner lukija = new Scanner(System.in);
        Korttipakka pakka = new Korttipakka();
        pakka.sekoita();
        
//        pakka.prependKortti(new Kortti("♠", 1));
//        pakka.prependKortti(new Kortti("♠", 10));
//        pakka.prependKortti(new Kortti("♠", 1));
//        pakka.prependKortti(new Kortti("♠", 10));

        System.out.println("\n♦ ♥ ♣ ♠   BLACKJACK   ♠ ♣ ♥ ♦\n");

        PelaajanKasi kortit = new PelaajanKasi();
        kortit.otaKortti(pakka.jaaKortti());
        kortit.otaKortti(pakka.jaaKortti());
        
        while (true) {
            if (kortit.ifBlackjack()) {
                System.out.println(kortit.tulostaKasi() + "| Tulos: BLACKJACK");
                break;
            }
            System.out.println("Kätesi: " + kortit.tulostaKasi() + "| Tulos: " + kortit.selvitaSumma());
            System.out.print("Seuraava kortti? [k/e])");

            if (lukija.nextLine().equalsIgnoreCase("k")) {
                kortit.otaKortti(pakka.jaaKortti());
                if (kortit.selvitaSumma() > 21) {
                    System.out.println("Yli 21! Tulos: " + kortit.selvitaSumma());
                    break;
                }
            }
            else {
                break;
            }
        }

        //System.out.println("\nAvustaja pelaa");
        PelaajanKasi avustajanKortit = new PelaajanKasi();
        avustajanKortit.otaKortti(pakka.jaaKortti());
        avustajanKortit.otaKortti(pakka.jaaKortti());

        if (avustajanKortit.ifBlackjack()) {
            System.out.println(avustajanKortit.tulostaKasi() + " | Tulos: BLACKJACK");
        }

        while (avustajanKortit.selvitaSumma() <= 15) {
            avustajanKortit.otaKortti(pakka.jaaKortti());
            //System.out.println(avustajanKortit.tulostaKasi());
        }
        
        System.out.println("\nLOPPUTULOS:");
        System.out.println("Pelaajan kortit: " + kortit.tulostaKasi() + "| Tulos: " + kortit.selvitaSumma());      
        System.out.println("Avustajan kortit: " + avustajanKortit.tulostaKasi() + "| Tulos: " + avustajanKortit.selvitaSumma());
        
        if ((kortit.selvitaSumma() > avustajanKortit.selvitaSumma() && kortit.selvitaSumma() <= 21) || (avustajanKortit.selvitaSumma() > 21 && kortit.selvitaSumma() <= 21)) {
            System.out.println("Pelaaja voitti!");
        }
        else if ((kortit.selvitaSumma() < avustajanKortit.selvitaSumma() && avustajanKortit.selvitaSumma() <= 21) || (kortit.selvitaSumma() > 21 && avustajanKortit.selvitaSumma() <= 21)) {
            System.out.println("Avustaja voitti!");
        }
        else {
            System.out.println("Tasapeli!");
        }

    }
}
