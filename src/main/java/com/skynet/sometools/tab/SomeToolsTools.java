package com.skynet.sometools.tab;

import com.skynet.sometools.register.ItemRegister;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

/**
 * TODO
 *
 * @program: forge-1.16.3-34.1.0-mdk
 * @author: 1260535819@qq.com
 * @create: 2021-01-13 15:37
 */

public class SomeToolsTools extends ItemGroup {
    public SomeToolsTools() {
        super("Some Tools Tools");
    }

    @Override
    public ItemStack createIcon() {
        return new ItemStack(ItemRegister.OBSIDIAN_SWORD.get());
    }
}
