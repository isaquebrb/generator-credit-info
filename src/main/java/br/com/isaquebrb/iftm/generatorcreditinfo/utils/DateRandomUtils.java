package br.com.isaquebrb.iftm.generatorcreditinfo.utils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static br.com.isaquebrb.iftm.generatorcreditinfo.utils.NumberRandomUtils.randomInteger;

public class DateRandomUtils {

    DateRandomUtils() {
        //Utility class
    }

    public static LocalDate randomDate(Integer startYearRange, Integer endYearRange) {
        Integer randomYear = randomInteger(startYearRange, endYearRange);
        Integer randomDay = randomInteger(1, 28);
        Integer randomMonth = randomInteger(1, 12);

        return LocalDate.of(randomYear, randomMonth, randomDay);
    }

    public static String timeToString(LocalDateTime dateTime) {
        return dateTime.format(DateTimeFormatter.ofPattern("HH:mm:ss"));
    }
}
