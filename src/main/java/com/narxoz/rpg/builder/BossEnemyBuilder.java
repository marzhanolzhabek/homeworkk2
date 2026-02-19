package com.narxoz.rpg.builder;

import com.narxoz.rpg.enemy.DragonBoss;
import com.narxoz.rpg.enemy.Enemy;
import com.narxoz.rpg.factory.EnemyComponentFactory;

import java.util.List;
import java.util.Map;

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
    private Map<Integer, Integer> bossPhases; 
    private String aiBehavior;
    private boolean enrageMode;
    private int difficultyMultiplier;
    private int bossLevel;
    private boolean isRaidBoss;
    private String armorType;
    private List<String> resistances;
    private String region;
    private boolean hasUltimate;
    private int ultimateCooldown;
    private boolean isImmuneToStatus;
    private String specialMechanic;

 
    public BossEnemyBuilder setPhaseCount(int phaseCount) { this.phaseCount = phaseCount; return this; }
    public BossEnemyBuilder setPhases(Map<Integer, Integer> bossPhases) { this.bossPhases = bossPhases; return this; }
    public BossEnemyBuilder setAiBehavior(String aiBehavior) { this.aiBehavior = aiBehavior; return this; }
    public BossEnemyBuilder setEnrageMode(boolean enrageMode) { this.enrageMode = enrageMode; return this; }
    public BossEnemyBuilder setDifficultyMultiplier(int multiplier) { this.difficultyMultiplier = multiplier; return this; }
    public BossEnemyBuilder setBossLevel(int level) { this.bossLevel = level; return this; }
    public BossEnemyBuilder setIsRaidBoss(boolean raid) { this.isRaidBoss = raid; return this; }
    public BossEnemyBuilder setArmorType(String armorType) { this.armorType = armorType; return this; }
    public BossEnemyBuilder setResistances(List<String> resistances) { this.resistances = resistances; return this; }
    public BossEnemyBuilder setRegion(String region) { this.region = region; return this; }
    public BossEnemyBuilder setHasUltimate(boolean hasUltimate) { this.hasUltimate = hasUltimate; return this; }
    public BossEnemyBuilder setUltimateCooldown(int cd) { this.ultimateCooldown = cd; return this; }
    public BossEnemyBuilder setIsImmuneToStatus(boolean immune) { this.isImmuneToStatus = immune; return this; }
    public BossEnemyBuilder setSpecialMechanic(String mech) { this.specialMechanic = mech; return this; }

    @Override
    public EnemyBuilder setName(String name) { this.name = name; return this; }
    @Override
    public EnemyBuilder setHealth(int health) { this.health = health; return this; }
    @Override
    public EnemyBuilder setDamage(int damage) { this.damage = damage; return this; }
    @Override
    public EnemyBuilder setDefense(int defense) { this.defense = defense; return this; }
    @Override
    public EnemyBuilder setSpeed(int speed) { this.speed = speed; return this; }
    @Override
    public EnemyBuilder setElement(String element) { this.element = element; return this; }

    @Override
    public EnemyBuilder setComponents(EnemyComponentFactory factory) {
        this.abilities = factory.createAbilities();
        this.lootTable = factory.createLootTable();
        this.aiBehavior = factory.createAIBehavior();
        return this;
    }

    @Override
    public Enemy build() {
        if (name == null || health <= 0)
            throw new IllegalStateException("Name and health are required!");

        DragonBoss boss = new DragonBoss(name, health, damage, defense, speed, element, abilities, lootTable, phaseCount);
        boss.setBossPhases(bossPhases); 
        return boss;
    }
}
