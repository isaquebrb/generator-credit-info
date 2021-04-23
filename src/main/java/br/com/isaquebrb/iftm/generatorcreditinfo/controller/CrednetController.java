package br.com.isaquebrb.iftm.generatorcreditinfo.controller;

import br.com.isaquebrb.iftm.generatorcreditinfo.model.request.CnpjRequest;
import br.com.isaquebrb.iftm.generatorcreditinfo.model.request.CpfRequest;
import br.com.isaquebrb.iftm.generatorcreditinfo.model.response.CrednetResponsePf;
import br.com.isaquebrb.iftm.generatorcreditinfo.model.response.CrednetResponsePj;
import br.com.isaquebrb.iftm.generatorcreditinfo.generator.CrednetRandomInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/crednet")
@RequiredArgsConstructor
public class CrednetController {

    private final CrednetRandomInfo crednetRandomInfo;

    @GetMapping("/pf")
    public ResponseEntity<CrednetResponsePf> getCrednetInfoPf(@RequestBody @Valid CpfRequest cpfRequest) {
        return ResponseEntity.ok(crednetRandomInfo.generateCrednetInfoPf(cpfRequest.getDocument()));
    }

    @GetMapping("/pj")
    public ResponseEntity<CrednetResponsePj> getCrednetInfoPj(@RequestBody @Valid CnpjRequest cnpjRequest) {
        return ResponseEntity.ok(crednetRandomInfo.generateCrednetInfoPj(cnpjRequest.getDocument()));
    }
}
