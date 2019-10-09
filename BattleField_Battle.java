package BattleField;


import java.util.*;

import static BattleField.Action.*;
import static BattleField.Weapons.*;

public class Battle {
    public static void main(String[] args) {
        Out o=new Out();
        Fighter a = new Fighter("令狐葱");
        Fighter b = new Fighter("西门吹水");
        System.out.println(a);
        System.out.println(b);
        Queue<Weapons> q1 = prepare(spear, trident, darts, goldbrick);
        Queue<Weapons> q2 = prepare(spear, trident, darts, goldbrick);
        a.setWeaponsQueue(q1);
        b.setWeaponsQueue(q2);
        for (Weapons weapon : q1) {
            System.out.print(weapon.getName() + " ");
        }
        System.out.println();
        for (Weapons weapon : q2) {
            System.out.print(weapon.getName() + " ");
        }
        System.out.println();
        double rite = deal((a.getSpeed() + 0.0) / (a.getSpeed() + b.getSpeed()));
        for (int j = 1; j > 0; j++) {
            System.out.println("第" + j + "回合");
            System.out.println("=============================================");
            if (roll(rite)) {
                if (roll(0.5) && !a.getWeaponsQueue().isEmpty()) {
                    Weapons w = getWeapon(a);
                    w.attack(a, b);
                } else {
                    attack(a, b, roll(a.getCritRite()));
                }
                boolean l1 = judge(a, b);
                if (l1) {
                    break;
                }
                if (roll(0.5) && !b.getWeaponsQueue().isEmpty()) {
                    Weapons w = getWeapon(b);
                    w.attack(b, a);
                } else {
                    attack(b, a, roll(a.getCritRite()));
                }
                boolean l2 = judge(b, a);
                if (l2) {
                    break;
                }
            } else {
                if (roll(0.5) && !b.getWeaponsQueue().isEmpty()) {
                    Weapons w = getWeapon(b);
                    w.attack(b, a);
                } else {
                    attack(b, a, roll(a.getCritRite()));
                }
                boolean l1 = judge(b, a);
                if (l1) {
                    break;
                }
                if (roll(0.5) && !a.getWeaponsQueue().isEmpty()) {
                    Weapons w = getWeapon(a);
                    w.attack(a, b);
                } else {
                    attack(a, b, roll(a.getCritRite()));
                }
                boolean l2 = judge(a, b);
                if (l2) {
                    break;
                }
            }
            System.out.println("=============================================");
        }
    }
}

