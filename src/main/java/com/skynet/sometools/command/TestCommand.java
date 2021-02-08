package com.skynet.sometools.command;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.context.CommandContext;
import com.skynet.sometools.common.Utils;
import net.minecraft.command.CommandSource;
import net.minecraft.util.text.TranslationTextComponent;

/**
 * TestCommand
 *
 * @program: SomeTools-Forge-1.16.3-34.1.0-mdk
 * @author: 1260535819@qq.com
 * @create: 2021-01-17 22:04
 */

public class TestCommand implements Command<CommandSource> {
    public static TestCommand instance = new TestCommand();

    @Override
    public int run(CommandContext<CommandSource> context) {
        context.getSource().sendFeedback(new TranslationTextComponent("cmd." + Utils.MOD_ID + ".hello"), false);
        return 0;
    }
}
