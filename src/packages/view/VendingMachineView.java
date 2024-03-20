package packages.view;

import packages.dto.VendingMachineItem;
import packages.io.UserIO;

import java.math.BigDecimal;
import java.util.HashMap;

public class VendingMachineView {
    private UserIO io;

    public VendingMachineView(UserIO io) {
        this.io = io;
    }

    public void displayAllItems(HashMap<String,VendingMachineItem> items) {
        int i = 0; // to assign a number to each item.
        for (VendingMachineItem item : items.values()) {
            io.print(i + ". " + item.getName() + "::" + item.getCost());
            i++;
        }
        io.print(items.size() + " .Exit");
    }

    public BigDecimal promptToInsertCoin() {
        return io.readBigDecimal("Please put a coin into the vending machine: ");
    }

    public int promptForItem() {
        return io.readInt("Please choose an item from the list above.");
    }
}
