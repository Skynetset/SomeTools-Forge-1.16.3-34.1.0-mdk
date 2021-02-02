package com.skynet.sometools.listregistered.item.blocks.blockentity.screen;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.systems.RenderSystem;
import com.skynet.sometools.listregistered.item.blocks.blockentity.container.MyChestContainer;
import net.minecraft.client.gui.IHasContainer;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

/**
 * TODO ObsidianFirstContainerScreen
 *
 * @program: SomeTools-Forge-1.16.3-34.1.0-mdk
 * @author: 1260535819@qq.com
 * @create: 2021-01-16 23:33
 */

@OnlyIn(Dist.CLIENT)
public class MyChestContainerScreen extends ContainerScreen<MyChestContainer> implements IHasContainer<MyChestContainer> {
    //    private final ResourceLocation OBSIDIAN_CONTAINER_RESOURCE = new ResourceLocation(Utils.MOD_ID,
    //    "textures/gui/container.png");
    /**
     * The ResourceLocation containing the chest GUI texture.
     */
    private static final ResourceLocation CHEST_GUI_TEXTURE = new ResourceLocation("textures/gui/container/generic_54" +
            ".png");
    /**
     * Window height is calculated with these values; the more rows, the higher
     */
    private final int inventoryRows;

    private final int textureWidth = 176;
    private final int textureHeight = 166;

    public MyChestContainerScreen(MyChestContainer container, PlayerInventory playerInventory, ITextComponent title) {
        super(container, playerInventory, title);
        this.passEvents = false;
        int i = 222;
        int j = 114;
        this.inventoryRows = container.getNumRows();
        this.ySize = 114 + this.inventoryRows * 18;
        this.playerInventoryTitleY = this.ySize - 94;
    }

    @Override
    public void render(MatrixStack matrixStack, int mouseX, int mouseY, float partialTicks) {
        this.renderBackground(matrixStack);
        super.render(matrixStack, mouseX, mouseY, partialTicks);
        this.renderHoveredTooltip(matrixStack, mouseX, mouseY);
    }

    //    @Override
    //    protected void drawGuiContainerForegroundLayer(MatrixStack matrixStack, int x, int y) {
    //        drawCenteredString(matrixStack, this.font, Integer.toString(this.getContainer().getIntArray().get(0)),
    //        82, 20, 0xeb0505);
    //    }

    @Override
    protected void drawGuiContainerBackgroundLayer(MatrixStack matrixStack, float partialTicks, int x, int y) {
        RenderSystem.color4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.minecraft.getTextureManager().bindTexture(CHEST_GUI_TEXTURE);
        int i = (this.width - this.xSize) / 2;
        int j = (this.height - this.ySize) / 2;
        this.blit(matrixStack, i, j, 0, 0, this.xSize, this.inventoryRows * 18 + 17);
        this.blit(matrixStack, i, j + this.inventoryRows * 18 + 17, 0, 126, this.xSize, 96);
    }
}

