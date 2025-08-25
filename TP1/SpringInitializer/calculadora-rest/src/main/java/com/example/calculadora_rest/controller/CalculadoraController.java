package com.example.calculadora_rest.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class CalculadoraController {

    @RequestMapping(value = "/adicao", method = {RequestMethod.GET, RequestMethod.POST})
    public double adicao(@RequestParam double a, @RequestParam double b) {
        return a + b;
    }

    @RequestMapping(value = "/subtracao", method = {RequestMethod.GET, RequestMethod.POST})
    public double subtracao(@RequestParam double a, @RequestParam double b) {
        return a - b;
    }

    @RequestMapping(value = "/multiplicacao", method = {RequestMethod.GET, RequestMethod.POST})
    public double multiplicacao(@RequestParam double a, @RequestParam double b) {
        return a * b;
    }

    @RequestMapping(value = "/divisao", method = {RequestMethod.GET, RequestMethod.POST})
    public double divisao(@RequestParam double a, @RequestParam double b) {
        if (b == 0) throw new IllegalArgumentException("O divisor não pode ser zero!");
        return a / b;
    }

    @RequestMapping(value = "/exponenciacao", method = {RequestMethod.GET, RequestMethod.POST})
    public double exponenciacao(@RequestParam double a, @RequestParam double b) {
        return Math.pow(a, b);
    }
}

