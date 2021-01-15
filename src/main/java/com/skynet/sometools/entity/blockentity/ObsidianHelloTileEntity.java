package com.skynet.sometools.entity.blockentity;

import com.skynet.sometools.register.TileEntityTypeRegister;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.text.TranslationTextComponent;

/**
 * TODO ObsidianHelloTileEntity
 *
 * @program: forge-1.16.3-34.1.0-mdk
 * @author: 1260535819@qq.com
 * @create: 2021-01-14 14:15
 */

public class ObsidianHelloTileEntity extends TileEntity implements ITickableTileEntity {
    private static final int MAX_TIME = 5 * 20;
    private int timer = 0;

    public ObsidianHelloTileEntity() {
        super(TileEntityTypeRegister.OBSIDIAN_HELLO_TILE_ENTITY.get());
    }

    @Override
    public void tick() {
        if (world != null && !world.isRemote) {
            if (timer == MAX_TIME) {
                PlayerEntity player = world.getClosestPlayer(pos.getX(), pos.getY(), pos.getZ(), 10, false);
                TranslationTextComponent translationTextComponent = new TranslationTextComponent("message.hello_block.hello");
                if (player != null) {
                    player.sendStatusMessage(translationTextComponent, false);
                }
                timer = 0;
            }
            timer++;
        }
    }
}


