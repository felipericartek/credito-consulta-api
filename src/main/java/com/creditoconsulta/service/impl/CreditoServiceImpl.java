package com.creditoconsulta.service.impl;

import com.creditoconsulta.messaging.MensageriaService;
import com.creditoconsulta.model.Credito;
import com.creditoconsulta.repository.CreditoRepository;
import com.creditoconsulta.service.CreditoService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CreditoServiceImpl implements CreditoService {

    private final CreditoRepository creditoRepository;
    private final MensageriaService mensageriaService;

    public CreditoServiceImpl(CreditoRepository creditoRepository, MensageriaService mensageriaService) {
        this.creditoRepository = creditoRepository;
        this.mensageriaService = mensageriaService;
    }

    @Override
    public List<Credito> buscarPorNumeroNfse(String numeroNfse) {
        var creditos = creditoRepository.findByNumeroNfse(numeroNfse);
        mensageriaService.enviarConsulta("Consulta por NFS-e: " + numeroNfse);
        return creditos;
    }

    @Override
    public Credito buscarPorNumeroCredito(String numeroCredito) {
        var credito = creditoRepository.findByNumeroCredito(numeroCredito)
                .orElseThrow(() -> new EntityNotFoundException("Crédito não encontrado"));
        mensageriaService.enviarConsulta("Consulta por Crédito: " + numeroCredito);
        return credito;
    }
}
