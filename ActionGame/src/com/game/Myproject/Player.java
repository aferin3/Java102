package com.game.Myproject;

import java.util.Arrays;

public class Player extends Character {
    private Armor armor;
    private Weapon weapon;
    private int defence = 0;
    int defaultHealth;
    int defaultDamage;
    int block;

    public Player(int id, String name, int health, int damage, int coin,int block) {
        super(id, name, health, damage, coin);
        this.defaultHealth = health;
        this.block=block;
        this.defaultDamage = damage;

    }


    public int getBlock() {
        return this.block;
    }

    public void setBlock(int block) {
        this.block = block;
    }

    public Armor getArmor() {
        return this.armor;
    }

    public void setArmor(Armor armor) {
        this.armor = armor;
    }

    public Weapon getWeapon() {
        return this.weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public int getDefence() {
        return this.defence;
    }

    public void setDefence(int defence) {
        this.defence = defence;
    }

    public int getDefaultHealth() {
        return this.defaultHealth;
    }

    public void setDefaultHealth(int defaultHealth) {
        this.defaultHealth = defaultHealth;
    }

    void armorAdd(Armor armor) {
        super.setHealth(this.defaultHealth+armor.getDefence());
        this.setArmor(armor);

    }

    void weaponAdd(Weapon weapon) {
        super.setDamage(this.defaultDamage+weapon.getDamage());
        this.setWeapon(weapon);
    }
    //overloading
    void showDetails(Player player) {
        System.out.println("ID: " + player.getID());
        System.out.println("Name: " + player.getName());
        System.out.println("Health :" + player.getHealth());
        System.out.println("Damage: " + player.getDamage());
        System.out.println("Coin: " + player.getCoin());
        System.out.println("Defense:  " + player.getBlock());
        
        if (player.getArmor() != null)
            System.out.println("Armor: " + player.getArmor().getName());
        if (player.getWeapon() != null)
            System.out.println("Weapon: " + player.getWeapon().getName());
        if(SafeHouse.prizebox[0] != null)System.out.print("Prizes: ");
        for (String  prizeString : SafeHouse.prizebox) {
            if(prizeString != null){
                System.out.print(prizeString + "\t");
            }
            
        }
        System.out.println();

    }

    public void goLocation(Player player, SafeHouse safeHouse) {
        //safeHouse.onLocation(player,safeHouse);
        
    }
    

}
