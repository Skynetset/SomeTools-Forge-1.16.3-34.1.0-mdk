package com.skynet.sometools.item.blocks.blockentity.event;

import com.skynet.sometools.item.blocks.BlockRegister;
import com.skynet.sometools.item.fluid.FluidRegister;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

/**
 * TODO RenderTypeRegistry
 *
 * @program: forge-1.16.3-34.1.0-mdk
 * @author: 1260535819@qq.com
 * @create: 2021-01-13 22:47
 */

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class RenderTypeRegistry {
    @SubscribeEvent
    public static void onRenderTypeSetup(FMLClientSetupEvent event) {
        event.enqueueWork(() -> {
            RenderTypeLookup.setRenderLayer(BlockRegister.GLASS_JAR.get(), RenderType.getTranslucent());

            RenderTypeLookup.setRenderLayer(FluidRegister.obsidianFluid.get(), RenderType.getTranslucent());
            RenderTypeLookup.setRenderLayer(FluidRegister.obsidianFluidFlowing.get(), RenderType.getTranslucent());
        });
    }
}

