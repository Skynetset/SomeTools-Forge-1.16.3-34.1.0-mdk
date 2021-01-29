package com.skynet.sometools.data.recipes;

import com.skynet.sometools.item.tab.ItemRegister;
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
        ShapedRecipeBuilder.shapedRecipe(ItemRegister.OBSIDIAN_WRENCH.get())
                .patternLine("III")
                .patternLine(" G ")
                .patternLine(" G ")
                .key('I', Items.IRON_INGOT)
                .key('G', Items.GOLD_INGOT)
                .addCriterion("iron_ingot", InventoryChangeTrigger.Instance.forItems(Items.IRON_INGOT, Items.GOLD_INGOT))
                .build(consumer);
        ShapedRecipeBuilder.shapedRecipe(ItemRegister.OBSIDIAN_BLOCK.get())
                .patternLine("III")
                .patternLine("III")
                .patternLine("III")
                .key('I', ItemRegister.OBSIDIAN_INGOT.get())
                .addCriterion("obsidian_ingot", InventoryChangeTrigger.Instance.forItems(ItemRegister.OBSIDIAN_INGOT.get()))
                .build(consumer);
        ShapedRecipeBuilder.shapedRecipe(ItemRegister.OBSIDIAN_INGOT.get())
                .patternLine("I  ")
                .key('I', ItemRegister.OBSIDIAN_BLOCK.get())
                .addCriterion("obsidian_block", InventoryChangeTrigger.Instance.forItems(ItemRegister.OBSIDIAN_BLOCK.get()))
                .build(consumer);
    }
}
