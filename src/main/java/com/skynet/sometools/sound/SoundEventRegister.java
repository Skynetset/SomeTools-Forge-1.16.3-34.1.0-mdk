package com.skynet.sometools.sound;

import com.skynet.sometools.common.Utils;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

/**
 * TODO SoundEventRegister
 *
 * @program: SomeTools-Forge-1.16.3-34.1.0-mdk
 * @author: 1260535819@qq.com
 * @create: 2021-01-28 07:07
 */

public class SoundEventRegister {
    public static final DeferredRegister<SoundEvent> SOUNDS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, Utils.MOD_ID);
    public static final RegistryObject<SoundEvent> MEA_SOUND = SOUNDS.register("mea", () -> new SoundEvent(new ResourceLocation(Utils.MOD_ID, "mea")));
}
