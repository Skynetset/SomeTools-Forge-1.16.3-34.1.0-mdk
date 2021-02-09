package com.skynet.sometools.listregistered.item;

import com.skynet.sometools.list.ItemList;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

/**
 * groups
 *
 * @program: forge-1.16.3-34.1.0-mdk
 * @author: 1260535819@qq.com
 * @create: 2021-01-13 15:09
 */

public class SomeToolsGroup {
    public static final ItemGroup INGOT_GROUP = new ItemGroup("ingot") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(ItemList.OBSIDIAN_INGOT);
        }
    };
    public static final ItemGroup FOOD_GROUP = new ItemGroup("food") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(ItemList.OBSIDIAN_APPLE);
        }
    };
    public static final ItemGroup TOOLS_GROUP = new ItemGroup("tools") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(ItemList.OBSIDIAN_SWORD);
        }
    };
    public static final ItemGroup ARMER_GROUP = new ItemGroup("armer") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(ItemList.OBSIDIAN_CHEST_PLATE);
        }
    };
    public static final ItemGroup BLOCK_GROUP = new ItemGroup("blocks") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(ItemList.OBSIDIAN_BLOCK);
        }
    };
    public static final ItemGroup ITEMS_GROUP = new ItemGroup("items") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(ItemList.obsidianFluidBucket);
        }
    };
}
