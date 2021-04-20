package br.com.isaquebrb.iftm.batchcreditanalisys.model.request;

import lombok.Getter;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.Size;

@Getter
public class CpfRequest {

    @Size(min = 11, max = 11, message = "Quantidade de dígitos do CPF inválida")
    @CPF(message = "Documento CPF inválido")
    private String document;
}
