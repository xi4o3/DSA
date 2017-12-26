package driver;

import adt.OrderSortedLinkedList;
import adt.OrderSortedListInterface;
import adt.SortedDoublyLinkedList;
import entity.Affiliate;
import entity.Food;
import entity.customer;
import entity.order;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author DANSO
 */
public class UserStory1 {

    public static OrderSortedListInterface<order> orderList = new OrderSortedLinkedList<>();
    private SortedDoublyLinkedList<Affiliate> affiliate = new SortedDoublyLinkedList<>();
    public static SortedDoublyLinkedList<Food> food = new SortedDoublyLinkedList<>();
    public static OrderSortedListInterface<customer> customer = new OrderSortedLinkedList<>();

    private static customer curCustomer;

    public UserStory1(SortedDoublyLinkedList<Affiliate> getaffiliate, SortedDoublyLinkedList<Food> getfood, OrderSortedListInterface<customer> getCust, OrderSortedListInterface<order> getOrder) {
        this.orderList = getOrder;
        this.affiliate = getaffiliate;
        this.food = getfood;
        this.customer = getCust;
    }

    UserStory1(SortedDoublyLinkedList<Affiliate> affiliate, SortedDoublyLinkedList<Food> food) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean custLogin() {
        Scanner login = new Scanner(System.in);
        int idcount = 0;
        boolean password = false;
        while (idcount == 0) {
            System.out.println("===============");
            System.out.println("Customer Login");
            System.out.println("===============");
            System.out.print("Customer ID: ");
            String id = login.nextLine();
            for (int i = 1; i <= customer.getNumberOfEntries(); i++) {
                if (id.equals(customer.getEntry(i).getCusId())) {
                    while (!password) {
                        System.out.print("Password: ");
                        String pass = login.nextLine();
                        idcount = 1;
                        if (pass.equals(customer.getEntry(i).getCusPass())) {
                            password = true;
                            System.out.println("Successfully Login");
                            curCustomer = customer.getEntry(i);
                        } else {
                            System.out.println("Invalid password");
                        }
                    }
                }
            }
            if (idcount == 0) {
                System.out.println("No ID found");
            }
        }
        return password;
    }

    public void order1() {
        orderF();

    }

    public void show() {
        //order.toString();
        for (int i = 1; i <= orderList.getNumberOfEntries(); i++) {
            if (curCustomer.getCusId().equalsIgnoreCase(orderList.getEntry(i).getCustInfo().getCusId()) && orderList.getEntry(i).getStatus().equals("Completed")) {
                System.out.printf(orderList.getEntry(i).toString());
            }
        }
    }

    public void mainRestaurant() {
        System.out.println("==========Fastest Delivery System==========");
        for (int i = 1; i <= affiliate.getSize(); i++) {
            System.out.println(affiliate.getAtPosition(i).getRes_name());
        }
        System.out.println("Back");
    }

    public static void mainBlue() {
        System.out.println("==========Fastest Delivery System==========");

    }

