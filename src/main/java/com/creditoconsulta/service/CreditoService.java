package com.creditoconsulta.service;

import com.creditoconsulta.model.Credito;

import java.util.List;

public interface CreditoService {
    List<Credito> buscarPorNumeroNfse(String numeroNfse);
    Credito buscarPorNumeroCredito(String numeroCredito);
}
