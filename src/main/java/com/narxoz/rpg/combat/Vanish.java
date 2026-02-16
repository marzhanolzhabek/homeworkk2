package com.narxoz.rpg.combat;

public class Vanish implements Ability {
    @Override
    public String getName() {
        return "Vanish";
    }

    @Override
    public int getDamage() {
        return 0; // Utility ability
    }

    @Override
    public String getDescription() {
        return "Temporarily disappears from the battlefield.";
    }

    @Override
    public Ability clone() {
        try {
            return (Ability) super.clone();
        } catch (CloneNotSupportedException e) {
            return new Vanish();
        }
    }
}