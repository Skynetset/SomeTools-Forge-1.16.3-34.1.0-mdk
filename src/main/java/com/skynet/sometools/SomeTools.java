package com.skynet.sometools;

import com.skynet.sometools.common.Utils;
import com.skynet.sometools.register.BlockRegister;
import com.skynet.sometools.register.ItemRegister;
import com.skynet.sometools.register.TileEntityTypeRegister;
import net.minecraftforge.fml.common.Mod;
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
        ItemRegister.ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
        BlockRegister.BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
        TileEntityTypeRegister.TILE_ENTITIES.register(FMLJavaModLoadingContext.get().getModEventBus());
    }
}
