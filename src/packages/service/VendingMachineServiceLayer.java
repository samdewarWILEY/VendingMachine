package packages.service;

import packages.dao.VendingMachineDAO;
import packages.service.Exception.VendingMachineInsufficientCoinException;
import packages.service.Exception.VendingMachineItemNotFoundException;
import packages.service.Exception.VendingMachineOutOfStockException;

import java.math.BigDecimal;

public interface VendingMachineServiceLayer{

    public void dispenseItem(BigDecimal coin, String itemName, VendingMachineDAO dao) throws VendingMachineInsufficientCoinException,
            VendingMachineItemNotFoundException, VendingMachineOutOfStockException;

    public void returnCoin(BigDecimal coin, String itemName,VendingMachineDAO dao) throws VendingMachineItemNotFoundException;

}
