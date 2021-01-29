package com.skynet.sometools.particle;

import com.skynet.sometools.common.Utils;
import com.skynet.sometools.particle.iparticle.ObsidianParticleData;
import net.minecraft.particles.ParticleType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

/**
 * TODO ParticleRegister
 *
 * @program: SomeTools-Forge-1.16.3-34.1.0-mdk
 * @author: 1260535819@qq.com
 * @create: 2021-01-27 20:23
 */

public class ParticleRegister {
    public static final DeferredRegister<ParticleType<?>> PARTICLE_TYPES = DeferredRegister.create(ForgeRegistries.PARTICLE_TYPES, Utils.MOD_ID);
    public static final RegistryObject<ParticleType<ObsidianParticleData>> OBSIDIAN_PARTICLE = PARTICLE_TYPES.register("obsidian_particle", ObsidianParticleType::new);
}
