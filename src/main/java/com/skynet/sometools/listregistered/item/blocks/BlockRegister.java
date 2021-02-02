// package com.skynet.sometools.item.blocks;
//
// import com.skynet.sometools.common.Utils;
// import com.skynet.sometools.item.fluid.FluidRegister;
// import net.minecraft.block.Block;
// import net.minecraft.block.FlowingFluidBlock;
// import net.minecraft.block.material.Material;
// import net.minecraftforge.fml.RegistryObject;
// import net.minecraftforge.registries.DeferredRegister;
// import net.minecraftforge.registries.ForgeRegistries;
//
//
// /**
//  * TODO BlockRegister
//  *
//  * @program: forge-1.16.3-34.1.0-mdk
//  * @author: 1260535819@qq.com
//  * @create: 2021-01-13 21:22
//  */
//
//
// public class BlockRegister {
//     public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Utils
//     .MOD_ID);
//
//     public static final RegistryObject<Block> OBSIDIAN_BLOCK = BLOCKS.register("obsidian_block", ObsidianBlock::new);
//     public static final RegistryObject<Block> OBSIDIAN_RUBIK_CUBE = BLOCKS.register("obsidian_rubik_cube",
//     ObsidianRubikCube::new);
//     public static final RegistryObject<Block> OBSIDIAN_FRAME = BLOCKS.register("obsidian_frame", ObsidianFrame::new);
//     public static final RegistryObject<GlassJar> GLASS_JAR = BLOCKS.register("glass_jar", GlassJar::new);
//     public static final RegistryObject<Block> OBSIDIAN_OBJ = BLOCKS.register("obsidian_obj", ObsidianOBJ::new);
//
//     public static final RegistryObject<Block> OBSIDIAN_COUNTER = BLOCKS.register("obsidian_counter_block",
//     ObsidianCounter::new);
//     public static final RegistryObject<Block> OBSIDIAN_HELLO = BLOCKS.register("obsidian_hello_block",
//     ObsidianHelloBlock::new);
//     public static final RegistryObject<Block> OBSIDIAN_ZOMBIE_BLOCK = BLOCKS.register("obsidian_zombie_block",
//             ObsidianZombieBlock::new);
//     public static final RegistryObject<Block> OBSIDIAN_HIDDEN_BLOCK = BLOCKS.register("obsidian_hidden_block",
//             ObsidianHiddenBlock::new);
//     public static final RegistryObject<Block> OBSIDIAN_TER_BLOCK = BLOCKS.register("obsidian_ter_block",
//             ObsidianTERBlock::new);
//     public static final RegistryObject<Block> OBSIDIAN_UP_BLOCK = BLOCKS.register("obsidian_up_block",
//             ObsidianUpBlock::new);
//     public static final RegistryObject<Block> OBSIDIAN_DOWN_BLOCK = BLOCKS.register("obsidian_down_block",
//             ObsidianDownBlock::new);
//     public static final RegistryObject<Block> OBSIDIAN_TRASH_BLOCK = BLOCKS.register("obsidian_trash_block",
//             ObsidianTrashBlock::new);
//     public static final RegistryObject<Block> OBSIDIAN_ITEM_SAVE_BLOCK = BLOCKS.register("obsidian_item_save",
//             ObsidianItemSaveBlock::new);
//     public static final RegistryObject<Block> OBSIDIAN_FIRST_CONTAINER_BLOCK = BLOCKS.register
//     ("obsidian_first_container",
//             ObsidianFirstContainerBlock::new);
//     public static final RegistryObject<Block> MY_CHEST_WITH_CONTAINER_BLOCK = BLOCKS.register(
//             "my_chest_with_container",
//             MyChestWithContainerBlock::new);
//
//     public static final RegistryObject<FlowingFluidBlock> OBSIDIAN_FLUID_BLOCK = BLOCKS.register(
//             "obsidian_fluid",() -> new FlowingFluidBlock(FluidRegister.obsidianFluid, Block.Properties.create
//             (Material.WATER).doesNotBlockMovement().hardnessAndResistance(100.0F).noDrops()));
// }
