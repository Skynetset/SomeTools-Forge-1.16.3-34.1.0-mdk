package com.skynet.sometools.list.data.recipes;

import com.skynet.sometools.list.ItemList;
import net.minecraft.advancements.criterion.InventoryChangeTrigger;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.IFinishedRecipe;
import net.minecraft.data.ShapedRecipeBuilder;
import net.minecraft.item.Items;
import net.minecraftforge.common.data.ForgeRecipeProvider;

import java.util.function.Consumer;

/**
 * Recipes
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
        ShapedRecipeBuilder.shapedRecipe(ItemList.OBSIDIAN_WRENCH)
                .patternLine("III")
                .patternLine(" G ")
                .patternLine(" G ")
                .key('I', Items.IRON_INGOT)
                .key('G', Items.GOLD_INGOT)
                .addCriterion("iron_ingot", InventoryChangeTrigger.Instance.forItems(Items.IRON_INGOT,
                        Items.GOLD_INGOT))
                .build(consumer);
        ShapedRecipeBuilder.shapedRecipe(ItemList.OBSIDIAN_BLOCK)
                .patternLine("III")
                .patternLine("III")
                .patternLine("III")
                .key('I', ItemList.OBSIDIAN_INGOT)
                .addCriterion("obsidian_ingot",
                        InventoryChangeTrigger.Instance.forItems(ItemList.OBSIDIAN_INGOT))
                .build(consumer);
        ShapedRecipeBuilder.shapedRecipe(ItemList.OBSIDIAN_INGOT)
                .patternLine("I  ")
                .key('I', ItemList.OBSIDIAN_BLOCK)
                .addCriterion("obsidian_block",
                        InventoryChangeTrigger.Instance.forItems(ItemList.OBSIDIAN_BLOCK))
                .build(consumer);
    }
}
