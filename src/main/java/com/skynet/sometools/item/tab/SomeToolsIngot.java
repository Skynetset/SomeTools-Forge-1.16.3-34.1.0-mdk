package com.skynet.sometools.item.tab;

import com.skynet.sometools.item.ItemRegister;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

/**
 * TODO SomeToolsTab
 *
 * @program: forge-1.16.3-34.1.0-mdk
 * @author: 1260535819@qq.com
 * @create: 2021-01-13 15:05
 */

public class SomeToolsIngot extends ItemGroup {
    public SomeToolsIngot() {
        super("Some Tools Ingot");
    }

    @Override
    public ItemStack createIcon() {
        return new ItemStack(ItemRegister.OBSIDIAN_INGOT.get());
    }
}
