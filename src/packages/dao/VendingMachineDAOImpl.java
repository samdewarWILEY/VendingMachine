package packages.dao;

import java.util.*;

public class VendingMachineDAOImpl implements VendingMachineDAO{

    private Map<String,VendingMachineItem> items;
    private final String filePath = "packages/dao/data.txt";

    @Override
    public Map<String, VendingMachineItem> getAllItems() {
        return this.items;
    }

    @Override
    public void setAllItems(Map<String, VendingMachineItem> items) {
        this.items = items;
    }

    @Override
    public void marshallItems() {

    }

    @Override
    public void unmarshallItems() {

    }

    @Override
    public void updateInventory() {

    }
}
