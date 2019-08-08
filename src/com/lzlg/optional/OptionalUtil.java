package com.lzlg.optional;

import java.util.Optional;
import java.util.Properties;

/**
 * Optional工具类
 */
public class OptionalUtil {
    private OptionalUtil() {
    }

    /**
     * 将字符串转换为整数
     *
     * @param s
     * @return
     */
    public static Optional<Integer> stringToInt(String s) {
        try {
            return Optional.of(Integer.parseInt(s));
        } catch (NumberFormatException e) {
            return Optional.empty();
        }
    }

    public static int readDuration(Properties properties, String name) {
        return Optional.ofNullable(properties.getProperty(name))
                .flatMap(n -> stringToInt(n))
                .filter(i -> i > 0)
                .orElse(0);
    }
}
