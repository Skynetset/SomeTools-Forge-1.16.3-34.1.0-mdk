package com.skynet.sometools.client.particle;

import com.skynet.sometools.client.input.KeyBoardInput;
import com.skynet.sometools.common.Utils;
import com.skynet.sometools.ibakedmodel.ObsidianHiddenBlockModel;
import com.skynet.sometools.ibakedmodel.ObsidianWrenchBakedModel;
import com.skynet.sometools.listregistered.*;
import com.skynet.sometools.listregistered.entity.render.FlyingSwordRender;
import com.skynet.sometools.listregistered.entity.render.ObsidianAnimalRender;
import com.skynet.sometools.listregistered.item.blocks.blockentity.screen.MyChestContainerScreen;
import com.skynet.sometools.listregistered.item.blocks.blockentity.screen.ObsidianFirstContainerScreen;
import com.skynet.sometools.listregistered.fluid.FluidRegister;
import com.skynet.sometools.render.tileentityrenderer.ObsidianTER;
import net.minecraft.block.BlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScreenManager;
import net.minecraft.client.renderer.BlockModelShapes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
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
 * ClientSideRegistryEvents
 *
 * @program: forge-1.16.3-34.1.0-mdk
 * @author: 1260535819@qq.com
 * @create: 2021-01-13 17:45
 */
@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
class ClientSideRegistryEvents {

    private ClientSideRegistryEvents() {
    }

    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent event) {

        event.enqueueWork(() -> ScreenManager.registerFactory(RegisteredContainerTypeList.OBSIDIAN_FIRST_CONTAINER,
                ObsidianFirstContainerScreen::new));
        event.enqueueWork(() -> ScreenManager.registerFactory(RegisteredContainerTypeList.MY_CHEST_CONTAINER,
                MyChestContainerScreen::new));

        // 注册键盘快捷键
        event.enqueueWork(() -> ClientRegistry.registerKeyBinding(KeyBoardInput.MESSAGE_KEY));

        // 魔法锭
        event.enqueueWork(() -> ItemModelsProperties.registerProperty(RegisteredItemList.magic_ingot, new ResourceLocation(Utils.MOD_ID,
                        "size"),
                (itemStack, clientWorld, livingEntity) -> itemStack.getCount()));

        event.enqueueWork(() -> ClientRegistry.bindTileEntityRenderer(RegisteredTileEntityTypeList.obsidian_ter_tile_block,
                ObsidianTER::new));

        event.enqueueWork(() -> {
            RenderTypeLookup.setRenderLayer(RegisteredBlockList.glass_jar, RenderType.getTranslucent());

            RenderTypeLookup.setRenderLayer(FluidRegister.obsidianFluid.get(), RenderType.getTranslucent());
            RenderTypeLookup.setRenderLayer(FluidRegister.obsidianFluidFlowing.get(), RenderType.getTranslucent());
        });

        // 实体渲染
        RenderingRegistry.registerEntityRenderingHandler(RegisteredEntityTypeList.FLYING_SWORD_ENTITY,
                FlyingSwordRender::new);
        RenderingRegistry.registerEntityRenderingHandler(RegisteredEntityTypeList.OBSIDIAN_ANIMAL_ENTITY,
                ObsidianAnimalRender::new);


    }

    @SubscribeEvent
    public static void onParticleFactoryRegistration(ParticleFactoryRegisterEvent event) {
        Minecraft.getInstance().particles.registerFactory(RegisteredParticleList.OBSIDIAN_PARTICLE,
                ObsidianParticleFactory::new);
    }

    @SubscribeEvent
    public static void onObsidianWrenchModelBaked(ModelBakeEvent event) {
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

    @SubscribeEvent
    public static void onObsidianHiddenBlockModelBaked(ModelBakeEvent event) {
        for (BlockState blockstate : RegisteredBlockList.obsidian_hidden_block.getStateContainer().getValidStates()) {
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
