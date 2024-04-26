package com.game.Myproject;

import java.util.Scanner;

public class Store extends Location {

    Weapon[] weapons;
    Armor[] armors;
    

    public Store(int ID,String Name, Weapon[] weapons, Armor[] armors) {
        super(ID,Name);
        this.weapons = weapons;
        this.armors = armors;
        

    }

    public void onLocation(Player player) {
        int select;
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);
        
        try {
            System.out.println("1-Weapons   2-Armors    3-Back to Safe House");
            select = scanner.nextInt();
            System.out.println("Your Coin: "+ player.getCoin());
            if(select == 1){
                for (Weapon weapon : weapons) {
                    System.out.println(weapon.getId() + "-" + weapon.getName() + "  Damage = "
                    + weapon.getDamage() + "\tPrice= " + weapon.getPrice());
        
                }
                System.out.println((weapons.length +1)+ "-Cancel");
                select = scanner.nextInt();
                if(select == weapons.length+1) this.onLocation(player);
                else buy(player,weapons[select-1]);
            }else if (select == 2){
                for (Armor armor : armors) {
                    System.out.println(armor.getId() + "-" + armor.getName() + "  Defense = "
                    + armor.getDefence() + "\tPrice= " + armor.getPrice());
                    
                
                }
                System.out.println((armors.length+1) + "-Cancel");
                select = scanner.nextInt();
                if(select == armors.length+1) this.onLocation(player);
                else buy(player,armors[select-1]);
                
            }else{
                Game.safeHouse.onLocation(player);
            }
            
            
        } catch (Exception e) {
            System.out.println("\n!!!!!!!!!!!!!!!      Wrong choise. Please try again      !!!!!!!!!!!!!!!\n");
            
            
        }
        
        

    }

    private void buy(Player player, Armor armor) {
        if(player.getCoin()<armor.getPrice()){
            System.out.println("Unsufficient coin");
            
        }else{
            player.armorAdd(armor);
            player.setCoin(player.getCoin()-armor.getPrice());
            System.out.println(armor.getName()+" was taken.");
            System.out.println("You have "+ player.getCoin() + " coins left.");
            
        }
        this.onLocation(player);
    }

    void buy(Player player, Weapon weapon) {
        if(player.getCoin()<weapon.getPrice()){
            System.out.println("Unsufficient coin");
            
        }else{
            player.weaponAdd(weapon);
            player.setCoin(player.getCoin()-weapon.getPrice());
            System.out.println(weapon.getName()+" was taken.");
            System.out.println("You have "+ player.getCoin() + " coins left.");
        }
        
        this.onLocation(player);
        
        System.out.println(player.getDamage());

    }

}
