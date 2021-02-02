package com.skynet.sometools.listregistered.item.tools.pickaxe;

import com.skynet.sometools.listregistered.item.SomeToolsGroup;
import com.skynet.sometools.listregistered.item.tools.SomeToolsItemTier;
import net.minecraft.block.BlockState;
import net.minecraft.block.material.Material;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.PickaxeItem;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.annotation.Nullable;
import java.util.List;

/**
 * TODO ObsidianPickaxe
 *
 * @program: forge-1.16.3-34.1.0-mdk
 * @author: 1260535819@qq.com
 * @create: 2021-01-13 16:28
 */

public class ObsidianPickaxe extends PickaxeItem {
    private static final Logger LOGGER = LogManager.getLogger();

    public ObsidianPickaxe() {
        super(SomeToolsItemTier.OBSIDIAN, 2, -0.5F, (new Item.Properties()).group(SomeToolsGroup.TOOLS_GROUP));
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip,
                               ITooltipFlag flagIn) {
        tooltip.add(new TranslationTextComponent(""));
        tooltip.add(new TranslationTextComponent("testTips"));
        super.addInformation(stack, worldIn, tooltip, flagIn);
    }

    @Override
    public boolean canHarvestBlock(BlockState blockIn) {
        int i = this.getTier().getHarvestLevel();
        if (blockIn.getHarvestTool() == net.minecraftforge.common.ToolType.PICKAXE) {
            return i >= blockIn.getHarvestLevel();
        }
        Material material = blockIn.getMaterial();
        return material == Material.ROCK || material == Material.IRON || material == Material.ANVIL;
    }

    @Override
    public float getDestroySpeed(ItemStack stack, BlockState state) {
        Material material = state.getMaterial();
        return material != Material.IRON && material != Material.ANVIL && material != Material.ROCK ?
                super.getDestroySpeed(stack, state) : this.efficiency;
    }
}
