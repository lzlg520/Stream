package com.lzlg.design.factory;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

/**
 * 产品工厂类
 */
public class ProductFactory {
    private ProductFactory() {
    }

//    public static Product createProduct(String name) {
//        switch (name) {
//            case "loan":
//                return new Loan();
//            case "stock":
//                return new Stock();
//            case "bond":
//                return new Bond();
//            default:
//                throw new RuntimeException("No such product : " + name);
//        }
//    }
    /**
     * 使用Lambda表达式后，变成工厂类的静态域
     * 不适合保存具有三个参数以上的构造函数
     */
    final static Map<String, Supplier<Product>> map = new HashMap<>();

    static {
        map.put("loan", Loan::new);
        map.put("stock", Stock::new);
        map.put("bond", Bond::new);
    }

    public static Product createProduct(String name) {
        Supplier<Product> supplier = map.get(name);
        if (supplier != null) {
            supplier.get();
        }
        throw new IllegalArgumentException("No such product " + name);
    }
}
