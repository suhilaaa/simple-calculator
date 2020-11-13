package com.company.xite.simplecalculator.calculator;

import com.company.xite.simplecalculator.Result;
import com.company.xite.simplecalculator.equation.Equation;
import com.company.xite.simplecalculator.equation.EquationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CalculatorController {
    @Autowired
    private EquationService equationService;

    @Autowired
    private CalculatorService calculatorService;

    @PostMapping("/calculate/{userId}")
    public Result calculate(@PathVariable long userId, @RequestParam String equation){
        Equation formattedEquation = equationService.getEquation(equation);
        return calculatorService.performEquation(formattedEquation);
    }
}
