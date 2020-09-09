package net.movill.erp.controller;

import lombok.extern.slf4j.Slf4j;
import net.movill.common.advice.ExceptionHandleControllerAdvice;
import net.movill.common.prop.ErrorProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Locale;


@Slf4j
@RestControllerAdvice
public class ExceptionControllderAdvice extends ExceptionHandleControllerAdvice {
    public ExceptionControllderAdvice(ErrorProperties errorProperties) {
        super(errorProperties);
    }

    @Autowired
    private MessageSource messageSource;

    private String getMessage(String code, String...args) {
        return messageSource.getMessage(code, args, Locale.getDefault());
    }
}
