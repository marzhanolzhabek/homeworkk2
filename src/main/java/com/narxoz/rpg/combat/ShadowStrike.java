package com.narxoz.rpg.combat;

public class ShadowStrike implements Ability {
    @Override
    public String getName() {
        return "Shadow Strike";
    }

    @Override
    public int getDamage() {
        return 45;
    }

    @Override
    public String getDescription() {
        return "Strikes from the shadows, hard to predict.";
    }

    @Override
    public Ability clone() {
        try {
            return (Ability) super.clone();
        } catch (CloneNotSupportedException e) {
            return new ShadowStrike();
        }
    }
}