package com.game.Myproject;

import java.util.Random;
import java.util.Scanner;

public class Snake extends Character {
    
    

    public Snake(int id, String name, int health, int damage) {
        super(id, name, health, damage, 0);

       
    }
    
    
    public static void deathSnake(Character snake) {

        
        Random random = new Random();
        int trophyRand = random.nextInt(100);
        
        if (trophyRand < 45) {
            System.out.println();
            System.out.println("There is nothing to get!");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        } else if (trophyRand < 70) {
            // get coin
            
            int randomNum = random.nextInt(100);
            
            if (randomNum < 50)
                snake.setCoin(1);
            else if (randomNum > 79)
                snake.setCoin(10);
            else
                snake.setCoin(5);
            System.out.println("You win "+ snake.getCoin()+" coin.");
            Game.gamePlayer.setCoin(Game.gamePlayer.getCoin()+snake.getCoin());
        } else if (trophyRand < 85) {
            // get armor
            int randArm = random.nextInt(100);
            if(randArm<50){
                trophyAsk(Armor.armors[0]);
            }else if(randArm<80){
                trophyAsk(Armor.armors[1]);
            }else{
                trophyAsk(Armor.armors[2]);

            }
        } else {
            // get weapon
            int randweapon = random.nextInt(100);
            if(randweapon<10){
                trophyAsk(Weapon.weapons[3]);
            }
            else if(randweapon<50){
                trophyAsk(Weapon.weapons[0]);
            }else if(randweapon<80){
                trophyAsk(Weapon.weapons[1]);
            }else{
                trophyAsk(Weapon.weapons[2]);

            }
        }

        
    }

    static void trophyAsk(Armor armor){
        Scanner scanner = new Scanner(System.in);
        int select = 0;

        System.out.println("You win "+ armor.getName());
        System.out.println("Do you want to take it on?      1. Yes    2. No");
        select = scanner.nextInt();
        try {
            switch(select){
                case 1:
                Game.gamePlayer.armorAdd(armor);
                System.out.println(armor.getName()+ " taken");
                break;
                case 2:
                System.out.println(armor.getName() + " was not taken" );
                break;
            }
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e);
        }

        
    }

    static void trophyAsk(Weapon weapon){
        Scanner scanner = new Scanner(System.in);
        int select = 0;

        System.out.println("You win "+ weapon.getName());
        System.out.println("Do you want to take it on?      1. Yes    2. No");
        select = scanner.nextInt();
        try {
            switch(select){
                case 1:
                Game.gamePlayer.weaponAdd(weapon);
                System.out.println(weapon.getName()+ " taken");
                break;
                case 2:
                System.out.println(weapon.getName() + " was not taken" );
                break;
            }
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e);
        }

        
    }

}
