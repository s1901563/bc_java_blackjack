/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author s1901563
 */
public class Kortti {
    private String maa;
    private int arvo;

    public Kortti(String maa, int arvo) {
        this.maa = maa;
        this.arvo = arvo;
    }

    public String getMaa() {
        return maa;
    }

    public int getArvo() {
        return arvo;
    }

    public void setMaa(String maa) {
        this.maa = maa;
    }

    public void setArvo(int arvo) {
        this.arvo = arvo;
    }

    @Override
    public String toString() {
        return "Kortti{" + "maa=" + maa + ", arvo=" + arvo + '}';
    }
    
}
