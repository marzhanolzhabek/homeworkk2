package com.narxoz.rpg.loot;

import java.util.ArrayList;
import java.util.List;

public class ShadowLootTable implements LootTable {
    @Override
    public List<String> getItems() {
        List<String> items = new ArrayList<>();
        items.add("Shadow Dagger");
        items.add("Cloak of Darkness");
        return items;
    }

    @Override
    public int getGoldDrop() {
        return 90;
    }

    @Override
    public int getExperienceDrop() {
        return 45;
    }

    @Override
    public LootTable clone() {
        try {
            return (LootTable) super.clone();
        } catch (CloneNotSupportedException e) {
            return new ShadowLootTable();
        }
    }
}