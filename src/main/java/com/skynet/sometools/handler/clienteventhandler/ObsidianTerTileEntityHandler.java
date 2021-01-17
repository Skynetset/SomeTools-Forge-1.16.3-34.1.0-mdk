package com.skynet.sometools.handler.clienteventhandler;

import com.skynet.sometools.blocks.blockentity.TileEntityTypeRegister;
import com.skynet.sometools.render.tileentityrenderer.ObsidianTER;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

/**
 * TODO ClientEventHandler
 *
 * @program: forge-1.16.3-34.1.0-mdk
 * @author: 1260535819@qq.com
 * @create: 2021-01-15 11:42
 */

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ObsidianTerTileEntityHandler {
    @SubscribeEvent
    public static void onClientEvent(FMLClientSetupEvent event) {
        event.enqueueWork(() -> {
            ClientRegistry.bindTileEntityRenderer(TileEntityTypeRegister.OBSIDIAN_TER_TILE_ENTITY.get(), ObsidianTER::new);
        });
    }
}
