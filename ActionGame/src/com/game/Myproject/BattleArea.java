package com.game.Myproject;

import java.util.Random;
import java.util.Scanner;

public class BattleArea extends Location {

    Character monster;
    String prize;
    Boolean isGivenPrize;
    int monsterNumber;
    int maxMonsterNum;
    public static int defensePercentage = 20;
    public static int prizeNumber = 0;
    public static BattleArea[] battleAreas;

    public BattleArea(int ID, String Name, String prize, Character monster, int maxMonsterNum) {
        super(ID, Name);

        this.isGivenPrize = false;
        this.prize = prize;
        this.monster = monster;
        this.maxMonsterNum = maxMonsterNum;
        monsterNumber = 0;

       

    }

    static {
         //Battle Areas
         battleAreas= new BattleArea[4];
         battleAreas[0]= new BattleArea(2,"Cave", "Food", Character.monsters[0],3);
         battleAreas[1]= new BattleArea(3,"Forest", "Firewood", Character.monsters[1],3);
         battleAreas[2] = new BattleArea(4,"River", "Water", Character.monsters[2],3);
         battleAreas[3] = new BattleArea(5,"Mine", null, Character.monsters[3], 6);

         battleAreas[3].setIsGivenPrize(true); //There is no prize in Mine
    }

    @Override
    public void onLocation(Player player) {
        Scanner scanner = new Scanner(System.in);
        int select = 0;

        System.out.println("You came across " + this.monsterNumber + " " + this.monster.getName());
        System.out.println("     1-Fight        2-Run Away to Safe House");
        try {
            select = scanner.nextInt();

            switch (select) {
                case 1:
                    if (monsterNumber == 1) {
                        fight(player, monster);
                        if (player.getHealth() <= 0) {
                            System.out.println("The " + player.getName() + " was dead.");
                            System.out.println("GAME OVER");
                        } else {
                            System.out.println("The " + monster.getName() + " was dead");
                            if (!isGivenPrize && prizeNumber < 3) {
                                SafeHouse.prizebox[prizeNumber] = this.prize;
                                System.out.println("******************************************\tYou win new prize: "
                                        + this.prize + "\t\t******************************************");
                                isGivenPrize = true;
                                prizeNumber++;

                            }
                           if(monster.getID() != 4){ 
                            System.out.println();
                            System.out.println("You win " + monster.getCoin() + " coin.\n");
                            player.setCoin(player.getCoin() + monster.getCoin());
                           }else {
                            Snake.deathSnake(Character.monsters[3]);
                           }
                            SafeHouse.safeHouse.onLocation(player);
                        }
                    } else {

                        for (int i = 0; i < monsterNumber; i++) {
                            System.out.println((i + 1) + ". " + monster.getName());
                            monster.setHealth(monster.defaultHealth);
                            Thread.sleep(3000);
                            fight(player, monster);
                            if (monster.getHealth() <= 0) {
                                if (monster.getID() != 4) {
                                    System.out.println((i + 1) + "." + monster.getName() + " was dead. \nYou win "
                                            + monster.getCoin() + " coin\n");
                                    player.setCoin(player.getCoin() + monster.getCoin());
                                } else {
                                    Snake.deathSnake(Character.monsters[3]);

                                }

                            }

                        }
                        if (player.getHealth() <= 0) {
                            System.out.println("The " + player.getName() + " was dead.");
                            System.out.println("GAME OVER");
                        } else {
                            System.out.println("All " + monster.getName() + "s were dead");
                            if (!isGivenPrize && prizeNumber < SafeHouse.prizebox.length) {
                                SafeHouse.prizebox[prizeNumber] = this.prize;
                                System.out.println("******************************************\tYou win new prize: "
                                        + this.prize + "\t\t******************************************");
                                isGivenPrize = true;
                                prizeNumber++;

                            }
                            SafeHouse.safeHouse.onLocation(player);
                        }
                    }
                    break;
                case 2:
                    SafeHouse.safeHouse.onLocation(player);
            }
        } catch (Exception e) {
            System.out.println(e);
            this.onLocation(player);
        }

    }

    void fight(Player player, Character monster) {
        Boolean next;
        next = (int) Math.random() * 100 % 2 == 0 ? true : false; // who start first
        Boolean isHit = true;
        String name = player.getName();
        String mons = monster.getName();
        while (!player.isDead() && !monster.isDead()) {

            Random random = new Random();
            int luck = random.nextInt(101);
            if (next) {
                System.out.println(name + " try to hit...\n");
                isHit = luck < defensePercentage ? false : true;

            } else {
                System.out.println(mons + " try to hit...\n");
                isHit = luck < player.getBlock() ? false : true;

            }

            try {
                Thread.sleep(2000);

            } catch (InterruptedException e) {
                System.out.println(e);
            }
            if (next && isHit) {
                monster.setHealth(monster.getHealth() - player.getDamage());
                System.out.println(name + " hit======> The" + mons);
                if (monster.getHealth() <= 0)
                    break;
                System.out.println("The " + mons + "'s Health: " + monster.getHealth());

            } else if (next && !isHit) {
                System.out.println("The " + mons + " xxxxxxx deflected the attack\n");
            } else if (!next && isHit) {
                player.setHealth(player.getHealth() - monster.getDamage());
                System.out.println("The " + mons + " hit======> " + player.getName());
                if (player.getHealth() <= 0)
                    break;
                System.out.println("The " + name + "'s Health: " + player.getHealth());
                System.out.println();
            } else {
                System.out.println("The " + name + " xxxxxxx deflected the attack\n");
            }
            next = !next;
            try {
                Thread.sleep(2000);

            } catch (InterruptedException e) {
                System.out.println(e);
            }

        }

    }

    public Character getMonster() {
        return this.monster;
    }

    public void setMonster(Character monster) {
        this.monster = monster;
    }

    public String getPrize() {
        return this.prize;
    }

    public void setPrize(String prize) {
        this.prize = prize;
    }

    public Boolean isIsGivenPrize() {
        return this.isGivenPrize;
    }

    public Boolean getIsGivenPrize() {
        return this.isGivenPrize;
    }

    public void setIsGivenPrize(Boolean isGivenPrize) {
        this.isGivenPrize = isGivenPrize;
    }

    public int getMonsterNumber() {
        return this.monsterNumber;
    }

    public void setMonsterNumber(int monsterNumber) {
        this.monsterNumber = monsterNumber;
    }

    public int getMaxMonsterNum() {
        return this.maxMonsterNum;
    }

    public void setMaxMonsterNum(int maxMonsterNum) {
        this.maxMonsterNum = maxMonsterNum;
    }

}
