package com.skynet.sometools.item.tab;

import com.skynet.sometools.item.blocks.BlockRegister;
import com.skynet.sometools.common.Utils;
import com.skynet.sometools.item.fluid.FluidRegister;
import com.skynet.sometools.item.armors.SomeToolsArmorMaterial;
import com.skynet.sometools.item.food.ObsidianApple;
import com.skynet.sometools.item.ingot.MagicIngot;
import com.skynet.sometools.item.ingot.ObsidianIngot;
import com.skynet.sometools.item.sword.ObsidianSword;
import com.skynet.sometools.item.tools.*;
import com.skynet.sometools.item.tools.pickaxe.ObsidianPickaxe;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.BlockItem;
import net.minecraft.item.BucketItem;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import static net.minecraft.item.Items.BUCKET;


/**
 * TODO itemRegister
 *
 * @program: forge-1.16.3-34.1.0-mdk
 * @author: 1260535819@qq.com
 * @create: 2021-01-13 14:50
 */

public class ItemRegister {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Utils.MOD_ID);

    public static final RegistryObject<Item> OBSIDIAN_BLOCK = ITEMS.register("obsidian_block",
            () -> new BlockItem(BlockRegister.OBSIDIAN_BLOCK.get(), new Item.Properties().group(SomeToolsGroup.BLOCK_GROUP)));
    public static final RegistryObject<Item> OBSIDIAN_RUBIK_CUBE = ITEMS.register("obsidian_rubik_cube",
            () -> new BlockItem(BlockRegister.OBSIDIAN_RUBIK_CUBE.get(),
                    new Item.Properties().group(SomeToolsGroup.BLOCK_GROUP)));
    public static final RegistryObject<Item> OBSIDIAN_FRAME = ITEMS.register("obsidian_frame",
            () -> new BlockItem(BlockRegister.OBSIDIAN_FRAME.get(), new Item.Properties().group(SomeToolsGroup.BLOCK_GROUP)));
    public static final RegistryObject<BlockItem> GLASS_JAR = ITEMS.register("glass_jar", () -> {
        return new BlockItem(BlockRegister.GLASS_JAR.get(), new Item.Properties().group(SomeToolsGroup.BLOCK_GROUP));
    });
    public static final RegistryObject<Item> OBSIDIAN_OBJ = ITEMS.register("obsidian_obj",
            () -> new BlockItem(BlockRegister.OBSIDIAN_OBJ.get(), new Item.Properties().group(SomeToolsGroup.BLOCK_GROUP)));
    public static final RegistryObject<Item> OBSIDIAN_COUNTER = ITEMS.register("obsidian_counter_block",
            () -> new BlockItem(BlockRegister.OBSIDIAN_COUNTER.get(), new Item.Properties().group(SomeToolsGroup.BLOCK_GROUP)));
    public static final RegistryObject<Item> OBSIDIAN_HELLO = ITEMS.register("obsidian_hello_block",
            () -> new BlockItem(BlockRegister.OBSIDIAN_HELLO.get(), new Item.Properties().group(SomeToolsGroup.BLOCK_GROUP)));
    public static final RegistryObject<Item> OBSIDIAN_ZOMBIE_BLOCK = ITEMS.register("obsidian_zombie_block",
            () -> new BlockItem(BlockRegister.OBSIDIAN_ZOMBIE_BLOCK.get(), new Item.Properties().group(SomeToolsGroup.BLOCK_GROUP)));
    public static final RegistryObject<Item> OBSIDIAN_HIDDEN_BLOCK = ITEMS.register("obsidian_hidden_block",
            () -> new BlockItem(BlockRegister.OBSIDIAN_HIDDEN_BLOCK.get(), new Item.Properties().group(SomeToolsGroup.BLOCK_GROUP)));
    public static final RegistryObject<Item> OBSIDIAN_TER_BLOCK = ITEMS.register("obsidian_ter_block",
            () -> new BlockItem(BlockRegister.OBSIDIAN_TER_BLOCK.get(), new Item.Properties().group(SomeToolsGroup.BLOCK_GROUP)));
    public static final RegistryObject<Item> OBSIDIAN_UP_BLOCK = ITEMS.register("obsidian_up_block",
            () -> new BlockItem(BlockRegister.OBSIDIAN_UP_BLOCK.get(), new Item.Properties().group(SomeToolsGroup.BLOCK_GROUP)));
    public static final RegistryObject<Item> OBSIDIAN_DOWN_BLOCK = ITEMS.register("obsidian_down_block",
            () -> new BlockItem(BlockRegister.OBSIDIAN_DOWN_BLOCK.get(), new Item.Properties().group(SomeToolsGroup.BLOCK_GROUP)));
    public static final RegistryObject<Item> OBSIDIAN_TRASH_BLOCK = ITEMS.register("obsidian_trash_block",
            () -> new BlockItem(BlockRegister.OBSIDIAN_TRASH_BLOCK.get(), new Item.Properties().group(SomeToolsGroup.BLOCK_GROUP)));
    public static final RegistryObject<Item> OBSIDIAN_ITEM_SAVE = ITEMS.register("obsidian_item_save",
            () -> new BlockItem(BlockRegister.OBSIDIAN_ITEM_SAVE_BLOCK.get(), new Item.Properties().group(SomeToolsGroup.BLOCK_GROUP)));
    public static final RegistryObject<Item> OBSIDIAN_FIRST_CONTAINER = ITEMS.register("obsidian_first_container",
            () -> new BlockItem(BlockRegister.OBSIDIAN_FIRST_CONTAINER_BLOCK.get(), new Item.Properties().group(SomeToolsGroup.BLOCK_GROUP)));
    public static final RegistryObject<Item> MY_CHEST_WITH_CONTAINER_BLOCK = ITEMS.register("my_chest_with_container",
            () -> new BlockItem(BlockRegister.MY_CHEST_WITH_CONTAINER_BLOCK.get(), new Item.Properties().group(SomeToolsGroup.BLOCK_GROUP)));

    public static final RegistryObject<Item> OBSIDIAN_INGOT = ITEMS.register("obsidian_ingot", ObsidianIngot::new);
    public static final RegistryObject<Item> MAGIC_INGOT = ITEMS.register("magic_ingot", MagicIngot::new);
    public static final RegistryObject<Item> OBSIDIAN_APPLE = ITEMS.register("obsidian_apple", ObsidianApple::new);
    public static final RegistryObject<Item> OBSIDIAN_SWORD = ITEMS.register("obsidian_sword", ObsidianSword::new);
    public static final RegistryObject<Item> OBSIDIAN_PICKAXE = ITEMS.register("obsidian_pickaxe",
            ObsidianPickaxe::new);
    public static final RegistryObject<Item> OBSIDIAN_WRENCH = ITEMS.register("obsidian_wrench",
            ObsidianWrench::new);
    public static final RegistryObject<Item> OBSIDIAN_MESSAGE = ITEMS.register("obsidian_message",
            ObsidianMessage::new);
    public static final RegistryObject<Item> OBSIDIAN_SPEED_UP_SHOW_ITEM = ITEMS.register("obsidian_show_speedup",
            ObsidianSpeedUpShowItem::new);
    public static final RegistryObject<Item> OBSIDIAN_FIRST_GUI = ITEMS.register("obsidian_first_gui",
            ObsidianFirstGuiItem::new);
    public static final RegistryObject<Item> OBSIDIAN_HUD_ITEM = ITEMS.register("obsidian_hud",
            ObsidianHudItem::new);
    public static final RegistryObject<Item> TEST_CONFIG_ITEM = ITEMS.register("test_config_item",
            TestConfigItem::new);
    public static final RegistryObject<Item> SOUND_TEST_ITEM = ITEMS.register("sound_test_item",
            SoundTestItem::new);


    public static final RegistryObject<Item> obsidianFluidBucket = ITEMS.register("obsidian_fluid_bucket",
            () -> new BucketItem(FluidRegister.obsidianFluid,
                    new Item.Properties().group(SomeToolsGroup.ITEMS_GROUP).containerItem(BUCKET)));


    public static final RegistryObject<Item> OBSIDIAN_HELMET = ITEMS.register("obsidian_helmet",
            () -> new ArmorItem(SomeToolsArmorMaterial.OBSIDIAN, EquipmentSlotType.HEAD,
                    (new Item.Properties()).group(SomeToolsGroup.ARMER_GROUP)));
    public static final RegistryObject<Item> OBSIDIAN_CHEST_PLATE = ITEMS.register("obsidian_chestplate",
            () -> new ArmorItem(SomeToolsArmorMaterial.OBSIDIAN, EquipmentSlotType.CHEST,
                    (new Item.Properties()).group(SomeToolsGroup.ARMER_GROUP)));
    public static final RegistryObject<Item> OBSIDIAN_LEGGINGS = ITEMS.register("obsidian_leggings",
            () -> new ArmorItem(SomeToolsArmorMaterial.OBSIDIAN, EquipmentSlotType.LEGS,
                    (new Item.Properties()).group(SomeToolsGroup.ARMER_GROUP)));
    public static final RegistryObject<Item> OBSIDIAN_BOOTS = ITEMS.register("obsidian_boots",
            () -> new ArmorItem(SomeToolsArmorMaterial.OBSIDIAN, EquipmentSlotType.FEET,
                    (new Item.Properties()).group(SomeToolsGroup.ARMER_GROUP)));

}
