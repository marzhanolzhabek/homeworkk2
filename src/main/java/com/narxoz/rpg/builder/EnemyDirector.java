package com.narxoz.rpg.builder;

import com.narxoz.rpg.enemy.Enemy;

import java.util.List;

public class EnemyDirector {
    private EnemyBuilder builder;

    public EnemyDirector(EnemyBuilder builder) {
        this.builder = builder;
    }

    
    public Enemy createMinion(com.narxoz.rpg.factory.EnemyComponentFactory factory) {
        return builder.setName("Minion")
                .setHealth(100)
                .setDamage(20)
                .setDefense(5)
                .setSpeed(10)
                .setElement("Neutral")
                .setComponents(factory)
                .build();
    }

    
    public Enemy createElite(com.narxoz.rpg.factory.EnemyComponentFactory factory) {
        return builder.setName("Elite")
                .setHealth(300)
                .setDamage(50)
                .setDefense(20)
                .setSpeed(15)
                .setElement("Elemental")
                .setComponents(factory)
                .build();
    }


    public Enemy createRaidBoss(com.narxoz.rpg.factory.EnemyComponentFactory factory) {
        if (builder instanceof BossEnemyBuilder) {
            BossEnemyBuilder bossBuilder = (BossEnemyBuilder) builder;

            return bossBuilder
                    .setName("Dragon Boss")
                    .setHealth(10000)
                    .setDamage(500)
                    .setDefense(200)
                    .setSpeed(20)
                    .setElement("Fire")
                    .setPhaseCount(3)
                    .setAiBehavior("Aggressive")
                    .setEnrageMode(true)
                    .setDifficultyMultiplier(2)
                    .setBossLevel(10)
                    .setIsRaidBoss(true)
                    .setArmorType("Scale")
                    .setResistances(List.of("Fire", "Ice"))
                    .setRegion("Volcano")
                    .setHasUltimate(true)
                    .setUltimateCooldown(30)
                    .setIsImmuneToStatus(false)
                    .setSpecialMechanic("Tail Swipe")
                    .setComponents(factory)
                    .build();
        }

        throw new IllegalStateException("Builder must be BossEnemyBuilder for raid boss!");
    }


    public Enemy createMiniBoss(com.narxoz.rpg.factory.EnemyComponentFactory factory) {
        if (builder instanceof BossEnemyBuilder) {
            BossEnemyBuilder bossBuilder = (BossEnemyBuilder) builder;

            return bossBuilder
                    .setName("Mini Boss")
                    .setHealth(2000)
                    .setDamage(150)
                    .setDefense(80)
                    .setSpeed(15)
                    .setElement("Ice")
                    .setPhaseCount(2)
                    .setAiBehavior("Defensive")
                    .setEnrageMode(false)
                    .setDifficultyMultiplier(1)
                    .setBossLevel(5)
                    .setIsRaidBoss(false)
                    .setArmorType("Plate")
                    .setResistances(List.of("Ice"))
                    .setRegion("Glacier")
                    .setHasUltimate(false)
                    .setUltimateCooldown(0)
                    .setIsImmuneToStatus(false)
                    .setSpecialMechanic("Frost Breath")
                    .setComponents(factory)
                    .build();
        }
        throw new IllegalStateException("Builder must be BossEnemyBuilder for mini boss!");
    }
}
