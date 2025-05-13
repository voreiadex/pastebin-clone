package com.example.pastebin.repository;

import com.example.pastebin.entity.Paste;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface PasteRepository extends JpaRepository<Paste, Long> {
    Optional<Paste> findByShortUrl(String shortUrl);
}