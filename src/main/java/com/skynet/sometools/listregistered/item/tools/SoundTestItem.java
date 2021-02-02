package com.skynet.sometools.listregistered.item.tools;

import com.skynet.sometools.listregistered.RegisteredSounds;
import com.skynet.sometools.listregistered.item.SomeToolsGroup;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.world.World;

/**
 * TODO SoundTestItem
 *
 * @program: SomeTools-Forge-1.16.3-34.1.0-mdk
 * @author: 1260535819@qq.com
 * @create: 2021-01-28 07:10
 */

public class SoundTestItem extends Item {
    public SoundTestItem() {
        super(new Properties().group(SomeToolsGroup.TOOLS_GROUP));
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
        if (worldIn.isRemote) {
            worldIn.playSound(playerIn, playerIn.getPosition(), RegisteredSounds.MEA_SOUND,
                    SoundCategory.AMBIENT, 10f, 1f);
        }
        return super.onItemRightClick(worldIn, playerIn, handIn);
    }
}

