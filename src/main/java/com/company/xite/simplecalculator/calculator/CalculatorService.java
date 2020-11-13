package com.company.xite.simplecalculator.calculator;

import com.company.xite.simplecalculator.Result;
import com.company.xite.simplecalculator.classifier.NumberClassificationService;
import com.company.xite.simplecalculator.classifier.NumberClassifier;
import com.company.xite.simplecalculator.equation.Equation;
import org.springframework.stereotype.Service;

@Service
public class CalculatorService {
    private Result result;

    public Result performEquation(Equation equation) {
        result.setEquation(equation);
        switch (equation.getOperator()) {
            case "+":
                result.setResultNumber(equation.getFirstOperand() + equation.getSecondOperand());
                break;
            case "-":
                result.setResultNumber(equation.getFirstOperand() - equation.getSecondOperand());
                break;
            case "*":
            case "x":
            case "X":
                result.setResultNumber(equation.getFirstOperand() * equation.getSecondOperand());
                break;
            case "/":
                result.setResultNumber(equation.getFirstOperand() / equation.getSecondOperand());
        }
        result.setNumberClassifier(
                new NumberClassifier(NumberClassificationService.isNaturalNumber(result.getResultNumber()),
                        NumberClassificationService.isPositiveNumber(result.getResultNumber()),
                        NumberClassificationService.isNegativeNumber(result.getResultNumber()),
                        NumberClassificationService.isPrimeNumber(result.getResultNumber()),
                        NumberClassificationService.isWholeNumber(result.getResultNumber()))
        );
        return result;
    }
}
