package br.com.isaquebrb.iftm.batchcreditanalisys.controller;

import br.com.isaquebrb.iftm.batchcreditanalisys.model.response.ProcobCrednetResponse;
import br.com.isaquebrb.iftm.batchcreditanalisys.service.ProcobGenerateRandomInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/procob")
@RequiredArgsConstructor
public class ProcobController {

    private final ProcobGenerateRandomInfo procobGenerateRandomInfo;

    @GetMapping("/crednet/{document}")
    public ResponseEntity<ProcobCrednetResponse> getCrednetInfo(@PathVariable("document") String document) {
        return ResponseEntity.ok(procobGenerateRandomInfo.generateCrednetInfo(document));
    }
}
