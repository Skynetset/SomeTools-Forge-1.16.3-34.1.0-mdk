package com.skynet.sometools.listregistered.tileentities;

import com.skynet.sometools.list.TileEntityTypeList;
import com.skynet.sometools.listregistered.entity.capability.SomeToolsCapability;
import com.skynet.sometools.listregistered.entity.capability.impl.SimpleCapability;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * ObsidianDownBlockTileEntity
 *
 * @program: SomeTools-Forge-1.16.3-34.1.0-mdk
 * @author: 1260535819@qq.com
 * @create: 2021-01-16 18:33
 */

public class ObsidianDownBlockTileEntity extends TileEntity {
    public ObsidianDownBlockTileEntity() {
        super(TileEntityTypeList.OBSIDIAN_DOWN_BLOCK_ENTITY);
    }

    @Nonnull
    @Override
    public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @Nullable Direction side) {
        if (cap == SomeToolsCapability.SIMPLE_CAPABILITY) {
            return LazyOptional.of(() -> new SimpleCapability("Hello")).cast();
        }
        return LazyOptional.empty();
    }
}

