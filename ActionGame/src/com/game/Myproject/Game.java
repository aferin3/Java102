package com.game.Myproject;

import java.util.Arrays;
import java.util.Scanner;



public class Game {
    // Player
    static Player gamePlayer;
    
    
    
    
    
    

    public static void main(String[] args) {

        
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
                    persantage = 15;
                    break;
                case 2:
                    persantage = 30;
                    break;
                case 3:
                    persantage = 45;
                    break;
                default:
                    persantage =20;
            }
            BattleArea.defensePercentage = persantage;

        } catch (Exception e) {
            System.out.println("Easy mode selected");
        }
        System.out.println("Please select a player");
        
        
        for (Player player : Player.players) {
            player.showDetails(player);
        }
        
        System.out.print("Select : ");
        
        try {
            select = scanner.nextInt();
            
            gamePlayer = Player.players[select-1];
        } catch (Exception e) {
            System.out.println("\n!!!!!!!!!!!!!!!      Wrong choise. Please try again      !!!!!!!!!!!!!!!\n");
            main(args);
        }
        
        SafeHouse.safeHouse.onLocation(gamePlayer);
        
        
        

    
    }
}
