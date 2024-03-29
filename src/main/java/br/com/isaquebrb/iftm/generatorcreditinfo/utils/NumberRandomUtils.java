package br.com.isaquebrb.iftm.generatorcreditinfo.utils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class NumberRandomUtils {

    NumberRandomUtils() {
        //Utility class
    }

    public static Integer randomInteger(int startRange, int endRange){
        return new Random().nextInt(endRange - startRange) + startRange;
    }

    public static Double randomDouble(Double startRange, Double endRange) {
        return ThreadLocalRandom.current().nextDouble(startRange, endRange);
    }

    public static BigDecimal randomBigDecimalValue(Double startRange, Double endRange) {
        return BigDecimal.valueOf(randomDouble(startRange, endRange)).setScale(2, RoundingMode.HALF_DOWN);
    }
}
