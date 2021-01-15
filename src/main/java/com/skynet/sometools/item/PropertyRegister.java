package com.skynet.sometools.item;

import com.skynet.sometools.common.Utils;
import com.skynet.sometools.item.ItemRegister;
import net.minecraft.item.ItemModelsProperties;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

/**
 * TODO
 *
 * @program: forge-1.16.3-34.1.0-mdk
 * @author: 1260535819@qq.com
 * @create: 2021-01-13 17:45
 */
@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class PropertyRegister {
    @SubscribeEvent
    public static void propertyOverrideRegistry(FMLClientSetupEvent event) {
        event.enqueueWork(() -> {
            ItemModelsProperties.registerProperty(ItemRegister.MAGIC_INGOT.get(), new ResourceLocation(Utils.MOD_ID, "size"),
                    (itemStack, clientWorld, livingEntity) -> itemStack.getCount());
        });
    }
}
