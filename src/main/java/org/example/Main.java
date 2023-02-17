package org.example;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //System.out.println("Chemin du fichier: ");
        String filePath = "src/main/java/org/example/numero.txt";// sc.nextLine();

        ArrayList<String> lines = getFileLines(filePath);
        if(lines == null){
            System.out.println("Erreur de lecture du fichier");
        }else {
            if(!isAllNumber(lines)) {
                System.out.println("fichier invalides, ne contient pas que des nombres");
            }else {
                System.out.println("opérateur : ");
                String userInput = sc.nextLine();
                while (!isOperator(userInput)){
                    System.out.println("opérateur inconnue, essayez encore ( *, +, - ) : ");
                }
                System.out.println(doCalcul(lines, userInput));
            }
        }

    }

    static String createOutput(int first,int second, String operator){
        String output = "";
        output += operator + " " + first + " (=" + second + ") ";
        return output;
    }

    static int doCalcul(ArrayList<String> lines, String operator){
        StringBuilder output = new StringBuilder();
        int result = Integer.parseInt(lines.get(0));
        output.append(result).append(" ");
        lines.remove(0);
        for (String line : lines) {
            int number = Integer.parseInt(line);
            switch (operator) {
                case "+" -> result += number;
                case "-" -> result -= number;
                case "*" -> result *= number;
            }
            output.append(createOutput(result, number, operator));
        }
        System.out.println(output);
        return result;
    }

    static ArrayList<String> getFileLines(String filePath) {
        try{
            File file = new File(filePath);
            Scanner scanner = new Scanner(file);
            ArrayList<String> lines = new ArrayList<>();
            while(scanner.hasNextLine())
            {
                String line = scanner.nextLine();
                lines.add(line);
            }
            scanner.close();
            return lines;
        }catch (IOException e){
            e.printStackTrace();
            return null;
        }
    }
    static boolean isOperator(String userInput){
        return userInput.equals("+") || userInput.equals("-") || userInput.equals("*");
    }

     static boolean isAllNumber(ArrayList<String> lines){
        for (String line : lines) {
            if(!isNumber(line)){
                return false;
            }
        }
        return true;
    }

    static boolean isNumber(String userInput){
        try{
            Integer.parseInt(userInput);
            return true;
        }catch (NumberFormatException e){
            return false;
        }
    }
}