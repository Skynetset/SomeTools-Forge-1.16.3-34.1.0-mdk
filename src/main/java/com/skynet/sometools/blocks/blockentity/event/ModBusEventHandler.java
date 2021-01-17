package com.skynet.sometools.blocks.blockentity.event;

import com.skynet.sometools.blocks.blockentity.screen.MyChestContainerScreen;
import com.skynet.sometools.blocks.blockentity.screen.ObsidianFirstContainerScreen;
import net.minecraft.client.gui.ScreenManager;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

/**
 * TODO ModBusEventHandler
 *
 * @program: SomeTools-Forge-1.16.3-34.1.0-mdk
 * @author: 1260535819@qq.com
 * @create: 2021-01-16 23:40
 */

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModBusEventHandler {
    @SubscribeEvent
    public static void onClientSetupEvent(FMLClientSetupEvent event) {
        event.enqueueWork(() -> {
            ScreenManager.registerFactory(ContainerTypeRegister.OBSIDIAN_FIRST_CONTAINER.get(),
                    ObsidianFirstContainerScreen::new);
        });
        event.enqueueWork(() -> {
            ScreenManager.registerFactory(ContainerTypeRegister.MY_CHEST_CONTAINER.get(),
                    MyChestContainerScreen::new);
        });
    }
}

