package pwr.edu.pl.robimylicytacje.infrastructure.database.Util;

import java.math.BigDecimal;

public class MoneyUtil {

    public static BigDecimal parsePrice(String raw) {
        try {
            return new BigDecimal(raw.replace("zł", "").replace(",", ".").trim());
        } catch (Exception e) {
            return BigDecimal.ZERO;
        }
    }
}
