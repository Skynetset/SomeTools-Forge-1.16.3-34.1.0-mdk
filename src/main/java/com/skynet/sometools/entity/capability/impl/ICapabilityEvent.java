package com.skynet.sometools.entity.capability.impl;

import com.skynet.sometools.entity.capability.ISimpleCapability;
import com.skynet.sometools.entity.capability.ISpeedUpCapability;
import net.minecraft.nbt.INBT;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

import javax.annotation.Nullable;

/**
 * TODO ICapabilityEvent   能力注册
 *
 * @program: SomeTools-Forge-1.16.3-34.1.0-mdk
 * @author: 1260535819@qq.com
 * @create: 2021-01-16 18:58
 */
@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class ICapabilityEvent {
    @SubscribeEvent
    public static void onSetUpEvent(FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
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
