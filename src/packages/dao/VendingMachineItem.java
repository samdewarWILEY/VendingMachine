package packages.dao;

public class VendingMachineItem {
    // attribute name will be key in the vending machine
    private String name;
    private int cost;
    private int qty;

    public VendingMachineItem(String name, int cost, int qty) {
        this.name = name;
        this.cost = cost;
        this.qty = qty;
    }

    public String getName() {
        return name;
    }

    public int getCost() {
        return cost;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }
}
