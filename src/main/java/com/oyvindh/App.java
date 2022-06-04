package com.oyvindh;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class App {
    ArrayList<String> listOfLines = new ArrayList();

    public static void main(String[] args) {
        new App().readFileToList();
    }

    void printSize() {
        System.out.println(listOfLines.size());
        removeLetter();
    }
    void readFileToList() {
        try {
            listOfLines.clear();
            File f = new File("C:/Users/oyvin/OneDrive/Dokumenter/GitHub/WordlePossibilities/PossibleWords.txt");
            BufferedReader br = new BufferedReader(new FileReader(f));
            String line = br.readLine();
            while (line != null) {
                listOfLines.add(line);
                line = br.readLine();
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        printSize();
    }
    void removeLetter() {
        Scanner s = new Scanner(System.in);
        System.out.println("What letter is not in the word? ");
        String inputLetter = s.nextLine();
        int numbers = 0;
        while (numbers !=  listOfLines.size()) {
            if (listOfLines.get(numbers).contains(inputLetter)) {
                //System.out.println(listOfLines.get(numbers));
                listOfLines.remove(numbers);
            } else {
            numbers++;
        }
        }
        System.out.println(listOfLines.size());
        runAgain();

    }
    void runAgain(){
        System.out.println("Do you wanna continue? y/n ");
        Scanner s = new Scanner(System.in);
        String answer = s.nextLine();
        if (answer.equalsIgnoreCase("y")) {
            removeLetter();
        } else {
            System.out.println("The possibilities left were: " + listOfLines.size());
            System.exit(0);
        }
    }
}
