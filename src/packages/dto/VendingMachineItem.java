package packages.dto;

import packages.view.VendingMachineView;

import java.math.BigDecimal;

public class VendingMachineItem {
    private String name;
    private BigDecimal cost;
    private int quantity;

    public VendingMachineItem(String name, BigDecimal cost, int quantity){
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

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
