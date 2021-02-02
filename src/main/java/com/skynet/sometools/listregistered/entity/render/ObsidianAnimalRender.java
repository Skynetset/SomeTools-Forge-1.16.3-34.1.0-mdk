package com.skynet.sometools.listregistered.entity.render;

import com.skynet.sometools.common.Utils;
import com.skynet.sometools.listregistered.entity.ObsidianAnimalEntity;
import com.skynet.sometools.listregistered.entity.model.ObsidianAnimalModel;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

/**
 * ObsidianAnimalRender
 * 直接继承了MobRenderer来自动的渲染一些类似于影子的东西。
 * 之所以这里有两个构造函数是因为，当注册Render的时候，Lambda表达式里只给了一个参数，
 * 虽然也可以把预设的内容写在Lambda表达式里，
 * 但是如果那样干了就没法简化代码了，所以这里就额外添加了一个构造函数。
 * <p>
 * 这里构造函数的第二个参数是你的动物的模型，第三个参数是影子的大小。
 *
 * @program: SomeTools-Forge-1.16.3-34.1.0-mdk
 * @author: 1260535819@qq.com
 * @create: 2021-01-16 18:13
 */

public class ObsidianAnimalRender extends MobRenderer<ObsidianAnimalEntity, ObsidianAnimalModel> {

    public ObsidianAnimalRender(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new ObsidianAnimalModel(), 1F);
    }

    public ObsidianAnimalRender(EntityRendererManager renderManagerIn, ObsidianAnimalModel entityModelIn,
                                float shadowSizeIn) {
        super(renderManagerIn, entityModelIn, shadowSizeIn);
    }

    @Override
    public ResourceLocation getEntityTexture(ObsidianAnimalEntity entity) {
        return new ResourceLocation(Utils.MOD_ID, "textures/entity/obsidian_animal.png");
    }
}

