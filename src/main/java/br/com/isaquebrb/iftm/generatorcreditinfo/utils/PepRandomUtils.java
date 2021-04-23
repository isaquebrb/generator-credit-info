package br.com.isaquebrb.iftm.generatorcreditinfo.utils;

import br.com.isaquebrb.iftm.generatorcreditinfo.model.enums.Agency;
import br.com.isaquebrb.iftm.generatorcreditinfo.model.enums.Occupation;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class PepRandomUtils {

    PepRandomUtils(){
        //Utility class
    }

    public static String randomOccupation() {
        Integer randomNumber = new Random().nextInt(4);

        Map<Integer, String> occupationMap = new HashMap<>();
        occupationMap.put(0, Occupation.PRESIDENT.getLabel());
        occupationMap.put(1, Occupation.GOVERNOR.getLabel());
        occupationMap.put(2, Occupation.MAYOR.getLabel());
        occupationMap.put(3, Occupation.CONGRESSMAN.getLabel());

        return occupationMap.get(randomNumber);
    }

    public static String randomAgency() {
        Integer randomNumber = new Random().nextInt(4);

        Map<Integer, String> occupationMap = new HashMap<>();
        occupationMap.put(0, Agency.FEDERATIVE_BRAZIL.getLabel());
        occupationMap.put(1, Agency.MINAS_GERAIS_STATE.getLabel());
        occupationMap.put(2, Agency.UBERLANDIA_CITY.getLabel());
        occupationMap.put(3, Agency.LEGISLATIVE_SP_ASSEMBLY.getLabel());

        return occupationMap.get(randomNumber);
    }
}
