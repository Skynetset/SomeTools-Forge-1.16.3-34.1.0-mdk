package com.skynet.sometools.list.item.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

/**
 * GlassJar
 *
 * @program: forge-1.16.3-34.1.0-mdk
 * @author: 1260535819@qq.com
 * @create: 2021-01-13 22:45
 */

public class GlassJar extends Block {
    public GlassJar() {
        super(Properties.create(Material.ROCK).hardnessAndResistance(5).notSolid());
    }
}
