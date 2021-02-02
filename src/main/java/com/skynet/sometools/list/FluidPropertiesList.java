package com.skynet.sometools.list;

import com.skynet.sometools.listregistered.RegisteredBlockList;
import com.skynet.sometools.listregistered.RegisteredFluidList;
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
            new ForgeFlowingFluid.Properties(()->RegisteredFluidList.obsidianFluid
                    , ()->RegisteredFluidList.obsidianFluidFlowing
                    , FluidAttributes
                    .builder(new ResourceLocation("block/water_still"), new ResourceLocation("block/water_flow"))
                    .color(0xFF420372)
                    .density(4000)
                    .viscosity(4000))
                    .bucket(()->RegisteredItemList.obsidian_fluid_bucket)
                    .block(()->RegisteredBlockList.OBSIDIAN_FLUID_BLOCK)
                    .slopeFindDistance(3)
                    .explosionResistance(100F);
}
