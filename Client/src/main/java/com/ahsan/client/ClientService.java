package com.ahsan.client;

import com.ahsan.agents.spam.SpamAgent;
import com.ahsan.agents.spam.SpamCheckResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ClientService {
    private final ClientRepository clientRepository;
    private final SpamAgent spamAgent;

    public void registerClient(ClientRegistrationRequest request){
        Client client = Client.builder()
                .firstName(request.firstName())
                .lastName(request.lastName())
                .email(request.email())
                .build();

        this.clientRepository.save(client);

        SpamCheckResponse spamCheckResponse = this.spamAgent.isSpammer(client.getId());


        if (!spamCheckResponse.isSpammer()){
            throw new IllegalStateException("Spammer");
        }



        //validation
    }
}
