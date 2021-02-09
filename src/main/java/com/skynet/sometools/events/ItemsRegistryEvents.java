package com.skynet.sometools.events;

import com.skynet.sometools.client.particle.ObsidianParticleType;
import com.skynet.sometools.common.Utils;
import com.skynet.sometools.list.*;
import com.skynet.sometools.listregistered.entity.FlyingSwordEntity;
import com.skynet.sometools.listregistered.entity.ObsidianAnimalEntity;
import com.skynet.sometools.listregistered.fluid.FluidRegister;
import com.skynet.sometools.listregistered.iparticle.ObsidianParticleData;
import com.skynet.sometools.listregistered.item.SomeToolsGroup;
import com.skynet.sometools.listregistered.item.armors.SomeToolsArmorMaterial;
import com.skynet.sometools.listregistered.item.blocks.*;
import com.skynet.sometools.listregistered.item.blocks.blockentity.container.MyChestContainer;
import com.skynet.sometools.listregistered.item.blocks.blockentity.container.ObsidianFirstContainer;
import com.skynet.sometools.listregistered.item.blocks.blockentity.container.ObsidianFirstContainerItemNumber;
import com.skynet.sometools.listregistered.item.food.ObsidianApple;
import com.skynet.sometools.listregistered.item.ingot.MagicIngot;
import com.skynet.sometools.listregistered.item.itemstacktileentityrenderer.ObsidianWrenchItemStackTileEntityRenderer;
import com.skynet.sometools.listregistered.item.sword.ObsidianSword;
import com.skynet.sometools.listregistered.item.tools.*;
import com.skynet.sometools.listregistered.item.tools.pickaxe.ObsidianPickaxe;
import com.skynet.sometools.listregistered.tileentities.*;
import net.minecraft.block.Block;
import net.minecraft.block.FlowingFluidBlock;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.BlockItem;
import net.minecraft.item.BucketItem;
import net.minecraft.item.Item;
import net.minecraft.network.PacketBuffer;
import net.minecraft.particles.ParticleType;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.common.extensions.IForgeContainerType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.apache.logging.log4j.Logger;

import static net.minecraft.item.Items.BUCKET;

/**
 * RegistryEvents
 *
 * @program: SomeTools-Forge-1.16.3-34.1.0-mdk
 * @author: 1260535819@qq.com
 * @create: 2021-01-30 11:06
 */

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
class ItemsRegistryEvents {
    public static final Logger LOGGER = Utils.LOGGER;
    public static final String MOD_ID = Utils.MOD_ID;

    private ItemsRegistryEvents() {
    }

