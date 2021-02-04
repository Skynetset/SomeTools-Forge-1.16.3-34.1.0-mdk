package com.skynet.sometools.listregistered.fluid;

import com.skynet.sometools.listregistered.RegisteredBlockList;
import com.skynet.sometools.listregistered.RegisteredItemList;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.FluidAttributes;
import net.minecraftforge.fluids.ForgeFlowingFluid;

/**
 * TODO
 *
 * @program: SomeTools-Forge-1.16.3-34.1.0-mdk
 * @author: 1260535819@qq.com
 * @create: 2021-01-30 13:34
 */

public class FluidPropertiesList {
    public static ForgeFlowingFluid.Properties OBSIDIAN_FLUID_PROPERTIES =
            new ForgeFlowingFluid.Properties(FluidRegister.obsidianFluid
                    , FluidRegister.obsidianFluidFlowing
                    , FluidAttributes
                    .builder(new ResourceLocation("block/water_still"), new ResourceLocation("block/water_flow"))
                    .color(0xFF420372)
                    .density(4000)
                    .viscosity(4000))
                    .bucket(() -> RegisteredItemList.obsidian_fluid_bucket)
                    .block(() -> RegisteredBlockList.obsidian_fluid)
                    .slopeFindDistance(3)
                    .explosionResistance(100F);
}
