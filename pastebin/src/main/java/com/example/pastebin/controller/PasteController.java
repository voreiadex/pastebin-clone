package com.example.pastebin.controller;

import com.example.pastebin.service.PasteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/pastes")
@RequiredArgsConstructor
public class PasteController {
    private final PasteService pasteService;

    @PostMapping
    public String createPaste(@RequestBody String content) {
        return pasteService.createPaste(content);
    }

    @GetMapping("/{shortUrl}")
    public String getPaste(@PathVariable String shortUrl) {
        return pasteService.getPaste(shortUrl);
    }

    @Controller
    public static class HomeController {

        @GetMapping("/")
        public String home() {
            return "forward:/index.html";
        }
    }
}