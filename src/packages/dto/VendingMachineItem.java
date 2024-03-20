package packages.dto;

import packages.view.VendingMachineView;

public class VendingMachineItem {
    private String name;
    private double cost;
    private int quantity;

    public VendingMachineItem(String name, double cost, int quantity){
        this.cost= cost;
        this.name = name;
        this.quantity =  quantity;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
