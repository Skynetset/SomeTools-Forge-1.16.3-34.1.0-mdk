package com.skynet.sometools.listregistered.fluid;

import com.skynet.sometools.common.Utils;
import net.minecraft.fluid.FlowingFluid;
import net.minecraft.fluid.Fluid;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

/**
 * TODO FluidRegistry
 *
 * @program: SomeTools-Forge-1.16.3-34.1.0-mdk
 * @author: 1260535819@qq.com
 * @create: 2021-01-17 17:38
 */

public class FluidRegister {
    public static final DeferredRegister<Fluid> FLUIDS = DeferredRegister.create(ForgeRegistries.FLUIDS, Utils.MOD_ID);

    public static final ResourceLocation STILL_OIL_TEXTURE = new ResourceLocation("block/water_still");
    public static final ResourceLocation FLOWING_OIL_TEXTURE = new ResourceLocation("block/water_flow");

    public static RegistryObject<FlowingFluid> obsidianFluid = FLUIDS.register("obsidian_fluid",
            () -> new ForgeFlowingFluid.Source(FluidPropertiesList.OBSIDIAN_FLUID_PROPERTIES));
    public static RegistryObject<FlowingFluid> obsidianFluidFlowing = FLUIDS.register("obsidian_fluid_flowing", () -> new ForgeFlowingFluid.Flowing(FluidPropertiesList.OBSIDIAN_FLUID_PROPERTIES));
}

