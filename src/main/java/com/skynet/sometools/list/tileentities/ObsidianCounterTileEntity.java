package com.skynet.sometools.list.tileentities;

import com.skynet.sometools.list.TileEntityTypeList;
import net.minecraft.block.BlockState;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.TileEntity;

/**
 * ObsidianCounterTileEntity
 *
 * @program: forge-1.16.3-34.1.0-mdk
 * @author: 1260535819@qq.com
 * @create: 2021-01-14 09:22
 */

public class ObsidianCounterTileEntity extends TileEntity {
    private int counter = 0;

    /**
     * 传入方块实体的类型
     *
     * @return : null
     *
     * @author : 1260535819@qq.com
     * @date : 2021/1/14 9:30
     */
    public ObsidianCounterTileEntity() {
        super(TileEntityTypeList.OBSIDIAN_COUNTER_TILE_ENTITY);
    }

    /**
     * 方块实体功能的具体实现
     *
     * @return : int
     *
     * @author : 1260535819@qq.com
     * @date : 2021/1/14 9:30
     */
    public int increase() {
        counter++;
        /*
          标记要保存的数据，在定时保存时会保存该值
         */
        markDirty();
        return counter;
    }

    /**
     * 从存档中获取nbt值
     *
     * @param state :
     * @param nbt   :
     *
     * @return : void
     *
     * @author : 1260535819@qq.com
     * @date : 2021/1/14 12:35
     */
    @Override
    public void read(BlockState state, CompoundNBT nbt) {
        counter = nbt.getInt("counter");
        super.read(state, nbt);
    }

    /**
     * 将值存入nbt中以进行持久化操作
     *
     * @param compound :
     *
     * @return : net.minecraft.nbt.CompoundNBT
     *
     * @author : 1260535819@qq.com
     * @date : 2021/1/14 12:36
     */
    @Override
    public CompoundNBT write(CompoundNBT compound) {
        compound.putInt("counter", counter);
        return super.write(compound);
    }
}

