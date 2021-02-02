package com.skynet.sometools.listregistered.tileentities;

import com.skynet.sometools.listregistered.RegisteredTileEntityTypeList;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.ItemStackHandler;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * TODO ObsidianTrashTileEntity
 *
 * @program: SomeTools-Forge-1.16.3-34.1.0-mdk
 * @author: 1260535819@qq.com
 * @create: 2021-01-16 19:13
 */

public class ObsidianTrashTileEntity extends TileEntity {
    public ObsidianTrashTileEntity() {
        super(RegisteredTileEntityTypeList.obsidian_trash_tile_block);
    }

    @Nonnull
    @Override
    public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @Nullable Direction side) {
        if (side == Direction.UP && cap == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) {
            return LazyOptional.of(() -> new ItemStackHandler() {
                @Override
                public boolean isItemValid(int slot, @Nonnull ItemStack stack) {
                    return stack.getItem() == Items.COBBLESTONE;
                }
            }).cast();
        }
        return super.getCapability(cap, side);
    }
}

