package com.skynet.sometools.list;

import com.skynet.sometools.list.EntityTypeList;
import com.skynet.sometools.list.data.recipes.Recipes;
import com.skynet.sometools.list.entity.capability.ISimpleCapability;
import com.skynet.sometools.list.entity.capability.ISpeedUpCapability;
import com.skynet.sometools.net.NetWorking;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.attributes.GlobalEntityTypeAttributes;
import net.minecraft.nbt.INBT;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.GatherDataEvent;

import javax.annotation.Nullable;

/**
 * ICapabilityEvent   能力注册
 *
 * @program: SomeTools-Forge-1.16.3-34.1.0-mdk
 * @author: 1260535819@qq.com
 * @create: 2021-01-16 18:58
 */
@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
class NoneSideRegistryEvents {

    private NoneSideRegistryEvents() {
    }

    @SubscribeEvent
    public static void dataGen(GatherDataEvent event) {
        event.getGenerator().addProvider(new Recipes(event.getGenerator()));
    }

    @SubscribeEvent
    public static void onSetUpEvent(FMLCommonSetupEvent event) {
        event.enqueueWork(NetWorking::registerMessage);

        event.enqueueWork(() -> {
            /*
              在FMLCommonSetupEvent这个事件中为实体添加了属性，必须放在event.enqueueWork中。

              GlobalEntityTypeAttributes.put有两个参数，
              第一个参数是EntityType   第二个就是这个实体应该有哪些属性，以及这些属性的默认值是什么，
              这里调用了createMutableAttribute
              添加了一个属性即Attributes.MAX_HEALTH，并且设置了默认值是100，这样生物默认就是100点的血量。
              @param event
             */
            GlobalEntityTypeAttributes.put(EntityTypeList.OBSIDIAN_ANIMAL_ENTITY,
                    MobEntity.func_233666_p_().createMutableAttribute(Attributes.MAX_HEALTH, 100.0D).create());

            CapabilityManager.INSTANCE.register(
                    ISimpleCapability.class,
                    new Capability.IStorage<ISimpleCapability>() {
                        @Nullable
                        @Override
                        public INBT writeNBT(Capability<ISimpleCapability> capability, ISimpleCapability instance,
                                             Direction side) {
                            return null;
                        }

                        @Override
                        public void readNBT(Capability<ISimpleCapability> capability, ISimpleCapability instance,
                                            Direction side, INBT nbt) {
                        }
                    },
                    () -> null
            );
            CapabilityManager.INSTANCE.register(
                    ISpeedUpCapability.class,
                    new Capability.IStorage<ISpeedUpCapability>() {
                        @Nullable
                        @Override
                        public INBT writeNBT(Capability<ISpeedUpCapability> capability, ISpeedUpCapability instance,
                                             Direction side) {
                            return null;
                        }

                        @Override
                        public void readNBT(Capability<ISpeedUpCapability> capability, ISpeedUpCapability instance,
                                            Direction side, INBT nbt) {

                        }
                    },
                    () -> null
            );
        });
    }
}
