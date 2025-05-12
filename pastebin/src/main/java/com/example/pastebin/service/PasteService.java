package com.example.pastebin.service;

import com.example.pastebin.entity.Paste;
import com.example.pastebin.repository.PasteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.concurrent.ThreadLocalRandom;

@Service
@RequiredArgsConstructor
public class PasteService {
    private final PasteRepository pasteRepository;

    public String createPaste(String content) {
        Paste paste = new Paste();
        paste.setContent(content);
        paste.setShortUrl(generateShortUrl());
        return pasteRepository.save(paste).getShortUrl();
    }

    public String getPaste(String shortUrl) {
        return pasteRepository.findByShortUrl(shortUrl)
                .orElseThrow(() -> new RuntimeException("Paste not found"))
                .getContent();
    }

    private String generateShortUrl() {
        return Integer.toHexString(ThreadLocalRandom.current().nextInt());
    }
}