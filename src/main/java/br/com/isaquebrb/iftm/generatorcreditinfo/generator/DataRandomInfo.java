package br.com.isaquebrb.iftm.generatorcreditinfo.generator;

import br.com.isaquebrb.iftm.generatorcreditinfo.model.data.DataInfo;
import br.com.isaquebrb.iftm.generatorcreditinfo.model.data.content.*;
import br.com.isaquebrb.iftm.generatorcreditinfo.model.data.info.AddressSearchInfo;
import br.com.isaquebrb.iftm.generatorcreditinfo.model.data.info.EmailInfo;
import br.com.isaquebrb.iftm.generatorcreditinfo.model.data.info.NameInfo;
import br.com.isaquebrb.iftm.generatorcreditinfo.model.data.info.PhoneSearchInfo;
import br.com.isaquebrb.iftm.generatorcreditinfo.model.enums.Address;
import br.com.isaquebrb.iftm.generatorcreditinfo.model.enums.Company;
import br.com.isaquebrb.iftm.generatorcreditinfo.model.enums.Nationality;
import br.com.isaquebrb.iftm.generatorcreditinfo.model.response.DataResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.Collections;
import java.util.Random;

import static br.com.isaquebrb.iftm.generatorcreditinfo.utils.DataRandomUtils.*;
import static br.com.isaquebrb.iftm.generatorcreditinfo.utils.DateRandomUtils.randomDate;
import static br.com.isaquebrb.iftm.generatorcreditinfo.utils.DateRandomUtils.timeToString;
import static br.com.isaquebrb.iftm.generatorcreditinfo.utils.NumberRandomUtils.randomInteger;

@Slf4j
@Component
public class DataRandomInfo {
    public DataResponse generateDataInfoPf(String document) {
        log.info("[DataRandomInfo.generateDataInfoPf] Generating Data Info to the CPF " + document);
        DataInfo dataInfo = DataInfo.builder()
                .name(createNamePf(document))
                .addressSearch(createAddress())
                .phonesSearch(createPhone())
                .emails(createEmail()).build();

        return new DataResponse(dataInfo, LocalDate.now().toString(), timeToString(LocalDateTime.now()));
    }

    public DataResponse generateDataInfoPj(String document) {
        log.info("[DataRandomInfo.generateDataInfoPj] Generating Data Info to the CNPJ " + document);
        DataInfo dataInfo = DataInfo.builder()
                .name(createNamePj(document))
                .addressSearch(createAddress())
                .phonesSearch(createPhone())
                .emails(createEmail()).build();

        return new DataResponse(dataInfo, LocalDate.now().toString(), timeToString(LocalDateTime.now()));
    }

    private NameInfo createNamePf(String document) {
        LocalDate birthDate = randomDate(1970, 2006);

        NameContent content = NameContentPf.builder()
                .document(document)
                .name(randomNamePf())
                .gender(randomGender())
                .documentType("PF")
                .birthdayDate(birthDate.toString())
                .age(String.valueOf(Period.between(birthDate, LocalDate.now()).getYears()))
                .foreign(createForeign())
                .build();
        return new NameInfo("SIM", content);
    }

    private NameInfo createNamePj(String document) {
        LocalDate randomBirth = randomDate(1970, 2020);
        Company randomComp = randomCompany();

        NameContent content = NameContentPj.builder()
                .document(document)
                .name(randomComp.getLabel())
                .documentType("PJ")
                .birthdayDate(randomBirth.toString())
                .age(String.valueOf(Period.between(randomBirth, LocalDate.now()).getYears()))
                .tradeName(randomComp.getTradeName())
                .primaryCnae(randomComp.getCnae().toString())
                .descriptionPrimaryCnae(randomComp.getDescriptionCnae())
                .build();
        return new NameInfo("SIM", content);
    }

    private AddressSearchInfo createAddress() {
        Address randomAddress = randomAddress();

        AddressSearchContent content = AddressSearchContent.builder()
                .stateUf(randomAddress.getUf())
                .cep(randomAddress.getCep())
                .address(randomAddress.getAddress())
                .city(randomAddress.name())
                .district(randomAddress.getDistrict())
                .number(String.valueOf(new Random().nextInt(2000)))
                .complement("")
                .build();

        return new AddressSearchInfo("SIM", Collections.singletonList(content));
    }

    private PhoneSearchInfo createPhone() {
        String areaCode = randomInteger(11, 100).toString();
        String operator = randomPhoneOperator();

        String cellNumber = randomInteger(3000, 5001).toString() + randomInteger(3000, 5001).toString();
        Phone cellphone = new Phone(areaCode, cellNumber, operator);

        String lineNumber = randomInteger(9000, 9999).toString() + randomInteger(9000, 9999).toString();
        Phone landLine = new Phone(areaCode, lineNumber, operator);

        PhoneSearchContent content = new PhoneSearchContent(Collections.singletonList(cellphone),
                Collections.singletonList(landLine));

        return new PhoneSearchInfo("SIM", content);
    }

    private EmailInfo createEmail() {
        String emailPrefix = (randomNamePf().charAt(0) + randomLastName()).toLowerCase();
        Email randomEmail = new Email(emailPrefix + "@email.com");
        return new EmailInfo("SIM", new EmailContent(Collections.singletonList(randomEmail)));
    }

    private Foreign createForeign() {
        if (new Random().nextBoolean()) {
            return new Foreign("SIM", "NAO",
                    new OriginCountry(Nationality.BRAZILIAN.getCode().toString(), Nationality.BRAZILIAN.getLabel()));
        }

        Nationality randomNat = randomNationality();
        OriginCountry country = new OriginCountry(randomNat.getCode().toString(), randomNat.getLabel());
        return new Foreign("SIM", "SIM", country);
    }
}