    @SubscribeEvent
    public static void registerItems(final RegistryEvent.Register<Item> register) {
        register.getRegistry().registerAll(
                ItemList.OBSIDIAN_REPLACE_1 = new ChunkReplaceCenterItem().setRegistryName(location(
                        "chunk_replace_center_item")),
                ItemList.OBSIDIAN_BLOCK = new BlockItem(BlockList.OBSIDIAN_BLOCK,
                        new Item.Properties().group(SomeToolsGroup.BLOCK_GROUP)).setRegistryName(
                        BlockList.OBSIDIAN_BLOCK.getRegistryName()),
                ItemList.OBSIDIAN_RUBIK_CUBE = new BlockItem(BlockList.OBSIDIAN_RUBIK_CUBE,
                        new Item.Properties().group(SomeToolsGroup.BLOCK_GROUP))
                        .setRegistryName(BlockList.OBSIDIAN_RUBIK_CUBE.getRegistryName()),
                ItemList.OBSIDIAN_FRAME = new BlockItem(BlockList.OBSIDIAN_FRAME,
                        new Item.Properties().group(SomeToolsGroup.BLOCK_GROUP)).setRegistryName(BlockList.OBSIDIAN_FRAME.getRegistryName()),
                ItemList.GLASS_JAR = new BlockItem(BlockList.GLASS_JAR,
                        new Item.Properties().group(SomeToolsGroup.BLOCK_GROUP)).setRegistryName(BlockList.GLASS_JAR.getRegistryName()),
                ItemList.OBSIDIAN_OBJ = new BlockItem(BlockList.OBSIDIAN_OBJ,
                        new Item.Properties().group(SomeToolsGroup.BLOCK_GROUP)).setRegistryName(BlockList.OBSIDIAN_OBJ.getRegistryName()),
                ItemList.OBSIDIAN_COUNTER = new BlockItem(BlockList.OBSIDIAN_COUNTER,
                        new Item.Properties().group(SomeToolsGroup.BLOCK_GROUP)).setRegistryName(BlockList.OBSIDIAN_COUNTER.getRegistryName()),
                ItemList.OBSIDIAN_HELLO = new BlockItem(BlockList.OBSIDIAN_HELLO,
                        new Item.Properties().group(SomeToolsGroup.BLOCK_GROUP)).setRegistryName(BlockList.OBSIDIAN_HELLO.getRegistryName()),
                ItemList.OBSIDIAN_ZOMBIE_BLOCK = new BlockItem(BlockList.OBSIDIAN_ZOMBIE_BLOCK,
                        new Item.Properties().group(SomeToolsGroup.BLOCK_GROUP)).setRegistryName(BlockList.OBSIDIAN_ZOMBIE_BLOCK.getRegistryName()),
                ItemList.OBSIDIAN_HIDDEN_BLOCK = new BlockItem(BlockList.OBSIDIAN_HIDDEN_BLOCK,
                        new Item.Properties().group(SomeToolsGroup.BLOCK_GROUP)).setRegistryName(BlockList.OBSIDIAN_HIDDEN_BLOCK.getRegistryName()),
                ItemList.OBSIDIAN_TER_BLOCK = new BlockItem(BlockList.OBSIDIAN_TER_BLOCK,
                        new Item.Properties().group(SomeToolsGroup.BLOCK_GROUP)).setRegistryName(BlockList.OBSIDIAN_TER_BLOCK.getRegistryName()),
                ItemList.OBSIDIAN_UP_BLOCK = new BlockItem(BlockList.OBSIDIAN_UP_BLOCK,
                        new Item.Properties().group(SomeToolsGroup.BLOCK_GROUP)).setRegistryName(BlockList.OBSIDIAN_UP_BLOCK.getRegistryName()),
                ItemList.OBSIDIAN_DOWN_BLOCK = new BlockItem(BlockList.OBSIDIAN_DOWN_BLOCK,
                        new Item.Properties().group(SomeToolsGroup.BLOCK_GROUP)).setRegistryName(BlockList.OBSIDIAN_DOWN_BLOCK.getRegistryName()),
                ItemList.OBSIDIAN_TRASH_BLOCK = new BlockItem(BlockList.OBSIDIAN_TRASH_BLOCK,
                        new Item.Properties().group(SomeToolsGroup.BLOCK_GROUP)).setRegistryName(BlockList.OBSIDIAN_TRASH_BLOCK.getRegistryName()),
                ItemList.OBSIDIAN_ITEM_SAVE = new BlockItem(BlockList.OBSIDIAN_ITEM_SAVE_BLOCK,
                        new Item.Properties().group(SomeToolsGroup.BLOCK_GROUP)).setRegistryName(BlockList.OBSIDIAN_ITEM_SAVE_BLOCK.getRegistryName()),
                ItemList.OBSIDIAN_FIRST_CONTAINER = new BlockItem(BlockList.OBSIDIAN_FIRST_CONTAINER_BLOCK,
                        new Item.Properties().group(SomeToolsGroup.BLOCK_GROUP)).setRegistryName(BlockList.OBSIDIAN_FIRST_CONTAINER_BLOCK.getRegistryName()),
                ItemList.MY_CHEST_WITH_CONTAINER_BLOCK =
                        new BlockItem(BlockList.MY_CHEST_WITH_CONTAINER_BLOCK,
                                new Item.Properties().group(SomeToolsGroup.BLOCK_GROUP)).setRegistryName(BlockList.MY_CHEST_WITH_CONTAINER_BLOCK.getRegistryName()),

                ItemList.OBSIDIAN_INGOT =
                        new Item(new Item.Properties().group(SomeToolsGroup.INGOT_GROUP)).setRegistryName(location(
                                "obsidian_ingot")),
                ItemList.MAGIC_INGOT = new MagicIngot().setRegistryName(location("magic_ingot")),
                ItemList.OBSIDIAN_APPLE = new ObsidianApple().setRegistryName(location("obsidian_apple")),
                ItemList.OBSIDIAN_SWORD = new ObsidianSword().setRegistryName(location("obsidian_sword")),
                ItemList.OBSIDIAN_PICKAXE = new ObsidianPickaxe().setRegistryName(location("obsidian_pickaxe")),
                ItemList.OBSIDIAN_WRENCH =
                        new Item(new Item.Properties().group(SomeToolsGroup.TOOLS_GROUP).setISTER(() -> ObsidianWrenchItemStackTileEntityRenderer::new)).setRegistryName(location(
                                "obsidian_wrench")),
                ItemList.OBSIDIAN_MESSAGE = new ObsidianMessage().setRegistryName(location("obsidian_message")),
                ItemList.OBSIDIAN_SPEED_UP_SHOW_ITEM = new ObsidianSpeedUpShowItem().setRegistryName(location(
                        "obsidian_show_speedup")),
                ItemList.OBSIDIAN_FIRST_GUI = new ObsidianFirstGuiItem().setRegistryName(location("obsidian_first_gui"
                )),
                ItemList.OBSIDIAN_HUD_ITEM =
                        new Item(new Item.Properties().group(SomeToolsGroup.TOOLS_GROUP)).setRegistryName(location(
                                "obsidian_hud")),
                ItemList.TEST_CONFIG_ITEM = new TestConfigItem().setRegistryName(location("test_config_item")),
                ItemList.SOUND_TEST_ITEM = new SoundTestItem().setRegistryName(location("sound_test_item")),


                ItemList.OBSIDIAN_HELMET = new ArmorItem(SomeToolsArmorMaterial.OBSIDIAN, EquipmentSlotType.HEAD,
                        (new Item.Properties()).group(SomeToolsGroup.ARMER_GROUP)).setRegistryName(location(
                        "obsidian_helmet")),
                ItemList.OBSIDIAN_CHEST_PLATE = new ArmorItem(SomeToolsArmorMaterial.OBSIDIAN, EquipmentSlotType.CHEST,
                        (new Item.Properties()).group(SomeToolsGroup.ARMER_GROUP)).setRegistryName(location(
                        "obsidian_chestplate")),
                ItemList.OBSIDIAN_LEGGINGS = new ArmorItem(SomeToolsArmorMaterial.OBSIDIAN, EquipmentSlotType.LEGS,
                        (new Item.Properties()).group(SomeToolsGroup.ARMER_GROUP)).setRegistryName(location(
                        "obsidian_leggings")),
                ItemList.OBSIDIAN_BOOTS = new ArmorItem(SomeToolsArmorMaterial.OBSIDIAN, EquipmentSlotType.FEET,
                        (new Item.Properties()).group(SomeToolsGroup.ARMER_GROUP)).setRegistryName(location(
                        "obsidian_boots")),
                ItemList.obsidianFluidBucket = new BucketItem(FluidRegister.obsidianFluid,
                        new Item.Properties().group(SomeToolsGroup.ITEMS_GROUP).containerItem(BUCKET)).setRegistryName(location(
                        "obsidian_fluid_bucket"))
        );
    }

