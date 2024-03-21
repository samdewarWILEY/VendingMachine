package packages.controller;

import packages.dao.VendingMachineDAO;

import packages.service.VendingMachineServiceLayer;
import packages.view.VendingMachineView;

public class VendingMachineController {


    private VendingMachineServiceLayer serviceLayer;
    private VendingMachineView view;


    public VendingMachineController(VendingMachineServiceLayer serviceLayer, VendingMachineView view) {
        this.serviceLayer = serviceLayer;
        this.view = view;
    }


    public void run() {
        var items = serviceLayer.getAllItems();
        int idx;
        while (true) {
            view.displayAllItems(items);
            view.promptToInsertCoin();
            idx =view.promptForItem();
            if(idx==items.size()) break;
            items.remove(idx);
            serviceLayer.setAllItems(items);
        }
    }

    private void returnCoin(){

    }


}
