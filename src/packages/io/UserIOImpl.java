package packages.io;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Scanner;

import static java.text.ChoiceFormat.nextDouble;

@Component
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

    /**
     * Sam
     * Read a double from commandline
     * @param message to prompt user with
     * @return double from user input
     */
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

    /**
     * Sam
     * Read a double from commandline
     * Loop will run indefinitely if the user enters a value out of range
     * @param message to prompt user with
     * @return double from user input
     */
    @Override
    public double readDouble(String message, double min, double max){
        System.out.println(message);
        double output;
        try{
            do{
            output = scanner.nextDouble();
            }while(output>max || output<min);
        }catch (Exception e){
            System.out.println(e);
            return 0;
        }
        return output;
    }

    /**
     * Sam
     * Read an int from commandline
     * @param message to prompt user with
     * @return int from user input
     */
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

    /**
     * Sam
     * Read an int from commandline
     * Loop will run indefinitely if the user enters a value out of range
     * @param message to prompt user with
     * @return int from user input
     */
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

    /**
     * Sam
     * Read a String from commandline
     * @param message to prompt user with
     * @return String from user input
     */
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

    /**
     * Sam
     * Read a BigDecimal from commandline
     * @param message to prompt user with
     * @return BigDecimal from user input
     */
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

    /**
     * Sam
     * Read a BigDecimal from commandline
     * Loop will run indefinitely if the user enters a value out of range
     * @param message to prompt user with
     * @return BigDecimal from user input
     */
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
