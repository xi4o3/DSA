/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author MSI-
 */
public class DailyReport implements Comparable<DailyReport>  {
    private int manID;
    private String deliName;
    private String deliContactNo;
    private int totalDeliveries;
    private int totalDistances;

    public DailyReport(int manID, String deliName, String deliContactNo, int totalDeliveries, int totalDistances) {
        this.manID = manID;
        this.deliName = deliName;
        this.deliContactNo = deliContactNo;
        this.totalDeliveries = totalDeliveries;
        this.totalDistances = totalDistances;
    }

    public int getManID() {
        return manID;
    }

    public void setManID(int manID) {
        this.manID = manID;
    }

    public String getDeliName() {
        return deliName;
    }

    public void setDeliName(String deliName) {
        this.deliName = deliName;
    }

    public String getDeliContactNo() {
        return deliContactNo;
    }

    public void setDeliContactNo(String deliContactNo) {
        this.deliContactNo = deliContactNo;
    }

    public int getTotalDeliveries() {
        return totalDeliveries;
    }

    public void setTotalDeliveries(int totalDeliveries) {
        this.totalDeliveries = totalDeliveries;
    }

    public int getTotalDistances() {
        return totalDistances;
    }

    public void setTotalDistances(int totalDistances) {
        this.totalDistances = totalDistances;
    }

    @Override
    public int compareTo(DailyReport o) {
         int nextrow = 1;
      //compare total delivery 
        if(this.totalDeliveries <= o.getTotalDeliveries())
        {
            
            if(this.totalDeliveries== o.getTotalDeliveries())
            {
    
                if(Integer.toString(this.getManID()).compareTo(Integer.toString(o.getManID()))>0)
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
