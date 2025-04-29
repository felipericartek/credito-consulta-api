package com.creditoconsulta.controller;

import com.creditoconsulta.model.Credito;
import com.creditoconsulta.service.CreditoService;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CreditoControllerTest {

    @Test
    void deveRetornarCreditosPorNfse() {
        CreditoService service = mock(CreditoService.class);
        CreditoController controller = new CreditoController(service);

        var credito = new Credito();
        credito.setNumeroNfse("7891011");

        when(service.buscarPorNumeroNfse("7891011")).thenReturn(List.of(credito));

        ResponseEntity<List<Credito>> resposta = controller.buscarPorNumeroNfse("7891011");

        assertEquals(HttpStatus.OK, resposta.getStatusCode());
        assertEquals(1, resposta.getBody().size());
    }

    @Test
    void deveRetornarCreditoPorNumero() {
        CreditoService service = mock(CreditoService.class);
        CreditoController controller = new CreditoController(service);

        var credito = new Credito();
        credito.setNumeroCredito("123456");

        when(service.buscarPorNumeroCredito("123456")).thenReturn(credito);

        ResponseEntity<Credito> resposta = controller.buscarPorNumeroCredito("123456");

        assertEquals(HttpStatus.OK, resposta.getStatusCode());
        assertEquals("123456", resposta.getBody().getNumeroCredito());
    }
}
