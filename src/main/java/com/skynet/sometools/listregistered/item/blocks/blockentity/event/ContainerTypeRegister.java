// package com.skynet.sometools.item.blocks.blockentity.event;
//
// import com.skynet.sometools.item.blocks.blockentity.container.MyChestContainer;
// import com.skynet.sometools.item.blocks.blockentity.container.ObsidianFirstContainer;
// import com.skynet.sometools.item.blocks.blockentity.container.ObsidianFirstContainerItemNumber;
// import com.skynet.sometools.common.Utils;
// import net.minecraft.client.Minecraft;
// import net.minecraft.entity.player.PlayerInventory;
// import net.minecraft.inventory.container.ContainerType;
// import net.minecraft.network.PacketBuffer;
// import net.minecraftforge.common.extensions.IForgeContainerType;
// import net.minecraftforge.fml.RegistryObject;
// import net.minecraftforge.registries.DeferredRegister;
// import net.minecraftforge.registries.ForgeRegistries;
//
// /**
//  * TODO ContainerTypeRegister
//  *
//  * @program: SomeTools-Forge-1.16.3-34.1.0-mdk
//  * @author: 1260535819@qq.com
//  * @create: 2021-01-16 23:36
//  */
//
// public class ContainerTypeRegister {
//     public static final DeferredRegister<ContainerType<?>> CONTAINERS = DeferredRegister.create(ForgeRegistries
//     .CONTAINERS, Utils.MOD_ID);
//
//     public static final RegistryObject<ContainerType<ObsidianFirstContainer>> OBSIDIAN_FIRST_CONTAINER =
//             CONTAINERS.register("obsidian_first_container",
//                     () -> IForgeContainerType.create((int windowId, PlayerInventory inv, PacketBuffer data) ->
//                                     new ObsidianFirstContainer(windowId, inv, data.readBlockPos(), Minecraft
//                                     .getInstance().world, new ObsidianFirstContainerItemNumber())));
//     public static final RegistryObject<ContainerType<MyChestContainer>> MY_CHEST_CONTAINER =
//             CONTAINERS.register("my_chest_container",
//                     () -> IForgeContainerType.create((int windowId, PlayerInventory inv, PacketBuffer data) ->
//                             MyChestContainer.createGeneric9X3(windowId, inv)));
// }
//
