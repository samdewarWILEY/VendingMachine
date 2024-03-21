package packages.service;

import packages.dao.VendingMachineDAO;
import packages.dto.VendingMachineItem;
import packages.service.Exception.VendingMachineInsufficientCoinException;
import packages.service.Exception.VendingMachineItemNotFoundException;
import packages.service.Exception.VendingMachineOutOfStockException;

import java.math.BigDecimal;
import java.util.HashMap;

public interface VendingMachineServiceLayer{

    public void dispenseItem(BigDecimal coin, String itemName) throws VendingMachineInsufficientCoinException,
            VendingMachineItemNotFoundException, VendingMachineOutOfStockException;

    public void returnCoin(BigDecimal coin, String itemName) throws VendingMachineItemNotFoundException;

    public HashMap<String, VendingMachineItem> getAllItems();

    public void setAllItems(HashMap<String,VendingMachineItem> items);

    public void buyItem(int userSelection, String userCoin) throws VendingMachineItemNotFoundException, VendingMachineInsufficientCoinException, VendingMachineOutOfStockException;
}
