package com.skynet.sometools.listregistered.item.blocks.blockentity.container;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.inventory.container.Slot;
import net.minecraft.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

/**
 * TODO ObsidianFirstContainer
 *
 * @program: SomeTools-Forge-1.16.3-34.1.0-mdk
 * @author: 1260535819@qq.com
 * @create: 2021-01-16 23:32
 */

public class MyChestContainer extends Container {
    private final int numRows;
    private final IInventory lowerChestInventory;

    private MyChestContainer(ContainerType<?> type, int id, PlayerInventory player, int rows) {
        this(type, id, player, new Inventory(9 * rows), rows);
    }

    public static MyChestContainer createGeneric9X1(int id, PlayerInventory player) {
        return new MyChestContainer(ContainerType.GENERIC_9X1, id, player, 1);
    }

    public static MyChestContainer createGeneric9X2(int id, PlayerInventory player) {
        return new MyChestContainer(ContainerType.GENERIC_9X2, id, player, 2);
    }

    public static MyChestContainer createGeneric9X3(int id, PlayerInventory player) {
        return new MyChestContainer(ContainerType.GENERIC_9X3, id, player, 3);
    }

    public static MyChestContainer createGeneric9X4(int id, PlayerInventory player) {
        return new MyChestContainer(ContainerType.GENERIC_9X4, id, player, 4);
    }

    public static MyChestContainer createGeneric9X5(int id, PlayerInventory player) {
        return new MyChestContainer(ContainerType.GENERIC_9X5, id, player, 5);
    }

    public static MyChestContainer createGeneric9X6(int id, PlayerInventory player) {
        return new MyChestContainer(ContainerType.GENERIC_9X6, id, player, 6);
    }

    public static MyChestContainer createGeneric9X3(int id, PlayerInventory player, IInventory blockEntity) {
        return new MyChestContainer(ContainerType.GENERIC_9X3, id, player, blockEntity, 3);
    }

    public static MyChestContainer createGeneric9X6(int id, PlayerInventory player, IInventory blockEntity) {
        return new MyChestContainer(ContainerType.GENERIC_9X6, id, player, blockEntity, 6);
    }

    public MyChestContainer(ContainerType<?> type, int id, PlayerInventory playerInventoryIn, IInventory p_i50092_4_, int rows) {
        super(type, id);
        assertInventorySize(p_i50092_4_, rows * 9);
        this.lowerChestInventory = p_i50092_4_;
        this.numRows = rows;
        p_i50092_4_.openInventory(playerInventoryIn.player);
        int i = (this.numRows - 4) * 18;

        for(int j = 0; j < this.numRows; ++j) {
            for(int k = 0; k < 9; ++k) {
                this.addSlot(new Slot(p_i50092_4_, k + j * 9, 8 + k * 18, 18 + j * 18));
            }
        }

        for(int l = 0; l < 3; ++l) {
            for(int j1 = 0; j1 < 9; ++j1) {
                this.addSlot(new Slot(playerInventoryIn, j1 + l * 9 + 9, 8 + j1 * 18, 103 + l * 18 + i));
            }
        }

        for(int i1 = 0; i1 < 9; ++i1) {
            this.addSlot(new Slot(playerInventoryIn, i1, 8 + i1 * 18, 161 + i));
        }

    }

//    public MyChestContainer(int id, PlayerInventory playerInventory, BlockPos pos, World world,
//                            ObsidianFirstContainerItemNumber intArray) {
//        super(ContainerTypeRegister.obsidianFirstContainer.get(), id);
//        this.intArray = intArray;
//        trackIntArray(this.intArray);
//        ObsidianFirstContainerTileEntity obsidianFirstContainerTileEntity = (ObsidianFirstContainerTileEntity) world.getTileEntity(pos);
//        this.addSlot(new Slot(obsidianFirstContainerTileEntity.getInventory(), 0, 80, 32));
//        this.addSlot(new Slot(obsidianFirstContainerTileEntity.getInventory(), 0, 80, 32));
//        layoutPlayerInventorySlots(playerInventory, 8, 84);
//    }

    private int addSlotRange(IInventory inventory, int index, int x, int y, int amount, int dx) {
        for (int i = 0; i < amount; i++) {
            addSlot(new Slot(inventory, index, x, y));
            x += dx;
            index++;
        }
        return index;
    }

    private int addSlotBox(IInventory inventory, int index, int x, int y, int horAmount, int dx, int verAmount, int dy) {
        for (int j = 0; j < verAmount; j++) {
            index = addSlotRange(inventory, index, x, y, horAmount, dx);
            y += dy;
        }
        return index;
    }

    private void layoutPlayerInventorySlots(IInventory inventory, int leftCol, int topRow) {
        // Player inventory
        addSlotBox(inventory, 9, leftCol, topRow, 9, 18, 3, 18);

        // Hotbar
        topRow += 58;
        addSlotRange(inventory, 0, leftCol, topRow, 9, 18);
    }


    /**
     * Determines whether supplied player can use this container
     */
    @Override
    public boolean canInteractWith(PlayerEntity playerIn) {
        return this.lowerChestInventory.isUsableByPlayer(playerIn);
    }

    /**
     * Handle when the stack in slot {@code index} is shift-clicked. Normally this moves the stack between the player
     * inventory and the other inventory(s).
     */
    @Override
    public ItemStack transferStackInSlot(PlayerEntity playerIn, int index) {
        ItemStack itemstack = ItemStack.EMPTY;
        Slot slot = this.inventorySlots.get(index);
        if (slot != null && slot.getHasStack()) {
            ItemStack itemstack1 = slot.getStack();
            itemstack = itemstack1.copy();
            if (index < this.numRows * 9) {
                if (!this.mergeItemStack(itemstack1, this.numRows * 9, this.inventorySlots.size(), true)) {
                    return ItemStack.EMPTY;
                }
            } else if (!this.mergeItemStack(itemstack1, 0, this.numRows * 9, false)) {
                return ItemStack.EMPTY;
            }

            if (itemstack1.isEmpty()) {
                slot.putStack(ItemStack.EMPTY);
            } else {
                slot.onSlotChanged();
            }
        }

        return itemstack;
    }

    /**
     * Called when the container is closed.
     */
    @Override
    public void onContainerClosed(PlayerEntity playerIn) {
        super.onContainerClosed(playerIn);
        this.lowerChestInventory.closeInventory(playerIn);
    }

    /**
     * Gets the inventory associated with this chest container.
     *
     * @see #getLowerChestInventory
     */
    public IInventory getLowerChestInventory() {
        return this.lowerChestInventory;
    }

    @OnlyIn(Dist.CLIENT)
    public int getNumRows() {
        return this.numRows;
    }
}

