package com.skynet.sometools.listregistered;

import com.skynet.sometools.common.Utils;
import com.skynet.sometools.listregistered.iparticle.ObsidianParticleData;
import net.minecraft.particles.ParticleType;
import net.minecraftforge.registries.ObjectHolder;

/**
 * TODO ParticleList
 *
 * @program: SomeTools-Forge-1.16.3-34.1.0-mdk
 * @author: 1260535819@qq.com
 * @create: 2021-01-30 12:44
 */

@ObjectHolder(Utils.MOD_ID)
public class RegisteredParticleList {
    @ObjectHolder("obsidian_particle")
    public static final ParticleType<ObsidianParticleData> OBSIDIAN_PARTICLE = null;
}