    @SubscribeEvent
    public static void registerBlocks(final RegistryEvent.Register<Block> register) {
        register.getRegistry().registerAll(
                BlockList.GLASS_JAR = new GlassJar().setRegistryName(location("glass_jar")),
                BlockList.MY_CHEST_WITH_CONTAINER_BLOCK = new MyChestWithContainerBlock().setRegistryName(location(
                        "my_chest_with_container")),
                BlockList.OBSIDIAN_BLOCK = new ObsidianBlock().setRegistryName(location("obsidian_block")),
                BlockList.OBSIDIAN_COUNTER = new ObsidianCounter().setRegistryName(location("obsidian_counter_block")),
                BlockList.OBSIDIAN_DOWN_BLOCK = new ObsidianDownBlock().setRegistryName(location("obsidian_down_block"
                )),
                BlockList.OBSIDIAN_FIRST_CONTAINER_BLOCK =
                        new ObsidianFirstContainerBlock().setRegistryName(location("obsidian_first_container")),
                BlockList.OBSIDIAN_FLUID_BLOCK =
                        (FlowingFluidBlock) new FlowingFluidBlock(FluidRegister.obsidianFluid,
                                Block.Properties.create(Material.WATER).doesNotBlockMovement().hardnessAndResistance(100.0F).noDrops()).setRegistryName(location("obsidian_fluid")),
                BlockList.OBSIDIAN_FRAME = new ObsidianFrame().setRegistryName(location("obsidian_frame")),
                BlockList.OBSIDIAN_HELLO = new ObsidianHelloBlock().setRegistryName(location("obsidian_hello_block")),
                BlockList.OBSIDIAN_HIDDEN_BLOCK = new ObsidianHiddenBlock().setRegistryName(location(
                        "obsidian_hidden_block")),
                BlockList.OBSIDIAN_ITEM_SAVE_BLOCK = new ObsidianItemSaveBlock().setRegistryName(location(
                        "obsidian_item_save")),
                BlockList.OBSIDIAN_OBJ = new ObsidianOBJ().setRegistryName(location("obsidian_obj")),
                BlockList.OBSIDIAN_RUBIK_CUBE = new ObsidianRubikCube().setRegistryName(location("obsidian_rubik_cube"
                )),
                BlockList.OBSIDIAN_TER_BLOCK = new ObsidianTERBlock().setRegistryName(location("obsidian_ter_block")),
                BlockList.OBSIDIAN_TRASH_BLOCK = new ObsidianTrashBlock().setRegistryName(location(
                        "obsidian_trash_block")),
                BlockList.OBSIDIAN_UP_BLOCK = new ObsidianUpBlock().setRegistryName(location("obsidian_up_block")),
                BlockList.OBSIDIAN_ZOMBIE_BLOCK = new ObsidianDownBlock().setRegistryName(location(
                        "obsidian_zombie_block"))
        );
    }

