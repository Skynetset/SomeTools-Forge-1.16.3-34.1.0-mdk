package com.skynet.sometools.entity.capability.provider;

import com.skynet.sometools.entity.capability.ISpeedUpCapability;
import com.skynet.sometools.entity.capability.SomeToolsCapability;
import com.skynet.sometools.entity.capability.impl.SpeedUpCapability;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.util.INBTSerializable;
import net.minecraftforge.common.util.LazyOptional;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Random;

/**
 * SpeedUpCapabilityProvider
 * ICapabilityProvider接口是必须实现的，
 * INBTSerializable<CompoundNBT>是可以不用实现的，
 * 如果CapabilityProvider不需要保存数据，可以不实现这个接口，
 * 如果实现了这个接口，当附加完能力时，Forge在保存数据和读取数据时，会自动调用这两个接口。
 *
 * @program: SomeTools-Forge-1.16.3-34.1.0-mdk
 * @author: 1260535819@qq.com
 * @create: 2021-01-16 20:30
 */

public class SpeedUpCapabilityProvider implements ICapabilityProvider, INBTSerializable<CompoundNBT> {
    private ISpeedUpCapability speedUpCapability;

    @Nonnull
    @Override
    public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @Nullable Direction side) {
        return cap == SomeToolsCapability.SPEED_UP_CAPABILITY ? LazyOptional.of(this::getOrCreateCapability).cast() : LazyOptional.empty();
    }

    @Nonnull
    ISpeedUpCapability getOrCreateCapability() {
        if (speedUpCapability == null) {
            Random random = new Random();
            this.speedUpCapability = new SpeedUpCapability(random.nextInt(99) + 1);
        }
        return this.speedUpCapability;
    }

    @Override
    public CompoundNBT serializeNBT() {
        return getOrCreateCapability().serializeNBT();
    }

    @Override
    public void deserializeNBT(CompoundNBT nbt) {
        getOrCreateCapability().deserializeNBT(nbt);
    }
}
