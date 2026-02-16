package com.narxoz.rpg.loot;

import java.util.ArrayList;
import java.util.List;

public class FireLootTable implements LootTable {
    @Override
    public List<String> getItems() {
        List<String> items = new ArrayList<>();
        items.add("Flaming Sword");
        items.add("Fire Gem");
        return items;
    }

    @Override
    public int getGoldDrop() {
        return 100;
    }

    @Override
    public int getExperienceDrop() {
        return 50;
    }

    @Override
    public LootTable clone() {
        try {
            return (LootTable) super.clone();
        } catch (CloneNotSupportedException e) {
            return new FireLootTable();
        }
    }
}