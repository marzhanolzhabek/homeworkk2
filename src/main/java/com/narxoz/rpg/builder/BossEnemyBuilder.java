package com.narxoz.rpg.builder;

import com.narxoz.rpg.enemy.DragonBoss;
import com.narxoz.rpg.enemy.Enemy;
import com.narxoz.rpg.factory.EnemyComponentFactory;

import java.util.List;

public class BossEnemyBuilder implements EnemyBuilder {
    private String name;
    private int health;
    private int damage;
    private int defense;
    private int speed;
    private String element;
    private List<com.narxoz.rpg.combat.Ability> abilities;
    private com.narxoz.rpg.loot.LootTable lootTable;
    private int phaseCount;

    public BossEnemyBuilder setPhaseCount(int phaseCount) {
        this.phaseCount = phaseCount;
        return this;
    }

    @Override
    public EnemyBuilder setName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public EnemyBuilder setHealth(int health) {
        this.health = health;
        return this;
    }

    @Override
    public EnemyBuilder setDamage(int damage) {
        this.damage = damage;
        return this;
    }

    @Override
    public EnemyBuilder setDefense(int defense) {
        this.defense = defense;
        return this;
    }

    @Override
    public EnemyBuilder setSpeed(int speed) {
        this.speed = speed;
        return this;
    }

    @Override
    public EnemyBuilder setElement(String element) {
        this.element = element;
        return this;
    }

    @Override
    public EnemyBuilder setComponents(EnemyComponentFactory factory) {
        this.abilities = factory.createAbilities();
        this.lootTable = factory.createLootTable();
        return this;
    }

    @Override
    public Enemy build() {
        if (name == null || health <= 0) throw new IllegalStateException("Name and health are required!");
        return new DragonBoss(name, health, damage, defense, speed, element, abilities, lootTable, phaseCount);
    }
}