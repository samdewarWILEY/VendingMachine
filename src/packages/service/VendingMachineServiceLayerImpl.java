package packages.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import packages.dao.VendingMachineDAO;
import packages.dao.VendingMachineDAOImpl;
import packages.dto.VendingMachineItem;
import packages.service.Exception.VendingMachineInsufficientCoinException;
import packages.service.Exception.VendingMachineItemNotFoundException;
import packages.service.Exception.VendingMachineOutOfStockException;

import java.math.BigDecimal;
import java.util.*;

@Component
public class VendingMachineServiceLayerImpl implements VendingMachineServiceLayer {
    private VendingMachineDAO dao;

    @Autowired
    public VendingMachineServiceLayerImpl(VendingMachineDAO dao) {
        this.dao = dao;
    }

    @Override
    public void dispenseItem(BigDecimal coin, String itemName) throws
            VendingMachineInsufficientCoinException,
            VendingMachineItemNotFoundException,
            VendingMachineOutOfStockException {
        // The item is not exist in the vending machine
        if (!dao.getAllItems().containsKey(itemName)) {
            throw new VendingMachineItemNotFoundException("The item can not found: " + itemName);
        }
        VendingMachineItem currentItem = dao.getAllItems().get(itemName);
        // not enough stock
        if (currentItem.getQuantity() < 1) {
            throw new VendingMachineOutOfStockException("The item " + itemName + " is currently out of stock");
        }
        BigDecimal itemCost = currentItem.getCost();
        // not enough coin input
        if (itemCost.compareTo(coin) > 0) {
            throw new VendingMachineInsufficientCoinException("Please provide sufficient coin");
        }
        System.out.println("Payment Successful, vending now ....");
    }

    //returning the remaining coin to user
    public void returnCoin(BigDecimal coin, String itemName) throws VendingMachineItemNotFoundException {
        if (!dao.getAllItems().containsKey(itemName)) {
            throw new VendingMachineItemNotFoundException("The item can not found: " + itemName);
        }
        VendingMachineItem currentItem = dao.getAllItems().get(itemName);
        BigDecimal itemCost = currentItem.getCost();
        BigDecimal remainingCoin = coin.subtract(itemCost);
        int[] numsOfCoins = new int[4];
        int index = 0;
        for (CoinValues value : CoinValues.values()) {
            numsOfCoins[index++] = remainingCoin.divide(value.getValue()).intValue();
            remainingCoin = remainingCoin.remainder(value.getValue());
        }
        //return coin message
        for (int i = 0; i < numsOfCoins.length; i++) {
            if (numsOfCoins[i] != 0) {
                System.out.println("Here is the change : " + CoinValues.Dime.getValueByIndex(i) + " quantities : " + numsOfCoins[i]);
            }
        }
    }

    @Override
    public HashMap<String, VendingMachineItem> getAllItems() {
        return dao.getAllItems();
    }

    @Override
    public void setAllItems(HashMap<String, VendingMachineItem> items) {
        dao.setAllItems(items);
    }

    public void buyItem(int userSelection, String userCoin) throws VendingMachineItemNotFoundException, VendingMachineInsufficientCoinException, VendingMachineOutOfStockException {
        switch (userSelection) {
            case 0:
                dispenseItem(new BigDecimal(userCoin),"m&m beans");
                returnCoin(new BigDecimal(userCoin), "m&m beans");
                dao.updateInventory("m&m beans");
                break;
            case 1:
                dispenseItem(new BigDecimal(userCoin),"pepsi");
                returnCoin(new BigDecimal(userCoin), "pepsi");
                dao.updateInventory("pepsi");
                break;
            case 2:
                dispenseItem(new BigDecimal(userCoin),"sparkling water");
                returnCoin(new BigDecimal(userCoin), "sparkling water");
                dao.updateInventory("sparkling water");
                break;
            case 3:
                dispenseItem(new BigDecimal(userCoin),"Dortillo Tortilla Chips");
                returnCoin(new BigDecimal(userCoin), "Dortillo Tortilla Chips");
                dao.updateInventory("Doritos Tortilla Chips");
                break;
            default:
                break;
        }

    }
}
