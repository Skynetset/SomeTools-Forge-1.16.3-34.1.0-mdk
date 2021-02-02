package com.skynet.sometools.client.particle;

import com.skynet.sometools.client.input.KeyBoardInput;
import com.skynet.sometools.common.Utils;
import com.skynet.sometools.ibakedmodel.ObsidianWrenchBakedModel;
import com.skynet.sometools.listregistered.*;
import com.skynet.sometools.listregistered.entity.render.FlyingSwordRender;
import com.skynet.sometools.listregistered.entity.render.ObsidianAnimalRender;
import com.skynet.sometools.listregistered.item.blocks.blockentity.screen.MyChestContainerScreen;
import com.skynet.sometools.listregistered.item.blocks.blockentity.screen.ObsidianFirstContainerScreen;
import com.skynet.sometools.render.tileentityrenderer.ObsidianTER;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScreenManager;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.model.IBakedModel;
import net.minecraft.client.renderer.model.ModelResourceLocation;
import net.minecraft.item.ItemModelsProperties;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ModelBakeEvent;
import net.minecraftforge.client.event.ParticleFactoryRegisterEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

import java.util.Map;

/**
 * TODO
 *
 * @program: forge-1.16.3-34.1.0-mdk
 * @author: 1260535819@qq.com
 * @create: 2021-01-13 17:45
 */
@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
class ClientSideRegistryEvents {

    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent event) {

        event.enqueueWork(() -> {
            ScreenManager.registerFactory(RegisteredContainerTypeList.OBSIDIAN_FIRST_CONTAINER,
                    ObsidianFirstContainerScreen::new);
        });
        event.enqueueWork(() -> {
            ScreenManager.registerFactory(RegisteredContainerTypeList.MY_CHEST_CONTAINER,
                    MyChestContainerScreen::new);
        });

        // 注册键盘快捷键
        event.enqueueWork(() -> ClientRegistry.registerKeyBinding(KeyBoardInput.MESSAGE_KEY));

        // 魔法锭
        event.enqueueWork(() -> {
            ItemModelsProperties.registerProperty(RegisteredItemList.magic_ingot, new ResourceLocation(Utils.MOD_ID, "size"),
                    (itemStack, clientWorld, livingEntity) -> itemStack.getCount());
        });

        event.enqueueWork(() -> {
            ClientRegistry.bindTileEntityRenderer(RegisteredTileEntityTypeList.OBSIDIAN_TER_TILE_ENTITY, ObsidianTER::new);
        });

        event.enqueueWork(() -> {
            RenderTypeLookup.setRenderLayer(RegisteredBlockList.GLASS_JAR, RenderType.getTranslucent());

            RenderTypeLookup.setRenderLayer(RegisteredFluidList.obsidianFluid, RenderType.getTranslucent());
            RenderTypeLookup.setRenderLayer(RegisteredFluidList.obsidianFluidFlowing, RenderType.getTranslucent());
        });

        // 实体渲染
        RenderingRegistry.registerEntityRenderingHandler(RegisteredEntityTypeList.FLYING_SWORD_ENTITY,
                (EntityRendererManager manager) -> {
                    return new FlyingSwordRender(manager);
                });
        RenderingRegistry.registerEntityRenderingHandler(RegisteredEntityTypeList.OBSIDIAN_ANIMAL_ENTITY,
                (EntityRendererManager manager) -> {
                    return new ObsidianAnimalRender(manager);
                });



    }

    @SubscribeEvent
    public static void onParticleFactoryRegistration(ParticleFactoryRegisterEvent event) {
        Minecraft.getInstance().particles.registerFactory(RegisteredParticleList.OBSIDIAN_PARTICLE,
                ObsidianParticleFactory::new);
    }

    @SubscribeEvent
    public static void onModelBaked(ModelBakeEvent event) {
        Map<ResourceLocation, IBakedModel> modelRegistry = event.getModelRegistry();
        ModelResourceLocation location = new ModelResourceLocation(RegisteredItemList.obsidian_wrench.getRegistryName()
                , "inventory");
        IBakedModel existingModel = modelRegistry.get(location);
        if (existingModel == null) {
            throw new RuntimeException("Did not find Obsidian Hidden in registry");
        } else if (existingModel instanceof ObsidianWrenchBakedModel) {
            throw new RuntimeException("Tried to replaceObsidian Hidden twice");
        } else {
            ObsidianWrenchBakedModel obsidianWrenchBakedModel = new ObsidianWrenchBakedModel(existingModel);
            event.getModelRegistry().put(location, obsidianWrenchBakedModel);
        }
    }
}
