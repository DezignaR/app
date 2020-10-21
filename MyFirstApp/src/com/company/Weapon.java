package com.company;

public class Weapon extends Object {
    public Weapon(String Name, int Stat, int Price){
        super.price=Price;
        super.model=Name;
        super.stat=Stat;
        super.type="Weapon";
    }

    public Weapon() {

    }
}
