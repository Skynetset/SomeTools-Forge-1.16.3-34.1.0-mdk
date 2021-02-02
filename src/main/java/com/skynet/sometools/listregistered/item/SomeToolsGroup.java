package com.skynet.sometools.listregistered.item;

import com.skynet.sometools.listregistered.RegisteredItemList;
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
            return new ItemStack(RegisteredItemList.obsidian_ingot);
        }
    };
    public static final ItemGroup FOOD_GROUP = new ItemGroup("food") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(RegisteredItemList.obsidian_apple);
        }
    };
    public static final ItemGroup TOOLS_GROUP = new ItemGroup("tools") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(RegisteredItemList.obsidian_sword);
        }
    };
    public static final ItemGroup ARMER_GROUP = new ItemGroup("armer") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(RegisteredItemList.obsidian_chestplate);
        }
    };
    public static final ItemGroup BLOCK_GROUP = new ItemGroup("blocks") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(RegisteredItemList.obsidian_block);
        }
    };
    public static final ItemGroup ITEMS_GROUP = new ItemGroup("items") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(RegisteredItemList.obsidian_fluid_bucket);
        }
    };
}
