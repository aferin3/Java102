package com.game.Myproject;
public abstract class Location {
    private String Name;
    private int id;


    public Location(int id,String Name) {
        this.Name = Name;
        this.id = id;
    }


    public String getName() {
        return this.Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public abstract void onLocation(Player player);

}
