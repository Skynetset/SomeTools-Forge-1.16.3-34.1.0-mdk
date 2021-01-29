package com.skynet.sometools.item.tools;

import com.skynet.sometools.item.tab.SomeToolsGroup;
import com.skynet.sometools.item.itemstacktileentityrenderer.ObsidianWrenchItemStackTileEntityRenderer;
import net.minecraft.item.Item;

/**
 * TODO ObsidianWrench
 *
 * @program: SomeTools-Forge-1.16.3-34.1.0-mdk
 * @author: 1260535819@qq.com
 * @create: 2021-01-15 15:14
 */

public class ObsidianWrench extends Item {
    public ObsidianWrench() {
        super(new Properties().group(SomeToolsGroup.TOOLS_GROUP).setISTER(() -> ObsidianWrenchItemStackTileEntityRenderer::new));
    }
}

