package com.skynet.sometools;

import com.skynet.sometools.common.Utils;
import com.skynet.sometools.config.Config;
import com.skynet.sometools.listregistered.item.fluid.FluidRegister;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.Logger;

/**
 * SomeTools 注册总线
 *
 * @program: forge-1.16.3-34.1.0-mdk
 * @author: 1260535819@qq.com
 * @create: 2021-01-13 09:57
 */

@Mod(Utils.MOD_ID)
public class SomeTools {
    public static final Logger LOGGER = Utils.LOGGER;

    public static SomeTools instance;

    public SomeTools() {
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Config.COMMON_CONFIG);
        instance = this;

        // 流体注册
        FluidRegister.FLUIDS.register(FMLJavaModLoadingContext.get().getModEventBus());
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::clientSetup);
    }

    private void setup(final FMLCommonSetupEvent event) {
    }

    private void clientSetup(final FMLClientSetupEvent event) {
    }

    private void serverStartingSetup(final FMLServerStartingEvent event) {
    }

    // public SomeTools() {
    //     // 配置文件获取
    //     ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Config.COMMON_CONFIG);
    //
    //     // 方块注册
    //     BlockRegister.BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
    //     // 物品注册
    //     ItemRegister.ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
    //     // 流体注册
    //     FluidRegister.FLUIDS.register(FMLJavaModLoadingContext.get().getModEventBus());
    //     // 方块实体注册
    //     TileEntityTypeRegister.TILE_ENTITIES.register(FMLJavaModLoadingContext.get().getModEventBus());
    //     // 实体注册
    //     EntityTypeRegister.ENTITY_TYPES.register(FMLJavaModLoadingContext.get().getModEventBus());
    //     // 容器注册
    //     ContainerTypeRegister.CONTAINERS.register(FMLJavaModLoadingContext.get().getModEventBus());
    //     // 粒子效果注册
    //     ParticleRegister.PARTICLE_TYPES.register(FMLJavaModLoadingContext.get().getModEventBus());
    //     // 声音注册
    //     SoundEventRegister.SOUNDS.register(FMLJavaModLoadingContext.get().getModEventBus());
    // }
}
