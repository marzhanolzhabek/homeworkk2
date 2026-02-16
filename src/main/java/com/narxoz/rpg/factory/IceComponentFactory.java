package com.narxoz.rpg.factory;

import com.narxoz.rpg.combat.Ability;
import com.narxoz.rpg.combat.FrostBolt;
import com.narxoz.rpg.loot.IceLootTable;
import com.narxoz.rpg.loot.LootTable;

import java.util.ArrayList;
import java.util.List;

public class IceComponentFactory implements EnemyComponentFactory {

    @Override
    public List<Ability> createAbilities() {
        List<Ability> abilities = new ArrayList<>();
        abilities.add(new FrostBolt());
        return abilities;
    }

    @Override
    public LootTable createLootTable() {
        return new IceLootTable();
    }

    @Override
    public String createAIBehavior() {
        return "Defensive";
    }
}