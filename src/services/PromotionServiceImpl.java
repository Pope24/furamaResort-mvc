package services;

import models.Customer;
import utils.DataBookingUtil;
import utils.DataPromotionUtil;
import utils.MenuModifier;

import java.io.IOException;
import java.util.Stack;
import java.util.TreeSet;

public class PromotionServiceImpl {
    static DataPromotionUtil promotionService = new DataPromotionUtil();
    static MenuModifier menuModifier = new MenuModifier();
    static TreeSet<Customer> customerListUsedService = null;

    public void displayCustomerListUsedService() {
        customerListUsedService = promotionService.getCustomerListUsedService();
        for (Customer customer : customerListUsedService) {
            System.out.println(customer);
        }
    }
    public void displayCustomerReceiveVoucher() {
        Stack<Integer> voucherStack = menuModifier.getAmountVoucher(promotionService.getCustomerListUsedService().size());
        Stack<Customer> customerStack = new Stack<>();
        TreeSet<Customer> customerListUsedService = promotionService.getCustomerListUsedService();
        for (Customer customer : customerListUsedService) {
            customerStack.push(customer);
        }
        for (int i = 0; i < customerStack.size(); i++) {
            System.out.println(customerStack.elementAt(i) + " ==> voucher: " + voucherStack.elementAt(i) + "%");
        }
    }
}
