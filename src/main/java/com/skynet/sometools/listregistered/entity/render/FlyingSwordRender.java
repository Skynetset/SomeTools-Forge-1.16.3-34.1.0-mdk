package com.skynet.sometools.listregistered.entity.render;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.skynet.sometools.common.Utils;
import com.skynet.sometools.listregistered.entity.FlyingSwordEntity;
import com.skynet.sometools.listregistered.entity.model.FlyingSwordModel;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.vector.Vector3f;

/**
 * TODO FlyingSwordRender
 *
 * @program: SomeTools-Forge-1.16.3-34.1.0-mdk
 * @author: 1260535819@qq.com
 * @create: 2021-01-16 17:41
 */

public class FlyingSwordRender extends EntityRenderer<FlyingSwordEntity> {
    private final EntityModel<FlyingSwordEntity> flyingSwordModel;

    public FlyingSwordRender(EntityRendererManager renderManager) {
        super(renderManager);
        flyingSwordModel = new FlyingSwordModel();
    }

    @Override
    public ResourceLocation getEntityTexture(FlyingSwordEntity entity) {
        return new ResourceLocation(Utils.MOD_ID, "textures/entity/flying_sword.png");
    }

    @Override
    public void render(FlyingSwordEntity entityIn, float entityYaw, float partialTicks, MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn) {
        super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
        matrixStackIn.push();
        matrixStackIn.rotate(Vector3f.YN.rotationDegrees(45));
        IVertexBuilder ivertexbuilder = bufferIn.getBuffer(this.flyingSwordModel.getRenderType(this.getEntityTexture(entityIn)));
        this.flyingSwordModel.render(matrixStackIn, ivertexbuilder, packedLightIn, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
        matrixStackIn.pop();
    }
}

