package com.creditoconsulta.messaging;

import com.creditoconsulta.messaging.kafka.KafkaMensageriaService;
import org.junit.jupiter.api.Test;
import org.springframework.kafka.core.KafkaTemplate;

import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.*;

class KafkaMensageriaServiceTest {

    @Test
    void deveEnviarMensagemParaKafka() {
        KafkaTemplate<String, String> kafkaTemplate = mock(KafkaTemplate.class);
        KafkaMensageriaService service = new KafkaMensageriaService(kafkaTemplate);

        var field = KafkaMensageriaService.class.getDeclaredFields()[0];
        field.setAccessible(true);
        try {
            field.set(service, "topico-teste");
        } catch (IllegalAccessException e) {
            fail("Erro ao injetar campo");
        }

        service.enviarConsulta("mensagem de teste");

        verify(kafkaTemplate).send("topico-teste", "mensagem de teste");
    }
}

