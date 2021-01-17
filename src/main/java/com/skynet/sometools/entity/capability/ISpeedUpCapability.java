package com.skynet.sometools.entity.capability;

import net.minecraft.nbt.CompoundNBT;
import net.minecraftforge.common.util.INBTSerializable;

/**
 * TODO ISpeedUpCapability
 *
 * @program: SomeTools-Forge-1.16.3-34.1.0-mdk
 * @author: 1260535819@qq.com
 * @create: 2021-01-16 20:22
 */

public interface ISpeedUpCapability extends INBTSerializable<CompoundNBT> {
    int getLevel();
}

