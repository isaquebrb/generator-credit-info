package br.com.isaquebrb.iftm.generatorcreditinfo.controller;

import br.com.isaquebrb.iftm.generatorcreditinfo.generator.DataRandomInfo;
import br.com.isaquebrb.iftm.generatorcreditinfo.model.request.CnpjRequest;
import br.com.isaquebrb.iftm.generatorcreditinfo.model.request.CpfRequest;
import br.com.isaquebrb.iftm.generatorcreditinfo.model.response.DataResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("data")
@RequiredArgsConstructor
public class DataController {

    private final DataRandomInfo dataRandomInfo;

    @GetMapping("/pf")
    public ResponseEntity<DataResponse> generateDataInfoPf(@RequestBody @Valid CpfRequest request) {
        return ResponseEntity.ok(dataRandomInfo.generateDataInfoPf(request.getDocument()));
    }

    @GetMapping("/pj")
    public ResponseEntity<DataResponse> generateDataInfoPf(@RequestBody @Valid CnpjRequest request) {
        return ResponseEntity.ok(dataRandomInfo.generateDataInfoPj(request.getDocument()));
    }
}
