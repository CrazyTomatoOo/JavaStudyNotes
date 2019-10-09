package BattleField;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Action {
    public static boolean roll(double a) {
        double t = Math.random();
        if (t < a)
            return true;
        else
            return false;
    }

    public static void evade(Fighter fighter) {
        switch ((int) (Math.random() * 3)) {
            case 0:
                System.out.println("," + fighter.getName() + "轻松躲过");
                break;
            case 1:
                System.out.println("," + fighter.getName() + "从容应对化解攻击");
                break;
            default:
                System.out.println("," + fighter.getName() + "呵呵一笑，御气腾空，躲过一击");
                break;
        }
    }

    public static double crit(double damage) {
        damage = damage * 1.5;
        return damage;
    }

    public static double deal(double a) {
        return (double) Math.round(a * 100) / 100;
    }

    public static void attack(Fighter fighter1, Fighter fighter2, boolean a) {
        if (a) {
            System.out.print(fighter1.getName() + "凝气于掌，大力拍出");
            boolean l = fighter2.setHp(deal(fighter2.getHp() - crit(fighter1.getDamage())));
            if (l) {
                System.out.println("对" + fighter2.getName() + "，造成" + deal(crit(fighter1.getDamage())) + "点伤害");
            }
        } else {
            System.out.print(fighter1.getName()+"直出一拳");
            boolean l = fighter2.setHp(deal(fighter2.getHp() - fighter1.getDamage()));
            if (l) {
                System.out.println("对" + fighter2.getName() + "，造成" + fighter1.getDamage() + "点伤害");
            }
        }
    }

    public static Weapons getWeapon(Fighter fighter) {
        Weapons weapon = fighter.getWeaponsQueue().poll();
        System.out.print(fighter.getName() + "掏出了" + weapon.getName() + ",");
        return weapon;
    }

    public static Queue<Weapons> prepare(Weapons... weapons) {
        List<Weapons> list = new LinkedList<Weapons>();
        Queue<Weapons> queue = new LinkedList<>();
        for (Weapons weapon : weapons) {
            list.add(weapon);
        }
        Collections.shuffle(list);
        for (Weapons weapon : list) {
            queue.add(weapon);
        }
        return queue;
    }

    public static boolean judge(Fighter fighter1, Fighter fighter2) {
        if (fighter1.getHp() <= 0) {
            if (fighter2.getHp() > 100) {
                System.out.println(fighter1.getName() + "倒地不起，" + fighter2.getName() + "完胜！！！");
            } else if (fighter2.getHp() < 20) {
                System.out.println(fighter1.getName() + "惜败，" + fighter2.getName() + "险胜！！！");
            } else {
                System.out.println(fighter2.getName() + "获得胜利！！！");
            }
            return true;
        } else if (fighter2.getHp() <= 0) {
            if (fighter1.getHp() > 100) {
                System.out.println(fighter2.getName() + "倒地不起，" + fighter1.getName() + "完胜！！！");
            } else if (fighter1.getHp() < 20) {
                System.out.println(fighter2.getName() + "惜败，" + fighter1.getName() + "险胜！！！");
            } else {
                System.out.println(fighter1.getName() + "获得胜利！！！");
            }
            return true;
        } else {
            System.out.print(fighter1.getName() + "还剩" + fighter1.getHp() + "点HP||");
            System.out.println(fighter2.getName() + "还剩" + fighter2.getHp() + "点HP");
            return false;
        }
    }
}
