package com.lzlg.design.template;

import java.util.function.Consumer;

/**
 * 使用Lambda表达式的新的在线银行类
 */
public class OnlineBankingLambda {
    /**
     * 加入Consumer<Customer> makeCustomerHappy，使用Lambda表达式
     *
     * @param id
     * @param makeCustomerHappy
     */
    public void processCustomer(int id, Consumer<Customer> makeCustomerHappy) {
        Customer c = Database.getCustomerWithId(id);
        makeCustomerHappy.accept(c);
    }
}
