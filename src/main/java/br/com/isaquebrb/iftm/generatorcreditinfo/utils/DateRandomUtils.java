package br.com.isaquebrb.iftm.generatorcreditinfo.utils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class DateRandomUtils {

    DateRandomUtils() {
        //Utility class
    }

    public static LocalDate randomDate(Integer startYearRange, Integer endYearRange) {
        Integer randomYear = new Random().nextInt(endYearRange - startYearRange) + startYearRange;
        Integer randomDay = new Random().nextInt(30 - 1) + 1;
        Integer randomMonth = new Random().nextInt(12 - 1) + 1;

        return LocalDate.of(randomYear, randomMonth, randomDay);
    }

    public static String timeToString(LocalDateTime dateTime) {
        return dateTime.format(DateTimeFormatter.ofPattern("HH:mm:ss"));
    }
}
