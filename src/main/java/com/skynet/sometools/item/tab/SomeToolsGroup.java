package com.skynet.sometools.item.tab;

import com.skynet.sometools.item.blocks.BlockRegister;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

/**
 * TODO groups
 *
 * @program: forge-1.16.3-34.1.0-mdk
 * @author: 1260535819@qq.com
 * @create: 2021-01-13 15:09
 */

public class SomeToolsGroup {
    public static final ItemGroup INGOT_GROUP = new ItemGroup("ingot") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(ItemRegister.OBSIDIAN_INGOT.get());
        }
    };
    public static final ItemGroup FOOD_GROUP = new ItemGroup("food") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(ItemRegister.OBSIDIAN_APPLE.get());
        }
    };
    public static final ItemGroup TOOLS_GROUP = new ItemGroup("tools") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(ItemRegister.OBSIDIAN_SWORD.get());
        }
    };
    public static final ItemGroup ARMER_GROUP = new ItemGroup("armer") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(ItemRegister.OBSIDIAN_CHEST_PLATE.get());
        }
    };
    public static final ItemGroup BLOCK_GROUP = new ItemGroup("blocks") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(BlockRegister.OBSIDIAN_BLOCK.get());
        }
    };
    public static final ItemGroup ITEMS_GROUP = new ItemGroup("items") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(ItemRegister.obsidianFluidBucket.get());
        }
    };
}
