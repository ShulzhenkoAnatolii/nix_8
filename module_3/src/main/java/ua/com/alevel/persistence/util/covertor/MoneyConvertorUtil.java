package ua.com.alevel.persistence.util.covertor;

public final class MoneyConvertorUtil {

    public static Long moneyConversionInLong(Double amountDouble) {
        return (long) (amountDouble * 100);
    }

    public static Double moneyConversionInDouble(Long amountLong) {
        return ((amountLong / 100) + (double) (amountLong % 100) / 100);
    }
}
