package com.example.personalprofile.dto.request;

import lombok.Data;

@Data
public class ContactMessageRequest {
    private String name;
    private String email;
    private String message;
}
