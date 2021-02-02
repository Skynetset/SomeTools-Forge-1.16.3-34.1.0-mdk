// package com.skynet.sometools.entity;
//
// import com.skynet.sometools.common.Utils;
// import net.minecraft.entity.EntityClassification;
// import net.minecraft.entity.EntityType;
// import net.minecraftforge.fml.RegistryObject;
// import net.minecraftforge.registries.DeferredRegister;
// import net.minecraftforge.registries.ForgeRegistries;
//
// /**
//  * TODO EntityTypeRegister
//  *
//  * @program: SomeTools-Forge-1.16.3-34.1.0-mdk
//  * @author: 1260535819@qq.com
//  * @create: 2021-01-16 17:44
//  */
//
// public class EntityTypeRegister {
//     public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITIES, Utils.MOD_ID);
//
//     public static final RegistryObject<EntityType<FlyingSwordEntity>> FLYING_SWORD_ENTITY = ENTITY_TYPES.register("flying_sword", () -> EntityType.Builder.create(FlyingSwordEntity::new, EntityClassification.MISC).size(3, 0.5F).build("flying_sword"));
//     public static final RegistryObject<EntityType<ObsidianAnimalEntity>> OBSIDIAN_ANIMAL_ENTITY = ENTITY_TYPES.register(
//             "obsidian_animal", () -> EntityType.Builder.create(ObsidianAnimalEntity::new, EntityClassification.MISC).size(3, 0.5F).build(
//                     "obsidian_animal"));
// }
