package com.ahsan.client;

import com.ahsan.agents.notification.NotificationAgent;
import com.ahsan.agents.notification.NotificationRequest;
import com.ahsan.agents.spam.SpamAgent;
import com.ahsan.agents.spam.SpamCheckResponse;
import com.ahsan.rmq.RabbitMQMessageProducer;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ClientService {
    private final ClientRepository clientRepository;
    private final SpamAgent spamAgent;
    private final NotificationAgent notificationAgent;
    private final RabbitMQMessageProducer rabbitMQMessageProducer;


    public void registerClient(ClientRegistrationRequest request) {

        Client client = Client.builder()
                .firstName(request.firstName())
                .lastName(request.lastName())
                .email(request.email())
                .build();

        clientRepository.saveAndFlush(client);

        SpamCheckResponse spamCheckResponse = spamAgent.isSpammer(client.getId());

        if (!spamCheckResponse.isSpammer()){
            throw new IllegalStateException("Spammer!");
        }

//        notificationAgent.sendNotification(
//                new NotificationRequest(
//                        client.getId(),
//                        client.getEmail(),
//                        String.format("Hi %s, Welcome to tecognize.. ",client.getFirstName())
//                )
//        );


        NotificationRequest notificationRequest = new NotificationRequest(
                client.getId(),
                client.getEmail(),
                String.format("Hi %s, Welcome to tecognize.. ",client.getFirstName())
        );

        rabbitMQMessageProducer.publish(
                notificationRequest,
                "internal.exchange",
                "internal-notification.routing-key");


        
        //validation
    }
}
