package com.skynet.sometools.server.worldgen;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

/**
 * OreGen
 *
 * @program: SomeTools-Forge-1.16.3-34.1.0-mdk
 * @author: 1260535819@qq.com
 * @create: 2021-01-30 10:11
 */

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class OreGen {
    /**
     * 世界生成都是服务端的行为，这里需要订阅FMLCommonSetupEvent事件。
     * <p>
     * 通过ForgeRegistries.BIOMES获取所有注册好的生物群系，
     * 并且调用biome.generateFeatures向生物群系中添加Feature（矿物）。
     * Feature有不同的阶段，这里GenerationStage.Decoration.UNDERGROUND_ORES代表矿物生成阶段。
     * 然后通过Feature.ORE.withConfiguration来创建一个矿物生成的Feature。
     *
     * @param event :
     *
     * @return : void
     *
     * @author : 1260535819@qq.com
     * @date : 2021/1/30 10:15
     */
    @SubscribeEvent
    public static void onSetUpEvent(FMLCommonSetupEvent event) {
        // for (Biome biome : ForgeRegistries.BIOMES) {
        //     biome.generateFeatures(GenerationStage.Decoration.UNDERGROUND_ORES,
        //             /**
        //              * Feature.ORE.withConfiguration需要传入一个OreFeatureConfig用来配置矿物生成Feature,
        //              * 因为是在主世界生成矿物，所以第一个参数填入的是OreFeatureConfig.FillerBlockType.NATURAL_STONE，
        //              * 第二个参数指定要生成方块的默认状态，这里选择生成之前创建的黑曜石方块，
        //              * 第三个参数控制了每次生成的最大数量。
        //              *
        //              * 现在矿物还没发生成，因为还没有指定矿物需要生成在哪里，生成几次。这就是withPlacement的作用。
        //              * 传入一个Placement，这个Placement用来控制Feature需要生成在哪里，
        //              * 原版提供了很多的Placement，这里使用Placement.COUNT_DEPTH_AVERAGE，
        //              * 调用它的configure的方法，里面传入一个DepthAverageConfig，
        //              * @author : 1260535819@qq.com
        //              * @date : 2021/1/30 10:22
        //              * @param event :
        //              * @return : void
        //              */
        //             Feature.ORE.withConfiguration(
        //                     new OreFeatureConfig(OreFeatureConfig.FillerBlockType.field_241882_a,
        //                             BlockRegister.OBSIDIAN_BLOCK.get().getDefaultState(),
        //                             3)
        //             ).withPlacement(Placement.field_242910_o.configure(new DepthAverageConfig(50,100)),
        //                     new ConfiguredPlacement<>(),);
        // }
    }
}

