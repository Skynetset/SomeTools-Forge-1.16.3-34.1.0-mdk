package com.skynet.sometools.blocks;

import com.skynet.sometools.entity.blockentity.ObsidianCounterTileEntity;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

import javax.annotation.Nullable;

/**
 * TODO ObsidianCounter.java
 *
 * @program: forge-1.16.3-34.1.0-mdk
 * @author: 1260535819@qq.com
 * @create: 2021-01-14 09:19
 */

public class ObsidianCounter extends Block {
    public ObsidianCounter() {
        super(Properties.create(Material.ROCK).hardnessAndResistance(5));
    }

    @Override
    public boolean hasTileEntity(BlockState state) {
        return true;
    }

    @Nullable
    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world) {
        return new ObsidianCounterTileEntity();
    }

    /**
     *
     * @param state
     * @param worldIn
     * @param pos
     * @param player
     * @param handIn
     * @param hit
     * @return
     */
    @Override
    public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
        /**
         * 判断方法是否在服务端调用，任何涉及到数据处理的逻辑都应该在服务端执行
         * 判断了传入的handIn是不是「主手」，之所以要进行这个判断，是因为这个方法两个手都会执行一次。
         */
        if (!worldIn.isRemote && handIn == Hand.MAIN_HAND) {
            /**
             * 在这里通过调用worldIn.getTileEntity方法，获取到我们方块所对应的TileEntity，
             * 一定要通过这个方法调用的原因是，一个方块哪怕绑定了TileEntity，你也不能保证，这个TileEntity是一定存在的。
             */
            ObsidianCounterTileEntity obsidianCounterTileEntity = (ObsidianCounterTileEntity) worldIn.getTileEntity(pos);
            int counter = obsidianCounterTileEntity.increase();
            /**
             * 创建消息键，并在18n中格式化消息
             */
            TranslationTextComponent translationTextComponent = new TranslationTextComponent("message.neutrino.counter", counter);
            /**
             * 向客户端发送消息
             */
            player.sendStatusMessage(translationTextComponent, false);
        }
        return ActionResultType.SUCCESS;
    }
}

