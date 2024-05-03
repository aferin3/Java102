package org.fidan.patikaproducts;


import java.util.TreeMap;


// Marka sınıfı
class Brand implements Comparable<Brand> {
    static int staticID = 0;
    private int id;
    private String name;
    public static TreeMap<String,Brand> brands = new TreeMap<>();
    
    
    public Brand(String name) {
        this.id = ++staticID;
        this.name = name;
        brands.put(name,this);
    }

    // Getter ve Setter metotları

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return name;
    }

    static {
        Brand samsung =new Brand("Samsung");
        Brand lenovo = new Brand("Lenovo");
        Brand apple = new Brand("Apple");
        Brand huawei = new Brand("Huawei");
        Brand casper = new Brand("Casper");
        Brand asus = new Brand("Asus");
        Brand hp = new Brand("HP");
        Brand xioami = new Brand("Xioami");
        Brand Monster = new Brand("Monster");

    }

    public static void listBrands(){
        System.out.println("Markalarımız");
        System.out.println("-------------------");
        for (String iterable : brands.keySet()) {
            System.out.println(String.format("%-15s", brands.get(iterable)));
        }
    }

    @Override
    public int compareTo(Brand o) {
        // TODO Auto-generated method stub
       return this.getName().compareTo(o.getName());
    }
}

