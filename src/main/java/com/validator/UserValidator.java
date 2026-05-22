package com.validator;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.model.UserModel;

import org.apache.camel.Exchange;
import org.springframework.stereotype.Component;

@Component
public class UserValidator {

    private final ObjectMapper objectMapper = new ObjectMapper();


     public void validate(Exchange exchange) throws Exception {

        String body = exchange.getIn().getBody(String.class);

        // Parse JSON
        UserModel user = objectMapper.readValue(body, UserModel.class);

        // Just validate — exception thrown automatically if fields missing
        user.validate();

        // If no exception → put parsed object back
        exchange.getIn().setBody(body);
    }

}

