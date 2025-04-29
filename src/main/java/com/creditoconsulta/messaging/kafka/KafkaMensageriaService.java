package com.creditoconsulta.messaging.kafka;

import com.creditoconsulta.messaging.MensageriaService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaMensageriaService implements MensageriaService {

    private final KafkaTemplate<String, String> kafkaTemplate;
    private final String topic;

    public KafkaMensageriaService(KafkaTemplate<String, String> kafkaTemplate,
                                  @Value("${kafka.topic.consultas}") String topic) {
        this.kafkaTemplate = kafkaTemplate;
        this.topic = topic;
    }

    @Override
    public void enviarConsulta(String mensagem) {
        kafkaTemplate.send(topic, mensagem);
    }
}

