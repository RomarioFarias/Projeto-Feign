package com.carro.exception;

import com.carro.entity.Errors;
import com.carro.enums.ExceptionCode;
import com.carro.i18.MessageService;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.validation.ConstraintViolationException;
import java.util.List;

@RestControllerAdvice
@Slf4j
@Log4j
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {
    private final MessageService messageService;

    protected ResponseEntity<Object> handleTypeMismatch(TypeMismatchException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        logger.error(ex.getMessage(), ex);
        return this.handleExceptionInternal(ex, null, headers, status, request);
    }

    protected ResponseEntity<Object> handleBindException(BindException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        logger.warn(ex.getMessage(), ex);
        return this.handleExceptionInternal(ex, null, headers, status, request);
    }

    protected ResponseEntity<Object> handleException(Exception ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        logger.warn(ex.getMessage(), ex);
        return this.handleExceptionInternal(ex, null, headers, status, request);
    }


    @Override
    public ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex, HttpHeaders headers,
            HttpStatusCode status, WebRequest request) {
//        var message = this.message.get("RELATIONSHIP", List.of("KAKA").toArray(new String[0]));

        BindingResult bindingResult = ex.getBindingResult();
        List<FieldError> fieldError = bindingResult.getFieldErrors();
        //ObjectError a = fieldError.get(1);
//        List<Errors> errors = fieldError.stream()
//                .map(ex1->
//                        new Errors(ex1.getField(), messageService.get(ex1.getDefaultMessage()),"1333")).toList();
        String kaka = messageService.get(("API_FIELDS_INVALID"));
        List<Errors> errors = fieldError.stream()
                .map(fildError ->
                        new Errors(fildError.getField(), fildError.getDefaultMessage(), "1333")).toList();
        logger.error(ex.getMessage(), ex);

        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({ResourceNotFound.class})
    public ResponseEntity<Object> businessExceptionHandler(ResourceNotFound ex, WebRequest request) {
        var message = this.messageService.get(ExceptionCode.NOT_FOUND_BY_ID.toString(), ex.exceptionCode.getParametros());
        Errors error = new Errors(null, message, ex.exceptionCode.getCode());
        return this.handleExceptionInternal(ex, error, new HttpHeaders(), ex.getHttpStatus(), request);
    }

    @ExceptionHandler({BusinessException.class})
    public ResponseEntity<Object> businessExceptionHandler(BusinessException ex, WebRequest request) {
        // var message = this.message.get("RELATIONSHIP", List.of("KAKA").toArray(new String[0]));

        Errors error = new Errors(null, ex.getMessage(), ex.exceptionCode.getCode());
        return this.handleExceptionInternal(ex, error, new HttpHeaders(), ex.getHttpStatus(), request);
    }

//    private List<Errors> test(ErrorResponse response, BindingResult bindingResult) {
//        List<Errors> errorsList = new ArrayList();
//        Iterator var4 = bindingResult.getFieldErrors().iterator();
//
//        while(var4.hasNext()) {
//            FieldError fieldError = (FieldError)var4.next();
//            Errors error = (new Errors(fieldError.getField(), message.get(""), "222"));
//            errorsList.add(error);
//        }
//
//        response.setDetails(errorsList);
//        return errorsList;
//    }

    @ExceptionHandler({Exception.class})
    public ResponseEntity<Object> internalServerErrorExceptionHandler(Exception ex, WebRequest request) {
        logger.error(ex.getMessage(), ex);
        Errors errors = new Errors(null, messageService.get(ExceptionCode.INTERNAL_SERVER_ERROR.name()), ExceptionCode.INTERNAL_SERVER_ERROR.getCode());
        return this.handleExceptionInternal(ex, errors, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR, request);
    }

    @ExceptionHandler({ConstraintViolationException.class})
    public ResponseEntity<Object> handleConstraintViolation(ConstraintViolationException ex, WebRequest request) {
        logger.error(ex.getMessage(), ex);
        return this.handleExceptionInternal(ex, null, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }

    public ApiExceptionHandler(MessageService messageService) {
        this.messageService = messageService;
    }

}

