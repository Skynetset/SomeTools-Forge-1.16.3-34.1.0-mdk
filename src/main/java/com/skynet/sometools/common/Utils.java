package com.skynet.sometools.common;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.lang.reflect.Array;
import java.util.Collection;
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
}
