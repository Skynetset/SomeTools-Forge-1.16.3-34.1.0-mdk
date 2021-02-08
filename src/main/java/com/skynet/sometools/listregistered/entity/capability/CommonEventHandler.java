package com.skynet.sometools.listregistered.entity.capability;

import com.skynet.sometools.common.Utils;
import com.skynet.sometools.listregistered.entity.capability.provider.SpeedUpCapabilityProvider;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

/**
 * CommonEventHandler
 *
 * @program: SomeTools-Forge-1.16.3-34.1.0-mdk
 * @author: 1260535819@qq.com
 * @create: 2021-01-16 21:56
 */
@Mod.EventBusSubscriber()
public class CommonEventHandler {
    /**
     * 监听了AttachCapabilitiesEvent<Entity>事件，
     * 通过这个事件来为特定的对象附加自定义的CapabilityProvider。
     * 简单了判断了实体是不是玩家，如果是玩家，就附加能力。
     * 请注意：event.addCapability方法，看上去附加的好像不是CapabilityProvider而是Capability，
     * 但如果你观察过它的函数签名，你会发现第二个参数需要的类型是ICapabilityProvider，
     * 所以在一开始把这个函数理解成成event.addCapabilityProvider。
     * 这里的第一个参数是一个标记符，每一个附加的CapabilityProvider都必须是唯一的，ResourceLocation
     * 第一个参数一般情况填入你的modId，后一个参数随喜好填。
     * <p>
     * 可以填入的值有：
     * Entity
     * TileEntity
     * ItemStack
     * World
     * Chunk
     *
     * @param event :
     *
     * @return : void
     *
     * @author : 1260535819@qq.com
     * @date : 2021/1/16 21:34
     */
    @SubscribeEvent
    public static void onAttachCapabilityEvent(AttachCapabilitiesEvent<Entity> event) {
        Entity entity = event.getObject();
        if (entity instanceof PlayerEntity) {
            event.addCapability(new ResourceLocation(Utils.MOD_ID, "speedup"), new SpeedUpCapabilityProvider());
        }
    }

    /**
     * 当玩家死亡后重生或者从末地回到主世界，触发这个方法，
     * 理论上来说从末地回到主世界应该会自动同步数据，不知道处于什么样子的考虑，这个功能一直没有实现，
     * 所以需要在这里手动的恢复能力。
     * event.isWasDeath() 为真代表玩家死亡后重生，为假代表从末地回到主世界。
     * event.getOriginal() 得到的是玩家之前的实体，
     * event.getPlayer() 代表的是玩家重生之后的实体。
     * <p>
     * newCap.deserializeNBT(oldCap.serializeNBT());
     * 在这里恢复数据，这就是为什么需要让Capability实现INBTSerializable<CompoundNBT>。
     * 末地返回时保存数据
     *
     * @param event :e
     *
     * @return : void
     *
     * @author : 1260535819@qq.com
     * @date : 2021/1/16 21:33
     */
    @SubscribeEvent
    public static void onPlayerCloned(PlayerEvent.Clone event) {
        if (!event.isWasDeath()) {
            LazyOptional<ISpeedUpCapability> oldSpeedCap =
                    event.getOriginal().getCapability(SomeToolsCapability.SPEED_UP_CAPABILITY);
            LazyOptional<ISpeedUpCapability> newSpeedCap =
                    event.getPlayer().getCapability(SomeToolsCapability.SPEED_UP_CAPABILITY);
            if (oldSpeedCap.isPresent() && newSpeedCap.isPresent()) {
                newSpeedCap.ifPresent((newCap) -> oldSpeedCap.ifPresent((oldCap) -> newCap.deserializeNBT(oldCap.serializeNBT())));
            }
        }
    }
}
