package com.skynet.sometools.listregistered.item.tools;

import com.skynet.sometools.listregistered.entity.capability.ISpeedUpCapability;
import com.skynet.sometools.listregistered.entity.capability.SomeToolsCapability;
import com.skynet.sometools.listregistered.item.SomeToolsGroup;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.common.util.LazyOptional;

/**
 * ObsidianSpeedUpShowItem
 *
 * @program: SomeTools-Forge-1.16.3-34.1.0-mdk
 * @author: 1260535819@qq.com
 * @create: 2021-01-16 21:39
 */

public class ObsidianSpeedUpShowItem extends Item {
    public ObsidianSpeedUpShowItem() {
        super(new Properties().group(SomeToolsGroup.TOOLS_GROUP));
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
        if (!worldIn.isRemote && handIn == Hand.MAIN_HAND) {
            LazyOptional<ISpeedUpCapability> speedCap = playerIn.getCapability(SomeToolsCapability.SPEED_UP_CAPABILITY);
            speedCap.ifPresent((l) -> {
                        int level = l.getLevel();
                        playerIn.sendMessage(new TranslationTextComponent("message.obsidian_speed_show", level),
                                playerIn.getUniqueID());
                    }
            );
        }
        return super.onItemRightClick(worldIn, playerIn, handIn);
    }
}

