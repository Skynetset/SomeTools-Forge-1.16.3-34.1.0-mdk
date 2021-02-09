package com.skynet.sometools.list.item.blocks.blockentity.screen;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.skynet.sometools.common.Utils;
import com.skynet.sometools.list.item.blocks.blockentity.container.ObsidianFirstContainer;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;

/**
 * ObsidianFirstContainerScreen
 *
 * @program: SomeTools-Forge-1.16.3-34.1.0-mdk
 * @author: 1260535819@qq.com
 * @create: 2021-01-16 23:33
 */

public class ObsidianFirstContainerScreen extends ContainerScreen<ObsidianFirstContainer> {
    private final ResourceLocation OBSIDIAN_CONTAINER_RESOURCE = new ResourceLocation(Utils.MOD_ID, "textures/gui" +
            "/container.png");
    private final int textureWidth = 176;
    private final int textureHeight = 166;

    public ObsidianFirstContainerScreen(ObsidianFirstContainer screenContainer, PlayerInventory inv,
                                        ITextComponent titleIn) {
        super(screenContainer, inv, titleIn);
        this.xSize = textureWidth;
        this.ySize = textureHeight;
    }

    @Override
    public void render(MatrixStack matrixStack, int mouseX, int mouseY, float partialTicks) {
        renderBackground(matrixStack);
        super.render(matrixStack, mouseX, mouseY, partialTicks);
        renderHoveredTooltip(matrixStack, mouseX, mouseY);
    }

    @Override
    protected void drawGuiContainerForegroundLayer(MatrixStack matrixStack, int x, int y) {
        drawCenteredString(matrixStack, this.font, Integer.toString(this.getContainer().getIntArray().get(0)), 82, 20
                , 0xeb0505);
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(MatrixStack matrixStack, float partialTicks, int x, int y) {
        this.renderBackground(matrixStack);
        this.minecraft.getTextureManager().bindTexture(OBSIDIAN_CONTAINER_RESOURCE);
        int i = (this.width - this.xSize) / 2;
        int j = (this.height - this.ySize) / 2;
        blit(matrixStack, i, j, 0, 0, xSize, ySize, this.textureWidth, textureHeight);
    }
}

