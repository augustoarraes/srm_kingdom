package com.srmasset.api.infra;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
public class ConversaoProducerInfra {

    private final RabbitTemplate rabbitTemplate;

    public ConversaoProducerInfra(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void enviarMensagem(String mensagem) {
        rabbitTemplate.convertAndSend(RabbitMQConfig.SRM_FILA_CONVERSAO, mensagem);
    }
}
