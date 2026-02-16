package com.narxoz.rpg.loot;

import java.util.ArrayList;
import java.util.List;

public class IceLootTable implements LootTable {
    @Override
    public List<String> getItems() {
        List<String> items = new ArrayList<>();
        items.add("Frost Blade");
        items.add("Ice Crystal");
        return items;
    }

    @Override
    public int getGoldDrop() {
        return 80;
    }

    @Override
    public int getExperienceDrop() {
        return 40;
    }

    @Override
    public LootTable clone() {
        try {
            return (LootTable) super.clone();
        } catch (CloneNotSupportedException e) {
            return new IceLootTable();
        }
    }
}