package com.skynet.sometools.item.food;

import com.skynet.sometools.SomeToolsGroup;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;

/**
 * TODO ObsidianApple
 *
 * @program: forge-1.16.3-34.1.0-mdk
 * @author: 1260535819@qq.com
 * @create: 2021-01-13 15:31
 */

public class ObsidianApple extends Item {
    public static final Food FOOD=(new Food.Builder())
            .saturation(10)
            .hunger(20)
            .effect(()->new EffectInstance(Effects.LUCK,30*20,999),1)
            .effect(()->new EffectInstance(Effects.NIGHT_VISION,30*20,999),1)
            .build();
    public ObsidianApple() {
        super(new Properties().food(FOOD).group(SomeToolsGroup.foodGroup));
    }
}
