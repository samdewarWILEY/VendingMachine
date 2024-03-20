package packages.dao;

import packages.dto.VendingMachineItem;

import java.util.*;

public interface VendingMachineDAO {

    public HashMap<String, VendingMachineItem> getAllItems();

    public void setAllItems(HashMap<String,VendingMachineItem> items);

    public void marshallItems();

    public void unmarshallItems();

}
