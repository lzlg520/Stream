package com.lzlg.design.template;

/**
 * 模板方法抽象类--在线银行
 * 资料需要集成此类，并实现抽象方法
 */
public abstract class OnlineBanking {
    /**
     * 加入参数Consumer<Customer> makeCustomerHappy
     *
     * @param id
     */
    public void processCustomer(int id) {
        Customer c = Database.getCustomerWithId(id);
        makeCustomerHappy(c);
    }

    /**
     * 去除抽象方法，变成非抽象类
     *
     * @param c
     */
    abstract void makeCustomerHappy(Customer c);
}
