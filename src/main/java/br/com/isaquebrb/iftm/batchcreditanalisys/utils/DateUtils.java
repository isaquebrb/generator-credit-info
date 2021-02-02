package br.com.isaquebrb.iftm.batchcreditanalisys.utils;

import java.time.LocalDate;
import java.util.concurrent.ThreadLocalRandom;

public class DateUtils {

    public static LocalDate randomDate(){
        return LocalDate.ofEpochDay(ThreadLocalRandom
                .current().nextInt(0, 15000));
    }

    public static LocalDate randomRecentDate(){
        return LocalDate.ofEpochDay(ThreadLocalRandom
                .current().nextInt(10000, 15000));
    }
}
