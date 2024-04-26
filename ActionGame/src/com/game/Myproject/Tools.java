package com.game.Myproject;

public abstract class Tools {
    private int id;
    private String name;
    private int price;
    


    public Tools(int id,String name, int price) {
        this.name = name;
        this.price = price;
        this.id = id;
    }


    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return this.price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

}
