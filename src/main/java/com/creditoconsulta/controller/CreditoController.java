package com.creditoconsulta.controller;

import com.creditoconsulta.model.Credito;
import com.creditoconsulta.service.CreditoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/creditos")
public class CreditoController {

    private final CreditoService creditoService;

    public CreditoController(CreditoService creditoService) {
        this.creditoService = creditoService;
    }

    @GetMapping("/{numeroNfse}")
    public ResponseEntity<List<Credito>> buscarPorNumeroNfse(@PathVariable String numeroNfse) {
        return ResponseEntity.ok(creditoService.buscarPorNumeroNfse(numeroNfse));
    }

    @GetMapping("/credito/{numeroCredito}")
    public ResponseEntity<Credito> buscarPorNumeroCredito(@PathVariable String numeroCredito) {
        return ResponseEntity.ok(creditoService.buscarPorNumeroCredito(numeroCredito));
    }
}
