package com.company;
import java.util.Scanner;

public class GameMotor {
    public void StartGame() {
        boolean play = true;
        String PlayerEvent;
        Scanner answer = new Scanner(System.in);
        Object[] ShopObject = new Object[6];
        ShopObject[1] = new Weapon("Knife", 3, 5);
        ShopObject[2] = new Weapon("Katana", 5, 8);
        ShopObject[3] = new Armor("Shield", 2, 4);
        ShopObject[4] = new Armor("Armour", 4, 6);
        ShopObject[5] = new Health("Health Elixir", 5, 3);
        ShopObject[0] = new Object("NULL", 0, 0);


        Person Heroes = new Person();
        Heroes = CreateHero(ShopObject,Heroes );
        //Person Opponent1 = new Person("Elf",11, 7, ShopObject[0], 5, ShopObject[0], 1);
        //Person Opponent2 = new Person("Ork",20, 3, ShopObject[3], 3, ShopObject[1], 1);

        while (play = true) {
            System.out.println("Уровень: " + Heroes.getLevel());
            System.out.println("Ваша расса: " + Heroes.getName());
            System.out.println("Ваши жизни: " + Heroes.getHealth());
            System.out.println("Ваша сила: " + Heroes.getPower());
            System.out.println("Ваша броня: " + Heroes.getResist());
            System.out.println("Золото: " + Heroes.getCoin());
            System.out.println(   "#########################" +
                                "\n## Начать сражение (b) ##" +
                                "\n##     Магазин (s)     ##" +
                                "\n##    Инвентарь (i)    ##" +
                                "\n#########################");
            if (Heroes.getHealth()<=0){
                System.out.println("Вы умерли. Воскресить в новом теле?y/n");
            }
            PlayerEvent = answer.nextLine();
            switch (PlayerEvent) {
                //////////////////////////////////BATTLE///////////////////////////////
                case "b":
                    BattleGame(Heroes,CreateOpo(ShopObject,Heroes));
                    break;
                //////////////////////////////////////SHOP////////////////////
                case "s":
                    ShopGame(ShopObject,Heroes);
                    break;
                ////////////////////////////////INVENTORY////////////////////
                case "i":
                    Inventory(Heroes);
                    break;
                case "y":
                    Heroes=CreateOpo(ShopObject,Heroes);
                    break;
                case "n":
                    return ;

            }
        }
    }
    public Person CreateHero(Object [] ShopObject, Person heroes){
        RandomHero RandOpo = new RandomHero();

        RandOpo.Random(1);
        Person Hero = new Person(RandOpo.name,RandOpo.health, RandOpo.power, ShopObject[RandOpo.armor], RandOpo.coin, ShopObject[RandOpo.weapon], RandOpo.level);
        return Hero;
    }
    public Person CreateOpo(Object [] ShopObject, Person heroes){
        RandomHero RandOpo = new RandomHero();
        RandOpo.Random(heroes.getLevel());
        Person Opponent = new Person(RandOpo.name,RandOpo.health, RandOpo.power, ShopObject[RandOpo.armor], RandOpo.coin, ShopObject[RandOpo.weapon], RandOpo.level);
    return Opponent;
    }
    public void BattleGame(Person heroes, Person opponent){
        System.out.println("Жизни противника: " + opponent.getHealth());
        System.out.println("Сила противника: " + opponent.getPower());
        System.out.println("Броня противника: " + opponent.getResist());
        System.out.println("Ваши жизни: " + heroes.getHealth());
        System.out.println("Ваша сила: " + heroes.getPower());
        System.out.println("Ваша броня: " + heroes.getResist());
        boolean battle = true;
        int damageHum = 0;
        int damageOrk = 0;
        while (battle == true) {
            opponent.setDamage(heroes.getPower());
            damageHum += heroes.getPower() - opponent.getResistLevel();
            if (opponent.getHealth() > 0) {
                heroes.setDamage(opponent.getPower());
                damageOrk += opponent.getPower() - heroes.getResistLevel();
            } else {
                battle = false;
                heroes.setCoin(opponent.getCoin());
                heroes.levelUp();
                System.out.println("Битва окончена со счетом: " + heroes.getHealth() + "/" + opponent.getHealth());
                System.out.println("Нанесено урона: Вы -" + damageHum + " Противник -" + damageOrk);
                System.out.println("Заработанно золота:" + opponent.getCoin() + " Баланс:" + heroes.getCoin());
            }
            if (heroes.getHealth() <= 0) {
                System.out.println("Битва окончена со счетом: " + heroes.getHealth() + "/" + opponent.getHealth());
                System.out.println("Нанесено урона: Вы -" + damageHum + " Противник -" + damageOrk);
                System.out.println("Заработанно золота:" + "0" + " Баланс:" + heroes.getCoin());
                System.out.println("Game is over!!");
                break;
            }
        }
             System.out.println("Нажмите ENTER для продолжения...");
                Scanner answer = new Scanner(System.in);
                answer.nextLine();

        
    }
    public void ShopGame(Object[] shopObj, Person heroes){
        boolean shop = true;
        String ShopAnswer;
        Scanner answer = new Scanner(System.in);
       while (shop==true) {
           System.out.println("Выберите предмет");
           for (int i = 1; i < shopObj.length; i++) {
               System.out.println("Тип:" + shopObj[i].type +
                       "\nМодель:" + shopObj[i].model +
                       "\nЦена:" + shopObj[i].price +
                       "\nВведите " + i + " для покупки");
           }
           System.out.println("Введите q для выхода");
           ShopAnswer = answer.nextLine();
           switch (ShopAnswer) {
               case "q":
                   shop=false;
                   System.out.println("выход");
                   break;
               default:
                   int SAnsw = Integer.parseInt(ShopAnswer);

                   if (shopObj[SAnsw].type == "Weapon" && (heroes.getCoin() - shopObj[SAnsw].price) >= 0) {
                       heroes.SellingWeapon(shopObj[SAnsw]);
                   } else if (shopObj[SAnsw].type == "Armor" && (heroes.getCoin() - shopObj[SAnsw].price) >= 0) {
                       heroes.SellingArmor(shopObj[SAnsw]);
                   } else if (shopObj[SAnsw].type == "Health" && (heroes.getCoin() - shopObj[SAnsw].price) >= 0) {
                       heroes.Healing(shopObj[SAnsw]);
                   } else if ((heroes.getCoin() - shopObj[SAnsw].price) < 0)
                       System.out.println("Недостаточно золота!!");
                   else System.out.println("Ввел ху");
                   break;
           }
       }
    }
    public void Inventory(Person heroes){
        Object InvArmor,InvWeapon = new Object();
        InvArmor=heroes.getArmor();
        InvWeapon = heroes.getWeapon();
        System.out.println("Броня:" + InvArmor.model +
                "\nХарактеристики:" + InvArmor.stat+
                "\n");
        System.out.println("Оружие:" + InvWeapon.model +
                "\nХарактеристики:" + InvWeapon.stat+
                "\n");
        System.out.println("Нажмите ENTER для продолжения...");
        Scanner answer = new Scanner(System.in);
        answer.nextLine();

    }

}



