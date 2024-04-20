package ru.geekbrains.lesson2;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Task2 {

    /**
     * Запишите в файл следующие строки:
     * <p>
     * Анна=4
     * Елена=5
     * Марина=6
     * Владимир=?
     * Константин=?
     * Иван=4
     * <p>
     * Реализуйте метод, который считывает данные из файла и сохраняет в двумерный массив (либо HashMap, если
     * студенты с ним знакомы). В отдельном методе нужно будет пройти по структуре данных, если сохранено
     * значение ?, заменить его на соответствующее число. Если на каком-то месте встречается символ, отличный от
     * числа или ?, бросить подходящее исключение.
     */

    public static void main (String[] args) {
        prepareFile();
    }

    static Random random = new Random();
    static Scanner scanner = new Scanner(System.in);

    static void prepareFile() {


        if (scanner.hasNextInt()){
            int no = scanner.nextInt();
            String s = scanner.nextLine();
        }


        try (FileWriter fileWriter = new FileWriter("names.txt", false)) {
            fileWriter.write("Анна=4\n");
            fileWriter.write("Елена=5\n");
            fileWriter.write("Марина=6\n");
            if (random.nextInt(2) == 0){
                throw new Exception("Error.");
            }
            fileWriter.write("Владимир=?\n");
            fileWriter.write("Константин=?\n");
            fileWriter.write("Иван=4\n");
        }
        catch (IOException e){
            e.printStackTrace();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

}


















