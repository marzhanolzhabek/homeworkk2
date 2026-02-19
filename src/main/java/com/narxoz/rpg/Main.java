package com.narxoz.rpg;

import com.narxoz.rpg.builder.BossEnemyBuilder;
import com.narxoz.rpg.builder.BasicEnemyBuilder;
import com.narxoz.rpg.builder.EnemyDirector;
import com.narxoz.rpg.enemy.Enemy;
import com.narxoz.rpg.factory.FireComponentFactory;
import com.narxoz.rpg.prototype.EnemyRegistry;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        System.out.println("RPG Enemy System Demo");

       
        BasicEnemyBuilder basicBuilder = new BasicEnemyBuilder();
        EnemyDirector director = new EnemyDirector(basicBuilder);

        FireComponentFactory fireFactory = new FireComponentFactory();
        Enemy goblinMinion = director.createMinion(fireFactory);
        System.out.println("\n--- Goblin Minion ---");
        goblinMinion.displayStats();
        goblinMinion.displayAbilities();


        System.out.println("\n--- Boss Enemy ---");
        BossEnemyBuilder bossBuilder = new BossEnemyBuilder();
        EnemyDirector bossDirector = new EnemyDirector(bossBuilder);


        Map<Integer, Integer> bossPhases = new HashMap<>();
        bossPhases.put(1, 8000);
        bossPhases.put(2, 5000);
        bossPhases.put(3, 2000);

        ((BossEnemyBuilder) bossBuilder)
                .setPhaseCount(3)
                .setPhases(bossPhases)
                .setAiBehavior("Aggressive")
                .setEnrageMode(true)
                .setDifficultyMultiplier(2)
                .setRegion("Volcanic Mountains")
                .setBossLevel(10)
                .setIsRaidBoss(true)
                .setArmorType("Dragon Scales")
                .setResistances(Arrays.asList("Fire", "Poison"))
                .setHasUltimate(true)
                .setUltimateCooldown(30)
                .setIsImmuneToStatus(true)
                .setSpecialMechanic("Lava Eruption");

        Enemy dragonBoss = bossDirector.createRaidBoss(fireFactory);
        dragonBoss.displayStats();
        dragonBoss.displayAbilities();

        System.out.println("\n--- Prototype / Cloning Demo ---");
        EnemyRegistry registry = new EnemyRegistry();
        registry.registerTemplate("FireDragon", dragonBoss);

        Enemy clonedBoss = registry.createFromTemplate("FireDragon");

        System.out.println("\n--- Cloned Boss ---");
        clonedBoss.displayStats();
        clonedBoss.displayAbilities();


        System.out.println("\n--- Deep Copy Verification ---");
        clonedBoss.displayLoot();
        System.out.println("Original and cloned are separate objects: " +
                (dragonBoss != clonedBoss));

        System.out.println("\nDemo Complete");
    }
}
