package com.skynet.sometools.list.entity.capability.impl;

import com.skynet.sometools.list.entity.capability.ISimpleCapability;
import net.minecraft.util.math.BlockPos;

/**
 * SimpleCapability
 *
 * @program: SomeTools-Forge-1.16.3-34.1.0-mdk
 * @author: 1260535819@qq.com
 * @create: 2021-01-16 18:55
 */

public class SimpleCapability implements ISimpleCapability {
    private final String context;

    public SimpleCapability(String context) {
        this.context = context;
    }

    @Override
    public String getString(BlockPos pos) {
        return pos.toString() + ":::" + this.context;
    }
}
