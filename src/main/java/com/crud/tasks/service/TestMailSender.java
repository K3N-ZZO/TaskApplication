package com.crud.tasks.service;

import com.crud.tasks.config.AdminConfig;
import com.crud.tasks.domain.Mail;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TestMailSender {

    private final SimpleEmailService emailService;
    private final AdminConfig adminConfig;

    @PostConstruct
    public void sendTestMail() {
        System.out.println(">>> Wysyłam testowego maila <<<");

        Mail mail = Mail.builder()
                .mailTo(adminConfig.getAdminMail())
                .subject("TEST EMAIL")
                .message("To jest wiadomość testowa wysyłana przy starcie aplikacji.")
                .toCc(null) // możesz też przetestować z CC
                .build();

        emailService.send(mail);
    }
}