    @SubscribeEvent
    public static void registerContainerType(final RegistryEvent.Register<ContainerType<?>> register) {
        register.getRegistry().registerAll(
                ContainerTypeList.MY_CHEST_CONTAINER =
                        (ContainerType<MyChestContainer>) IForgeContainerType.create((int windowId, PlayerInventory inv, PacketBuffer data) -> MyChestContainer.createGeneric9X3(windowId, inv)).setRegistryName(location("my_chest_container")),
                ContainerTypeList.OBSIDIAN_FIRST_CONTAINER =
                        (ContainerType<ObsidianFirstContainer>) IForgeContainerType.create((int windowId, PlayerInventory inv, PacketBuffer data) -> new ObsidianFirstContainer(windowId, inv, data.readBlockPos(), Minecraft.getInstance().world, new ObsidianFirstContainerItemNumber())).setRegistryName(location("obsidian_first_container"))
        );
    }

    @SubscribeEvent
    public static void registerEntityTypes(final RegistryEvent.Register<EntityType<?>> register) {
        register.getRegistry().registerAll(
                EntityTypeList.FLYING_SWORD_ENTITY = (EntityType<FlyingSwordEntity>) EntityType.Builder.create(FlyingSwordEntity::new,
                        EntityClassification.MISC)
                        .size(3, 0.5F)
                        .build("flying_sword")
                        .setRegistryName(location("flying_sword")),
                EntityTypeList.OBSIDIAN_ANIMAL_ENTITY = (EntityType<ObsidianAnimalEntity>) EntityType.Builder.create(ObsidianAnimalEntity::new,
                        EntityClassification.MISC)
                        .size(3, 0.5F)
                        .build("obsidian_animal")
                        .setRegistryName(location("obsidian_animal"))
        );
    }

