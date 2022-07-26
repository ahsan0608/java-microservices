package com.ahsan.agents.spam;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("spam")
public interface SpamAgent {
    @GetMapping(path = "api/v1/spam-check/{clientId}")
    SpamCheckResponse isSpammer(@PathVariable("clientId") Integer clientId);
}
