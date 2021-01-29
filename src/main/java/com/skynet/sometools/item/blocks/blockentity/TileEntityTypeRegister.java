package com.skynet.sometools.item.blocks.blockentity;

import com.skynet.sometools.item.blocks.BlockRegister;
import com.skynet.sometools.common.Utils;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

/**
 * TODO TileEntityTypeRegistry
 *
 * @program: forge-1.16.3-34.1.0-mdk
 * @author: 1260535819@qq.com
 * @create: 2021-01-14 09:24
 */

public class TileEntityTypeRegister<T extends TileEntity> extends net.minecraftforge.registries.ForgeRegistryEntry<TileEntityType<?>> {

    public static final DeferredRegister<TileEntityType<?>> TILE_ENTITIES = DeferredRegister.create(ForgeRegistries.TILE_ENTITIES, Utils.MOD_ID);

    public static final RegistryObject<TileEntityType<ObsidianCounterTileEntity>> OBSIDIAN_COUNTER_TILE_ENTITY =
            TILE_ENTITIES.register("obsidian_counter_tile_entity",
                    () -> TileEntityType.Builder.create(ObsidianCounterTileEntity::new, BlockRegister.OBSIDIAN_COUNTER.get()).build(null));
    public static final RegistryObject<TileEntityType<ObsidianHelloTileEntity>> OBSIDIAN_HELLO_TILE_ENTITY =
            TILE_ENTITIES.register("obsidian_hello_block",
                    () -> TileEntityType.Builder.create(ObsidianHelloTileEntity::new, BlockRegister.OBSIDIAN_HELLO.get()).build(null));
    public static final RegistryObject<TileEntityType<ObsidianZombieTileEntity>> OBSIDIAN_ZOMBIE_TILE_ENTITY =
            TILE_ENTITIES.register("obsidian_zombie_tile_block",
                    () -> TileEntityType.Builder.create(ObsidianZombieTileEntity::new, BlockRegister.OBSIDIAN_ZOMBIE_BLOCK.get()).build(null));
    public static final RegistryObject<TileEntityType<ObsidianTERTileEntity>> OBSIDIAN_TER_TILE_ENTITY =
            TILE_ENTITIES.register("obsidian_ter_tile_block",
                    () -> TileEntityType.Builder.create(ObsidianTERTileEntity::new, BlockRegister.OBSIDIAN_TER_BLOCK.get()).build(null));
    public static final RegistryObject<TileEntityType<ObsidianUpBlockTileEntity>> OBSIDIAN_UP_BLOCK_ENTITY =
            TILE_ENTITIES.register("obsidian_up_tile_block",
                    () -> TileEntityType.Builder.create(ObsidianUpBlockTileEntity::new, BlockRegister.OBSIDIAN_UP_BLOCK.get()).build(null));
    public static final RegistryObject<TileEntityType<ObsidianDownBlockTileEntity>> OBSIDIAN_DOWN_BLOCK_ENTITY =
            TILE_ENTITIES.register("obsidian_down_tile_block",
                    () -> TileEntityType.Builder.create(ObsidianDownBlockTileEntity::new, BlockRegister.OBSIDIAN_DOWN_BLOCK.get()).build(null));
    public static final RegistryObject<TileEntityType<ObsidianTrashTileEntity>> OBSIDIAN_TRASH_TILE_ENTITY =
            TILE_ENTITIES.register("obsidian_trash_tile_block",
                    () -> TileEntityType.Builder.create(ObsidianTrashTileEntity::new, BlockRegister.OBSIDIAN_TRASH_BLOCK.get()).build(null));
    public static final RegistryObject<TileEntityType<ObsidianFirstContainerTileEntity>> OBSIDIAN_FIRST_CONTAINER_TILE_ENTITY =
            TILE_ENTITIES.register("obsidian_first_container_tile_entity",
                    () -> TileEntityType.Builder.create(ObsidianFirstContainerTileEntity::new,
                            BlockRegister.OBSIDIAN_FIRST_CONTAINER_BLOCK.get()).build(null));
    public static final RegistryObject<TileEntityType<MyChestWithContainerTileEntity>> MY_CHEST_WITH_CONTAINER_TILE_ENTITY =
            TILE_ENTITIES.register("my_chest_with_container_tile_entity",
                    () -> TileEntityType.Builder.create(MyChestWithContainerTileEntity::new,
                            BlockRegister.MY_CHEST_WITH_CONTAINER_BLOCK.get()).build(null));


//
//    private final Supplier<? extends T> factory;
//    private final Set<Block> validBlocks;
//    private final Type<?> datafixerType;
//
//    @Nullable
//    public static ResourceLocation getId(TileEntityType<?> tileEntityTypeIn) {
//        return Registry.BLOCK_ENTITY_TYPE.getKey(tileEntityTypeIn);
//    }
//
//    private static <T extends TileEntity> TileEntityType<T> register(String key, TileEntityType.Builder<T> builder) {
//        if (builder.blocks.isEmpty()) {
//            LOGGER.warn("Block entity type {} requires at least one valid block to be defined!", (Object)key);
//        }
//
//        Type<?> type = Util.attemptDataFix(TypeReferences.BLOCK_ENTITY, key);
//        return Registry.register(Registry.BLOCK_ENTITY_TYPE, key, builder.build(type));
//    }
//
//    public TileEntityTypeRegister(Supplier<? extends T> factoryIn, Set<Block> validBlocksIn, Type<?> dataFixerType) {
//        this.factory = factoryIn;
//        this.validBlocks = validBlocksIn;
//        this.datafixerType = dataFixerType;
//    }
//
//    @Nullable
//    public T create() {
//        return this.factory.get();
//    }
//
//    public boolean isValidBlock(Block blockIn) {
//        return this.validBlocks.contains(blockIn);
//    }
//
//    @Nullable
//    public T getIfExists(IBlockReader blockReader, BlockPos pos) {
//        TileEntity tileentity = blockReader.getTileEntity(pos);
//        return (T)(tileentity != null && tileentity.getType() == this ? tileentity : null);
//    }
//
//    public static final class Builder<T extends TileEntity> {
//        private final Supplier<? extends T> factory;
//        private final Set<Block> blocks;
//
//        private Builder(Supplier<? extends T> factoryIn, Set<Block> validBlocks) {
//            this.factory = factoryIn;
//            this.blocks = validBlocks;
//        }
//
//        public static <T extends TileEntity> TileEntityType.Builder<T> create(Supplier<? extends T> factoryIn, Block... validBlocks) {
//            return new TileEntityTypeRegister.Builder<>(factoryIn, ImmutableSet.copyOf(validBlocks));
//        }
//
//        public TileEntityType<T> build(Type<?> datafixerType) {
//            return new TileEntityType<>(this.factory, this.blocks, datafixerType);
//        }
//    }
}

