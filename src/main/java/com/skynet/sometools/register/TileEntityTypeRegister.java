package com.skynet.sometools.register;

import com.skynet.sometools.common.Utils;
import com.skynet.sometools.entity.blockentity.ObsidianCounterTileEntity;
import com.skynet.sometools.entity.blockentity.ObsidianHelloTileEntity;
import com.skynet.sometools.entity.blockentity.ObsidianTERTileEntity;
import com.skynet.sometools.entity.blockentity.ObsidianZombieTileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

/**
 * TODO TileEntityTypeRegistry
 *
 * @program: forge-1.16.3-34.1.0-mdk
 * @author: 1260535819@qq.com
 * @create: 2021-01-14 09:24
 */

public class TileEntityTypeRegister {
    public static final DeferredRegister<TileEntityType<?>> TILE_ENTITIES = DeferredRegister.create(ForgeRegistries.TILE_ENTITIES, Utils.MOD_ID);

    public static final RegistryObject<TileEntityType<ObsidianCounterTileEntity>> OBSIDIAN_COUNTER_TILE_ENTITY =
            TILE_ENTITIES.register("obsidian_counter_tileentity",
                    () -> TileEntityType.Builder.create(ObsidianCounterTileEntity::new, BlockRegister.OBSIDIAN_COUNTER.get()).build(null));
    public static final RegistryObject<TileEntityType<ObsidianHelloTileEntity>> OBSIDIAN_HELLO_TILE_ENTITY =
            TILE_ENTITIES.register("obsidian_hello_block",
                    () -> TileEntityType.Builder.create(ObsidianHelloTileEntity::new, BlockRegister.OBSIDIAN_HELLO.get()).build(null));
    public static final RegistryObject<TileEntityType<ObsidianZombieTileEntity>> OBSIDIAN_ZOMBIE_TILE_ENTITY =
            TILE_ENTITIES.register("obsidian_zombie_tile_block",
                    () -> TileEntityType.Builder.create(ObsidianZombieTileEntity::new, BlockRegister.OBSIDIAN_ZOMBIE_BLOCK.get()).build(null));
    public static final RegistryObject<TileEntityType<ObsidianTERTileEntity>> OBSIDIAN_TER_TILE_ENTITY =
            TILE_ENTITIES.register("obsidian_ter_tile_block",
                    () -> TileEntityType.Builder.create(ObsidianTERTileEntity::new, BlockRegister.OBSIDIAN_TER_BLOCK.get()).build(null));
}

