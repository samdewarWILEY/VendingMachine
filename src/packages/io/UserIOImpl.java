package packages.io;

import java.math.BigDecimal;
import java.util.Scanner;

import static java.text.ChoiceFormat.nextDouble;

public class UserIOImpl implements UserIO{
    Scanner scanner;
    public UserIOImpl(){
        this.scanner=new Scanner(System.in);
    }
    public UserIOImpl(Scanner scanner){
        this.scanner=scanner;
    }
    @Override
    public void print(String message) {
        System.out.println(message);
    }

    @Override
    public double readDouble(String message) {
        System.out.println(message);
        try{
            return scanner.nextDouble();
        }catch (Exception e){
            System.out.println(e);
            return 0;
        }
    }

    @Override
    public double readDouble(String message, double min, double max){
        System.out.println(message);
        double output;
        try{
            do{
            output = scanner.nextDouble();
            }while(output>max || output<max);
        }catch (Exception e){
            System.out.println(e);
            return 0;
        }
        return output;
    }

    @Override
    public int readInt(String message) {
        System.out.println(message);
        try{
            return scanner.nextInt();
        }catch (Exception e){
            System.out.println(e);
            return 0;
        }
    }

    @Override
    public int readInt(String message, double min, double max) {
        System.out.println(message);
        int output;
        try{
            do{
                output=scanner.nextInt();
            }while(output>max || output<min);
        }catch (Exception e){
            System.out.println(e);
            return 0;
        }
        return output;
    }

    @Override
    public String readString(String message) {
        System.out.println(message);
        try{
            return scanner.nextLine();
        }catch (Exception e){
            System.out.println(e);
            return "";
        }
    }

    @Override
    public BigDecimal readBigDecimal(String message){
        System.out.println(message);
        try{
            return new BigDecimal(scanner.nextLine());
        }catch (Exception e){
            System.out.println(e);
            return null;
        }
    }

    @Override
    public BigDecimal readBigDecimal(String message, BigDecimal min, BigDecimal max) {
        System.out.println(message);
        BigDecimal output;
        try{
            do{
                output=new BigDecimal(scanner.nextLine());
            }while(output.compareTo(min)<0 || output.compareTo(max)>0);
        }catch (Exception e){
            System.out.println(e);
            return null;
        }
        return output;
    }
}
