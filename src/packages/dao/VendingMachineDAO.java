package packages.dao;

import java.util.*;

public interface VendingMachineDAO {

    public Map<String,VendingMachineItem> getAllItems();

    public void setAllItems(Map<String,VendingMachineItem> items);

    public void marshallItems();

    public void unmarshallItems();

}
