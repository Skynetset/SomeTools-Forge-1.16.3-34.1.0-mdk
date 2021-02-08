package com.skynet.sometools.listregistered.tileentities;

import com.skynet.sometools.listregistered.RegisteredTileEntityTypeList;
import com.skynet.sometools.listregistered.entity.capability.ISimpleCapability;
import com.skynet.sometools.listregistered.entity.capability.SomeToolsCapability;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.common.util.LazyOptional;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * ObsidianUpBlockTileEntity
 *
 * @program: SomeTools-Forge-1.16.3-34.1.0-mdk
 * @author: 1260535819@qq.com
 * @create: 2021-01-16 18:30
 */

public class ObsidianUpBlockTileEntity extends TileEntity implements ITickableTileEntity {
    private static final Logger logger = LogManager.getLogger();

    public ObsidianUpBlockTileEntity() {
        super(RegisteredTileEntityTypeList.obsidian_up_tile_block);
    }

    @Override
    public void tick() {
        if (world != null && !world.isRemote) {
            BlockPos pos = this.pos.down();
            TileEntity tileEntity = world.getTileEntity(pos);
            if (tileEntity != null) {
                LazyOptional<ISimpleCapability> simpleCapabilityLazyOptional =
                        tileEntity.getCapability(SomeToolsCapability.SIMPLE_CAPABILITY);
                simpleCapabilityLazyOptional.ifPresent((s) -> {
                    String context = s.getString(this.pos);
                    logger.info(context);
                });
            }
        }

    }
}

