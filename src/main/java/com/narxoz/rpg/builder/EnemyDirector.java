package com.narxoz.rpg.builder;

import com.narxoz.rpg.enemy.Enemy;
import com.narxoz.rpg.factory.EnemyComponentFactory;

public class EnemyDirector {
    private EnemyBuilder builder;

    public EnemyDirector(EnemyBuilder builder) {
        this.builder = builder;
    }

    public Enemy createMinion(EnemyComponentFactory factory) {
        return builder.setName("Minion")
                .setHealth(100)
                .setDamage(20)
                .setDefense(5)
                .setSpeed(10)
                .setElement("Neutral")
                .setComponents(factory)
                .build();
    }

    public Enemy createElite(EnemyComponentFactory factory) {
        return builder.setName("Elite")
                .setHealth(300)
                .setDamage(50)
                .setDefense(20)
                .setSpeed(15)
                .setElement("Elemental")
                .setComponents(factory)
                .build();
    }

    public Enemy createRaidBoss(EnemyComponentFactory factory) {
        if (builder instanceof BossEnemyBuilder) {
            return ((BossEnemyBuilder) builder)
                    .setName("Dragon Boss")
                    .setHealth(10000)
                    .setDamage(500)
                    .setDefense(200)
                    .setSpeed(20)
                    .setElement("Fire")
                    .setComponents(factory)
                    .build();
        }
        throw new IllegalStateException("Builder must be BossEnemyBuilder for raid boss!");
    }
}