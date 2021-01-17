package com.skynet.sometools.entity.capability.impl;

import com.skynet.sometools.entity.capability.ISpeedUpCapability;
import net.minecraft.nbt.CompoundNBT;

/**
 * TODO SpeedUpCapability
 *
 * @program: SomeTools-Forge-1.16.3-34.1.0-mdk
 * @author: 1260535819@qq.com
 * @create: 2021-01-16 20:24
 */

public class SpeedUpCapability implements ISpeedUpCapability {
    private int level;

    public SpeedUpCapability(int level) {
        this.level = level;
    }

    @Override
    public int getLevel() {
        return level;
    }

    @Override
    public CompoundNBT serializeNBT() {
        CompoundNBT compoundNBT = new CompoundNBT();
        compoundNBT.putInt("level", this.level);
        return compoundNBT;
    }

    @Override
    public void deserializeNBT(CompoundNBT nbt) {
        this.level = nbt.getInt("level");
    }
}

