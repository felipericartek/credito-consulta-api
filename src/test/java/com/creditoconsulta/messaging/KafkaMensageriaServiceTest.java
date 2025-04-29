package com.creditoconsulta.messaging;

import com.creditoconsulta.messaging.kafka.KafkaMensageriaService;
import org.junit.jupiter.api.Test;
import org.springframework.kafka.core.KafkaTemplate;

import static org.mockito.Mockito.*;

class KafkaMensageriaServiceTest {

    @Test
    void deveEnviarMensagemParaKafka() {
        KafkaTemplate<String, String> kafkaTemplate = mock(KafkaTemplate.class);
        String topic = "topico-teste";
        KafkaMensageriaService service = new KafkaMensageriaService(kafkaTemplate, topic);

        service.enviarConsulta("mensagem de teste");

        verify(kafkaTemplate).send(topic, "mensagem de teste");
    }
}

