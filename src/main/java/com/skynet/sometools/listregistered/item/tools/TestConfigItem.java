package com.skynet.sometools.listregistered.item.tools;

import com.skynet.sometools.common.Utils;
import com.skynet.sometools.config.Config;
import com.skynet.sometools.listregistered.item.SomeToolsGroup;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;

/**
 * TestConfigItem
 *
 * @program: SomeTools-Forge-1.16.3-34.1.0-mdk
 * @author: 1260535819@qq.com
 * @create: 2021-01-17 22:17
 */

public class TestConfigItem extends Item {
    public TestConfigItem() {
        super(new Properties().group(SomeToolsGroup.TOOLS_GROUP));
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
        if (!worldIn.isRemote) {
            playerIn.sendMessage(new TranslationTextComponent("message." + Utils.MOD_ID + ".config",
                    Config.VALUE.get()), playerIn.getUniqueID());
        }
        return super.onItemRightClick(worldIn, playerIn, handIn);
    }

}
