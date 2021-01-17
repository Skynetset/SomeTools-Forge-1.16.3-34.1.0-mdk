package com.skynet.sometools.blocks.blockentity;

import com.skynet.sometools.blocks.blockentity.container.ObsidianFirstContainer;
import com.skynet.sometools.blocks.blockentity.container.ObsidianFirstContainerItemNumber;
import com.skynet.sometools.common.Utils;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.DoubleSidedInventory;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.inventory.container.ChestContainer;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.*;
import net.minecraft.util.NonNullList;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;

/**
 * TODO ObsidianFirstContainerTileEntity
 *
 * @program: SomeTools-Forge-1.16.3-34.1.0-mdk
 * @author: 1260535819@qq.com
 * @create: 2021-01-16 23:25
 */

@OnlyIn(
        value = Dist.CLIENT,
        _interface = IChestLid.class
)
public class MyChestWithContainerTileEntity extends LockableLootTileEntity implements IChestLid, ITickableTileEntity {
    public static final Integer SLOT_NUM=27;
    private NonNullList<ItemStack> chestContents = NonNullList.withSize(SLOT_NUM, ItemStack.EMPTY);

    /**
     * The current angle of the lid (between 0 and 1)
     * 盖子的当前角度（0到1之间）
     */
    protected float lidAngle;
    /**
     * The angle of the lid last tick
     * 盖子最后一个刻度的角度
     */
    protected float prevLidAngle;
    /**
     * The number of players currently using this chest
     * 当前使用此箱子的玩家数量
     */
    protected int numPlayersUsing;
    /**
     * A counter that is incremented once each tick. Used to determine when to recompute ; this is done every 200
     * ticks (but staggered between different chests). However, the new value isn't actually sent to clients when it is
     * changed.
     * 一个计数器，每个刻度增加一次。 用于确定何时重新计算;
     * 每200个刻度完成一次（但在不同的箱子之间错开）。
     * 但是，更改后，新值实际上并未发送给客户端。
     */
    private int ticksSinceSync;


//    private Inventory inventory = new Inventory(SLOT_NUM);
//    private ObsidianFirstContainerItemNumber itemNumber = new ObsidianFirstContainerItemNumber();

    public MyChestWithContainerTileEntity() {
        super(TileEntityTypeRegister.MY_CHEST_WITH_CONTAINER_TILE_ENTITY.get());
    }

    @Override
    public ITextComponent getDisplayName() {
        return new TranslationTextComponent("gui." + Utils.MOD_ID + ".chest");
    }

    @Override
    protected ITextComponent getDefaultName() {
        return new TranslationTextComponent("gui." + Utils.MOD_ID + ".chestDefault");
    }

    @Override
    protected NonNullList<ItemStack> getItems() {
        return this.chestContents;
    }

    @Override
    protected void setItems(NonNullList<ItemStack> itemsIn) {
        this.chestContents = itemsIn;
    }

    @Override
    protected Container createMenu(int id, PlayerInventory player) {
        return ChestContainer.createGeneric9X3(id, player, this);
    }

    @Override
    public void read(BlockState state, CompoundNBT nbt) {
        super.read(state, nbt);
        this.chestContents = NonNullList.withSize(this.getSizeInventory(), ItemStack.EMPTY);
        if (!this.checkLootAndRead(nbt)) {
            ItemStackHelper.loadAllItems(nbt, this.chestContents);
        }
    }

    @Override
    public CompoundNBT write(CompoundNBT compound) {
        super.write(compound);
        if (!this.checkLootAndWrite(compound)) {
            ItemStackHelper.saveAllItems(compound, this.chestContents);
        }

        return compound;
    }

    @Override
    public void tick() {
        {
            int i = this.pos.getX();
            int j = this.pos.getY();
            int k = this.pos.getZ();
            ++this.ticksSinceSync;
            this.numPlayersUsing = calculatePlayersUsingSync(this.world, this, this.ticksSinceSync, i, j, k, this.numPlayersUsing);
            this.prevLidAngle = this.lidAngle;
            float f = 0.1F;
            if (this.numPlayersUsing > 0 && this.lidAngle == 0.0F) {
//                this.playSound(SoundEvents.BLOCK_CHEST_OPEN);
                PlayerEntity player = world.getClosestPlayer(pos.getX(), pos.getY(), pos.getZ(), 10, false);
                if (player != null) {
                    player.sendStatusMessage(new TranslationTextComponent("message.my_chest_with_container.open"),
                            true);
                }
            }

            if (this.numPlayersUsing == 0 && this.lidAngle > 0.0F || this.numPlayersUsing > 0 && this.lidAngle < 1.0F) {
                float f1 = this.lidAngle;
                if (this.numPlayersUsing > 0) {
                    this.lidAngle += 0.1F;
                } else {
                    this.lidAngle -= 0.1F;
                }

                if (this.lidAngle > 1.0F) {
                    this.lidAngle = 1.0F;
                }

                float f2 = 0.5F;
                if (this.lidAngle < 0.5F && f1 >= 0.5F) {
//                    this.playSound(SoundEvents.BLOCK_CHEST_CLOSE);
                    PlayerEntity player = world.getClosestPlayer(pos.getX(), pos.getY(), pos.getZ(), 10, false);
                    if (player != null) {
                        player.sendStatusMessage(new TranslationTextComponent("message.my_chest_with_container.close"),
                                true);
                    }
                }

                if (this.lidAngle < 0.0F) {
                    this.lidAngle = 0.0F;
                }
            }

        }
    }

    @Override
    public int getSizeInventory() {
        return SLOT_NUM;
    }

    @Override
    public float getLidAngle(float partialTicks) {
        return this.lidAngle;
    }

    public static int calculatePlayersUsingSync(World p_213977_0_, LockableTileEntity p_213977_1_, int p_213977_2_, int p_213977_3_, int p_213977_4_, int p_213977_5_, int p_213977_6_) {
        if (!p_213977_0_.isRemote && p_213977_6_ != 0 && (p_213977_2_ + p_213977_3_ + p_213977_4_ + p_213977_5_) % 200 == 0) {
            p_213977_6_ = calculatePlayersUsing(p_213977_0_, p_213977_1_, p_213977_3_, p_213977_4_, p_213977_5_);
        }

        return p_213977_6_;
    }
    public static int calculatePlayersUsing(World p_213976_0_, LockableTileEntity p_213976_1_, int p_213976_2_, int p_213976_3_, int p_213976_4_) {
        int i = 0;
        float f = 5.0F;

        for(PlayerEntity playerentity : p_213976_0_.getEntitiesWithinAABB(PlayerEntity.class, new AxisAlignedBB((double)((float)p_213976_2_ - 5.0F), (double)((float)p_213976_3_ - 5.0F), (double)((float)p_213976_4_ - 5.0F), (double)((float)(p_213976_2_ + 1) + 5.0F), (double)((float)(p_213976_3_ + 1) + 5.0F), (double)((float)(p_213976_4_ + 1) + 5.0F)))) {
            if (playerentity.openContainer instanceof ChestContainer) {
                IInventory iinventory = ((ChestContainer)playerentity.openContainer).getLowerChestInventory();
                if (iinventory == p_213976_1_ || iinventory instanceof DoubleSidedInventory && ((DoubleSidedInventory)iinventory).isPartOfLargeChest(p_213976_1_)) {
                    ++i;
                }
            }
        }

        return i;
    }
}
