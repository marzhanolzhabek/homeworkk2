package com.narxoz.rpg.enemy;

import com.narxoz.rpg.combat.Ability;
import com.narxoz.rpg.loot.LootTable;

import java.util.ArrayList;
import java.util.List;

public class Goblin extends Enemy {

    public Goblin(String name, int health, int damage, int defense, int speed, String element,
                  List<Ability> abilities, LootTable lootTable) {
        super(name, health, damage, defense, speed, element, abilities, lootTable);
    }

    @Override
    public Enemy clone() {
        List<Ability> clonedAbilities = new ArrayList<>();
        for (Ability a : abilities) {
            clonedAbilities.add(a.clone());
        }
        LootTable clonedLoot = lootTable.clone();
        return new Goblin(name, health, damage, defense, speed, element, clonedAbilities, clonedLoot);
    }
}