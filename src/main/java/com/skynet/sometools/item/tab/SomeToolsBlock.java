package com.skynet.sometools.item.tab;

import com.skynet.sometools.blocks.blockentity.BlockRegister;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

/**
 * TODO
 *
 * @program: forge-1.16.3-34.1.0-mdk
 * @author: 1260535819@qq.com
 * @create: 2021-01-13 15:37
 */

public class SomeToolsBlock extends ItemGroup {
    public SomeToolsBlock() {
        super("Some Tools Block");
    }

    @Override
    public ItemStack createIcon() {
        return new ItemStack(BlockRegister.OBSIDIAN_BLOCK.get());
    }
}
