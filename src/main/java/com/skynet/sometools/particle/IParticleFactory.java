package com.skynet.sometools.particle;

import com.skynet.sometools.particle.iparticle.ObsidianParticleData;
import net.minecraft.client.particle.IAnimatedSprite;
import net.minecraft.client.particle.IParticleFactory;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.world.ClientWorld;

/**
 * TODO IParticleFactory
 *
 * @program: SomeTools-Forge-1.16.3-34.1.0-mdk
 * @author: 1260535819@qq.com
 * @create: 2021-01-27 20:24
 */

class ObsidianParticleFactory implements IParticleFactory<ObsidianParticleData> {
    private final IAnimatedSprite sprites;

    public ObsidianParticleFactory(IAnimatedSprite sprite) {
        this.sprites = sprite;
    }

    @Override
    public Particle makeParticle(ObsidianParticleData typeIn, ClientWorld worldIn, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed) {
        ObsidianParticle particle = new ObsidianParticle(worldIn, x, y, z, typeIn.getSpeed(), typeIn.getColor(), typeIn.getDiameter());
        particle.selectSpriteRandomly(sprites);
        return particle;
    }
}

