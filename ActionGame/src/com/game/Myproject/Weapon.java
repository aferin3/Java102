package com.game.Myproject;

public class Weapon extends Tools {
    private int damage;
    public Weapon(int id,String name, int price, int damage) {
        super(id, name, price);
        this.damage = damage;
        
    }


    public int getDamage() {
        return this.damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }


}
