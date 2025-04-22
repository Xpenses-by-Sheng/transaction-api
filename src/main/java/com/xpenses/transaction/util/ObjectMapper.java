package com.xpenses.transaction.util;

import org.modelmapper.ModelMapper;

public class ObjectMapper {

    private static final ModelMapper MAPPER = new ModelMapper();

    /***
     * Convert object of type S to object of type T
     * @param obj
     * @param classType
     * @return mapped object
     * @param <S>
     * @param <T>
     */
    public static <S, T> T mapObject(S obj, Class<T> classType) {
        return MAPPER.map(obj, classType);
    }

}
