package com.skynet.sometools.listregistered;

import com.skynet.sometools.common.Utils;
import com.skynet.sometools.listregistered.tileentities.*;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.registries.ObjectHolder;

/**
 * TODO TileEntityTypeList
 *
 * @program: SomeTools-Forge-1.16.3-34.1.0-mdk
 * @author: 1260535819@qq.com
 * @create: 2021-01-30 12:54
 */

@ObjectHolder(Utils.MOD_ID)
public class RegisteredTileEntityTypeList {
    public static TileEntityType<ObsidianCounterTileEntity> OBSIDIAN_COUNTER_TILE_ENTITY;
    public static TileEntityType<ObsidianHelloTileEntity> OBSIDIAN_HELLO_TILE_ENTITY;
    public static TileEntityType<ObsidianZombieTileEntity> OBSIDIAN_ZOMBIE_TILE_ENTITY;
    public static TileEntityType<ObsidianTERTileEntity> OBSIDIAN_TER_TILE_ENTITY;
    public static TileEntityType<ObsidianUpBlockTileEntity> OBSIDIAN_UP_BLOCK_ENTITY;
    public static TileEntityType<ObsidianDownBlockTileEntity> OBSIDIAN_DOWN_BLOCK_ENTITY;
    public static TileEntityType<ObsidianTrashTileEntity> OBSIDIAN_TRASH_TILE_ENTITY;
    public static TileEntityType<ObsidianFirstContainerTileEntity> OBSIDIAN_FIRST_CONTAINER_TILE_ENTITY;
    public static TileEntityType<MyChestWithContainerTileEntity> MY_CHEST_WITH_CONTAINER_TILE_ENTITY;
}
