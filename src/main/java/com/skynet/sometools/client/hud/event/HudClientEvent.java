package com.skynet.sometools.client.hud.event;

import com.skynet.sometools.client.hud.ObsidianGUI;
import com.skynet.sometools.item.ItemRegister;
import net.minecraft.client.Minecraft;
import net.minecraft.util.Hand;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

/**
 * TODO HudClientEvent inGameGui
 *
 * @program: SomeTools-Forge-1.16.3-34.1.0-mdk
 * @author: 1260535819@qq.com
 * @create: 2021-01-17 15:53
 */

@Mod.EventBusSubscriber(value = Dist.CLIENT)
public class HudClientEvent {
    @SubscribeEvent
    public static void onOverlayRender(RenderGameOverlayEvent event) {
        if (event.getType() != RenderGameOverlayEvent.ElementType.ALL) {
            return;
        }
        if (Minecraft.getInstance().player == null || Minecraft.getInstance().player.getHeldItem(Hand.MAIN_HAND).getItem() != ItemRegister.OBSIDIAN_HUD_ITEM.get()) {
            return;
        }
        ObsidianGUI obsidianGUI = new ObsidianGUI(event.getMatrixStack());
        obsidianGUI.render();
    }
}

