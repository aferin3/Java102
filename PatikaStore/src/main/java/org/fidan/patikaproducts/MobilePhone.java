package org.fidan.patikaproducts;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class MobilePhone extends HighTech {
    int batteryCapacity;
    int camera;
    String color;
    public static LinkedHashMap<Integer, MobilePhone> mobilePhones = new LinkedHashMap();

    public MobilePhone(String name, Brand brand, String category, double price, int discount, double screenSize,
            int RAM, int batteryCapacity, int storage, String color, int camera) {
        super(name, brand, category, price, discount, screenSize, RAM, storage);
        // TODO Auto-generated constructor stub
        this.batteryCapacity = batteryCapacity;
        this.camera = camera;
        this.color = color;
        mobilePhones.put(this.getProductID(), this);
    }

    public int getBatteryCapacity() {
        return this.batteryCapacity;
    }

    public void setBatteryCapacity(int batteryCapacity) {
        this.batteryCapacity = batteryCapacity;
    }

    public String getColor() {
        return this.color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    static {
        MobilePhone a51 = new MobilePhone("Samsung Galaxy A51", Brand.brands.get("Samsung"),
                "Telefon", 3199.0, 10, 6.5, 6, 4000, 128, "Siyah", 32);

        MobilePhone iphone11 = new MobilePhone("Iphone 11 64 GB", Brand.brands.get("Apple"),
                "Telefon", 7379, 0, 6.1, 6, 3046, 64, "Mavi", 5);

        MobilePhone redmiNote10Pro = new MobilePhone("Redmi Note 10 Pro 8GB", Brand.brands.get("Xioami"),
                "Telefon", 3199, 0, 6.5, 6, 4000, 128, "Beyaz", 35);

    }

    public static void mobileList() {
        System.out.println("-----------------------------------------------------------------" +
                "----------------------------------------------------------------------------------------");
        System.out.printf("%-7s%-35s%-15s%-15s%-15s%-15s%-15s%-15s%-15s%-15s%-15s\n",
                "| ID", "| Ürün Adı", "| Fiyat", "| Marka", "| Depolama", "| Ekran", "| Kamera", "| Pil", "| RAM",
                "| Renk", "|");
        System.out.println("-----------------------------------------------------------------" +
                "----------------------------------------------------------------------------------------");
        for (MobilePhone mobilePhone : mobilePhones.values()) {
            System.out.printf("%-7s%-35s%-15s%-15s%-15s%-15s%-15s%-15s%-15s%-15s%-15s\n",
                    "| " + mobilePhone.getProductID(), "| " + mobilePhone.getName(),
                    "| " + mobilePhone.getPrice() + " TL", "| " + mobilePhone.getBrand(),
                    "| " + mobilePhone.getStorage(),
                    "| " + mobilePhone.screenSize, "| " + mobilePhone.camera, "| " + mobilePhone.batteryCapacity,
                    "| " + mobilePhone.RAM, "| " + mobilePhone.color, "|");

        }
        System.out.println("-----------------------------------------------------------------" +
                "----------------------------------------------------------------------------------------");
    }

    public static void MobileProcess() {
        Scanner scanner = new Scanner(System.in);
        int select;

        System.out.println("\nCep Telefonu İşlemleri\n--------------------------------------");
        System.out.println("1 - Telefonları Listele");
        System.out.println("2 - Telefon Ekle");
        System.out.println("3 - Telefon Sil");
        System.out.println("0 - Anasayfa");
        System.out.print("Tercihiniz : ");

        try {
            select = scanner.nextInt();
            switch (select) {
                case 0:
                    PatikaStore.main(null);
                case 1:
                    mobileList();
                    System.out.println("0 - Anasayfa:");
                    System.out.println("1 - Geri");
                    select = scanner.nextInt();
                    switch (select) {
                        case 0:
                            PatikaStore.main(null);
                            break;
                        case 1:
                            MobileProcess();
                            break;

                        default:
                            MobileProcess();
                    }
                    break;
                case 2:
                    mobileAdd();
                    MobileProcess();
                    break;
                case 3:
                    mobileList();
                    System.out.print("\n!!!!Silmek istediğiniz telefonun ID'sini giriniz: ");
                    select = scanner.nextInt();
                    removeMobile(select);
                    MobileProcess();
                    break;
                default:
                    MobileProcess();

            }
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Hatalı bir giriş yaptınız tekrar deneyiniz.");
            MobileProcess();
        }

    }

    public static void removeMobile(Integer ID) {
        System.out.println(mobilePhones.get(ID).getName() + " silindi.");
        mobilePhones.remove(ID);

    }

    public static void mobileAdd(){
        String name;
        int price;
        String brand;
        int storage;
        double screenSize;
        int camera;
        int battery;
        int RAM;
        String color;

        Scanner scanner =new Scanner(System.in);

        System.out.print("Ürün Adı: ");
        name = scanner.nextLine();
        System.out.print("Fiyatı: ");
        price = scanner.nextInt();
        System.out.print("Markası: ");
        brand = scanner.nextLine();
        System.out.print("Ekran genişliği: ");
        screenSize = scanner.nextDouble();
        System.out.print("Kamera Çözünürlüğü: ");
        camera = scanner.nextInt();
        System.out.print("Batarya kapasitesi: ");
        battery = scanner.nextInt();
        System.out.print("RAM: ");
        RAM = scanner.nextInt();
        System.out.print("Depolama: ");
        storage = scanner.nextInt();
        System.out.print("Renk: ");
        color = scanner.nextLine();

        MobilePhone mobile = new MobilePhone(name, Brand.brands.get(brand), "Telefon", price, 0, screenSize, RAM, battery, storage, color, camera);
        

    }

}
