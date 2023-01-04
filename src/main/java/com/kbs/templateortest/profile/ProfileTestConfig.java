package com.kbs.templateortest.profile;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;

@Configuration
@RequiredArgsConstructor
@Profile("test")
public class ProfileTestConfig implements ProfileConfig {

    private final Environment env;

    @Bean
    @Override
    public String getProfile() {

        System.out.println("ProfileTestConfig.getProfile");

        String[] activeProfiles = env.getActiveProfiles();
        String result = null;

        if(activeProfiles.length == 0) {
            System.out.println("no activeProfile");
        } else {
            result = activeProfiles[0];
        }

        return result;
    }
}
