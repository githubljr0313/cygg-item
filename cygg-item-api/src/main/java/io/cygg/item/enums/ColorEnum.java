package io.cygg.item.enums;


import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

public enum ColorEnum {

    RED("RED", "红色"),
    ORANGE("ORANGE", "橙色"),
    YELLOW("YELLOW", "黄色"),
    GREEN("GREEN", "绿色"),
    CYAN("CYAN", "青色"),
    BLUE("BLUE", "蓝色"),
    BROWN("BROWN", "褐色"),
    PURPLE("PURPLE", "紫色");

    @Getter
    private String code;
    @Getter
    private String name;

    ColorEnum(String code, String name){
        this.code = code;
        this.name = name;
    }

    public static Map<String, ColorEnum> cache = new HashMap<>();

    static {
        for (ColorEnum value : ColorEnum.values()) {
            cache.put(value.getCode(), value);
        }
    }

    public static ColorEnum getEnumByCode(String code){
        return cache.get(code);
    }
}
