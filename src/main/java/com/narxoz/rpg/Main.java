package com.narxoz.rpg;

import com.narxoz.rpg.builder.BossEnemyBuilder;
import com.narxoz.rpg.builder.BasicEnemyBuilder;
import com.narxoz.rpg.builder.EnemyDirector;
import com.narxoz.rpg.enemy.Enemy;
import com.narxoz.rpg.factory.FireComponentFactory;
import com.narxoz.rpg.factory.IceComponentFactory;
import com.narxoz.rpg.prototype.EnemyRegistry;

public class Main {
    public static void main(String[] args) {
        System.out.println("RPG Enemy System Demo");

        // === Abstract Factory + Builder Demo ===
        BasicEnemyBuilder basicBuilder = new BasicEnemyBuilder();
        EnemyDirector director = new EnemyDirector(basicBuilder);

        FireComponentFactory fireFactory = new FireComponentFactory();
        Enemy goblinMinion = director.createMinion(fireFactory);
        goblinMinion.displayStats();
        goblinMinion.displayAbilities();

        System.out.println("\n--- Boss Enemy ---");
        BossEnemyBuilder bossBuilder = new BossEnemyBuilder();
        EnemyDirector bossDirector = new EnemyDirector(bossBuilder);
        Enemy dragonBoss = bossDirector.createRaidBoss(fireFactory);
        dragonBoss.displayStats();
        dragonBoss.displayAbilities();

        // === Prototype Demo ===
        EnemyRegistry registry = new EnemyRegistry();
        registry.registerTemplate("FireDragon", dragonBoss);
        Enemy clonedBoss = registry.createFromTemplate("FireDragon");
        System.out.println("\n--- Cloned Boss ---");
        clonedBoss.displayStats();

        System.out.println("\nDemo Complete");
    }
}