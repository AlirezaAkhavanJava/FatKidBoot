package com.arcade.FatKidBoot.event;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserEvent {
    private String username;
    private String password;
    private String email;
    private LocalDateTime dateTime;
    private boolean welcomeEmail = false;

    public UserEvent(String email, String username) {
        this.email = email;
        this.username = username;
        this.dateTime = LocalDateTime.now();
    }

    public void srtWelcomeEmail(boolean welcomeEmail) {
        this.welcomeEmail = welcomeEmail;
    }
}
