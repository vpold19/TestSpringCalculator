package com.example.skypro.testspringcalculator.controller;

import com.example.skypro.testspringcalculator.service.CalculatorService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculatorController {
    private final CalculatorService calculatorService;

    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @GetMapping()
    public String hello() {
        return "<b> Добро пожаловать в мой крутой калькулятор, умеет только суммировать, вычитать, умножать и делить, пока что...</b>";
    }

    @GetMapping("/plus")
    public String plus(@RequestParam("num1") int a, @RequestParam("num2") int b) {
        return String.format("%s + %s = %s", a, b, calculatorService.plus(a, b));
    }

    @GetMapping("/minus")
    public String minus(@RequestParam("num1") int a, @RequestParam("num2") int b) {
        return String.format("%s - %s = %s", a, b, calculatorService.minus(a, b));
    }

    @GetMapping("/multiply")
    public String multiply(@RequestParam("num1") int a, @RequestParam("num2") int b) {
        return String.format("%s * %s =%s", a, b, calculatorService.multiply(a, b));
    }

    @GetMapping("/divide")
    public String divide(@RequestParam("num1") int a, @RequestParam("num2") int b) {
        try {
            int result = calculatorService.divide(a, b);
            return String.format("%s * %s =%s", a, b, result);
        } catch (Exception e) {
            return "Тупой чтоли? На 0 делить нельзя";
        }
    }
}
