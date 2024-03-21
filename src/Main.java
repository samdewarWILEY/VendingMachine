import packages.controller.VendingMachineController;
import packages.dao.VendingMachineDAO;
import packages.dao.VendingMachineDAOImpl;
import packages.io.UserIO;
import packages.io.UserIOImpl;
import packages.service.VendingMachineServiceLayer;
import packages.service.VendingMachineServiceLayerImpl;
import packages.view.VendingMachineView;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        UserIO io = new UserIOImpl();
        VendingMachineDAO dao = new VendingMachineDAOImpl();
        VendingMachineServiceLayer serviceLayer = new VendingMachineServiceLayerImpl(new HashMap<>());

        VendingMachineView view = new VendingMachineView(io);
        VendingMachineController controller = new VendingMachineController(dao,serviceLayer,view);
        controller.run();
    }
}