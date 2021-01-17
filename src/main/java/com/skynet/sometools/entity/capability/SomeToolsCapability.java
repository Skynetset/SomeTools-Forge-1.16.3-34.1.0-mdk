package com.skynet.sometools.entity.capability;

import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;

/**
 * TODO ModCapability
 *
 * @program: SomeTools-Forge-1.16.3-34.1.0-mdk
 * @author: 1260535819@qq.com
 * @create: 2021-01-16 18:56
 */

public class SomeToolsCapability {
    @CapabilityInject(ISimpleCapability.class)
    public static Capability<ISimpleCapability> SIMPLE_CAPABILITY;
    @CapabilityInject(ISpeedUpCapability.class)
    public static Capability<ISpeedUpCapability> SPEED_UP_CAPABILITY;

}
