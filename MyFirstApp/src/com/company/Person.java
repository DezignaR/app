package com.company;

public class Person {
    private int Health;
    private int Power;
    private String Name;
    private int Level;
    private int Coin;
    Object weapon = new Object();
    Object armor = new Object();
  /////////////////////
    public void setDamage(int applyDamage){
        this.Health=((this.Health+this.Level)+(this.armor.stat-applyDamage));
    }
    public void SellingWeapon (Object ShopObj){
        this.Coin = this.Coin - ShopObj.price;
        this.weapon.stat=ShopObj.stat;
    }
    public void SellingArmor (Object ShopObj){
        this.Coin = this.Coin - ShopObj.price;
        this.armor.stat=ShopObj.stat;
    }
    public void levelUp (){
        this.Level+=1;
    }
    public void Healing(Object health){
        this.Coin = this.Coin - health.price;
        this.Health += health.stat;
    }
    public void setCoin(int coin) {
        this.Coin += coin;
    }
    ///////////////////Get parameters////////////
    public int getResist(){
        return armor.stat;
    }
    public int getHealth() {
        return Health;
    }
    public int getPower(){
        return Power+weapon.stat;
    }
    public int getResistLevel(){
        return armor.stat+Level;
    }
    public int getLevel() {
        return Level;
    }
    public Object getArmor() {
        return armor;
    }
    public Object getWeapon() {
        return weapon;
    }
    public String getName(){
        return Name;
    }
    public int getCoin() {
        return Coin;
    }





/////////////////////////////Constructors/////////////////////
    public Person(){}
    public Person (String name,int health,int power, Object armor,int coin, Object weapon, int level){
        this.Name = name;
        this.Health = health;
        this.armor = armor;
        this.Coin = coin;
        this.weapon = weapon;
        this.Level = level;
        this.Power = power;



    }



}
