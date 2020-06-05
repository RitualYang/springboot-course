package com.wty.constant;

/**
 * @author WTY
 * @Date 2020/5/30 22:23
 */
public enum I18nConstant {
    USERNAME("username");
    private final String key;

    I18nConstant(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }
}
