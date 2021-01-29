package com.skynet.sometools.item.tools.pickaxe;

import com.skynet.sometools.item.tab.SomeToolsGroup;
import com.skynet.sometools.item.tools.SomeToolsItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.PickaxeItem;

/**
 * TODO ObsidianPickaxe
 *
 * @program: forge-1.16.3-34.1.0-mdk
 * @author: 1260535819@qq.com
 * @create: 2021-01-13 16:28
 */

public class ObsidianPickaxe extends PickaxeItem {
    public ObsidianPickaxe() {
        super(SomeToolsItemTier.OBSIDIAN, 2, -0.5F, (new Item.Properties()).group(SomeToolsGroup.TOOLS_GROUP));
    }
}
