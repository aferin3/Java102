package com.game.Myproject;



public class Armor extends Tools{
    private int defence;
    public static Armor[] armors = new Armor[3];
    
    public Armor(int id,String name, int price,int defence) {
        super(id, name, price);
        this.defence = defence;


        
        
    }

    static {
        //Armors
        
        armors[0] = new Armor(1, "Light Armor", 15, 5);
        armors[1] = new Armor(2, "Medium Armor", 25, 7);
        armors[2] = new Armor(3, "Heavy Armor", 40, 10);
    }


    public int getDefence() {
        return this.defence;
    }

    public void setDefence(int defence) {
        this.defence = defence;
    }

}
