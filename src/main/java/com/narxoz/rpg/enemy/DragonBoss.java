package com.narxoz.rpg.enemy;

import com.narxoz.rpg.combat.Ability;
import com.narxoz.rpg.loot.LootTable;

import java.util.ArrayList;
import java.util.List;

public class DragonBoss extends Enemy {
    private int phaseCount;

    public DragonBoss(String name, int health, int damage, int defense, int speed, String element,
                      List<Ability> abilities, LootTable lootTable, int phaseCount) {
        super(name, health, damage, defense, speed, element, abilities, lootTable);
        this.phaseCount = phaseCount;
    }

    public int getPhaseCount() {
        return phaseCount;
    }

    @Override
    public Enemy clone() {
        List<Ability> clonedAbilities = new ArrayList<>();
        for (Ability a : abilities) {
            clonedAbilities.add(a.clone());
        }
        LootTable clonedLoot = lootTable.clone();
        return new DragonBoss(name, health, damage, defense, speed, element, clonedAbilities, clonedLoot, phaseCount);
    }

    @Override
    public void displayStats() {
        super.displayStats();
        System.out.println("Phases: " + phaseCount);
    }
}