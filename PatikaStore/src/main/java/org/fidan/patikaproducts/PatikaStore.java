/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package org.fidan.patikaproducts;

import java.util.Scanner;

/**
 *
 * @author Aferin
 */
public class PatikaStore {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int select;

        MobilePhone xioami = new MobilePhone("Redmi Note 12 Plus", Brand.brands.get("Xioami"), "Telefon", 13000, 20, 6.1, 8, 5000, 128, "Beyaz", 52);
       


        System.out.println("PatikaStore Ürün Yönetim Paneli !");
        System.out.println("1 - Notebook İşlemleri");
        System.out.println("2 - Cep Telefonu İşlemleri");
        System.out.println("3 - Markaları Listele");
        System.out.println("0 - Çıkış Yap");

        System.out.print("Tercihiniz : ");

        try {
            select = scanner.nextInt();
            switch (select) {
                case 0:
                    System.exit(0);
                    break;
                case 1:
                    Notebook.NotebookProcess();
                    break;
                case 2:
                    MobilePhone.MobileProcess();
                    break;
                case 3:
                    Brand.listBrands();
                    System.out.println("0 - Anasayfa");
                    select = scanner.nextInt();
                    main(args);
                    break;
                default:
                    main(args);
            }
        } catch (Exception e) {
            //System.out.println(e);
            System.out.println("\n!!!Yanlış giriş yaptının lütfen tekrar deneyiniz!!!\n");
            main(args);
        }

    }
}
