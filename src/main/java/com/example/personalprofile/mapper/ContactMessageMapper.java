package com.example.personalprofile.mapper;

import com.example.personalprofile.dto.request.ContactMessageRequest;
import com.example.personalprofile.models.ContactMessage;

import java.time.LocalDateTime;

public class ContactMessageMapper {

    // Convert request DTO to entity
    public static ContactMessage toContactMessage(ContactMessageRequest request) {
        ContactMessage message = new ContactMessage();
        message.setName(request.getName());
        message.setEmail(request.getEmail());
        message.setMessage(request.getMessage());
        message.setCreatedAt(LocalDateTime.now());
        return message;
    }
}
