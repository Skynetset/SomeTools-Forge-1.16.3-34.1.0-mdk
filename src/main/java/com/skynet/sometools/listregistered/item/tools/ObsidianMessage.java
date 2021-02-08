package com.skynet.sometools.listregistered.item.tools;

import com.skynet.sometools.listregistered.item.SomeToolsGroup;
import com.skynet.sometools.net.NetWorking;
import com.skynet.sometools.net.data.SendPack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.PacketDistributor;

/**
 * ObsidianMessage
 *
 * @program: SomeTools-Forge-1.16.3-34.1.0-mdk
 * @author: 1260535819@qq.com
 * @create: 2021-01-16 17:03
 */

public class ObsidianMessage extends Item {
    public ObsidianMessage() {
        super(new Properties().group(SomeToolsGroup.TOOLS_GROUP));
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
        if (worldIn.isRemote) {
            NetWorking.INSTANCE.sendToServer(new SendPack("From the Client"));
        }
        if (!worldIn.isRemote) {
            NetWorking.INSTANCE.send(
                    PacketDistributor.PLAYER.with(
                            () -> (ServerPlayerEntity) playerIn
                    ),
                    new SendPack("From Server"));
        }
        return super.onItemRightClick(worldIn, playerIn, handIn);
    }
}

