package com.skynet.sometools.handler.modbuseventhandler;

import com.skynet.sometools.item.blocks.BlockRegister;
import com.skynet.sometools.ibakedmodel.ObsidianHiddenBlockModel;
import net.minecraft.block.BlockState;
import net.minecraft.client.renderer.BlockModelShapes;
import net.minecraft.client.renderer.model.IBakedModel;
import net.minecraft.client.renderer.model.ModelResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ModelBakeEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

/**
 * TODO ModBusEventHandler
 *
 * @program: forge-1.16.3-34.1.0-mdk
 * @author: 1260535819@qq.com
 * @create: 2021-01-14 21:53
 */

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD,value = Dist.CLIENT)
public class ObsidianHiddenBlockHandler {
    @SubscribeEvent
    public static void onModelBaked(ModelBakeEvent event) {
        for (BlockState blockstate : BlockRegister.OBSIDIAN_HIDDEN_BLOCK.get().getStateContainer().getValidStates()) {
            ModelResourceLocation modelResourceLocation = BlockModelShapes.getModelLocation(blockstate);
            IBakedModel existingModel = event.getModelRegistry().get(modelResourceLocation);
            if (existingModel == null) {
                throw new RuntimeException("Did not find Obsidian Hidden in registry");
            } else if (existingModel instanceof ObsidianHiddenBlockModel) {
                throw new RuntimeException("Tried to replaceObsidian Hidden twice");
            } else {
                ObsidianHiddenBlockModel obsidianHiddenBlockModel = new ObsidianHiddenBlockModel(existingModel);
                event.getModelRegistry().put(modelResourceLocation, obsidianHiddenBlockModel);
            }
        }
    }
}
