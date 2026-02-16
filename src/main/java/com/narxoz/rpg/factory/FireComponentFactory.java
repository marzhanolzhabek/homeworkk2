package com.narxoz.rpg.factory;

import com.narxoz.rpg.combat.Ability;
import com.narxoz.rpg.combat.Fireball;
import com.narxoz.rpg.combat.FlameShield;
import com.narxoz.rpg.loot.LootTable;
import com.narxoz.rpg.loot.FireLootTable;

import java.util.ArrayList;
import java.util.List;

public class FireComponentFactory implements EnemyComponentFactory {

    @Override
    public List<Ability> createAbilities() {
        List<Ability> abilities = new ArrayList<>();
        abilities.add(new Fireball());
        abilities.add(new FlameShield());
        return abilities;
    }

    @Override
    public LootTable createLootTable() {
        return new FireLootTable();
    }

    @Override
    public String createAIBehavior() {
        return "Aggressive";
    }
}