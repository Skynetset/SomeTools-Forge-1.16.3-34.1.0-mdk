package com.skynet.sometools.ibakedmodel;

import com.skynet.sometools.item.blocks.BlockRegister;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BlockRendererDispatcher;
import net.minecraft.client.renderer.model.BakedQuad;
import net.minecraft.client.renderer.model.IBakedModel;
import net.minecraft.client.renderer.model.ItemCameraTransforms;
import net.minecraft.client.renderer.model.ItemOverrideList;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockDisplayReader;
import net.minecraftforge.client.model.data.IModelData;
import net.minecraftforge.client.model.data.ModelDataMap;
import net.minecraftforge.client.model.data.ModelProperty;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.List;
import java.util.Random;

/**
 * TODO ObsidianHiddenBlockModel
 *
 * @program: forge-1.16.3-34.1.0-mdk
 * @author: 1260535819@qq.com
 * @create: 2021-01-14 21:35
 */

public class ObsidianHiddenBlockModel implements IBakedModel {
    IBakedModel defaultModel;
    public static ModelProperty<BlockState> COPIED_BLOCK = new ModelProperty<>();

    public ObsidianHiddenBlockModel(IBakedModel existingModel) {
        defaultModel = existingModel;
    }

    @Nonnull
    @Override
    public List<BakedQuad> getQuads(@Nullable BlockState state, @Nullable Direction side, @Nonnull Random rand, @Nonnull IModelData extraData) {
        IBakedModel renderModel = defaultModel;
        if (extraData.hasProperty(COPIED_BLOCK)) {
            BlockState copiedBlock = extraData.getData(COPIED_BLOCK);
            if (copiedBlock != null) {
                Minecraft mc = Minecraft.getInstance();
                BlockRendererDispatcher blockRendererDispatcher = mc.getBlockRendererDispatcher();
                renderModel = blockRendererDispatcher.getModelForState(copiedBlock);
                defaultModel.isAmbientOcclusion(copiedBlock);
            }
        }
        try{
            renderModel.getQuads(state, side, rand, extraData);
        }catch (Throwable t){
            renderModel = defaultModel;
        }
        return renderModel.getQuads(state, side, rand, extraData);
    }

    @Override
    public IModelData getModelData(IBlockDisplayReader world, BlockPos pos, BlockState state, IModelData tileData) {

        Integer i = 1;
        BlockState downBlockState;
        ModelDataMap modelDataMap = new ModelDataMap.Builder().withInitial(COPIED_BLOCK, null).build();
        //        获取下方方块的BlockState
        do{
            downBlockState = world.getBlockState(pos.down(i++));
        }while (downBlockState.getBlock() == BlockRegister.OBSIDIAN_HIDDEN_BLOCK.get());

        if (downBlockState.getBlock() == Blocks.AIR) {
            return modelDataMap;
        }
        modelDataMap.setData(COPIED_BLOCK, downBlockState);
        return modelDataMap;
    }

    @Override
    public List<BakedQuad> getQuads(@Nullable BlockState state, @Nullable Direction side, Random rand) {
        throw new AssertionError("IBakedModel::getQuads should never be called, only IForgeBakedModel::getQuads");
    }

    /**
     * 控制是否开启环境光遮蔽
     * @author : 1260535819@qq.com
     * @date : 2021/1/14 21:40
     * @return : boolean
     */
    @Override
    public boolean isAmbientOcclusion() {
        return defaultModel.isAmbientOcclusion();
    }

    /**
     * 控制掉落物是否是3D的
     * @author : 1260535819@qq.com
     * @date : 2021/1/14 21:40
     * @return : boolean
     */
    @Override
    public boolean isGui3d() {
        return defaultModel.isGui3d();
    }

    /**
     * 暂不明，应该和物品的渲染光有关
     * @author : 1260535819@qq.com
     * @date : 2021/1/14 21:41
     * @return : boolean
     */
    @Override
    public boolean isSideLit() {
        return defaultModel.isSideLit();
    }

    /**
     * 是否使用内置的渲染，返回Ture会使用ISTR渲染
     * @author : 1260535819@qq.com
     * @date : 2021/1/14 21:41
     * @return : boolean
     */
    @Override
    public boolean isBuiltInRenderer() {
        return defaultModel.isBuiltInRenderer();
    }

    /**
     * 粒子效果材质
     * @author : 1260535819@qq.com
     * @date : 2021/1/14 21:41
     * @return : net.minecraft.client.renderer.texture.TextureAtlasSprite
     */
    @Override
    public TextureAtlasSprite getParticleTexture() {
        return defaultModel.getParticleTexture();
    }

    @Override
    public ItemCameraTransforms getItemCameraTransforms() {
        return null;
    }

    /**
     * 获取模型的复写列表
     * @author : 1260535819@qq.com
     * @date : 2021/1/14 21:42
     * @return : net.minecraft.client.renderer.model.ItemOverrideList
     */
    @Override
    public ItemOverrideList getOverrides() {
        return defaultModel.getOverrides();
    }
}

