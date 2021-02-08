package com.skynet.sometools.client.input;

import com.skynet.sometools.common.Utils;
import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.client.util.InputMappings;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.client.settings.KeyConflictContext;
import net.minecraftforge.client.settings.KeyModifier;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.lwjgl.glfw.GLFW;

/**
 * KeyBoardInput
 *
 * @program: SomeTools-Forge-1.16.3-34.1.0-mdk
 * @author: 1260535819@qq.com
 * @create: 2021-01-28 07:13
 */

@Mod.EventBusSubscriber(value = Dist.CLIENT)
public class KeyBoardInput {
    public static final KeyBinding MESSAGE_KEY = new KeyBinding("key.message",
            KeyConflictContext.IN_GAME,
            KeyModifier.CONTROL,
            InputMappings.Type.KEYSYM,
            GLFW.GLFW_KEY_J,
            "key.category." + Utils.MOD_ID);
    private static Minecraft instance;

    @SubscribeEvent
    public static void onKeyboardInput(InputEvent.KeyInputEvent event) {
        if (MESSAGE_KEY.isPressed()) {
            // instance = Minecraft.getInstance();
            // ClientPlayerEntity player = instance.player;
            // assert player != null;
            // BlockPos position = player.getPosition();
            // String chunkPos = String.format("Chunk: %d %d %d in %d %d %d", position.getX() & 15, position.getY() &
            // 15,
            //         position.getZ() & 15, position.getX() >> 4, position.getY() >> 4, position.getZ() >> 4);
            // Minecraft.getInstance().player.sendMessage(new TranslationTextComponent(chunkPos),
            //         Minecraft.getInstance().player.getUniqueID());
        }
    }
}

