package com.game.Myproject;

public class Weapon extends Tools {
    private int damage;
    public static Weapon[] weapons;
    public Weapon(int id,String name, int price, int damage) {
        super(id, name, price);
        this.damage = damage;

        
        
    }
    static {
        //Weapons
        weapons = new Weapon[4];
        weapons[0] = new Weapon(1, "Gun", 25, 2);
        weapons[1] = new Weapon(2, "Sword", 35, 3);
        weapons[2] = new Weapon(3, "Rifle", 45, 7);
        weapons[3] = new Weapon(4, "Mini Gun", 60, 10);
    }


    public int getDamage() {
        return this.damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }


}
