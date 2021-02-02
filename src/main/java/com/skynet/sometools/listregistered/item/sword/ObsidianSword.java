package com.skynet.sometools.listregistered.item.sword;

import com.skynet.sometools.listregistered.item.SomeToolsGroup;
import com.skynet.sometools.listregistered.item.tools.SomeToolsItemTier;
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
        super(SomeToolsItemTier.OBSIDIAN, 3000000, -0.5F, new Properties().group(SomeToolsGroup.TOOLS_GROUP));
    }
}
