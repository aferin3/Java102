package com.game.Myproject;


public class Character {
    private int id;
    private String name;
    private int health;
    private int damage;
    private int coin;
    private Weapon weapon;
    private Armor armor;
    int defaultHealth;
    
    

    public Character(int id, String name, int health, int damage, int coin) {
        this.id = id;
        this.name = name;
        this.health = health;
        this.damage = damage;
        this.coin = coin;
        this.defaultHealth = health;
    }


    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Weapon getWeapon() {
        return this.weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public Armor getArmor() {
        return this.armor;
    }

    public void setArmor(Armor armor) {
        this.armor = armor;
    }


    public int getID() {
        return this.id;
    }

    public void setID(int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return this.health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getDamage() {
        return this.damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getCoin() {
        return this.coin;
    }

    public void setCoin(int coin) {
        this.coin = coin;
    }

    boolean isDead() {
        if (this.health < 1)
            return true;
        else
            return false;
    }

    void showDetails(Character character) {
        System.out.println("ID: " + character.getID());
        System.out.println("Name: " + character.getName());
        System.out.println("Health :" + character.getHealth());
        System.out.println("Damage: " + character.getDamage());
        System.out.println("Coin: " + character.getCoin());
        System.out.println();
       

    }
}
