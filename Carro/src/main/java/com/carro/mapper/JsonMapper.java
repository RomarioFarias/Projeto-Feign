package com.carro.mapper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class JsonMapper {
    private static final ObjectMapper objectMapper = new ObjectMapper().registerModule(new JavaTimeModule());


    public static String toString(Object object) {
        try {
            return objectMapper.writeValueAsString(object);
        } catch (JsonProcessingException jsonProcessingException) {
            log.warn(jsonProcessingException.getMessage(), jsonProcessingException);
            throw new RuntimeException(jsonProcessingException);
        }
    }

    public static <T> T toObject(String payload, Class<T> object) {
        try {
            return objectMapper.readValue(payload, object);
        } catch (JsonProcessingException jsonProcessingException) {
            log.warn(jsonProcessingException.getMessage(), jsonProcessingException);
            throw new RuntimeException(jsonProcessingException);
        }
    }


    public static <T> T toObjectList(String payload, TypeReference<T> typeReference) {
        try {
            return objectMapper.readValue(payload, typeReference);
        } catch (JsonProcessingException jsonProcessingException) {
            log.warn(jsonProcessingException.getMessage(), jsonProcessingException);
            throw new RuntimeException(jsonProcessingException);
        }
    }


}
