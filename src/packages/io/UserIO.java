package packages.io;

import java.math.BigDecimal;

public interface UserIO {
    public void print(String message);
    public double readDouble(String message);
    public double readDouble(String message, double min, double max);
    public int readInt(String message);
    public int readInt(String message, double min, double max);
    public String readString(String message);

    public BigDecimal readBigDecimal(String message);
    public BigDecimal readBigDecimal(String message, BigDecimal min, BigDecimal max);
}
