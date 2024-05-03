package org.fidan.patikaproducts;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class Notebook extends HighTech {

    public static LinkedHashMap<Integer, Notebook> notebooks = new LinkedHashMap();

    public Notebook(String name, Brand brand, String category, double price, int discount, double screenSize,
            int RAM, int storage) {
        super(name, brand, category, price, discount, screenSize, RAM, storage);

        notebooks.put(this.getProductID(), this);

    }

    static {
        Notebook notebook1 = new Notebook("Huawei Matebook 14", Brand.brands.get("Huawei"), "Notebook",
                7000, 0, 14.0, 16, 512);
        Notebook notebook2 = new Notebook("LENOVO V14 IGL", Brand.brands.get("Lenovo"), "Notebook",
                3699, 0, 14, 8, 1024);
    }

    public static void notebooklist() {
        System.out.println(
                "------------------------------------------------------------------------------------------------------------");
        System.out.printf("%-7s%-35s%-15s%-15s%-15s%-15s%-15s%-15s\n",
                "| ID", "| Ürün Adı", "| Fiyat", "| Marka", "| Depolama", "| Ekran", "| RAM", "|");
        System.out.println(
                "------------------------------------------------------------------------------------------------------------");
        for (Notebook notebook : notebooks.values()) {
            System.out.printf("%-7s%-35s%-15s%-15s%-15s%-15s%-15s%-15s\n",
                    "| " + notebook.getProductID(), "| " + notebook.getName(), "| " + notebook.getPrice() + " TL",
                    "| " + notebook.getBrand(),
                    "| " + notebook.getStorage(), "| " + notebook.getScreenSize(), "| " + notebook.getRAM(), "|");
        }

        System.out.println(
                "------------------------------------------------------------------------------------------------------------");
    }

    public static void NotebookProcess() {
        Scanner scanner = new Scanner(System.in);
        int select;

        System.out.println("\nNotebook İşlemleri\n--------------------------------------");
        System.out.println("1 - Notebookları Listele");
        System.out.println("2 - Notebook Ekle");
        System.out.println("3 - Notebook Sil");
        System.out.println("0 - Anasayfa");

        System.out.print("Tercihiniz : ");
        try {
            select = scanner.nextInt();
            switch (select) {
                case 0:
                    PatikaStore.main(null);

                case 1:
                    notebooklist();
                    System.out.println("0 - Anasayfa:");
                    System.out.println("1 - Geri");
                    select = scanner.nextInt();
                    switch (select) {
                        case 0:
                            PatikaStore.main(null);
                            break;
                        case 1:
                            NotebookProcess();
                            break;

                        default:
                            NotebookProcess();
                    }
                    break;
                case 2:
                    notebookAdd();
                    break;
                case 3:
                    notebooklist();
                    System.out.print("\n!!!!Silmek istediğiniz notebook ID'sini giriniz: ");
                    select = scanner.nextInt();
                    removeNotebook(select);
                    NotebookProcess();
                    break;
                default:
                    NotebookProcess();
            }
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Hatalı bir giriş yaptınız tekrar deneyiniz.");
            NotebookProcess();
        }
    }

    private static void removeNotebook(int ID) {
        // TODO Auto-generated method stub
        System.out.println(notebooks.get(ID).getName() + " silindi.");
        notebooks.remove(ID);
    }

    public static void notebookAdd() {

        String name;
        int price;
        String brand;
        int storage;
        double screenSize;

        int battery;
        int RAM;

        Scanner scanner = new Scanner(System.in);

        System.out.print("Ürün Adı: ");
        name = scanner.nextLine();
        System.out.print("Fiyatı: ");
        price = scanner.nextInt();
        System.out.print("Markası: ");
        brand = scanner.nextLine();
        System.out.print("Ekran genişliği: ");
        screenSize = scanner.nextDouble();
        System.out.print("RAM: ");
        RAM = scanner.nextInt();
        System.out.print("Depolama: ");
        storage = scanner.nextInt();

        Notebook notebook = new Notebook(name, Brand.brands.get(brand), "Notebook", price, 0, screenSize, RAM, storage);

    }

}
