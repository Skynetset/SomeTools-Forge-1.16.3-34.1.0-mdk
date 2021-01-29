package com.skynet.sometools;

import com.skynet.sometools.item.blocks.BlockRegister;
import com.skynet.sometools.item.blocks.blockentity.TileEntityTypeRegister;
import com.skynet.sometools.item.blocks.blockentity.event.ContainerTypeRegister;
import com.skynet.sometools.common.Utils;
import com.skynet.sometools.config.Config;
import com.skynet.sometools.entity.EntityTypeRegister;
import com.skynet.sometools.item.fluid.FluidRegister;
import com.skynet.sometools.item.tab.ItemRegister;
import com.skynet.sometools.particle.ParticleRegister;
import com.skynet.sometools.sound.SoundEventRegister;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

/**
 * SomeTools 注册总线
 *
 * @program: forge-1.16.3-34.1.0-mdk
 * @author: 1260535819@qq.com
 * @create: 2021-01-13 09:57
 */

@Mod(Utils.MOD_ID)
public class SomeTools {
    public SomeTools() {
        // 配置文件获取
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Config.COMMON_CONFIG);

        // 方块注册
        BlockRegister.BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
        // 物品注册
        ItemRegister.ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
        // 流体注册
        FluidRegister.FLUIDS.register(FMLJavaModLoadingContext.get().getModEventBus());
        // 方块实体注册
        TileEntityTypeRegister.TILE_ENTITIES.register(FMLJavaModLoadingContext.get().getModEventBus());
        // 实体注册
        EntityTypeRegister.ENTITY_TYPES.register(FMLJavaModLoadingContext.get().getModEventBus());
        // 容器注册
        ContainerTypeRegister.CONTAINERS.register(FMLJavaModLoadingContext.get().getModEventBus());
        // 粒子效果注册
        ParticleRegister.PARTICLE_TYPES.register(FMLJavaModLoadingContext.get().getModEventBus());
        // 声音注册
        SoundEventRegister.SOUNDS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }
}
