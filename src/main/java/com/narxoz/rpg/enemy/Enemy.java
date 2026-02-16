package com.narxoz.rpg.enemy;

import com.narxoz.rpg.combat.Ability;
import com.narxoz.rpg.loot.LootTable;

import java.util.List;

public abstract class Enemy {
    protected String name;
    protected int health;
    protected int damage;
    protected int defense;
    protected int speed;
    protected String element;
    protected List<Ability> abilities;
    protected LootTable lootTable;

    public Enemy(String name, int health, int damage, int defense, int speed, String element,
                 List<Ability> abilities, LootTable lootTable) {
        this.name = name;
        this.health = health;
        this.damage = damage;
        this.defense = defense;
        this.speed = speed;
        this.element = element;
        this.abilities = abilities;
        this.lootTable = lootTable;
    }

    public abstract Enemy clone();

    public void displayStats() {
        System.out.println("Enemy: " + name);
        System.out.println("Health: " + health);
        System.out.println("Damage: " + damage);
        System.out.println("Defense: " + defense);
        System.out.println("Speed: " + speed);
        System.out.println("Element: " + element);
    }

    public void displayAbilities() {
        System.out.println("Abilities:");
        for (Ability a : abilities) {
            System.out.println("- " + a.getName() + ": " + a.getDescription());
        }
    }

    public void displayLoot() {
        System.out.println("Loot:");
        System.out.println("- Gold: " + lootTable.getGoldDrop());
        System.out.println("- Experience: " + lootTable.getExperienceDrop());
        System.out.println("- Items: " + lootTable.getItems());
    }
}