package com.skynet.sometools.item;

import com.skynet.sometools.blocks.blockentity.BlockRegister;
import com.skynet.sometools.item.armors.SomeToolsArmorMaterial;
import com.skynet.sometools.item.food.ObsidianApple;
import com.skynet.sometools.item.ingot.MagicIngot;
import com.skynet.sometools.item.ingot.ObsidianIngot;
import com.skynet.sometools.item.sword.ObsidianSword;
import com.skynet.sometools.item.tab.SomeToolsGroup;
import com.skynet.sometools.item.tools.ObsidianWrench;
import com.skynet.sometools.item.tools.pickaxe.ObsidianPickaxe;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;

import static com.skynet.sometools.register.SomeRegister.ITEMS;

/**
 * TODO itemRegister
 *
 * @program: forge-1.16.3-34.1.0-mdk
 * @author: 1260535819@qq.com
 * @create: 2021-01-13 14:50
 */

public class ItemRegister {
    public static final RegistryObject<Item> OBSIDIAN_BLOCK = ITEMS.register("obsidian_block",
            () -> new BlockItem(BlockRegister.OBSIDIAN_BLOCK.get(), new Item.Properties().group(SomeToolsGroup.blockGroup)));
    public static final RegistryObject<Item> OBSIDIAN_RUBIK_CUBE = ITEMS.register("obsidian_rubik_cube",
            () -> new BlockItem(BlockRegister.OBSIDIAN_RUBIK_CUBE.get(),
                    new Item.Properties().group(SomeToolsGroup.blockGroup)));
    public static RegistryObject<Item> OBSIDIAN_FRAME = ITEMS.register("obsidian_frame",
            () -> new BlockItem(BlockRegister.OBSIDIAN_FRAME.get(), new Item.Properties().group(SomeToolsGroup.blockGroup)));
    public static final RegistryObject<BlockItem> GLASS_JAR = ITEMS.register("glass_jar", () -> {
        return new BlockItem(BlockRegister.GLASS_JAR.get(), new Item.Properties().group(SomeToolsGroup.blockGroup));
    });
    public static final RegistryObject<Item> OBSIDIAN_OBJ = ITEMS.register("obsidian_obj",
            () -> new BlockItem(BlockRegister.OBSIDIAN_OBJ.get(), new Item.Properties().group(SomeToolsGroup.blockGroup)));
    public static final RegistryObject<Item> OBSIDIAN_COUNTER = ITEMS.register("obsidian_counter_block",
            () -> new BlockItem(BlockRegister.OBSIDIAN_COUNTER.get(), new Item.Properties().group(SomeToolsGroup.blockGroup)));
    public static final RegistryObject<Item> OBSIDIAN_HELLO = ITEMS.register("obsidian_hello_block",
            () -> new BlockItem(BlockRegister.OBSIDIAN_HELLO.get(), new Item.Properties().group(SomeToolsGroup.blockGroup)));
    public static final RegistryObject<Item> OBSIDIAN_ZOMBIE_BLOCK = ITEMS.register("obsidian_zombie_block",
            () -> new BlockItem(BlockRegister.OBSIDIAN_ZOMBIE_BLOCK.get(), new Item.Properties().group(SomeToolsGroup.blockGroup)));
    public static final RegistryObject<Item> OBSIDIAN_HIDDEN_BLOCK = ITEMS.register("obsidian_hidden_block",
            () -> new BlockItem(BlockRegister.OBSIDIAN_HIDDEN_BLOCK.get(), new Item.Properties().group(SomeToolsGroup.blockGroup)));
    public static final RegistryObject<Item> OBSIDIAN_TER_BLOCK = ITEMS.register("obsidian_ter_block",
            () -> new BlockItem(BlockRegister.OBSIDIAN_TER_BLOCK.get(), new Item.Properties().group(SomeToolsGroup.blockGroup)));

    public static final RegistryObject<Item> OBSIDIAN_INGOT = ITEMS.register("obsidian_ingot", ObsidianIngot::new);
    public static final RegistryObject<Item> MAGIC_INGOT = ITEMS.register("magic_ingot", MagicIngot::new);
    public static final RegistryObject<Item> OBSIDIAN_APPLE = ITEMS.register("obsidian_apple", ObsidianApple::new);
    public static final RegistryObject<Item> OBSIDIAN_SWORD = ITEMS.register("obsidian_sword", ObsidianSword::new);
    public static final RegistryObject<Item> OBSIDIAN_PICKAXE = ITEMS.register("obsidian_pickaxe",
            ObsidianPickaxe::new);
    public static final RegistryObject<Item> Obsidian_Wrench = ITEMS.register("obsidian_wrench",
            ObsidianWrench::new);

    public static final RegistryObject<Item> OBSIDIAN_HELMET = ITEMS.register("obsidian_helmet",
            () -> new ArmorItem(SomeToolsArmorMaterial.OBSIDIAN, EquipmentSlotType.HEAD,
                    (new Item.Properties()).group(SomeToolsGroup.armerGroup)));
    public static final RegistryObject<Item> OBSIDIAN_CHESTPLATE = ITEMS.register("obsidian_chestplate",
            () -> new ArmorItem(SomeToolsArmorMaterial.OBSIDIAN, EquipmentSlotType.CHEST,
                    (new Item.Properties()).group(SomeToolsGroup.armerGroup)));
    public static final RegistryObject<Item> OBSIDIAN_LEGGINGS = ITEMS.register("obsidian_leggings",
            () -> new ArmorItem(SomeToolsArmorMaterial.OBSIDIAN, EquipmentSlotType.LEGS,
                    (new Item.Properties()).group(SomeToolsGroup.armerGroup)));
    public static final RegistryObject<Item> OBSIDIAN_BOOTS = ITEMS.register("obsidian_boots",
            () -> new ArmorItem(SomeToolsArmorMaterial.OBSIDIAN, EquipmentSlotType.FEET,
                    (new Item.Properties()).group(SomeToolsGroup.armerGroup)));

}