    @SubscribeEvent
    public static void registerTileEntityType(final RegistryEvent.Register<TileEntityType<?>> register) {
        register.getRegistry().registerAll(
                TileEntityTypeList.MY_CHEST_WITH_CONTAINER_TILE_ENTITY =
                        (TileEntityType<MyChestWithContainerTileEntity>) TileEntityType.Builder.create(MyChestWithContainerTileEntity::new,
                                BlockList.MY_CHEST_WITH_CONTAINER_BLOCK)
                                .build(null)
                                .setRegistryName(location("my_chest_with_container_tile_entity")),
                TileEntityTypeList.OBSIDIAN_COUNTER_TILE_ENTITY =
                        (TileEntityType<ObsidianCounterTileEntity>) TileEntityType.Builder.create(ObsidianCounterTileEntity::new,
                                BlockList.OBSIDIAN_FIRST_CONTAINER_BLOCK)
                                .build(null)
                                .setRegistryName(location("obsidian_counter_tile_entity")),
                TileEntityTypeList.OBSIDIAN_DOWN_BLOCK_ENTITY =
                        (TileEntityType<ObsidianDownBlockTileEntity>) TileEntityType.Builder.create(ObsidianDownBlockTileEntity::new,
                                BlockList.OBSIDIAN_DOWN_BLOCK)
                                .build(null)
                                .setRegistryName(location("obsidian_down_tile_block")),
                TileEntityTypeList.OBSIDIAN_FIRST_CONTAINER_TILE_ENTITY =
                        (TileEntityType<ObsidianFirstContainerTileEntity>) TileEntityType.Builder.create(ObsidianFirstContainerTileEntity::new,
                                BlockList.OBSIDIAN_FIRST_CONTAINER_BLOCK)
                                .build(null)
                                .setRegistryName(location("obsidian_first_container_tile_entity")),
                TileEntityTypeList.OBSIDIAN_HELLO_TILE_ENTITY =
                        (TileEntityType<ObsidianHelloTileEntity>) TileEntityType.Builder.create(ObsidianHelloTileEntity::new,
                                BlockList.OBSIDIAN_HELLO)
                                .build(null)
                                .setRegistryName(location("obsidian_hello_block")),
                TileEntityTypeList.OBSIDIAN_TER_TILE_ENTITY =
                        (TileEntityType<ObsidianTERTileEntity>) TileEntityType.Builder.create(ObsidianTERTileEntity::new,
                                BlockList.OBSIDIAN_TER_BLOCK)
                                .build(null)
                                .setRegistryName(location("obsidian_ter_tile_block")),
                TileEntityTypeList.OBSIDIAN_TRASH_TILE_ENTITY =
                        (TileEntityType<ObsidianTrashTileEntity>) TileEntityType.Builder.create(ObsidianTrashTileEntity::new,
                                BlockList.OBSIDIAN_TRASH_BLOCK)
                                .build(null)
                                .setRegistryName(location(
                                        "obsidian_trash_tile_block")),
                TileEntityTypeList.OBSIDIAN_UP_BLOCK_ENTITY =
                        (TileEntityType<ObsidianUpBlockTileEntity>) TileEntityType.Builder.create(ObsidianUpBlockTileEntity::new,
                                BlockList.OBSIDIAN_UP_BLOCK)
                                .build(null)
                                .setRegistryName(location("obsidian_up_tile_block")),
                TileEntityTypeList.OBSIDIAN_ZOMBIE_TILE_ENTITY =
                        (TileEntityType<ObsidianZombieTileEntity>) TileEntityType.Builder.create(ObsidianZombieTileEntity::new,
                                BlockList.OBSIDIAN_ZOMBIE_BLOCK)
                                .build(null)
                                .setRegistryName(location("obsidian_zombie_tile_block"))
        );
    }

    @SubscribeEvent
    public static void registerParticleType(final RegistryEvent.Register<ParticleType<?>> register) {
        register.getRegistry().registerAll(
                ParticleList.OBSIDIAN_PARTICLE = (ParticleType<ObsidianParticleData>) new ObsidianParticleType().setRegistryName(location(
                        "obsidian_particle"))
        );
    }

    @SubscribeEvent
    public static void registerSound(final RegistryEvent.Register<SoundEvent> register) {
        register.getRegistry().registerAll(
                SoundList.MEA_SOUND = new SoundEvent(location("mea")).setRegistryName(location("mea"))
        );
    }

    private static ResourceLocation location(String name) {
        return new ResourceLocation(MOD_ID, name);
    }

}