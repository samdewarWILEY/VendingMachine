package packages.io;

import java.math.BigDecimal;

public interface UserIO {
    public void printString(String message);
    public double getDouble(String message);
    public int getInt(String message);
    public String getString(String message);

    public BigDecimal getBigDecimal(String message);
}
