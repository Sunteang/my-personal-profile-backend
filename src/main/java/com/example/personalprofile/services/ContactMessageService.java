package com.example.personalprofile.services;

import com.example.personalprofile.models.ContactMessage;
import com.example.personalprofile.repositories.ContactMessageRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ContactMessageService {

    private final ContactMessageRepository contactMessageRepository;

    public ContactMessageService(ContactMessageRepository contactMessageRepository) {
        this.contactMessageRepository = contactMessageRepository;
    }

    public List<ContactMessage> getAllMessages() {
        return contactMessageRepository.findAll();
    }

    public Optional<ContactMessage> getMessageById(Long id) {
        return contactMessageRepository.findById(id);
    }

    public ContactMessage createMessage(ContactMessage message) {
        message.setCreatedAt(LocalDateTime.now());
        return contactMessageRepository.save(message);
    }

    public void deleteMessage(Long id) {
        contactMessageRepository.deleteById(id);
    }
}
