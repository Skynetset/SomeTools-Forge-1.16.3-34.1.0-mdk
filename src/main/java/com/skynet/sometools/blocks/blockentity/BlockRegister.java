package com.skynet.sometools.blocks.blockentity;

import com.skynet.sometools.blocks.*;
import net.minecraft.block.Block;
import net.minecraftforge.fml.RegistryObject;

import static com.skynet.sometools.register.SomeRegister.BLOCKS;

/**
 * TODO BlockRegister
 *
 * @program: forge-1.16.3-34.1.0-mdk
 * @author: 1260535819@qq.com
 * @create: 2021-01-13 21:22
 */

public class BlockRegister {
    public static final RegistryObject<Block> OBSIDIAN_BLOCK = BLOCKS.register("obsidian_block", ObsidianBlock::new);
    public static final RegistryObject<Block> OBSIDIAN_RUBIK_CUBE = BLOCKS.register("obsidian_rubik_cube", ObsidianRubikCube::new);
    public static final RegistryObject<Block> OBSIDIAN_FRAME = BLOCKS.register("obsidian_frame", ObsidianFrame::new);
    public static final RegistryObject<GlassJar> GLASS_JAR = BLOCKS.register("glass_jar", GlassJar::new);
    public static final RegistryObject<Block> OBSIDIAN_OBJ = BLOCKS.register("obsidian_obj", ObsidianOBJ::new);

    public static final RegistryObject<Block> OBSIDIAN_COUNTER = BLOCKS.register("obsidian_counter_block", ObsidianCounter::new);
    public static final RegistryObject<Block> OBSIDIAN_HELLO = BLOCKS.register("obsidian_hello_block", ObsidianHelloBlock::new);
    public static final RegistryObject<Block> OBSIDIAN_ZOMBIE_BLOCK = BLOCKS.register("obsidian_zombie_block",
            ObsidianZombieBlock::new);
    public static final RegistryObject<Block> OBSIDIAN_HIDDEN_BLOCK = BLOCKS.register("obsidian_hidden_block",
            ObsidianHiddenBlock::new);
    public static final RegistryObject<Block> OBSIDIAN_TER_BLOCK = BLOCKS.register("obsidian_ter_block",
            ObsidianTERBlock::new);
}
