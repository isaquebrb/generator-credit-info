package br.com.isaquebrb.iftm.generatorcreditinfo.controller;

import br.com.isaquebrb.iftm.generatorcreditinfo.generator.CrednetRandomInfo;
import br.com.isaquebrb.iftm.generatorcreditinfo.model.request.CnpjRequest;
import br.com.isaquebrb.iftm.generatorcreditinfo.model.request.CpfRequest;
import br.com.isaquebrb.iftm.generatorcreditinfo.model.response.CrednetResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/crednet")
@RequiredArgsConstructor
public class CrednetController {

    private final CrednetRandomInfo crednetRandomInfo;

    @PostMapping("/pf")
    public ResponseEntity<CrednetResponse> generateCrednetInfoPf(@RequestBody @Valid CpfRequest cpfRequest) {
        return ResponseEntity.ok(crednetRandomInfo.generateCrednetInfoPf(cpfRequest.getDocument()));
    }

    @PostMapping("/pj")
    public ResponseEntity<CrednetResponse> generateCrednetInfoPj(@RequestBody @Valid CnpjRequest cnpjRequest) {
        return ResponseEntity.ok(crednetRandomInfo.generateCrednetInfoPj(cnpjRequest.getDocument()));
    }
}
