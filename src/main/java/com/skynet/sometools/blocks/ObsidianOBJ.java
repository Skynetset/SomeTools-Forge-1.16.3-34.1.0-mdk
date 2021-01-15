package com.skynet.sometools.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

/**
 * TODO ObsidianOBJ
 *
 * @program: forge-1.16.3-34.1.0-mdk
 * @author: 1260535819@qq.com
 * @create: 2021-01-14 09:02
 */

public class ObsidianOBJ extends Block {
    public ObsidianOBJ() {
        super(Properties.create(Material.ROCK).hardnessAndResistance(5).notSolid());
    }
}

