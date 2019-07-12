package com.lzlg.design.template;

/**
 * 模拟银行数据库
 */
public class Database {
    private Database() {
    }

    public static Customer getCustomerWithId(int id) {
        return new Customer(id, "Sun");
    }
}
