/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import adt.DMSortedListInterface;
import java.util.Date;

/**
 *
 * @author MSI-
 */
public class DeliveryMan implements Comparable<DeliveryMan> {
    private int manID;
    private String pw;
    private static int nextManID = 0001;
    private String name;
    private String contactNum;
    private String adds;
    private String status;
    private Date DateTime;
    private String workingStatus;
    private String orderCharge;
    private int maxDelivery;
    private double totalonCash;
    private double rating;
    private int totalDeliveries;
 
    
    

    public String getOrderCharge() {
        return orderCharge;
    }

    public void setOrderCharge(String orderCharge) {
        this.orderCharge = orderCharge;
    }

    public int getMaxDelivery() {
        return maxDelivery;
    }

    public void setMaxDelivery(int maxDelivery) {
        this.maxDelivery = maxDelivery;
    }

    public DeliveryMan() {
    }

    public String getWorkingStatus() {
        return workingStatus;
    }

    public void setWorkingStatus(String workingStatus) {
        this.workingStatus = workingStatus;
    }

    public Date getDateTime() {
        return DateTime;
    }

    public void setDateTime(Date DateTime) {
        this.DateTime = DateTime;
    }

    public DeliveryMan(int manID, String name) {
        this.manID =  nextManID++;
        this.name = name;
    }

    public DeliveryMan(String name) {
        this.manID = nextManID++;
        this.name = name;
    }


    public DeliveryMan(int manID, String name, String pw,String contactNum, String adds, String status, Date DateTime, String workingStatus, String orderCharge, int maxDelivery) {

        this.manID = nextManID++;
        this.pw = pw;
        this.name = name;
        this.contactNum = contactNum;
        this.adds = adds;
        this.status = status;
        this.DateTime = DateTime;
        this.workingStatus = workingStatus;
        this.orderCharge = orderCharge;
        this.maxDelivery = maxDelivery;
    }
    
      public DeliveryMan(int manID, String name, String pw,String contactNum, String adds, String status, Date DateTime, String workingStatus, String orderCharge, int maxDelivery, double totalonCash, double rating, int totalDeliveries) {

        this.manID = nextManID++;
        this.pw = pw;
        this.name = name;
        this.contactNum = contactNum;
        this.adds = adds;
        this.status = status;
        this.DateTime = DateTime;
        this.workingStatus = workingStatus;
        this.orderCharge = orderCharge;
        this.maxDelivery = maxDelivery;
        this.totalonCash = totalonCash;
        this.rating = rating;
        this.totalDeliveries = totalDeliveries;
    }

    public void setTotalonCash(double totalonCash) {
        this.totalonCash = totalonCash;
    }

    public double getTotalonCash() {
        return totalonCash;
    }
    
    public int getManID() {
        return manID;
    }

    public void setManID(int manID) {
        this.manID = nextManID++;
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }

    public static int getNextManID() {
        return nextManID;
    }

    public static void setNextManID(int nextManID) {
        DeliveryMan.nextManID = nextManID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

     public double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }
    
    
    public String getContactNum() {
        return contactNum;
    }

    public void setContactNum(String contactNum) {
        this.contactNum = contactNum;
    }

    public String getAdds() {
        return adds;
    }

    public void setAdds(String adds) {
        this.adds = adds;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    public int getTotalDeliveries() {
        return totalDeliveries;
    }

    public void setTotalDeliveries(int totalDeliveries) {
        this.totalDeliveries = totalDeliveries;
    }
    
    public String toString(){
        return String.format("No. %-10d %-20s %-20s %-20s  %-20s %.1f %4d", manID, name,contactNum,adds,status,rating,totalDeliveries);
//        return String.format("No. %-10d %-20s %-20s %-20s  %-20s %.1f %4d  %4d", manID, name,contactNum,adds,status,rating,totalDeliveries, dayTotalDeliveries);
    }
    
    @Override
    public int compareTo(DeliveryMan T){
        int nextrow = 1;
      //compare rating
        if(this.rating <= T.getRating())
        {
            
            if(this.rating== T.getRating())
            {
               
                // compare the manID
                if(Integer.toString(this.getManID()).compareTo(Integer.toString(T.getManID()))>0)
                {
                    nextrow = 1; 
                }
                else{
                    nextrow = 0;
                }
            }
            else{
                nextrow = 1;
            }
        }
        else{
            nextrow = 0;
        }
        return nextrow;
    }


    
}


    
