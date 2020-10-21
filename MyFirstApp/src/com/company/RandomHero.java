package com.company;

import java.util.Random;

public class RandomHero {
    public String name;
    public int health;
    public int power;
    public int armor;
    public int coin;
    public int weapon;
    public int level;

    public void Random(int Lvl){
        Random rand = new Random();
        String[] nameHeroes=new String[]{
                "Human","Elf","Ork","Cyborg", "Spirit","Monster","Cat"
        };
        int x;
        x = rand.nextInt(7);
        this.name = nameHeroes[x];
        this.health = rand.nextInt(10)+10;
        this.power = rand.nextInt(7)+Lvl;
        this.armor = rand.nextInt(2)+3;
        this.coin = rand.nextInt(7)+1;
        this.weapon = rand.nextInt(2)+1;
        this.level = Lvl;


    }
}
