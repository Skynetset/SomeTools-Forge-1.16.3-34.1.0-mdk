package com.skynet.sometools.listregistered;

import com.skynet.sometools.common.Utils;
import com.skynet.sometools.listregistered.entity.FlyingSwordEntity;
import com.skynet.sometools.listregistered.entity.ObsidianAnimalEntity;
import net.minecraft.entity.EntityType;
import net.minecraftforge.registries.ObjectHolder;

/**
 * EntityTypeList
 *
 * @program: SomeTools-Forge-1.16.3-34.1.0-mdk
 * @author: 1260535819@qq.com
 * @create: 2021-01-30 16:53
 */

@ObjectHolder(Utils.MOD_ID)
public class RegisteredEntityTypeList {
    @ObjectHolder("flying_sword")
    public static EntityType<FlyingSwordEntity> FLYING_SWORD_ENTITY;
    @ObjectHolder("obsidian_animal")
    public static EntityType<ObsidianAnimalEntity> OBSIDIAN_ANIMAL_ENTITY;
}
