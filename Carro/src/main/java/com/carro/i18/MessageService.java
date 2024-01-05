package com.carro.i18;

import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceResolvable;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.stereotype.Component;

@Component
public class MessageService {
    private  MessageSourceAccessor accessor;

//    public Message(MessageSource messageSource) {
//
//        this.accessor = new MessageSourceAccessor(messageSource, LocaleContextHolder.getLocale());
//    }

    public MessageService(MessageSource messageSource) {
        ResourceBundleMessageSource resource =
                new ResourceBundleMessageSource();
        resource.setBasename("messages");
        resource.setDefaultEncoding("utf-8");
        this.accessor = new MessageSourceAccessor(messageSource, LocaleContextHolder.getLocale());

    }
    public String get(String code) {
        return this.accessor.getMessage(code, LocaleContextHolder.getLocale());
    }

//    public String get(MessageProperties messageProp) {
//        return this.accessor.getMessage(messageProp.toString(), LocaleContextHolder.getLocale());
//    }

    public String get(String code, String[] args) {
        return this.accessor.getMessage(code, args);
    }


    public String get(MessageSourceResolvable resolvable) {
        return this.accessor.getMessage(resolvable, LocaleContextHolder.getLocale());
    }
}
