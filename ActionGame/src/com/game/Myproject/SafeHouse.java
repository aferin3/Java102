package com.game.Myproject;

import java.util.Random;
import java.util.Scanner;

public class SafeHouse extends Location {
    public static String[] prizebox;
   
    

    public SafeHouse(int ID,String Name) {
        super(ID,Name);
        
        prizebox = new String[3];
        
        

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
        Store store = Game.store;
        System.out.println(store.getId() + "-" + store.getName());
        try {
            Random random = new Random();
            
            BattleArea[] battleAreas = Game.battleAreas;
            for (BattleArea battleArea : battleAreas) {
                int i = random.nextInt(battleArea.maxMonsterNum);
                battleArea.setMonsterNumber(i+1);
                System.out.println(battleArea.getId()+"-"+battleArea.getName());
                
            }
            select = input.nextInt();
            switch(select){
                case 1:
                Game.store.onLocation(player);
                break;
                default:
                battleAreas[select-2].onLocation(player);
            }    
        } catch (Exception e) {
            System.out.println("Wrong Choice");
            this.onLocation(player);
        }
        
        

        

        

    }
    

}
