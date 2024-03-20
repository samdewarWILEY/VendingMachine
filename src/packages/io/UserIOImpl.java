package packages.io;

import java.math.BigDecimal;
import java.util.Scanner;

public class UserIOImpl implements UserIO{
    Scanner scanner;
    public UserIOImpl(){
        this.scanner=new Scanner(System.in);
    }
    public UserIOImpl(Scanner scanner){
        this.scanner=scanner;
    }
    @Override
    public void printString(String message) {
        System.out.println(message);
    }

    @Override
    public double getDouble(String message) {
        System.out.println(message);
        try{
            return scanner.nextDouble();
        }catch (Exception e){
            System.out.println(e);
            return 0;
        }
    }

    @Override
    public int getInt(String message) {
        System.out.println(message);
        try{
            return scanner.nextInt();
        }catch (Exception e){
            System.out.println(e);
            return 0;
        }
    }

    @Override
    public String getString(String message) {
        System.out.println(message);
        try{
            return scanner.nextLine();
        }catch (Exception e){
            System.out.println(e);
            return "";
        }
    }

    @Override
    public BigDecimal getBigDecimal(String message){
        System.out.println(message);
        try{
            return new BigDecimal(scanner.nextLine());
        }catch (Exception e){
            System.out.println(e);
            return null;
        }
    }
}
