package packages.controller;

import packages.dao.VendingMachineDAO;

import packages.service.VendingMachineServiceLayer;
import packages.view.VendingMachineView;

public class VendingMachineController {

    private VendingMachineDAO dao;
    private VendingMachineServiceLayer serviceLayer;
    private VendingMachineView view;


    public VendingMachineController(VendingMachineDAO dao, VendingMachineServiceLayer serviceLayer, VendingMachineView view) {
        this.dao = dao;
        this.serviceLayer = serviceLayer;
        this.view = view;
    }


    public void run() {
        var items = dao.getAllItems();
        int idx;
        while (true) {
            view.displayAllItems(items);
            idx =view.promptForItem();
            if(idx==items.size()) break;
            items.remove(idx);
            dao.setAllItems(items);
        }
    }

    private void returnCoin(){

    }


}
