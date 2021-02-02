package com.skynet.sometools.listregistered.item.blocks;

import com.skynet.sometools.listregistered.tileentities.MyChestWithContainerTileEntity;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.IWaterLoggable;
import net.minecraft.block.material.Material;
import net.minecraft.entity.monster.piglin.PiglinTasks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.stats.Stat;
import net.minecraft.stats.Stats;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

import javax.annotation.Nullable;

/**
 * TODO
 *
 * @program: SomeTools-Forge-1.16.3-34.1.0-mdk
 * @author: 1260535819@qq.com
 * @create: 2021-01-17 12:29
 */


public class MyChestWithContainerBlock extends Block implements IWaterLoggable {

    public MyChestWithContainerBlock() {
        super(Properties.create(Material.ROCK).hardnessAndResistance(5));
    }

    @Override
    public boolean hasTileEntity(BlockState state) {
        return true;
    }

    @Nullable
    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world) {
        return new MyChestWithContainerTileEntity();
    }

    @Override
    public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
        if (worldIn.isRemote) {
            return ActionResultType.SUCCESS;
        } else {
            if (!worldIn.isRemote && handIn == Hand.MAIN_HAND) {
                MyChestWithContainerTileEntity myChestWithContainerTileEntity = (MyChestWithContainerTileEntity) worldIn.getTileEntity(pos);
                player.openContainer(myChestWithContainerTileEntity);
                player.addStat(this.getOpenStat());
                PiglinTasks.func_234478_a_(player, true);
//                NetworkHooks.openGui((ServerPlayerEntity) player, myChestWithContainerTileEntity, (PacketBuffer packerBuffer) -> {
//                    packerBuffer.writeBlockPos(myChestWithContainerTileEntity.getPos());
//                });
            }

            return ActionResultType.CONSUME;
        }
    }

    protected Stat<ResourceLocation> getOpenStat() {
        return Stats.CUSTOM.get(Stats.OPEN_CHEST);
    }
}
