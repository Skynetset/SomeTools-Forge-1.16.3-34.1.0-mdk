package com.skynet.sometools.listregistered.item.blocks;

import com.skynet.sometools.listregistered.tileentities.ObsidianZombieTileEntity;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockReader;

import javax.annotation.Nullable;

/**
 * ObsidianZombieBlock
 *
 * @program: forge-1.16.3-34.1.0-mdk
 * @author: 1260535819@qq.com
 * @create: 2021-01-14 20:08
 */

public class ObsidianZombieBlock extends Block {
    public ObsidianZombieBlock() {
        super(Properties.create(Material.ROCK).hardnessAndResistance(5));
    }

    @Override
    public boolean hasTileEntity(BlockState state) {
        return true;
    }

    @Nullable
    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world) {
        return new ObsidianZombieTileEntity();
    }
}

