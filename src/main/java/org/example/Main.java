package org.example;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
            Interpretor interpretor = new Interpretor();

            while(true){
                Scanner scanner = new Scanner(System.in);
                StringBuilder sourceCodeBuilder = new StringBuilder();
                System.out.println("LAVA : A simple language made by Lucas, in Java");
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    if (line.equals("")) {
                        break;
                    }
                    sourceCodeBuilder.append(line).append("\n");
                }

                String sourceCode = sourceCodeBuilder.toString();
                interpretor.interpret(sourceCode);
            }

    }
}