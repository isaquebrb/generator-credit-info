package br.com.isaquebrb.iftm.generatorcreditinfo.model.request;

import lombok.Getter;
import org.hibernate.validator.constraints.br.CNPJ;

import javax.validation.constraints.Size;

@Getter
public class CnpjRequest {

    @Size(min = 14, max = 14, message = "Quantidade de dígitos do CNPJ inválida")
    @CNPJ(message = "Documento CNPJ inválido")
    private String document;
}
