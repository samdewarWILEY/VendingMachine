package packages.service;

import packages.dao.VendingMachineDAO;
import packages.dao.VendingMachineDAOImpl;
import packages.dto.VendingMachineItem;
import packages.service.Exception.VendingMachineInsufficientCoinException;
import packages.service.Exception.VendingMachineItemNotFoundException;
import packages.service.Exception.VendingMachineOutOfStockException;

import java.math.BigDecimal;
import java.util.*;

public class VendingMachineServiceLayerImpl implements VendingMachineServiceLayer{

    public VendingMachineServiceLayerImpl(HashMap<CoinValues, Integer> coinSystem) {
        //instantiate the all the coins value as 0 by default
        for (CoinValues coin : coinSystem.keySet()){
            coinSystem.put(coin,0);
        }
    }

    @Override
    public void dispenseItem(BigDecimal coin, String itemName, VendingMachineDAO dao) throws
            VendingMachineInsufficientCoinException,
            VendingMachineItemNotFoundException,
            VendingMachineOutOfStockException
    {
        // The item is not exist in the vending machine
        if(!dao.getAllItems().containsKey(itemName)){
            throw new VendingMachineItemNotFoundException("The item can not found: " +itemName);
        }
        VendingMachineItem currentItem = dao.getAllItems().get(itemName);
        // not enough stock
        if(currentItem.getQuantity() < 1){
            throw new VendingMachineOutOfStockException("The item "+ itemName + " is currently out of stock");
        }
        BigDecimal itemCost = currentItem.getCost();
        // not enough coin input
        if(itemCost.compareTo(coin)>0){
            throw new VendingMachineInsufficientCoinException("Please provide sufficient coin");
        }
        System.out.println("Payment Successful, vending now ...." );
    }

    //returning the remaining coin to user
    public void returnCoin(BigDecimal coin, String itemName,VendingMachineDAO dao) throws VendingMachineItemNotFoundException{
        if(!dao.getAllItems().containsKey(itemName)){
            throw new VendingMachineItemNotFoundException("The item can not found: " +itemName);
        }
        VendingMachineItem currentItem = dao.getAllItems().get(itemName);
        BigDecimal itemCost = currentItem.getCost();
        BigDecimal remainingCoin = coin.subtract(itemCost);
        int[] numsOfCoins = new int[4];
        int index = 0;
        for (CoinValues value:CoinValues.values()){
            numsOfCoins[index++] = remainingCoin.divide(value.getValue()).intValue();
            remainingCoin = remainingCoin.remainder(value.getValue());
        }
        //return coin message
        for (int i = 0 ; i < numsOfCoins.length; i++){
            if(numsOfCoins[i]!= 0){
                System.out.println("Here is the change : " + CoinValues.Dime.getValueByIndex(i) + " quantities : " + numsOfCoins[i]);
            }
        }
    }
}