    public void orderF() {
        boolean valid = true;
        order temp = null;
        Scanner order1 = new Scanner(System.in);
        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        Date today = new Date();
        String todaydate = df.format(today);
        String resName = null;
        String name = null;
        int phone = 0;
        String address = null;
        int post = 0;
        String food1 = null;
        int i = 0;
        String statusD = "Pending";
        int foodAmt = 0;
        int orId = orderList.getNumberOfEntries();
        char option;
        String option2 = null;
        double totalP = 0;
        double subTotal = 0;
        for (int c = 1; c <= affiliate.getSize(); c++) {
            System.out.println(affiliate.getAtPosition(c).getRes_name());
        }
        System.out.println("Please type in restaurant name!!");
        System.out.print("Restaurant Name: ");
        resName = order1.nextLine();
        int r;
        do {
            r = -1;
            for (int a = 1; a <= food.getSize(); a++) {
                if (resName.equals(food.getAtPosition(a).getRestaurant().getRes_name()) && food.getAtPosition(a).getFoodAVA().equals("YES")) {
                    r = a;
                    System.out.println(food.getAtPosition(a).toString1());
                }
            }
            if (r == -1) {
                System.out.println("No such Restaurant!!");
                System.out.print("Restaurant Name: ");
                resName = order1.nextLine();
            }
        } while (r == -1);
        String order_id = String.format("P%04d", orId + 1);
        System.out.println("Order ID: " + order_id);
        System.out.print("Name: ");
        name = order1.nextLine();
        do{
        try{
            System.out.print("Phone Number: ");
            phone = Integer.parseInt(order1.nextLine());
            valid = true;
        }catch(Exception ex){
            System.out.println("Please enter number only!!");
            valid = false;
        }
        }while(!valid);
        System.out.print("Address: ");
        address = order1.nextLine();
        do{
        try{
            System.out.print("Postcode: ");
            post = Integer.parseInt(order1.nextLine());
            valid = true;
        }catch(Exception ex){
            System.out.println("Please enter number only!!");
            valid = false;
        }
        }while(!valid);
        System.out.print("Food ID: ");
        food1 = order1.nextLine();

        int f;
        do {
            f = -1;
            for (int b = 1; b <= food.getSize() && f == -1; b++) {
                if (food1.equals(food.getAtPosition(b).getFoodID())) {
                    f = b;
                }
            }
            if (f == -1) {
                System.out.println("Wrong Food ID");
                System.out.print("Food ID: ");
                food1 = order1.nextLine();
            }
        } while (f == -1);

        do{
        try{
            System.out.print("Food Amount: ");
            foodAmt = Integer.parseInt(order1.nextLine());
            valid = true;
        }catch(Exception ex){
            System.out.println("Please enter number only!!");
            valid = false;
        }
        }while(!valid);
        for (int d = 1; d <= food.getSize(); d++) {
            if (food1.equals(food.getAtPosition(d).getFoodID())) {
                totalP = food.getAtPosition(d).getPrice() * foodAmt;
            }
        }
        temp = new order(order_id, name, phone, address, post, food1, foodAmt, totalP, todaydate, statusD, null, curCustomer, null);
        orderList.add(temp);
        System.out.print("Do you want to order other food?[y/n]");
        option = order1.nextLine().charAt(0);
        do {
            if (option == 'y') {
                System.out.print("Food: ");
                food1 = order1.nextLine();
            do{
            try{
                System.out.print("Food Amount: ");
                foodAmt = Integer.parseInt(order1.nextLine());
                valid = true;
            }catch(Exception ex){
                System.out.println("Please enter number only!!");
                valid = false;
              
            }
            }while(!valid);
                for (int d = 1; d <= food.getSize(); d++) {
                    if (food1.equals(food.getAtPosition(d).getFoodID())) {
                        totalP = food.getAtPosition(d).getPrice() * foodAmt;
                    }
                }
                temp = new order(order_id, name, phone, address, post, food1, foodAmt, totalP, todaydate, statusD, null, curCustomer, null);
                orderList.add(temp);
                System.out.print("Do you want to order other food?[y/n]");
                option = order1.nextLine().charAt(0);
            }

            if (option == 'n') {
                System.out.println("Please comfirm order!");
            }
        } while (option == 'y' || option == 'Y');

        System.out.printf("%-20s %-15s\n", "Food ID", "Quantity");
        System.out.println("------------------------------");
        for (int g = 1; g <= orderList.getNumberOfEntries(); g++) {
            if (curCustomer.getCusId().equalsIgnoreCase(orderList.getEntry(g).getCustInfo().getCusId()) && order_id.equals(orderList.getEntry(g).getOrderId())) {
                System.out.printf("%-20s %-8d\n", orderList.getEntry(g).getFood(), orderList.getEntry(g).getFoodAmt());
                subTotal += orderList.getEntry(g).getToPrice();
            }
        }
        System.out.printf("Total price : RM %.2f\n", subTotal);
        System.out.println("Do you comfirm the order?[y/n]");
        option2 = order1.nextLine();
        if (option2.equals("y")) {
            System.out.println("Order Sucessfully added!");
           
        } else if (option2.equals("n")) {
            for (int h = 1; h <= orderList.getNumberOfEntries(); h++) {
                if (order_id.equals(orderList.getEntry(h).getOrderId())) {
                    orderList.remove(h);
                    h--;
                }        
            }
            System.out.println("Order has been cancel!");
        }

    }

}

