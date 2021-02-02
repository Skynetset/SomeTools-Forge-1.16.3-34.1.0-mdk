// package com.skynet.sometools.item.fluid;
//
// import com.skynet.sometools.common.Utils;
// import com.skynet.sometools.item.blocks.BlockRegister;
// import com.skynet.sometools.listregistered.RegisteredItemList;
// import net.minecraft.fluid.FlowingFluid;
// import net.minecraft.fluid.Fluid;
// import net.minecraft.util.ResourceLocation;
// import net.minecraftforge.fluids.FluidAttributes;
// import net.minecraftforge.fluids.ForgeFlowingFluid;
// import net.minecraftforge.fml.RegistryObject;
// import net.minecraftforge.registries.DeferredRegister;
// import net.minecraftforge.registries.ForgeRegistries;
//
// /**
//  * TODO FluidRegistry
//  *
//  * @program: SomeTools-Forge-1.16.3-34.1.0-mdk
//  * @author: 1260535819@qq.com
//  * @create: 2021-01-17 17:38
//  */
//
// public class FluidRegister {
//     public static final DeferredRegister<Fluid> FLUIDS = DeferredRegister.create(ForgeRegistries.FLUIDS, Utils
//     .MOD_ID);
//
//     public static final ResourceLocation STILL_OIL_TEXTURE = new ResourceLocation("block/water_still");
//     public static final ResourceLocation FLOWING_OIL_TEXTURE = new ResourceLocation("block/water_flow");
//
//     public static RegistryObject<FlowingFluid> obsidianFluid = FLUIDS.register("obsidian_fluid", () -> new
//     ForgeFlowingFluid.Source(FluidRegister.PROPERTIES));
//     public static RegistryObject<FlowingFluid> obsidianFluidFlowing = FLUIDS.register("obsidian_fluid_flowing", ()
//     -> new ForgeFlowingFluid.Flowing(FluidRegister.PROPERTIES));
//
//     public static ForgeFlowingFluid.Properties PROPERTIES =
//             new ForgeFlowingFluid.Properties(obsidianFluid
//                     , obsidianFluidFlowing
//                     , FluidAttributes
//                     .builder(new ResourceLocation("block/water_still"), new ResourceLocation("block/water_flow"))
//                     .color(0xFF420372)
//                     .density(4000)
//                     .viscosity(4000))
//             .bucket(()->RegisteredItemList.obsidianFluidBucket)
//             .block(BlockRegister.OBSIDIAN_FLUID_BLOCK)
//             .slopeFindDistance(3)
//             .explosionResistance(100F);
// }
//
