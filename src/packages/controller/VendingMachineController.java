package packages.controller;

import packages.dao.VendingMachineDAO;

import packages.service.Exception.VendingMachineItemNotFoundException;
import packages.service.VendingMachineServiceLayer;
import packages.view.VendingMachineView;

import java.math.BigDecimal;

public class VendingMachineController {


    private VendingMachineServiceLayer serviceLayer;
    private VendingMachineView view;


    public VendingMachineController(VendingMachineServiceLayer serviceLayer, VendingMachineView view) {
        this.serviceLayer = serviceLayer;
        this.view = view;
    }


    public void run() throws VendingMachineItemNotFoundException {
        var items = serviceLayer.getAllItems();
        while (true) {
            view.displayAllItems(items);
            view.promptForItem();
            view.promptToInsertCoin();
            serviceLayer.buyItem(view.promptForItem(), view.promptToInsertCoin());
            serviceLayer.setAllItems(items);
        }
    }

    private void returnCoin() {

    }


}
