package br.com.isaquebrb.iftm.batchcreditanalisys.utils;

import br.com.isaquebrb.iftm.batchcreditanalisys.model.DocSituation;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

public class RandomProcobUtils {

    public static String randomDocSituation() {
        int randomNumber = ThreadLocalRandom.current().nextInt(1, 6);

        Map<Integer, String> docSituation = new HashMap<>();
        docSituation.put(1, DocSituation.ACTIVE.getLabel());
        docSituation.put(2, DocSituation.PENDING.getLabel());
        docSituation.put(3, DocSituation.SUSPENDED.getLabel());
        docSituation.put(4, DocSituation.CANCELED.getLabel());
        docSituation.put(5, DocSituation.DEAD.getLabel());
        docSituation.put(6, DocSituation.NULL.getLabel());

        return docSituation.get(randomNumber);
    }
}
