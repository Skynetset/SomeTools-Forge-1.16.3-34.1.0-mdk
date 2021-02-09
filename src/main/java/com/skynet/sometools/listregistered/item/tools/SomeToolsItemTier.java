package com.skynet.sometools.listregistered.item.tools;

import com.skynet.sometools.list.ItemList;
import net.minecraft.item.IItemTier;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.LazyValue;

import java.util.function.Supplier;

/**
 * itemTier
 *
 * @program: forge-1.16.3-34.1.0-mdk
 * @author: 1260535819@qq.com
 * @create: 2021-01-13 15:58
 */

public enum SomeToolsItemTier implements IItemTier {
    /**
     * 新增黑曜石等级
     *
     * @author : 1260535819@qq.com
     * @date : 2021/1/13 16:06
     * @param null :
     * @return : null
     */
    OBSIDIAN(3, 2000, 10.0F, 4.0F, 30, () -> {
        return Ingredient.fromItems(ItemList.OBSIDIAN_INGOT);
    });

    private final int harvestLevel;
    private final int maxUses;
    // 挖掘速度
    private final float efficiency;
    private final float attackDamage;
    private final int enchantAbility;
    private final LazyValue<Ingredient> repairMaterial;

    SomeToolsItemTier(int harvestLevelIn, int maxUsesIn, float efficiencyIn, float attackDamageIn,
                      int enchantAbilityIn, Supplier<Ingredient> repairMaterialIn) {
        this.harvestLevel = harvestLevelIn;
        this.maxUses = maxUsesIn;
        this.efficiency = efficiencyIn;
        this.attackDamage = attackDamageIn;
        this.enchantAbility = enchantAbilityIn;
        this.repairMaterial = new LazyValue<>(repairMaterialIn);
    }

    @Override
    public int getMaxUses() {
        return maxUses;
    }

    @Override
    public float getEfficiency() {
        return efficiency;
    }

    @Override
    public float getAttackDamage() {
        return attackDamage;
    }

    @Override
    public int getHarvestLevel() {
        return harvestLevel;
    }

    @Override
    public int getEnchantability() {
        return enchantAbility;
    }

    @Override
    public Ingredient getRepairMaterial() {
        return repairMaterial.getValue();
    }
}
