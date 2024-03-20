package packages.controller;

import packages.dao.VendingMachineDAO;
import packages.service.VendingMachineServiceLayer;
import packages.view.VendingMachineView;

public class VendingMachineController {

    VendingMachineDAO dao;
    VendingMachineServiceLayer serviceLayer;
    VendingMachineView view;

    VendingMachineController(VendingMachineDAO dao, VendingMachineServiceLayer serviceLayer, VendingMachineView view) {
        this.dao = dao;
        this.serviceLayer = serviceLayer;
        this.view = view;
    }

    public void run() {
        while (true) {
            view.displayAllItems(dao.getAllItems());
            view.promptForItem();
        }
    }


}
