package br.com.isaquebrb.iftm.generatorcreditinfo.utils;

import br.com.isaquebrb.iftm.generatorcreditinfo.model.data.content.PhoneOperator;
import br.com.isaquebrb.iftm.generatorcreditinfo.model.enums.*;

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

        return "FULANO " + namesMap.get(randomNumber) + " " + randomLastName();
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

    public static Company randomCompany() {
        Integer randomNumber = new Random().nextInt(5);

        Map<Integer, Company> companiesMap = new HashMap<>();
        companiesMap.put(0, Company.COMPANY_1);
        companiesMap.put(1, Company.COMPANY_2);
        companiesMap.put(2, Company.COMPANY_3);
        companiesMap.put(3, Company.COMPANY_4);
        companiesMap.put(4, Company.COMPANY_5);

        return companiesMap.get(randomNumber);
    }

    public static Address randomAddress() {
        Integer randomNumber = new Random().nextInt(7);

        Map<Integer, Address> addressMap = new HashMap<>();
        addressMap.put(0, Address.UBERLANDIA);
        addressMap.put(1, Address.SAO_PAULO);
        addressMap.put(2, Address.SALVADOR);
        addressMap.put(3, Address.CURITIBA);
        addressMap.put(4, Address.BRASILIA);
        addressMap.put(5, Address.PORTO_ALEGRE);
        addressMap.put(6, Address.RIO_BRANCO);

        return addressMap.get(randomNumber);
    }

    public static String randomPhoneOperator() {
        Integer randomNumber = new Random().nextInt(4);

        Map<Integer, String> operatorMap = new HashMap<>();
        operatorMap.put(0, PhoneOperator.OI.name());
        operatorMap.put(1, PhoneOperator.TIM.name());
        operatorMap.put(2, PhoneOperator.VIVO.name());
        operatorMap.put(3, PhoneOperator.CLARO.name());

        return operatorMap.get(randomNumber);
    }
}
