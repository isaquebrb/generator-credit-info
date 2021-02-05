package br.com.isaquebrb.iftm.batchcreditanalisys.utils;

import br.com.isaquebrb.iftm.batchcreditanalisys.model.DocSituation;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class RandomUtils {

    public static String randomDocSituation() {
        int randomNumber = new Random().nextInt(6);

        Map<Integer, String> docSituation = new HashMap<>();
        docSituation.put(0, DocSituation.ACTIVE.getLabel());
        docSituation.put(1, DocSituation.PENDING.getLabel());
        docSituation.put(2, DocSituation.SUSPENDED.getLabel());
        docSituation.put(3, DocSituation.CANCELED.getLabel());
        docSituation.put(4, DocSituation.DEAD.getLabel());
        docSituation.put(5, DocSituation.NULL.getLabel());

        return docSituation.get(randomNumber);
    }

    public static boolean randomBoolean(){
        Random random = new Random();
        return random.nextBoolean();
    }

    public static Double randomDouble(Double startRange, Double endRange) {
        return ThreadLocalRandom.current().nextDouble(startRange, endRange);
    }

    public static BigDecimal randomBigDecimalValue(Double startRange, Double endRange ) {
        return BigDecimal.valueOf(randomDouble(startRange, endRange)).setScale(2, RoundingMode.HALF_DOWN);
    }

    public static boolean isCompany(String document){
        return document.length() > 11;
    }
}
