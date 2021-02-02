package br.com.isaquebrb.iftm.batchcreditanalisys.controller;

import br.com.isaquebrb.iftm.batchcreditanalisys.model.response.ProcobCrednetResponse;
import br.com.isaquebrb.iftm.batchcreditanalisys.service.ProcobService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("/procob")
@RequiredArgsConstructor
public class ProcobController {

    private final ProcobService procobService;

    @GetMapping("/crednet/{document}")
    public ResponseEntity<ProcobCrednetResponse> getCrednetInfo(@PathVariable("document") Integer document) {
        return ResponseEntity.ok(procobService.getCrednetInfo(document));
    }
}
