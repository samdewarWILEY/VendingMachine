import packages.controller.VendingMachineController;
import packages.dao.VendingMachineDAO;
import packages.dao.VendingMachineDAOImpl;
import packages.io.UserIO;
import packages.io.UserIOImpl;
import packages.service.Exception.VendingMachineItemNotFoundException;
import packages.service.VendingMachineServiceLayer;
import packages.service.VendingMachineServiceLayerImpl;
import packages.view.VendingMachineView;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws VendingMachineItemNotFoundException {
        UserIO io = new UserIOImpl();
        VendingMachineDAO dao = new VendingMachineDAOImpl();
        VendingMachineServiceLayer serviceLayer = new VendingMachineServiceLayerImpl(dao);

        VendingMachineView view = new VendingMachineView(io);
        VendingMachineController controller = new VendingMachineController(serviceLayer,view);
        controller.run();
    }
}