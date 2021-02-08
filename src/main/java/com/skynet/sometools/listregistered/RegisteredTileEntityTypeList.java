package com.skynet.sometools.listregistered;

import com.skynet.sometools.common.Utils;
import com.skynet.sometools.listregistered.tileentities.*;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.registries.ObjectHolder;

/**
 * TileEntityTypeList
 *
 * @program: SomeTools-Forge-1.16.3-34.1.0-mdk
 * @author: 1260535819@qq.com
 * @create: 2021-01-30 12:54
 */

@ObjectHolder(Utils.MOD_ID)
public class RegisteredTileEntityTypeList {
    public static final TileEntityType<ObsidianCounterTileEntity> obsidian_counter_tile_entity = null;

    public static final TileEntityType<ObsidianHelloTileEntity> obsidian_hello_block = null;
    public static final TileEntityType<ObsidianZombieTileEntity> obsidian_zombie_tile_block = null;
    public static final TileEntityType<ObsidianTERTileEntity> obsidian_ter_tile_block = null;
    public static final TileEntityType<ObsidianUpBlockTileEntity> obsidian_up_tile_block = null;
    public static final TileEntityType<ObsidianDownBlockTileEntity> obsidian_down_tile_block = null;
    public static final TileEntityType<ObsidianTrashTileEntity> obsidian_trash_tile_block = null;
    public static final TileEntityType<ObsidianFirstContainerTileEntity> obsidian_first_container_tile_entity = null;
    public static final TileEntityType<MyChestWithContainerTileEntity> my_chest_with_container_tile_entity = null;
}
