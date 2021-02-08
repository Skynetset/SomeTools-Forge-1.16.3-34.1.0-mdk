package com.skynet.sometools.listregistered.tileentities;

import com.skynet.sometools.listregistered.RegisteredTileEntityTypeList;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SUpdateTileEntityPacket;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraftforge.common.util.Constants;

import javax.annotation.Nullable;

/**
 * ObsidianZombieTileEntity
 *
 * @program: forge-1.16.3-34.1.0-mdk
 * @author: 1260535819@qq.com
 * @create: 2021-01-14 20:10
 */

public class ObsidianZombieTileEntity extends TileEntity implements ITickableTileEntity {
    private final int MAX_TIME = 5 * 20;
    private boolean flag = false;
    private int timer = 0;


    public ObsidianZombieTileEntity() {
        super(RegisteredTileEntityTypeList.obsidian_zombie_tile_block);
    }

    @Override
    public void tick() {
        if (world.isRemote && flag) {
            PlayerEntity player = world.getClosestPlayer(pos.getX(), pos.getY(), pos.getZ(), 10, false);
            this.world.playSound(player, pos, SoundEvents.ENTITY_ZOMBIE_AMBIENT, SoundCategory.AMBIENT, 1.0f, 1.0f);
            flag = false;
        }
        if (!world.isRemote) {
            if (timer == MAX_TIME) {
                flag = true;
                world.notifyBlockUpdate(pos, getBlockState(), getBlockState(), Constants.BlockFlags.BLOCK_UPDATE);
                flag = true;
                timer = 0;
            }
            timer++;
        }
    }

    /**
     * 服务端发送数据包
     *
     * @return : net.minecraft.network.play.server.SUpdateTileEntityPacket
     *
     * @author : 1260535819@qq.com
     * @date : 2021/1/14 20:18
     */
    @Nullable
    @Override
    public SUpdateTileEntityPacket getUpdatePacket() {
        return new SUpdateTileEntityPacket(pos, 1, getUpdateTag());
    }

    /**
     * 客户端接受数据包
     *
     * @param net :
     * @param pkt :
     *
     * @return : void
     *
     * @author : 1260535819@qq.com
     * @date : 2021/1/14 20:18
     */
    @Override
    public void onDataPacket(NetworkManager net, SUpdateTileEntityPacket pkt) {
        handleUpdateTag(world.getBlockState(pkt.getPos()), pkt.getNbtCompound());
    }

    /**
     * 区块刚被载入时被调用
     *
     * @return : net.minecraft.nbt.CompoundNBT
     *
     * @author : 1260535819@qq.com
     * @date : 2021/1/14 20:24
     */
    @Override
    public CompoundNBT getUpdateTag() {
        CompoundNBT compoundNBT = super.getUpdateTag();
        compoundNBT.putBoolean("flag", flag);
        return compoundNBT;
    }

    /**
     * 区块刚被载入时被调用
     *
     * @param state :
     * @param tag   :
     *
     * @return : void
     *
     * @author : 1260535819@qq.com
     * @date : 2021/1/14 20:24
     */
    @Override
    public void handleUpdateTag(BlockState state, CompoundNBT tag) {
        flag = tag.getBoolean("flag");
    }
}

