package br.com.isaquebrb.iftm.batchcreditanalisys.service;

import br.com.isaquebrb.iftm.batchcreditanalisys.model.credtnet.CrednetInfo;
import br.com.isaquebrb.iftm.batchcreditanalisys.model.credtnet.CrednetPersonContent;
import br.com.isaquebrb.iftm.batchcreditanalisys.model.credtnet.CrednetPersonInfo;
import br.com.isaquebrb.iftm.batchcreditanalisys.model.response.ProcobCrednetResponse;
import br.com.isaquebrb.iftm.batchcreditanalisys.utils.DateUtils;
import br.com.isaquebrb.iftm.batchcreditanalisys.utils.RandomProcobUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@Service
public class ProcobService {

    public ProcobCrednetResponse getCrednetInfo(Integer document) {
        CrednetInfo crednetInfo = CrednetInfo.builder()
                .personInfo(crednetPersonInfo())
                .build();

        return new ProcobCrednetResponse(crednetInfo,
                LocalDate.now().toString(),
                LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")));
    }

    private CrednetPersonInfo crednetPersonInfo() {
        CrednetPersonInfo personInfo = new CrednetPersonInfo(
                CrednetPersonContent.builder()
                        .name("FULANO DA SILVA")
                        .birthDate(DateUtils.randomDate().toString())
                        .docSituation(RandomProcobUtils.randomDocSituation())
                        .docSituationDate(DateUtils.randomDate().toString()).build());
        personInfo.setHasInformation("SIM");
        return personInfo;
    }
}
