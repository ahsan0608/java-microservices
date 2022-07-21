package com.ahsan.spam;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class SpamCheckService {

    private final SpamCheckHistoryRepository spamCheckHistoryRepository;

    public boolean isSpamClient(Integer clientId){
        spamCheckHistoryRepository.save(
                SpamCheckHistory.builder()
                        .clientId(clientId)
                        .isSpammer(false)
                        .createdAt(LocalDateTime.now())
                        .build()
        );
        return true;
    }

}
