package com.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserModel {

      @JsonProperty("id")
    private Integer id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("email")
    private String email;

    // Just collect and throw — you handle the rest!
    public void validate() throws Exception {
        List<String> missing = new ArrayList<>();

        if (id == null)                        missing.add("id");
        if (name == null || name.isEmpty())    missing.add("name");
        if (email == null || email.isEmpty())  missing.add("email");

        if (!missing.isEmpty()) {
            throw new Exception("Missing fields: " + missing);
        }
    }

    public Integer getId()  { 
        return id; 
    }
    public String getName() {
         return name;
    }

    public String getEmail() {
         return email; 
    }


}
