package org.example;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Interpretor {
    private Map<String, Integer> variables;

    public  Interpretor(){
        variables = new HashMap<>();
    }

    public void interpret(String sourceCode) {
        String[] lines = sourceCode.split("\n");

        for (String line : lines) {
            line = line.trim();

            if (line.isEmpty()) {
                continue;
            }

            if (line.startsWith("print")) {
                handlePrintStatement(line);
            } else {
                handleAssignment(line);
            }
        }
    }

    private void handleAssignment(String line) {
        line = line.replace(" ", "");
        String[] parts = line.split("=");
        String variable = parts[0];
        int value = evaluateExpression(parts[1]);

        variables.put(variable, value);
    }

    private int evaluateExpression(String expression) {
        String[] tokens = expression.trim().split(" ");
        int result = 0;
        int current = 0;
        String operator = "+";

        for (String token : tokens) {
            if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/") || token.equals("%")) {
                operator = token;
            } else {
                int value = Integer.parseInt(token);

                if (operator.equals("+")) {
                    result += value;
                } else if (operator.equals("-")) {
                    result -= value;
                } else if (operator.equals("*")) {
                    result *= value;
                } else if (operator.equals("/")) {
                    result /= value;
                } else if (operator.equals("%")) {
                    result %= value;
                }
            }
        }

        return result;
    }

    private void handlePrintStatement(String line) {
        String[] parts = line.split(" ");
        String variable = parts[1].trim();

        if (variables.containsKey(variable)) {
            int value = variables.get(variable);
            System.out.println(value);
        } else {
            System.err.println("Error: Variable '" + variable + "' is undefined");
        }
    }
}
