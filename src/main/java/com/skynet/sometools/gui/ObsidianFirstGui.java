package com.skynet.sometools.gui;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.systems.RenderSystem;
import com.skynet.sometools.common.Utils;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.TextFieldWidget;
import net.minecraft.client.gui.widget.Widget;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.client.settings.SliderPercentageOption;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;

/**
 * ObsidianFirstGui
 *
 * @program: SomeTools-Forge-1.16.3-34.1.0-mdk
 * @author: 1260535819@qq.com
 * @create: 2021-01-16 22:53
 */

public class ObsidianFirstGui extends Screen {
    TextFieldWidget textFieldWidget;
    Button button;
    ResourceLocation OBSIDIAN_FIRST_GUI_TEXTURE = new ResourceLocation(Utils.MOD_ID, "textures/gui/first_gui.png");
    TranslationTextComponent content = new TranslationTextComponent("gui." + Utils.MOD_ID + ".first");
    SliderPercentageOption sliderPercentageOption;
    Widget sliderBar;

    protected ObsidianFirstGui(ITextComponent titleIn) {
        super(titleIn);
    }

    @Override
    protected void init() {
        this.minecraft.keyboardListener.enableRepeatEvents(true);
        this.textFieldWidget = new TextFieldWidget(this.font, this.width / 2 - 100, 66, 200, 20,
                new TranslationTextComponent("gui." + Utils.MOD_ID + ".first.context"));
        this.children.add(this.textFieldWidget);

        this.button = new Button(this.width / 2 - 40, 96, 80, 20,
                new TranslationTextComponent("gui." + Utils.MOD_ID + ".first.save"), (button) -> {
        });
        this.addButton(button);

        this.sliderPercentageOption = new SliderPercentageOption(Utils.MOD_ID + ".sliderbar", 5, 100, 5,
                (setting) -> (double) 0, (setting, value) -> {
        }, (gameSettings, sliderPercentageOption1) -> new TranslationTextComponent("gui." + Utils.MOD_ID + ".first" +
                ".test"));
        this.sliderBar = this.sliderPercentageOption.createWidget(Minecraft.getInstance().gameSettings,
                this.width / 2 - 100, 120, 200);
        this.children.add(this.sliderBar);

        super.init();
    }

    @Override
    public void render(MatrixStack matrixStack, int mouseX, int mouseY, float partialTicks) {
        this.renderBackground(matrixStack);
        RenderSystem.color4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.minecraft.getTextureManager().bindTexture(OBSIDIAN_FIRST_GUI_TEXTURE);
        int textureWidth = 208;
        int textureHeight = 156;
        blit(matrixStack, this.width / 2 - 150, 10, 0, 0, 300, 200, textureWidth, textureHeight);
        drawCenteredString(matrixStack, this.font, content, this.width / 2 - 10, 30, 0xeb0505);
        this.textFieldWidget.render(matrixStack, mouseX, mouseY, partialTicks);
        this.button.render(matrixStack, mouseX, mouseY, partialTicks);
        this.sliderBar.render(matrixStack, mouseX, mouseY, partialTicks);
        super.render(matrixStack, mouseX, mouseY, partialTicks);
    }
}
