package com.skynet.sometools.entity.render.FMLClientSetupEvent;

import com.skynet.sometools.entity.EntityTypeRegister;
import com.skynet.sometools.entity.render.FlyingSwordRender;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

/**
 * TODO flyingSwordEntityHandler
 *
 * @program: SomeTools-Forge-1.16.3-34.1.0-mdk
 * @author: 1260535819@qq.com
 * @create: 2021-01-16 17:46
 */
@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class FlyingSwordEntityHandler {
    @SubscribeEvent
    public static void onClientSetUpEvent(FMLClientSetupEvent event) {
        RenderingRegistry.registerEntityRenderingHandler(EntityTypeRegister.FLYING_SWORD_ENTITY.get(),
                (EntityRendererManager manager) -> {
            return new FlyingSwordRender(manager);
        });
    }
}
