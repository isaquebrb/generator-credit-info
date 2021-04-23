package br.com.isaquebrb.iftm.generatorcreditinfo.controller;

import br.com.isaquebrb.iftm.generatorcreditinfo.generator.PepRandomInfo;
import br.com.isaquebrb.iftm.generatorcreditinfo.model.request.CpfRequest;
import br.com.isaquebrb.iftm.generatorcreditinfo.model.response.PepResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/pep")
@RequiredArgsConstructor
public class PepController {

    private final PepRandomInfo pepRandomInfo;

    @GetMapping
    public ResponseEntity<PepResponse> getPepInfo(@RequestBody @Valid CpfRequest request){
        return ResponseEntity.ok(pepRandomInfo.generatePepInfo(request.getDocument()));
    }
}
