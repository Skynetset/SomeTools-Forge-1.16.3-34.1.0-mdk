package com.skynet.sometools.item.tab;

import com.skynet.sometools.item.ItemRegister;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

/**
 * TODO
 *
 * @program: forge-1.16.3-34.1.0-mdk
 * @author: 1260535819@qq.com
 * @create: 2021-01-13 15:37
 */

public class SomeToolsFood extends ItemGroup {
    public SomeToolsFood() {
        super("Some Tools Food");
    }

    @Override
    public ItemStack createIcon() {
        return new ItemStack(ItemRegister.OBSIDIAN_APPLE.get());
    }
}
