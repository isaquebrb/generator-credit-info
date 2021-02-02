package br.com.isaquebrb.iftm.batchcreditanalisys.utils;

import br.com.isaquebrb.iftm.batchcreditanalisys.model.DocSituation;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class RandomProcobUtils {

    public static String randomDocSituation() {
        int nano = LocalDateTime.now().getNano();
        Map<Integer, String> docSituation = new HashMap<>();
        docSituation.put(1, DocSituation.ACTIVE.getLabel());
        docSituation.put(2, DocSituation.PENDING.getLabel());
        docSituation.put(3, DocSituation.SUSPENDED.getLabel());
        docSituation.put(4, DocSituation.CANCELED.getLabel());
        docSituation.put(5, DocSituation.DEAD.getLabel());
        docSituation.put(6, DocSituation.NULL.getLabel());
        try {
            return docSituation.get(nano);
        } catch (NullPointerException e) {
            return DocSituation.ACTIVE.getLabel();
        }
    }
}
