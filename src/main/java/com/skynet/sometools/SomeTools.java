package com.skynet.sometools;

import com.skynet.sometools.common.Utils;
import com.skynet.sometools.register.SomeRegister;
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
        SomeRegister.ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
        SomeRegister.BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
        SomeRegister.TILE_ENTITIES.register(FMLJavaModLoadingContext.get().getModEventBus());
    }
}
