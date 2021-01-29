package com.skynet.sometools.entity.event.attributessetevent;

import com.skynet.sometools.entity.EntityTypeRegister;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.attributes.GlobalEntityTypeAttributes;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

/**
 * TODO AttributesSetEvent
 *
 * @program: SomeTools-Forge-1.16.3-34.1.0-mdk
 * @author: 1260535819@qq.com
 * @create: 2021-01-16 18:04
 */

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class ObsidianAnimalEvent {
    /**
     * 在FMLCommonSetupEvent这个事件中为实体添加了属性，这里的内容必须放在event.enqueueWork中。
     *
     * GlobalEntityTypeAttributes.put有两个参数，
     * 第一个参数是EntityType而第二个就是这个实体应该有哪些属性，以及这些属性的默认值是什么，
     * 这里我们调用了createMutableAttribute
     * 添加了一个属性即Attributes.MAX_HEALTH，并且设置了默认值是100，这样生物默认就是100点的血量。
     * @param event
     */
    @SubscribeEvent
    public static void setupAttributes(FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            GlobalEntityTypeAttributes.put(EntityTypeRegister.OBSIDIAN_ANIMAL_ENTITY.get(),
                    MobEntity.func_233666_p_().createMutableAttribute(Attributes.MAX_HEALTH, 100.0D).create());
        });
    }
}
