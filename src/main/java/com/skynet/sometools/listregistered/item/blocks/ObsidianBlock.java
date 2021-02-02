package com.skynet.sometools.listregistered.item.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

/**
 * TODO ObsidianBlock
 *
 * @program: forge-1.16.3-34.1.0-mdk
 * @author: 1260535819@qq.com
 * @create: 2021-01-13 21:14
 */

public class ObsidianBlock extends Block {
    public ObsidianBlock() {
        super(Properties.create(Material.ROCK).hardnessAndResistance(5));
    }
}