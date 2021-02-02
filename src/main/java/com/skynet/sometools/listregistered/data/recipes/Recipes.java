package com.skynet.sometools.listregistered.data.recipes;

import com.skynet.sometools.listregistered.RegisteredItemList;
import net.minecraft.advancements.criterion.InventoryChangeTrigger;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.IFinishedRecipe;
import net.minecraft.data.ShapedRecipeBuilder;
import net.minecraft.item.Items;
import net.minecraftforge.common.data.ForgeRecipeProvider;

import java.util.function.Consumer;

/**
 * TODO Recipes
 *
 * @program: SomeTools-Forge-1.16.3-34.1.0-mdk
 * @author: 1260535819@qq.com
 * @create: 2021-01-17 18:56
 */

public class Recipes extends ForgeRecipeProvider {
    public Recipes(DataGenerator generatorIn) {
        super(generatorIn);
    }

    @Override
    protected void registerRecipes(Consumer<IFinishedRecipe> consumer) {
        ShapedRecipeBuilder.shapedRecipe(RegisteredItemList.obsidian_wrench)
                .patternLine("III")
                .patternLine(" G ")
                .patternLine(" G ")
                .key('I', Items.IRON_INGOT)
                .key('G', Items.GOLD_INGOT)
                .addCriterion("iron_ingot", InventoryChangeTrigger.Instance.forItems(Items.IRON_INGOT, Items.GOLD_INGOT))
                .build(consumer);
        ShapedRecipeBuilder.shapedRecipe(RegisteredItemList.obsidian_block)
                .patternLine("III")
                .patternLine("III")
                .patternLine("III")
                .key('I', RegisteredItemList.obsidian_ingot)
                .addCriterion("obsidian_ingot", InventoryChangeTrigger.Instance.forItems(RegisteredItemList.obsidian_ingot))
                .build(consumer);
        ShapedRecipeBuilder.shapedRecipe(RegisteredItemList.obsidian_ingot)
                .patternLine("I  ")
                .key('I', RegisteredItemList.obsidian_block)
                .addCriterion("obsidian_block", InventoryChangeTrigger.Instance.forItems(RegisteredItemList.obsidian_block))
                .build(consumer);
    }
}
