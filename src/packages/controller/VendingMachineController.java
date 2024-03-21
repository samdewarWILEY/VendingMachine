package packages.controller;

import packages.dao.VendingMachineDAO;

import packages.service.Exception.VendingMachineInsufficientCoinException;
import packages.service.Exception.VendingMachineItemNotFoundException;
import packages.service.Exception.VendingMachineOutOfStockException;
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


    public void run() throws VendingMachineItemNotFoundException, VendingMachineInsufficientCoinException, VendingMachineOutOfStockException {
        var items = serviceLayer.getAllItems();
        while (true) {
            view.displayAllItems(items);
            String coin = view.promptToInsertCoin();
            serviceLayer.buyItem(view.promptForItem(), coin);
        }
    }



}
