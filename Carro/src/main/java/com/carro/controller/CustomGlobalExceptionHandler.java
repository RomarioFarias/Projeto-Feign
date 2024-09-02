//package com.carro.controller;
//
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.validation.FieldError;
//import org.springframework.web.bind.MethodArgumentNotValidException;
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.context.request.WebRequest;
//
//import java.time.LocalDateTime;
//import java.util.HashMap;
//import java.util.Map;
//
//@ControllerAdvice
//public class CustomGlobalExceptionHandler {
//
//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    public ResponseEntity<Object> handleValidationExceptions(MethodArgumentNotValidException ex, WebRequest request) {
//        Map<String, Object> body = new HashMap<>();
//        body.put("timestamp", LocalDateTime.now().toString());
//        body.put("status", HttpStatus.BAD_REQUEST.value());
//        body.put("error", "Bad Request");
//        body.put("path", request.getDescription(false).replace("uri=", ""));
//
//        Map<String, String> fieldErrors = new HashMap<>();
//        for (FieldError error : ex.getBindingResult().getFieldErrors()) {
//            fieldErrors.put(error.getField(), error.getDefaultMessage());
//        }
//        body.put("fieldErrors", fieldErrors);
//
//        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
//    }
//}