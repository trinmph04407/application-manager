/*
 * ================================================================================
 *   == COPYRIGHT HYPERTECH ENTERPRISE SOLUTIONS. ALL RIGHT RESERVED.            ==
 *   == HYPERTECH PROPRIETARY/CONFIDENTIAL. USE THIS SUBJECT TO LICENSE TERMS.   ==
 *   ==                                                                          ==
 *   == VISIT HTTP://HYPERTECH.COM.VN FOR MORE INFORMATION                       ==
 * ================================================================================
 *
 *  == Project: rest-api
 *  == Created by: duongnguyen
 *  == Created at: 12/30/17 4:33 AM
 */
package vn.poly.group2.pro2111.common.utils;

import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;

/**
 * io.cobrafw.utils -> DataTransformUtil
 *
 * @author duongnguyen
 * @since 1.0.0
 */
public final class DataTransformUtil {

    private DataTransformUtil() {
    }

    /**
     * Transform object from a type to another type
     *
     * @param source      Source object
     * @param destination Target type
     *
     * @return Transformed object
     */
    public static void transform(Object source, Object destination) {

        if (destination == null) {
            return;
        }

        try {

            // Copy all properties
            BeanUtils.copyProperties(destination, source);

        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Create object with type from another object
     *
     * @param source      Source object
     * @param targetType Target type
     *
     * @return Transformed object
     */
    public static Object transform(Object source, Class targetType) {

        try {

            // Instance result object
            Object result = targetType.newInstance();

            // Transform object
            transform(source, result);

            // Return result object
            return result;

        } catch (InstantiationException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}
