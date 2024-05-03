package org.fidan.patikaproducts;

public abstract class HighTech extends Products {
    double screenSize;
    int RAM;
    int storage;

    public HighTech(String name, Brand brand, String category, double price, int discount,double screenSize, int RAM, int storage) {
        super(name, brand, category, price, discount);
        //TODO Auto-generated constructor stub
        this.RAM = RAM;
        this.screenSize= screenSize;
        this.storage = storage;

    }

    



    public double getScreenSize() {
        return this.screenSize;
    }

    public void setScreenSize(int screenSize) {
        this.screenSize = screenSize;
    }

    public int getRAM() {
        return this.RAM;
    }

    public void setRAM(int RAM) {
        this.RAM = RAM;
    }

    public int getStorage() {
        return this.storage;
    }

    public void setStorage(int storage) {
        this.storage = storage;
    }
    
    
            

}
