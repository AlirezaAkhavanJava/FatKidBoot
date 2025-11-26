package com.arcade.FatKidBoot.audit;

import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class AuditorConfig {

    public AuditorAware<String> auditorAware() {
        //no spring security yet
        return () -> Optional.of("ADMIN");
    }
}
