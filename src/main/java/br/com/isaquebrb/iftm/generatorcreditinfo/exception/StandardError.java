package br.com.isaquebrb.iftm.generatorcreditinfo.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class StandardError {

    private Integer status;
    private List<String> errors;
    private String message;
}
