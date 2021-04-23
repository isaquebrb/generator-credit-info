package br.com.isaquebrb.iftm.generatorcreditinfo.utils;

import br.com.isaquebrb.iftm.generatorcreditinfo.model.enums.DocSituation;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class CredtnetRandomUtils {

    CredtnetRandomUtils(){
        //Utility class
    }


    public static String randomDocSituation() {
        Integer randomNumber = new Random().nextInt(6);

        Map<Integer, String> docSituation = new HashMap<>();
        docSituation.put(0, DocSituation.ACTIVE.getLabel());
        docSituation.put(1, DocSituation.PENDING.getLabel());
        docSituation.put(2, DocSituation.SUSPENDED.getLabel());
        docSituation.put(3, DocSituation.CANCELED.getLabel());
        docSituation.put(4, DocSituation.DEAD.getLabel());
        docSituation.put(5, DocSituation.NULL.getLabel());

        return docSituation.get(randomNumber);
    }
}
