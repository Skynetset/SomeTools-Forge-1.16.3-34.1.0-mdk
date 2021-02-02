package com.skynet.sometools.listregistered.entity;

import net.minecraft.entity.AgeableEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

/**
 * TODO ObsidianAnimal
 *
 * @program: SomeTools-Forge-1.16.3-34.1.0-mdk
 * @author: 1260535819@qq.com
 * @create: 2021-01-16 17:57
 */

public class ObsidianAnimalEntity extends AnimalEntity {
    public ObsidianAnimalEntity(EntityType<? extends AnimalEntity> type, World worldIn) {
        super(type, worldIn);
        this.goalSelector.addGoal(0, new Goal() {
            /**
             * 在默认情况下Goal的对构造方法是没有什么要求的，
             * 但是在大多数时候，都应该在构造方法，将实体的实例传递进来并保存，这样会方便实现实体的AI。
             * shouldExecute是Goal最为重要的方法，这里就是调用实体AI的地方，
             * 这里的AI非常简单，就是给靠近实体的玩家一个饥饿效果，
             * 实现原理和之前实现的会播放僵尸吼叫声的方块原理是一样的，
             * @author : 1260535819@qq.com
             * @date : 2021/1/16 18:01
             * @return : boolean
             */
            @Override
            public boolean shouldExecute() {
                World world = getEntityWorld();
                if (!world.isRemote) {
                    BlockPos blockPos = getPosition();
                    PlayerEntity player = world.getClosestPlayer(blockPos.getX(), blockPos.getY(), blockPos.getZ(), 10, false);
                    if (player != null) {
                        player.addPotionEffect(new EffectInstance(Effects.HUNGER, 3 * 20, 3));
                    }
                }
                return true;
            }
        });
        this.getAttributeManager().createInstanceIfAbsent(Attributes.MAX_HEALTH);
    }

    /**
     * 创建后代
     * @param p_241840_1_
     * @param p_241840_2_
     * @return
     */
    @Override
    public AgeableEntity func_241840_a(ServerWorld p_241840_1_, AgeableEntity p_241840_2_) {
        return null;
    }
}
