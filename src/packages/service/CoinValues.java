package packages.service;

import java.math.BigDecimal;

public enum CoinValues {
    Quarter(0,new BigDecimal("25")),
    Dime(1,new BigDecimal("10")),
    Nickel(2,new BigDecimal("5")),
    Penny(3,new BigDecimal("1"));

    private BigDecimal value;
    private int index;

    CoinValues(int index,BigDecimal value) {
        this.value = value;
        this.index = index;
    }

    public BigDecimal getValue() {
        return value;
    }

    public int getIndex(){
        return index;
    }

    public BigDecimal getValueByIndex(int index){
        for (CoinValues value : CoinValues.values()){
            if(value.getIndex() == index){
                return value.getValue();
            }
        }
        return null;
    }


}

