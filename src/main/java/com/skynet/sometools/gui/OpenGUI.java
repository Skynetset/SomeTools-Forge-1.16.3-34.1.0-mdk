package com.skynet.sometools.gui;

import com.skynet.sometools.common.Utils;
import net.minecraft.client.Minecraft;
import net.minecraft.util.text.TranslationTextComponent;

/**
 * OpenGUI
 *
 * @program: SomeTools-Forge-1.16.3-34.1.0-mdk
 * @author: 1260535819@qq.com
 * @create: 2021-01-16 23:11
 */

public class OpenGUI {
    public OpenGUI() {
        Minecraft.getInstance().displayGuiScreen(new ObsidianFirstGui(new TranslationTextComponent(Utils.MOD_ID +
                ".test")));
    }
}
