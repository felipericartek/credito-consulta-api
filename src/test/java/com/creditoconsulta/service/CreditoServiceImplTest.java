package com.creditoconsulta.service;

import com.creditoconsulta.messaging.MensageriaService;
import com.creditoconsulta.model.Credito;
import com.creditoconsulta.repository.CreditoRepository;
import com.creditoconsulta.service.impl.CreditoServiceImpl;
import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CreditoServiceImplTest {

    private CreditoRepository repository;
    private MensageriaService mensageriaService;
    private CreditoServiceImpl service;

    @BeforeEach
    void setUp() {
        repository = mock(CreditoRepository.class);
        mensageriaService = mock(MensageriaService.class);
        service = new CreditoServiceImpl(repository, mensageriaService);
    }

    @Test
    void deveBuscarCreditosPorNumeroNfse() {
        var credito = new Credito();
        credito.setNumeroNfse("7891011");
        when(repository.findByNumeroNfse("7891011")).thenReturn(List.of(credito));

        var resultado = service.buscarPorNumeroNfse("7891011");

        assertEquals(1, resultado.size());
        verify(mensageriaService).enviarConsulta("Consulta por NFS-e: 7891011");
    }

    @Test
    void deveBuscarCreditoPorNumero() {
        var credito = new Credito();
        credito.setNumeroCredito("123456");
        when(repository.findByNumeroCredito("123456")).thenReturn(Optional.of(credito));

        var resultado = service.buscarPorNumeroCredito("123456");

        assertNotNull(resultado);
        assertEquals("123456", resultado.getNumeroCredito());
        verify(mensageriaService).enviarConsulta("Consulta por Crédito: 123456");
    }

    @Test
    void deveLancarExcecaoQuandoCreditoNaoExiste() {
        when(repository.findByNumeroCredito("999")).thenReturn(Optional.empty());

        assertThrows(EntityNotFoundException.class, () -> service.buscarPorNumeroCredito("999"));
    }
}
