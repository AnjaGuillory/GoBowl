package edu.gatech.seclass.gobowl.controller;

/**
 * Created by charles on 7/7/16.
 */
public interface Manager {
    public String addCustomer(String first, String last, String email); // Null for no error
    public boolean findCustomer(String last, String email);
    public String findCustomeByCard();
    public boolean reprintCard();
    public String getCustomerFirst();
    public String getCustomerLast();
    public String getCustomerEmail();
    public String updateCustomer(String first, String last, String email);
}
