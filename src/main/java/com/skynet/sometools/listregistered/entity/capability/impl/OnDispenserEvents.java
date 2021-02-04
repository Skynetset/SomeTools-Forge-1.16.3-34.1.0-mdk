package com.skynet.sometools.listregistered.entity.capability.impl;

import com.skynet.sometools.listregistered.RegisteredItemList;
import net.minecraft.block.DispenserBlock;
import net.minecraft.dispenser.DefaultDispenseItemBehavior;
import net.minecraft.dispenser.IBlockSource;
import net.minecraft.item.BucketItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

/**
 * TODO ICapabilityEvent   能力注册
 *
 * @program: SomeTools-Forge-1.16.3-34.1.0-mdk
 * @author: 1260535819@qq.com
 * @create: 2021-01-16 18:58
 */
@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class OnDispenserEvents {


    @SubscribeEvent
    public static void onDispenserRegister(FMLCommonSetupEvent event) {
        DispenserBlock.registerDispenseBehavior(() -> RegisteredItemList.obsidian_fluid_bucket,
                new DefaultDispenseItemBehavior() {
                    private final DefaultDispenseItemBehavior dispenseItemBehavior = new DefaultDispenseItemBehavior();

                    /**
                     * Dispense the specified stack, play the dispense sound and spawn particles.
                     */
                    @Override
                    public ItemStack dispenseStack(IBlockSource source, ItemStack stack) {
                        BucketItem bucketitem = (BucketItem) stack.getItem();
                        BlockPos blockpos =
                                source.getBlockPos().offset(source.getBlockState().get(DispenserBlock.FACING));
                        World world = source.getWorld();
                        if (bucketitem.tryPlaceContainedLiquid(null, world, blockpos, null)) {
                            bucketitem.onLiquidPlaced(world, stack, blockpos);
                            return new ItemStack(Items.BUCKET);
                        } else {
                            return this.dispenseItemBehavior.dispense(source, stack);
                        }
                    }
                });
    }
}
