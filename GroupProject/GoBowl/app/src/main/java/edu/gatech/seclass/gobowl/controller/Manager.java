package edu.gatech.seclass.gobowl.controller;

/**
 * Created by charles on 7/7/16.
 */
public interface Manager {
    public void addCustomer(String first, String last, String email);
    public boolean findCustomer(String last, String email);
    public boolean reprintCard();
    public String getCustomerFirst();
    public String getCustomerLast();
    public String getCustomerEmail();
    public void updateCustomer(String first, String last, String email);
}
