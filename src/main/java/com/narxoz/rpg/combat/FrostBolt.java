package com.narxoz.rpg.combat;

public class FrostBolt implements Ability {
    @Override
    public String getName() {
        return "Frost Bolt";
    }

    @Override
    public int getDamage() {
        return 40;
    }

    @Override
    public String getDescription() {
        return "Launches an icy bolt to slow the enemy.";
    }

    @Override
    public Ability clone() {
        try {
            return (Ability) super.clone();
        } catch (CloneNotSupportedException e) {
            return new FrostBolt();
        }
    }
}