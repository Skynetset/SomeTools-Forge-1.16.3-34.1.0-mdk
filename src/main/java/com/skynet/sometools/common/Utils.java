package com.skynet.sometools.common;

import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * baseUtils
 *
 * @program: forge-1.16.3-34.1.0-mdk
 * @author: 1260535819@qq.com
 * @create: 2021-01-13 10:02
 */

public class Utils {
    public static final String MOD_ID = "sometools";
    public static final Logger LOGGER = LogManager.getLogger();

    public static boolean isNull(Object obj) {
        return obj == null;
    }

    public static boolean isNotNull(Object obj) {
        return !isNull(obj);
    }

    public static boolean isEmpty(Object obj) {
        if (obj == null) {
            return true;
        } else if (obj instanceof CharSequence) {
            return ((CharSequence) obj).length() == 0;
        } else if (obj instanceof Collection) {
            return ((Collection) obj).isEmpty();
        } else if (obj instanceof Map) {
            return ((Map) obj).isEmpty();
        } else if (obj.getClass().isArray()) {
            return Array.getLength(obj) == 0;
        }

        return false;
    }

    public static boolean isNotEmpty(Object obj) {
        return !isEmpty(obj);
    }

    /**
     * 判断stack1是否等于stack2
     * @author : 1260535819@qq.com
     * @date : 2021/2/10 17:52
     * @param stack1 :
     * @param stack2 :
     * @return : boolean
     */
    public static boolean stackEqualExact(ItemStack stack1, ItemStack stack2) {
        return stack1.getItem() == stack2.getItem() && ItemStack.areItemStackTagsEqual(stack1, stack2);
    }

    /**
     * 获取背包中所有副手中相同的物品对应的槽
     * @author : 1260535819@qq.com
     * @date : 2021/2/10 17:53
     * @param playerInventory :
     * @param itemStack :
     * @return : java.util.List<java.lang.Integer>
     */
    public static List<Integer> getAllSlot(PlayerInventory playerInventory, ItemStack itemStack) {
        List<Integer> slots = new ArrayList<>();
        for (int i = 0; i < playerInventory.getSizeInventory(); ++i) {
            ItemStack stackInSlot = playerInventory.getStackInSlot(i);
            if (!stackInSlot.isEmpty() && stackEqualExact(itemStack, stackInSlot)) {
                slots.add(i);
            }
        }
        return slots;
    }

    /**
     * 获取背包中所有副手中物品的总数
     * @author : 1260535819@qq.com
     * @date : 2021/2/10 17:54
     * @param playerInventory :
     * @param slots :
     * @return : java.lang.Integer
     */
    public static Integer getTotalCountOfStack(PlayerInventory playerInventory, List<Integer> slots) {
        Integer count = 0;
        if (isEmpty(slots)) {
            return count;
        }
        for (int i = 0; i < slots.size(); ++i) {
            count += playerInventory.getStackInSlot(slots.get(i)).getCount();
        }
        return count;
    }
}
