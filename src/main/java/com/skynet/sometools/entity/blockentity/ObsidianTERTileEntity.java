package com.skynet.sometools.entity.blockentity;

import com.skynet.sometools.register.TileEntityTypeRegister;
import net.minecraft.tileentity.TileEntity;

/**
 * TODO ObsidianTERTileEntity
 *
 * @program: forge-1.16.3-34.1.0-mdk
 * @author: 1260535819@qq.com
 * @create: 2021-01-15 11:34
 */

public class ObsidianTERTileEntity extends TileEntity {
    public ObsidianTERTileEntity() {
        super(TileEntityTypeRegister.OBSIDIAN_TER_TILE_ENTITY.get());
    }
}

