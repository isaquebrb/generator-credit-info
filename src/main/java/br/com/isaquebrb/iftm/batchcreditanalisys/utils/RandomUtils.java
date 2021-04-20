package br.com.isaquebrb.iftm.batchcreditanalisys.utils;

import br.com.isaquebrb.iftm.batchcreditanalisys.model.enums.Agency;
import br.com.isaquebrb.iftm.batchcreditanalisys.model.enums.DocSituation;
import br.com.isaquebrb.iftm.batchcreditanalisys.model.enums.Occupation;

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

    public static String randomOccupation() {
        int randomNumber = new Random().nextInt(4);

        Map<Integer, String> occupationMap = new HashMap<>();
        occupationMap.put(0, Occupation.PRESIDENT.getLabel());
        occupationMap.put(1, Occupation.GOVERNOR.getLabel());
        occupationMap.put(2, Occupation.MAYOR.getLabel());
        occupationMap.put(3, Occupation.CONGRESSMAN.getLabel());

        return occupationMap.get(randomNumber);
    }

    public static String randomAgency() {
        int randomNumber = new Random().nextInt(4);

        Map<Integer, String> occupationMap = new HashMap<>();
        occupationMap.put(0, Agency.FEDERATIVE_BRAZIL.getLabel());
        occupationMap.put(1, Agency.MINAS_GERAIS_STATE.getLabel());
        occupationMap.put(2, Agency.UBERLANDIA_CITY.getLabel());
        occupationMap.put(3, Agency.LEGISLATIVE_SP_ASSEMBLY.getLabel());

        return occupationMap.get(randomNumber);
    }

    public static Double randomDouble(Double startRange, Double endRange) {
        return ThreadLocalRandom.current().nextDouble(startRange, endRange);
    }

    public static BigDecimal randomBigDecimalValue(Double startRange, Double endRange) {
        return BigDecimal.valueOf(randomDouble(startRange, endRange)).setScale(2, RoundingMode.HALF_DOWN);
    }
}
