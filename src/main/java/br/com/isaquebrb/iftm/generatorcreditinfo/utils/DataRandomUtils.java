package br.com.isaquebrb.iftm.generatorcreditinfo.utils;

import br.com.isaquebrb.iftm.generatorcreditinfo.model.enums.Company;
import br.com.isaquebrb.iftm.generatorcreditinfo.model.enums.LastName;
import br.com.isaquebrb.iftm.generatorcreditinfo.model.enums.Name;
import br.com.isaquebrb.iftm.generatorcreditinfo.model.enums.Nationality;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class DataRandomUtils {

    DataRandomUtils() {
        //Utility class
    }

    public static String randomNamePf() {
        Integer randomNumber = new Random().nextInt(5);

        Map<Integer, String> namesMap = new HashMap<>();
        namesMap.put(0, Name.JOSE.name());
        namesMap.put(1, Name.JOAO.name());
        namesMap.put(2, Name.ANTONIO.name());
        namesMap.put(3, Name.FRANCISCO.name());
        namesMap.put(4, Name.CARLOS.name());

        return namesMap.get(randomNumber) + " " + randomLastName();
    }

    public static String randomLastName() {
        Integer randomNumber = new Random().nextInt(5);

        Map<Integer, String> lastNamesMap = new HashMap<>();
        lastNamesMap.put(0, LastName.SILVA.name());
        lastNamesMap.put(1, LastName.SANTOS.name());
        lastNamesMap.put(2, LastName.OLIVEIRA.name());
        lastNamesMap.put(3, LastName.SOUZA.name());
        lastNamesMap.put(4, LastName.RODRIGUES.name());

        return lastNamesMap.get(randomNumber);
    }

    public static String randomGender() {
        if (new Random().nextBoolean()) {
            return "M";
        } else {
            return "F";
        }
    }

    public static Nationality randomNationality() {
        Integer randomNumber = new Random().nextInt(5);

        Map<Integer, Nationality> nationalityMap = new HashMap<>();
        nationalityMap.put(0, Nationality.GERMAN);
        nationalityMap.put(1, Nationality.CHINESE);
        nationalityMap.put(2, Nationality.BOLIVIAN);
        nationalityMap.put(3, Nationality.BRITISH);
        nationalityMap.put(4, Nationality.ARGENTINIAN);

        return nationalityMap.get(randomNumber);
    }

    public static Company randomCompany(){
        Integer randomNumber = new Random().nextInt(5);

        Map<Integer, Company> companiesMap = new HashMap<>();
        companiesMap.put(0, Company.COMPANY_1);
        companiesMap.put(1, Company.COMPANY_2);
        companiesMap.put(2, Company.COMPANY_3);
        companiesMap.put(3, Company.COMPANY_4);
        companiesMap.put(4, Company.COMPANY_5);

        return companiesMap.get(randomNumber);
    }
}
