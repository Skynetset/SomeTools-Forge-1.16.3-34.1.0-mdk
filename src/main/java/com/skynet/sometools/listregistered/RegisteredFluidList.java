package com.skynet.sometools.listregistered;

import com.skynet.sometools.common.Utils;
import net.minecraft.fluid.FlowingFluid;
import net.minecraftforge.registries.ObjectHolder;

/**
 * TODO FluidList
 *
 * @program: SomeTools-Forge-1.16.3-34.1.0-mdk
 * @author: 1260535819@qq.com
 * @create: 2021-01-30 13:29
 */
@ObjectHolder(Utils.MOD_ID)
public class RegisteredFluidList {
    @ObjectHolder("obsidian_fluid")
    public static final FlowingFluid obsidianFluid = null;
    @ObjectHolder("obsidian_fluid_flowing")
    public static final FlowingFluid obsidianFluidFlowing = null;
}
