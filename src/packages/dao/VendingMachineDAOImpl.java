package packages.dao;

import packages.dto.VendingMachineItem;

import java.io.*;
import java.math.BigDecimal;
import java.util.*;

public class VendingMachineDAOImpl implements VendingMachineDAO{

    private HashMap<String,VendingMachineItem> items;
    private final String filePath = "../VendingMachine/src/data.txt";
    private FileReader fileReader;
    private FileWriter fileWriter;
    private BufferedReader bufferedReader;
    private final String DELIMITER = "::";

    public VendingMachineDAOImpl() {
        items = new HashMap<>();
        unmarshallItems();
    }

    @Override
    public HashMap<String, VendingMachineItem> getAllItems() {
        marshallItems();
        return this.items;
    }



    @Override
    public void setAllItems(HashMap<String, VendingMachineItem> items) {
        this.items = items;
    }

    private void marshallItems(){
        try {
            fileWriter = new FileWriter(filePath);
            for (String name : items.keySet()){
                String line = "";
                VendingMachineItem item = items.get(name);
                line += name + DELIMITER + item.getCost() + DELIMITER + item.getQuantity();
                fileWriter.write(line);
                fileWriter.write(System.lineSeparator());
            }
            fileWriter.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void unmarshallItems() {
        try {
            fileReader = new FileReader(filePath);
            bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine())!= null){
                System.out.println(line);
                String[] tokens = line.split(DELIMITER);
                String name = tokens[0];
                BigDecimal cost = new BigDecimal(tokens[1]);
                int qty = Integer.parseInt(tokens[2]);
                VendingMachineItem item = new VendingMachineItem(name,cost,qty);
                items.put(name,item);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateInventory(String itemToUpdate){
        unmarshallItems();
        VendingMachineItem item = items.get(itemToUpdate); // update quanity value of this item
        item.setQuantity(item.getQuantity() - 1);
        marshallItems();
    }



}
