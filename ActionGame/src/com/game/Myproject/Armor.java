package com.game.Myproject;

public class Armor extends Tools{
    private int defence;
    public Armor(int id,String name, int price,int defence) {
        super(id, name, price);
        this.defence = defence;
    }


    public int getDefence() {
        return this.defence;
    }

    public void setDefence(int defence) {
        this.defence = defence;
    }

}
