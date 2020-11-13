package com.company.xite.simplecalculator.user;

import com.company.xite.simplecalculator.equation.Equation;

import java.util.List;

public class User {
    private String id;
    private List<Equation> performedEquations;

    public User(String id, List<Equation> performedEquations) {
        this.id = id;
        this.performedEquations = performedEquations;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Equation> getPerformedEquations() {
        return performedEquations;
    }

    public void setPerformedEquations(List<Equation> performedEquations) {
        this.performedEquations = performedEquations;
    }
}
