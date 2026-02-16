package com.narxoz.rpg.combat;

public class FlameShield implements Ability {
    @Override
    public String getName() {
        return "Flame Shield";
    }

    @Override
    public int getDamage() {
        return 0; // Defensive ability
    }

    @Override
    public String getDescription() {
        return "Reduces incoming damage with flames.";
    }

    @Override
    public Ability clone() {
        try {
            return (Ability) super.clone();
        } catch (CloneNotSupportedException e) {
            return new FlameShield();
        }
    }
}