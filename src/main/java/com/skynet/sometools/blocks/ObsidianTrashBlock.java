package com.skynet.sometools.blocks;

import com.skynet.sometools.blocks.blockentity.ObsidianTrashTileEntity;
import com.skynet.sometools.entity.ObsidianUpBlockTileEntity;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockReader;

import javax.annotation.Nullable;

/**
 * TODO ObsidianBlock
 *
 * @program: forge-1.16.3-34.1.0-mdk
 * @author: 1260535819@qq.com
 * @create: 2021-01-13 21:14
 */

public class ObsidianTrashBlock extends Block {
    public ObsidianTrashBlock() {
        super(Properties.create(Material.ROCK).hardnessAndResistance(5));
    }
    @Override
    public boolean hasTileEntity(BlockState state) {
        return true;
    }

    @Nullable
    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world) {
        return new ObsidianTrashTileEntity();
    }
}