package BattleField;

import java.util.LinkedList;
import java.util.Queue;

import static BattleField.Action.*;
import static BattleField.Weapons.*;

public class Fighter {
    private String name;
    private int strength = (int) Math.round(Math.random() * 100);
    private int agile = (int) Math.round(Math.random() * (100 - strength));
    private int speed = 100 - strength - agile;
    private double hp = 300.0 + strength + 0.0;
    private double damage = 20.0 + 0.1 * (strength + 0.0);
    private Queue<Weapons> weaponsQueue;
    private double critRite = 0.3;
    private double evadeRite = agile / (agile + 100.0);

    public Fighter(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "玩家:" + name + " HP:" + hp + " 攻击力:" + damage + " 力量：" + strength + " 敏捷：" + agile + " 速度：" + speed;
    }

    public String getName() {
        return name;
    }

    public void setAgile(int agile) {
        this.agile = agile;
    }

    public int getAgile() {
        return agile;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getStrength() {
        return strength;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getSpeed() {
        return speed;
    }

    public double getHp() {
        return hp;
    }

    public boolean setHp(double hp) {
        if (this.getHp() > hp) {
            if (roll(this.getEvadeRite())) {
                evade(this);
                return false;
            } else {
                this.hp = deal(hp);
                return true;
            }
        } else {
            this.hp = deal(hp);
            return true;
        }
    }

    public double getDamage() {
        return damage;
    }

    public int get(String s) {
        switch (s) {
            case "strength":
                return this.strength;
            case "agile":
                return this.agile;
            case "speed":
                return this.speed;
            default:
                return 0;
        }
    }

    public Queue<Weapons> getWeaponsQueue() {
        return weaponsQueue;
    }

    public double getCritRite() {
        return critRite;
    }

    public void setCritRite(double critRite) {
        this.critRite = critRite;
    }

    public void setEvadeRite(double evadeRite) {
        this.evadeRite = evadeRite;
    }

    public double getEvadeRite() {
        return evadeRite;
    }

    public void setWeaponsQueue(Queue<Weapons> weaponsQueue) {
        this.weaponsQueue = weaponsQueue;
    }

    public static void main(String[] args) {
        Fighter fighter1 = new Fighter("world1");
        System.out.println(fighter1);
        Fighter fighter2 = new Fighter("world2");
        System.out.println(fighter2);
        Queue<Weapons> queue1 = new LinkedList<Weapons>();
        Queue<Weapons> queue2 = new LinkedList<Weapons>();
        fighter1.setWeaponsQueue(queue1);
        fighter2.setWeaponsQueue(queue2);
    }
}
