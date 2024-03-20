package packages.dao;

import java.io.*;
import java.math.BigDecimal;
import java.util.*;

public class VendingMachineDAOImpl implements VendingMachineDAO{

    private Map<String,VendingMachineItem> items;
    private final String filePath = "data.txt";
    private FileReader fileReader;
    private FileWriter fileWriter;
    private BufferedReader bufferedReader;
    private final String delimeter = "::";

    public VendingMachineDAOImpl() {
        items = new HashMap<>();
    }

    @Override
    public Map<String, VendingMachineItem> getAllItems() {
        return this.items;
    }



    @Override
    public void setAllItems(Map<String, VendingMachineItem> items) {
        this.items = items;
    }

    @Override
    public void marshallItems(){
        try {
            fileWriter = new FileWriter(filePath);
            for (String name : items.keySet()){
                String line = "";
                VendingMachineItem item = items.get(name);
                line += name + delimeter + item.getCost() + delimeter + item.getQty();
                fileWriter.write(line);
                fileWriter.write(System.lineSeparator());
            }
            fileWriter.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void unmarshallItems() {
        try {
            fileReader = new FileReader(filePath);
            bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine())!= null){
                String[] tokens = line.split(delimeter);
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

}
