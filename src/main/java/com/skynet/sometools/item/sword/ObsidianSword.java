package com.skynet.sometools.item.sword;

import com.skynet.sometools.SomeToolsGroup;
import com.skynet.sometools.SomeToolsItemTier;
import net.minecraft.item.SwordItem;

/**
 * TODO obsidianSword
 *
 * @program: forge-1.16.3-34.1.0-mdk
 * @author: 1260535819@qq.com
 * @create: 2021-01-13 16:18
 */

public class ObsidianSword extends SwordItem {
    public ObsidianSword() {
        super(SomeToolsItemTier.OBSIDIAN, 30, -0.5F, new Properties().group(SomeToolsGroup.toolsGroup));
    }
}
