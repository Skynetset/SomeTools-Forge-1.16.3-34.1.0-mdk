package com.skynet.sometools.listregistered.entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.IPacket;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * TODO FlyingSwordEntity  实体类之逻辑
 *
 * @program: SomeTools-Forge-1.16.3-34.1.0-mdk
 * @author: 1260535819@qq.com
 * @create: 2021-01-16 17:30
 */

public class FlyingSwordEntity extends Entity {
    /**
     * 数据同步
     * 所有同步的数据，都得先声明好，
     * 请注意这里的变量类型必须是static的，可以通过改变泛型的方式来修改需要同步值的类型。
     * 然后调用EntityDataManager.createKey来创建这个需要同步的数据。
     * 这里有两个参数，第一个参数一般是填入实体的类，第二个参数是控制了变量是如何序列化成字节流，
     * 对于Integer类型来说用DataSerializers.VARINT就行了，
     * 但是对于Float类型就需要特殊的序列化方式（这和浮点数的表示有关。），
     * DataSerializers 下面已经写好了许多方便的实例。
     *
     * @author : 1260535819@qq.com
     * @date : 2021/1/16 17:33
     * @param null :
     * @return : null
     */
    private static final DataParameter<Integer> COUNTER = EntityDataManager.createKey(FlyingSwordEntity.class,
            DataSerializers.VARINT);
    private final Logger logger = LogManager.getLogger();

    public FlyingSwordEntity(EntityType<?> entityTypeIn, World worldIn) {
        super(entityTypeIn, worldIn);
    }

    /**
     * 注册创建的数据同步
     * 所有需要同步的数据都需要注册进this.dataManager中
     *
     * @return : void
     *
     * @author : 1260535819@qq.com
     * @date : 2021/1/16 17:36
     */
    @Override
    protected void registerData() {
        this.dataManager.register(COUNTER, 0);
    }

    /**
     * 保持和恢复数据
     *
     * @param compound :
     *
     * @return : void
     *
     * @author : 1260535819@qq.com
     * @date : 2021/1/16 17:37
     */
    @Override
    protected void readAdditional(CompoundNBT compound) {
        this.dataManager.set(COUNTER, compound.getInt("counter"));
    }

    @Override
    protected void writeAdditional(CompoundNBT compound) {
        compound.putInt("counter", this.dataManager.get(COUNTER));
    }

    /**
     * 具体逻辑
     *
     * @return : void
     *
     * @author : 1260535819@qq.com
     * @date : 2021/1/16 17:38
     */
    @Override
    public void tick() {
        if (world.isRemote) {
            logger.info(this.dataManager.get(COUNTER));
        }
        if (!world.isRemote) {
            logger.info(this.dataManager.get(COUNTER));
            this.dataManager.set(COUNTER, this.dataManager.get(COUNTER) + 1);
        }
        super.tick();
    }

    /**
     * 实体是在服务端创建以后再通知客户端创建，所以这里涉及到了发包操作，
     * 不能再这里复用Minecraft原版提供的方法，这里必须使用Forge提供的NetworkHooks.getEntitySpawningPacket(this);
     * 来在客户端创建实体
     *
     * @return : net.minecraft.network.IPacket<?>
     *
     * @author : 1260535819@qq.com
     * @date : 2021/1/16 17:32
     */
    @Override
    public IPacket<?> createSpawnPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }
}

