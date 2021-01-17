package com.skynet.sometools;

import com.skynet.sometools.blocks.BlockRegister;
import com.skynet.sometools.blocks.blockentity.TileEntityTypeRegister;
import com.skynet.sometools.blocks.blockentity.event.ContainerTypeRegister;
import com.skynet.sometools.common.Utils;
import com.skynet.sometools.config.Config;
import com.skynet.sometools.entity.EntityTypeRegister;
import com.skynet.sometools.fluid.FluidRegister;
import com.skynet.sometools.item.ItemRegister;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

/**
 * TODO SomeTools
 *
 * @program: forge-1.16.3-34.1.0-mdk
 * @author: 1260535819@qq.com
 * @create: 2021-01-13 09:57
 */
@Mod(Utils.MOD_ID)
public class SomeTools {
    public SomeTools() {
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Config.COMMON_CONFIG);


        BlockRegister.BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
        ItemRegister.ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
        FluidRegister.FLUIDS.register(FMLJavaModLoadingContext.get().getModEventBus());
        TileEntityTypeRegister.TILE_ENTITIES.register(FMLJavaModLoadingContext.get().getModEventBus());
        EntityTypeRegister.ENTITY_TYPES.register(FMLJavaModLoadingContext.get().getModEventBus());
        ContainerTypeRegister.CONTAINERS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }
}
