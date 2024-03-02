package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class Main {
    public static String polybiusCipher(String s)
    {
        int row, col;

        String output = "";

        // convert each character
        // to its encrypted code
        for (int i = 0;i < s.length(); i++)
        {

            // finding row of the table
            row = (int)Math.ceil((s.charAt(i) - 'a') / 5) + 1;

            // finding column of the table
            col = ((s.charAt(i) - 'a') % 5) + 1;

            // if character is 'k'
            if (s.charAt(i) == 'k')
            {
                row = row - 1;
                col = 5 - col + 1;
            }

            // if character is greater than 'j'
            else if (s.charAt(i) >= 'j')
            {
                if (col == 1)
                {
                    col = 6;
                    row = row - 1;
                }
                col = col - 1;
            }

            output += row + "" + col;
        }

        return output;
    }

    public static String decryptPolybiusCipher(String s) {
        StringBuilder output = new StringBuilder();

        for (int i = 0; i < s.length(); i += 2) {
            int row = Character.getNumericValue(s.charAt(i)) - 1;
            int col = Character.getNumericValue(s.charAt(i + 1)) - 1;

            int charNum = (row * 5) + col;
            char letter;
            if (charNum < 8) {
                letter = (char) ('a' + charNum);
                if (letter > 'j') {
                    letter++;
                }
            } else {
                letter = (char) ('a' + charNum + 1);
            }
            output.append(letter);
        }

        return output.toString();
    }

    public static Boolean saveToFile(String s) {
        try {
            FileWriter writer = new FileWriter(s + ".txt");
            writer.write(s);
            writer.close();
            System.out.println("Result written to " + s + ".txt");
            return true;
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
            return false;
        }
    }

    public static String readFromFile(String s) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(s + ".txt"));
            String line = reader.readLine();
            System.out.println("Read from file: " + line);
            reader.close();
            return line;
        } catch (IOException e) {
            System.out.println("Error reading from file: " + e.getMessage());
            return "";
        }
    }

    public static void main (String[] args)
    {
        String s = "test";
        String output = polybiusCipher(s);
        System.out.println(output);
    }
}