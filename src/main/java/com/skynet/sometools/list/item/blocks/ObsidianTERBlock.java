package com.skynet.sometools.list.item.blocks;

import com.skynet.sometools.list.tileentities.ObsidianTERTileEntity;
import net.minecraft.block.BlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockReader;

import javax.annotation.Nullable;

/**
 * ObsidianTERBlock
 *
 * @program: forge-1.16.3-34.1.0-mdk
 * @author: 1260535819@qq.com
 * @create: 2021-01-15 11:30
 */

public class ObsidianTERBlock extends ObsidianFrame {
    @Override
    public boolean hasTileEntity(BlockState state) {
        return true;
    }

    @Nullable
    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world) {
        return new ObsidianTERTileEntity();
    }

}
