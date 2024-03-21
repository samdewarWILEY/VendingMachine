import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import packages.controller.VendingMachineController;
import packages.dao.VendingMachineDAO;
import packages.dao.VendingMachineDAOImpl;
import packages.io.UserIO;
import packages.io.UserIOImpl;
import packages.service.Exception.VendingMachineInsufficientCoinException;
import packages.service.Exception.VendingMachineItemNotFoundException;
import packages.service.Exception.VendingMachineOutOfStockException;
import packages.service.VendingMachineServiceLayer;
import packages.service.VendingMachineServiceLayerImpl;
import packages.view.VendingMachineView;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws VendingMachineItemNotFoundException, VendingMachineInsufficientCoinException, VendingMachineOutOfStockException {
//        UserIO io = new UserIOImpl();
//        VendingMachineDAO dao = new VendingMachineDAOImpl();
//        VendingMachineServiceLayer serviceLayer = new VendingMachineServiceLayerImpl(dao);
//
//        VendingMachineView view = new VendingMachineView(io);
//        VendingMachineController controller = new VendingMachineController(serviceLayer,view);

        AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext();
        appContext.scan("packages");
        appContext.refresh();
        VendingMachineController controller = appContext.getBean( VendingMachineController.class);
        controller.run();
    }
}