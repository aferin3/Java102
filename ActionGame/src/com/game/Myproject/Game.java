package com.game.Myproject;

import java.util.Scanner;



public class Game {
    // Player
    static Player gamePlayer;
    
    
    
    //public static Character[] monsters;
    

    
    
    public static Store store;
    public static SafeHouse safeHouse;
    public static BattleArea[] battleAreas;
    
    
    

    public static void main(String[] args) {

        //Weapons
        Weapon[] weapons = new Weapon[4];
        weapons[0] = new Weapon(1, "Gun", 25, 2);
        weapons[1] = new Weapon(2, "Sword", 35, 3);
        weapons[2] = new Weapon(3, "Rifle", 45, 7);
        weapons[3] = new Weapon(4, "Mini Gun", 60, 10);
        
        //Armors
        Armor[] armors = new Armor[3];
        armors[0] = new Armor(1, "Light Armor", 15, 5);
        armors[1] = new Armor(2, "Medium Armor", 25, 7);
        armors[2] = new Armor(3, "Heavy Armor", 40, 10);

        //Players
        Player[] players = new Player[4];
        players[0] = new Player(1, "Samurai", 21, 5, 15,30);
        players[1] = new Player(2, "Archer", 18, 7, 20,20);
        players[2] = new Player(3, "Knight", 24, 8, 10,10);
        players[3] = new Player(4, "Poco", 25, 6, 20, 25);

        
        //Monsters
        
        Character zombie=new Character(1, "Zombie", 10, 3, 4);
        Character vampire=new Character(2, "Vampire", 14, 4, 7);
        Character bear=new Character(3, "Bear", 20, 7, 12);


        // Locations
        safeHouse = new SafeHouse(0,"Safe House");
        store = new Store(1,"Store",weapons,armors);

        //Battle Areas
        battleAreas= new BattleArea[3];
        battleAreas[0]= new BattleArea(2,"Cave", "Food", zombie,4);
        battleAreas[1]= new BattleArea(3,"Forest", "Firewood", vampire,4);
        battleAreas[2] = new BattleArea(4,"River", "Water", bear,4);
        
        
        
        
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);
        int select = 0;
        System.out.println("Welcome to Action Game");
        System.out.println("Please select a difficulty level:   1-Easy  2-Normal 3-Hard ");
        
        try {
            select = scanner.nextInt();
            int persantage;
            switch(select){
                case 1:
                    persantage = 20;
                    break;
                case 2:
                    persantage = 40;
                    break;
                case 3:
                    persantage = 60;
                    break;
                default:
                    persantage =20;
            }
            BattleArea.defensePercentage = persantage;

        } catch (Exception e) {
            System.out.println("Easy mode selected");
        }
        System.out.println("Please select a player");

        for (Player player : players) {
            player.showDetails(player);
        }
        
        System.out.print("Select : ");
        
        try {
            select = scanner.nextInt();
            
            gamePlayer = players[select-1];
        } catch (Exception e) {
            System.out.println("\n!!!!!!!!!!!!!!!      Wrong choise. Please try again      !!!!!!!!!!!!!!!\n");
            main(args);
        }
        
        safeHouse.onLocation(gamePlayer);
        
        
        

    
    }
}
