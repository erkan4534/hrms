package com.hrms.core.utilities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.stereotype.Component;
import java.util.Locale;

@Component
public class MessageBundle {

    private static ResourceBundleMessageSource messageSource;
    private static Locale locale;
    @Autowired
    public MessageBundle(ResourceBundleMessageSource messageSource) {
        this.messageSource = messageSource;
        locale = new Locale("tr", "tr");
    }

    public static String getMessageTr(String message){
        return messageSource.getMessage(message,null,new Locale("tr"));
    }

}
