package packages.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import packages.dto.VendingMachineItem;
import packages.io.UserIO;

import java.math.BigDecimal;
import java.util.HashMap;

@Component
public class VendingMachineView {
    private UserIO io;

    @Autowired
    public VendingMachineView(UserIO io) {
        this.io = io;
    }

    /**
     * Ope
     * Displays all the items in the items hashmap to UserIO
     * @param items of the vending machine
     */
    public void displayAllItems(HashMap<String,VendingMachineItem> items) {
        int i = 0; // to assign a number to each item.
        for (VendingMachineItem item : items.values()) {
            io.print(i + ". " + item.getName() + "::" + item.getCost());
            i++;
        }
        io.print(items.size() + " .Exit");
    }

    /**
     * Ope
     * Sends prompt to IO & reads string
     * @return name of a coin (e.g. nickle)
     */
    public String promptToInsertCoin() {
        return io.readString("Please put a coin into the vending machine: ");
    }

    /**
     * Ope
     * Sends prompt to IO & reads string
     * @return name of an item (e.g. pepsi)
     */
    public int promptForItem() {
        return io.readInt("Please choose an item from the list above.");
    }
}
