package com.skynet.sometools.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

/**
 * TODO ObsidianHiddenBlock
 *
 * @program: forge-1.16.3-34.1.0-mdk
 * @author: 1260535819@qq.com
 * @create: 2021-01-14 21:34
 */

public class ObsidianHiddenBlock extends Block {
    public ObsidianHiddenBlock() {
        super(Properties.create(Material.ROCK).hardnessAndResistance(5).notSolid());
    }
}
