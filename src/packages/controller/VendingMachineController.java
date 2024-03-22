package packages.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import packages.service.Exception.VendingMachineInsufficientCoinException;
import packages.service.Exception.VendingMachineItemNotFoundException;
import packages.service.Exception.VendingMachineOutOfStockException;
import packages.service.VendingMachineServiceLayer;
import packages.view.VendingMachineView;

@Component
public class VendingMachineController {


    private VendingMachineServiceLayer serviceLayer;
    private VendingMachineView view;

    @Autowired
    public VendingMachineController(VendingMachineServiceLayer serviceLayer, VendingMachineView view) {
        this.serviceLayer = serviceLayer;
        this.view = view;
    }


    public void run() throws VendingMachineItemNotFoundException, VendingMachineInsufficientCoinException, VendingMachineOutOfStockException {
        var items = serviceLayer.getAllItems();
        while (true) {
            view.displayAllItems(items);
            String coin = view.promptToInsertCoin();
            serviceLayer.buyItem(view.promptForItem(), coin);
        }
    }


}
