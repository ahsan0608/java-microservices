package com.ahsan.spam;

import com.ahsan.agents.spam.SpamCheckResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("api/v1/spam-check")
@AllArgsConstructor
public class SpamController {

    private  final SpamCheckService spamCheckService;

    @GetMapping(path = "{clientId}")
    public SpamCheckResponse isSpammer(@PathVariable("clientId") Integer clientId){
        boolean isSpammerClient = spamCheckService.isSpamClient(clientId);
        log.info("spam check request for client {}", clientId);
        return new SpamCheckResponse(isSpammerClient);
    }
}
