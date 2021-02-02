package com.skynet.sometools.client.particle;

import com.mojang.serialization.Codec;
import com.skynet.sometools.listregistered.iparticle.ObsidianParticleData;
import net.minecraft.particles.ParticleType;
import net.minecraft.util.math.vector.Vector3d;

import java.awt.*;

/**
 * TODO ObsidianParticleType
 *
 * @program: SomeTools-Forge-1.16.3-34.1.0-mdk
 * @author: 1260535819@qq.com
 * @create: 2021-01-27 20:22
 */

public class ObsidianParticleType extends ParticleType<ObsidianParticleData> {
    public ObsidianParticleType() {
        super(false, ObsidianParticleData.DESERIALIZER);
    }

    @Override
    public Codec<ObsidianParticleData> func_230522_e_() {
        return Codec.unit(new ObsidianParticleData(new Vector3d(0, 0, 0), new Color(0), 0));
    }
}

