package com.skynet.sometools.list.item.tools;

import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.skynet.sometools.common.Utils;
import com.skynet.sometools.list.item.SomeToolsGroup;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.IClearable;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraft.world.gen.blockplacer.SimpleBlockPlacer;
import net.minecraft.world.server.ServerWorld;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * SoundTestItem
 *
 * @program: SomeTools-Forge-1.16.3-34.1.0-mdk
 * @author: 1260535819@qq.com
 * @create: 2021-01-28 07:10
 */

public class ChunkReplaceCenterItem extends Item {
    public ChunkReplaceCenterItem() {
        super(new Properties().group(SomeToolsGroup.TOOLS_GROUP));
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
        String text = "";

        //服务端
        if (!worldIn.isRemote) {
            BlockPos position = playerIn.getPosition();
            text = String.format("Chunk: %d %d %d in %d %d %d", position.getX() & 15, position.getY() & 15,
                    position.getZ() & 15, position.getX() >> 4, position.getY() >> 4, position.getZ() >> 4);
            playerIn.sendMessage(new TranslationTextComponent(text), playerIn.getUniqueID());

            ItemStack itemStack = playerIn.getHeldItemOffhand();
            PlayerInventory playerInventory = playerIn.inventory;
            List<Integer> allSlot = Utils.getAllSlot(playerInventory, itemStack);
            int countOfStack = Utils.getTotalCountOfStack(playerInventory, allSlot);
            List<BlockPos> poins = findChunkMainPoins(position, false);

            if (countOfStack < 1) {
                text = "副手中可用于替换的方块数量不够，请查看副手方块";
            } else {
                poins.forEach(pos -> {
                    ItemStack stackInSlot = playerInventory.getStackInSlot(allSlot.get(0));
                    if (stackInSlot.isEmpty()) {
                        playerInventory.removeStackFromSlot(allSlot.get(0));
                    } else {
                        try {
                            int inSlotCount = stackInSlot.getCount();
                            setBlock(worldIn.getServer().getWorld(playerIn.getEntityWorld().getDimensionKey()), pos,
                                    Block.getBlockFromItem(stackInSlot.getItem()).getDefaultState(), false);
                            stackInSlot.setCount(--inSlotCount);
                        } catch (CommandSyntaxException commandSyntaxException) {
                            commandSyntaxException.printStackTrace();
                        }
                    }
                    allSlot.removeIf(e -> playerInventory.getStackInSlot(e).isEmpty());
                });
            }

        }

        // if (worldIn.isRemote) {
        //     worldIn.playSound(playerIn, playerIn.getPosition(), SoundList.MEA_SOUND,
        //             SoundCategory.AMBIENT, 10f, 1f);
        // }
        playerIn.sendMessage(new TranslationTextComponent(text), playerIn.getUniqueID());
        return super.onItemRightClick(worldIn, playerIn, handIn);
    }


    private static int setBlock(ServerWorld serverworld, BlockPos pos, BlockState state, Boolean isDestroy) throws CommandSyntaxException {
        boolean flag;
        if (isDestroy) {
            serverworld.destroyBlock(pos, true);
            flag = !state.isAir() || !serverworld.getBlockState(pos).isAir();
        } else {
            TileEntity tileentity = serverworld.getTileEntity(pos);
            IClearable.clearObj(tileentity);
            flag = true;
        }
        SimpleBlockPlacer blockPlacer = new SimpleBlockPlacer();
        blockPlacer.place(serverworld, pos, state, new Random());

        serverworld.func_230547_a_(pos, state.getBlock());
        return 1;
    }


    /**
     * check all Pos
     *
     * @param position :
     * @param isODD    : 是否奇数 奇数 1-15 ，偶数 1-16 default 1-15
     *
     * @return : java.util.List<net.minecraft.util.math.BlockPos>
     *
     * @author : 1260535819@qq.com
     * @date : 2021/2/7 21:18
     */
    private static List<BlockPos> findChunkMainPoins(BlockPos position, Boolean isODD) {
        Integer maxSize = 14;
        if (Utils.isNotEmpty(isODD) && !isODD) {
            maxSize = 15;
        }

        List<BlockPos> blockPos = new ArrayList<>();
        int xZeroOfChunk = position.getX() - (position.getX() & 15);
        int zZeroOfChunk = position.getZ() - (position.getZ() & 15);
        int lowerY = position.getY() - 1;
        BlockPos southWestPos = new BlockPos(xZeroOfChunk, lowerY, zZeroOfChunk);
        /**
         * (numX == i && numZ == j) ||
         * ((i & 15) == (j & 15)) ||
         * ((i & 15) == 15 - (j & 15)) ||
         * (numX + 1 == i && numZ == j) ||
         * (numX == i && numZ + 1 == j) ||
         *  ++
         *  +
         */
        blockPos.add(southWestPos);
        blockPos.add(southWestPos.east(1));
        blockPos.add(southWestPos.south(1));

        /**
         *  (numX + 15 == i && numZ == j) ||
         *  (numX + 15 - 1 == i && numZ == j) ||
         *  (numX + 15 == i && numZ + 1 == j) ||
         *        ++
         *         +
         */
        blockPos.add(southWestPos.east(maxSize - 1));
        blockPos.add(southWestPos.east(maxSize));
        blockPos.add(southWestPos.east(maxSize).south(1));

        /**
         * (numX + 15 == i && numZ + 15 == j) ||
         * (numX + 15 - 1 == i && numZ + 15 == j) ||
         * (numX + 15 == i && numZ + 15 - 1 == j) ||
         *        +
         *       ++
         */
        blockPos.add(southWestPos.east(maxSize).south(maxSize - 1));
        blockPos.add(southWestPos.east(maxSize).south(maxSize));
        blockPos.add(southWestPos.east(maxSize - 1).south(maxSize));

        /**
         * (numX == i && numZ + 15 == j) ||
         * (numX + 1 == i && numZ + 15 == j) ||
         * (numX == i && numZ + 15 - 1 == j) ||
         * +
         * ++
         */
        blockPos.add(southWestPos.south(maxSize - 1));
        blockPos.add(southWestPos.south(maxSize));
        blockPos.add(southWestPos.south(maxSize).east(1));


        if (Utils.isNotEmpty(isODD) && !isODD) {
            /**
             * (numX + 7 == i && numZ + 7 == j) ||
             * (numX + 7 + 1 == i && numZ + 7 == j) ||
             * (numX + 7 == i && numZ + 7 + 1 == j) ||
             * (numX + 7 + 1 == i && numZ + 7 + 1 == j)
             *       ++
             *       ++
             */
            blockPos.add(southWestPos.east(maxSize >> 1).south(maxSize >> 1));
            blockPos.add(southWestPos.east((maxSize >> 1) + 1).south(maxSize >> 1));
            blockPos.add(southWestPos.east(maxSize >> 1).south((maxSize >> 1) + 1));
            blockPos.add(southWestPos.east((maxSize >> 1) + 1).south((maxSize >> 1) + 1));
        } else {
            /**
             *       +
             */
            blockPos.add(southWestPos.east(maxSize >> 1).south((maxSize >> 1) + 1));
        }
        return blockPos;
    }
}

