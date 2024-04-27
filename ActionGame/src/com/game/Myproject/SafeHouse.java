package com.game.Myproject;

import java.util.Random;
import java.util.Scanner;

public class SafeHouse extends Location {
    public static String[] prizebox;
    public static SafeHouse safeHouse;
    

    public SafeHouse(int ID,String Name) {
        super(ID,Name);
        
        
        // Locations
        
        prizebox = new String[3];

    }
    
    static {
        safeHouse = new SafeHouse(0,"Safe House");
    }

    static Scanner input = new Scanner(System.in);
    //overload
    public void onLocation(Player player) {
        
        if(prizebox[prizebox.length-1] != null){
            while(true){
                System.out.println("\n\t\t\t  *************************Congragualtions***************************");
                System.out.println();
                System.out.println("                         \t\t\tYou Finished the Game");
                System.out.println();
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                break;
            }
            Game.main(prizebox);
        }
        System.out.println("========== " + player.getName() + ", welcome to " + super.getName() + " ==========");
        if(player.getArmor() != null) player.setHealth(player.defaultHealth+player.getArmor().getDefence());
        else player.setHealth(player.defaultHealth);
        player.showDetails(player);
        
        int select;
        System.out.println();
        System.out.println("Where do you want to go?");
        
        System.out.println(Store.store.getId() + "-" + Store.store.getName());
        try {
            Random random = new Random();
            
            
            for (BattleArea battleArea : BattleArea.battleAreas) {
                int i = random.nextInt(battleArea.getMaxMonsterNum());
                battleArea.setMonsterNumber(i+1);
                
                System.out.println(battleArea.getId()+"-"+battleArea.getName());
                
            }
            select = input.nextInt();
            switch(select){
                case 1:
                Store.store.onLocation(player);
                break;
                default:
                BattleArea.battleAreas[select-2].onLocation(player);
            }    
        } catch (Exception e) {
            System.out.println(e);
            //this.onLocation(player);
        }
        
        

        

        

    }
    

}
