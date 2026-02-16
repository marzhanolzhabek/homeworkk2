package com.narxoz.rpg.combat;

public class Fireball implements Ability {
    @Override
    public String getName() {
        return "Fireball";
    }

    @Override
    public int getDamage() {
        return 50;
    }

    @Override
    public String getDescription() {
        return "Throws a ball of fire at the enemy.";
    }

    @Override
    public Ability clone() {
        try {
            return (Ability) super.clone();
        } catch (CloneNotSupportedException e) {
            return new Fireball();
        }
    }
}