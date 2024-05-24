package br.com.fiap.soat7.infrastructure.config;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Arrays;

@ControllerAdvice
public class GlobalExceptionHandler {

    public static final String INVALID_CATEGORY_VALUE = "invalid.category.value";
    public static final String BAD_REQUEST = "bad.request";

    private final MessageSource messageSource;

    public GlobalExceptionHandler(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<String> handleHttpMessageNotReadableException(HttpMessageNotReadableException ex) {
        Throwable rootCause = ex.getRootCause();
        if (rootCause instanceof InvalidFormatException) {
            InvalidFormatException ife = (InvalidFormatException) rootCause;
            Class<?> targetType = ife.getTargetType();
            if (targetType.isEnum()) {
                String message = messageSource.getMessage(INVALID_CATEGORY_VALUE, null, LocaleContextHolder.getLocale());
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message + Arrays.toString(targetType.getEnumConstants()));
            }
        }

        // Se a exceção for diferente, retorne uma mensagem de erro geral
        String generalErrorMessage = messageSource.getMessage(BAD_REQUEST, null, LocaleContextHolder.getLocale());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(generalErrorMessage);
    }
}