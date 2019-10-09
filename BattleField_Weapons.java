package BattleField;

import static BattleField.Action.*;

public abstract class Weapons {
    private double coefficient;
    private String mainAttribute;

    private String name;
    private double damage;

    public String getName() {
        return this.name;
    }

    public double getDamage() {
        return this.damage;
    }

    public String getMainAttribute() {
        return this.mainAttribute;
    }

    public double getCoefficient() {
        return this.coefficient;
    }

    public abstract void attack(Fighter fighter1, Fighter fighter2);

    private static class Trident extends Weapons {
        public Trident(double damage, double coefficient, String mainAttribute) {
            super.name = "三叉戟";
            super.coefficient = coefficient;
            super.damage = damage;
            super.mainAttribute = mainAttribute;
        }

        @Override
        public void attack(Fighter fighter1, Fighter fighter2) {
            if (roll(0.5)) {
                System.out.print("将" + this.getName() + "大力抛出，");
                double total = deal(crit(this.getDamage() + fighter1.get(this.getMainAttribute()) * this.getCoefficient()));
                boolean a = fighter2.setHp(fighter2.getHp() - total);
                if (a) {
                    System.out.println("对" + fighter2.getName() + "造成了" + total + "点伤害");
                }
            } else {
                System.out.print("向对手砍去");
                double total = deal(this.getDamage() + fighter1.get(this.getMainAttribute()) * this.getCoefficient());
                boolean a = fighter2.setHp(fighter2.getHp() - total);
                if (a) {
                    System.out.println("，对" + fighter2.getName() + "造成了" + total + "点伤害");
                }
            }
        }
    }

    public static class GoldBrick extends Weapons {
        public GoldBrick(double damage, double coefficient, String mainAttribute) {
            super.name = "金砖";
            super.damage = damage;
            super.coefficient = coefficient;
            super.mainAttribute = mainAttribute;
        }


        @Override
        public void attack(Fighter fighter1, Fighter fighter2) {
            System.out.print("向" + fighter2.getName() + "拍去，");
            boolean a = fighter2.setHp(deal(fighter2.getHp() / 2));
            if (a) {
                System.out.println("沙包大的金砖见过没，" + fighter2.getName() + "被吓丢了半条命");
            }
        }
    }

    public static class Spear extends Weapons {
        public Spear(double damage, double coefficient, String mainAttribute) {
            super.name = "红缨枪";
            super.coefficient = coefficient;
            super.mainAttribute = mainAttribute;
            super.damage = damage;
        }

        @Override
        public void attack(Fighter fighter1, Fighter fighter2) {
            double total = 0.0;
            if (roll(fighter1.getCritRite())) {
                System.out.print("一枪刺出，直取中路，");
                total = deal(crit(this.getDamage() + fighter1.get(this.getMainAttribute()) * this.getCoefficient()));
                boolean a = fighter2.setHp(fighter2.getHp() - total);
                if (a) {
                    boolean b = fighter1.setHp(fighter1.getHp() + total);
                    System.out.println("对" + fighter2.getName() + "造成了" + total + "点伤害，同时治疗自己等额HP");
                }
            } else {
                System.out.print("一记横扫千军，");
                total = deal(this.getDamage() + fighter1.get(this.getMainAttribute()) * this.getCoefficient());
                boolean a = fighter2.setHp(fighter2.getHp() - total);
                if (a) {
                    boolean b = fighter1.setHp(fighter1.getHp() + 0.5 * total);
                    System.out.println("对" + fighter2.getName() + "造成了" + total + "点伤害，并治疗自身" + (0.5 * total) + "点HP");
                }
            }
        }
    }

    public static class Darts extends Weapons {
        public Darts(double damage, double coefficient, String mainAttribute) {
            super.name = "要你命三千";
            super.coefficient = coefficient;
            super.damage = damage;
            super.mainAttribute = mainAttribute;
        }

        @Override
        public void attack(Fighter fighter1, Fighter fighter2) {
            for (int i = 1; i <= 3; i++) {
                if (roll(0.01)) {
                    boolean a = fighter2.setHp(0);
                    if (a) {
                        System.out.println("暗器的精髓在于飞花折叶也能杀人，" + fighter1.getName() + "秒杀了" + fighter2.getName());
                        break;
                    }
                } else {
                    System.out.print("飞刀直奔要害而去");
                    double total = deal(this.getDamage() + fighter1.get(this.getMainAttribute()) * this.getCoefficient());
                    boolean a = fighter2.setHp(fighter2.getHp() - total);
                    if (a) {
                        System.out.println("," + fighter2.getName() + "躲闪不及，受到" + total + "点伤害");
                    }
                    if (fighter2.getHp()<=0){break;}
                }
            }
        }
    }

    public static Weapons goldbrick = new GoldBrick(0, 0, "");
    public static Weapons trident = new Trident(40.0, 0.5, "strength");
    public static Weapons spear = new Spear(20.0, 0.8, "agile");
    public static Weapons darts = new Darts(10, 1.0, "speed");
}
