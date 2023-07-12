package com.aplicacionsaludos.app;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping(value = "api/saludo")
public class SaludoController {

    private final AtomicLong contador = new AtomicLong();
    private final String plantilla = "Hola %s";

    @GetMapping
    public Saludo saludo(@RequestParam(value = "nombre", defaultValue = "Mundo") String nombre){
        return new Saludo(contador.incrementAndGet(), String.format(plantilla, nombre));
    }
}
