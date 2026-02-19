package com.narxoz.rpg.enemy;

import com.narxoz.rpg.combat.Ability;
import com.narxoz.rpg.loot.LootTable;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DragonBoss extends Enemy {
    private int phaseCount;
    private Map<Integer, Integer> bossPhases;

    public DragonBoss(String name, int health, int damage, int defense, int speed, String element,
                      List<Ability> abilities, LootTable lootTable, int phaseCount) {
        super(name, health, damage, defense, speed, element, abilities, lootTable);
        this.phaseCount = phaseCount;
    }


    public DragonBoss(String name, int health, int damage, int defense, int speed, String element,
                      List<Ability> abilities, LootTable lootTable, int phaseCount,
                      String aiBehavior, boolean enrageMode, int difficultyMultiplier,
                      int bossLevel, boolean isRaidBoss, String armorType, List<String> resistances,
                      String region, boolean hasUltimate, int ultimateCooldown,
                      boolean isImmuneToStatus, String specialMechanic) {
        super(name, health, damage, defense, speed, element, abilities, lootTable);
        this.phaseCount = phaseCount;
      
        this.bossPhases = null; 
  
    }

    public void setBossPhases(Map<Integer, Integer> bossPhases) {
        this.bossPhases = bossPhases;
    }

    public Map<Integer, Integer> getBossPhases() {
        return bossPhases;
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

        DragonBoss clone = new DragonBoss(name, health, damage, defense, speed, element, clonedAbilities, clonedLoot, phaseCount);
        clone.setBossPhases(bossPhases); 
        return clone;
    }

    @Override
    public void displayStats() {
        super.displayStats();
        System.out.println("Phases: " + phaseCount);
        if (bossPhases != null) {
            System.out.println("Phase thresholds:");
            bossPhases.forEach((phase, hp) -> System.out.println("Phase " + phase + ": " + hp + " HP"));
        }
    }
}
