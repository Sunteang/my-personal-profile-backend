package com.example.personalprofile.controllers;

import com.example.personalprofile.dto.request.ContactMessageRequest;
import com.example.personalprofile.dto.response.ApiResponse;
import com.example.personalprofile.mapper.ContactMessageMapper;
import com.example.personalprofile.models.ContactMessage;
import com.example.personalprofile.services.ContactMessageService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contact")
public class ContactController {

    private final ContactMessageService contactMessageService;

    public ContactController(ContactMessageService contactMessageService) {
        this.contactMessageService = contactMessageService;
    }

    @PostMapping("/send")
    public ResponseEntity<ApiResponse<ContactMessage>> sendMessage(@RequestBody ContactMessageRequest request) {
        ContactMessage message = ContactMessageMapper.toContactMessage(request);
        ContactMessage saved = contactMessageService.createMessage(message);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new ApiResponse<>("Message sent successfully", 201, saved));
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<ContactMessage>>> getAllMessages() {
        return ResponseEntity.ok(
                new ApiResponse<>("Messages fetched successfully", 200, contactMessageService.getAllMessages())
        );
    }

    @PostMapping("/delete/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteMessage(@PathVariable Long id) {
        contactMessageService.deleteMessage(id);
        return ResponseEntity.ok(new ApiResponse<>("Message deleted successfully", 200, null));
    }
}
