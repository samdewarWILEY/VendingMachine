package packages.view;

import packages.dto.VendingMachineItem;
import packages.io.UserIO;

import java.util.Map;

public class VendingMachineView {
    private UserIO io;

    public VendingMachineView(UserIO io) {
        this.io = io;
    }

    public void displayAllItems(Map<String, VendingMachineItem> items) {
        int i = 0; // to assign a number to each item.
        for (VendingMachineItem item : items.values()) {
            io.getString(i + ". " + item.getName() + "::" + item.getCost());
            i++;
        }
        io.printString(items.size() + " .Exit");
    }

    public double promptToInsertCoin() {
        return io.getDouble("Please put a coin into the vending machine: ", 0, 100);
    }

    public int promptForItem() {
        return io.getInt("Please choose an item from the list above.");
    }
}
