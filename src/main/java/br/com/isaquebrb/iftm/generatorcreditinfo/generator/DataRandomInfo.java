package br.com.isaquebrb.iftm.generatorcreditinfo.generator;

import br.com.isaquebrb.iftm.generatorcreditinfo.model.data.DataInfo;
import br.com.isaquebrb.iftm.generatorcreditinfo.model.data.content.*;
import br.com.isaquebrb.iftm.generatorcreditinfo.model.data.info.AddressSearchInfo;
import br.com.isaquebrb.iftm.generatorcreditinfo.model.data.info.EmailInfo;
import br.com.isaquebrb.iftm.generatorcreditinfo.model.data.info.NameInfo;
import br.com.isaquebrb.iftm.generatorcreditinfo.model.data.info.PhoneSearchInfo;
import br.com.isaquebrb.iftm.generatorcreditinfo.model.enums.Company;
import br.com.isaquebrb.iftm.generatorcreditinfo.model.enums.Nationality;
import br.com.isaquebrb.iftm.generatorcreditinfo.model.response.DataResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.Random;

import static br.com.isaquebrb.iftm.generatorcreditinfo.utils.DataRandomUtils.*;
import static br.com.isaquebrb.iftm.generatorcreditinfo.utils.DateRandomUtils.randomDate;
import static br.com.isaquebrb.iftm.generatorcreditinfo.utils.DateRandomUtils.timeToString;

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
        return null;
    }

    private PhoneSearchInfo createPhone() {
        return null;
    }

    private EmailInfo createEmail() {
        return null;
    }

    private Foreign createForeign() {
        if (new Random().nextBoolean()) {
            return new Foreign("SIM","NAO",
                    new OriginCountry(Nationality.BRAZILIAN.getCode().toString(), Nationality.BRAZILIAN.getLabel()));
        }

        Nationality randomNat = randomNationality();
        OriginCountry country = new OriginCountry(randomNat.getCode().toString(), randomNat.getLabel());
        return new Foreign("SIM", "SIM", country);
    }
}
