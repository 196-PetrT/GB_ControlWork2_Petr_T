package virtual_picnic.user_interface;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class App {
    public App() {
        String pathToFile = "D:\\обучение в GB\\repForJava\\GB_ControlWork2_Petr_T\\virtual_picnic\\bd\\input.txt";

        System.err.println("программа выполняет общий подсчет количества продуктов, и по наименованиям\n" +
                "также определяется самое длинное наименование и частота встречающихся слов!\n");

        while (true) {
            Scanner in = new Scanner(System.in);
            System.out.print("Для выполнения программы введите любое значение, для завершения введите q: ");
            String nameFruit = in.nextLine();
            if (nameFruit.equalsIgnoreCase("q")) {
                System.out.println("Работа с программой завершена");
                break;
            }
            try {
                File file = new File(pathToFile);
                Scanner scanner = new Scanner(file);
                HashMap<String, Integer> fruitsMap = new HashMap<>();

                double wordCount = 0;
                String longestWord = "";

                while (scanner.hasNext()) {
                    String word = scanner.next();
                    wordCount++;
                    if (word.length() > longestWord.length()) longestWord = word;
                    fruitsMap.put(word, fruitsMap.getOrDefault(word, 0) + 1);
                }

                System.out.println("Общее количество продуктов: " + wordCount + "\n");
                System.out.println("Самое длинное название продукта: " + longestWord + "\n");
                System.out.println("Продукт попадается с частотой: ");
                for (String word : fruitsMap.keySet()) {
                    System.out.println(word + ": " + String.format("%.5g%n", (fruitsMap.get(word)/wordCount)));
                }

                scanner.close();
            } catch (FileNotFoundException e) {
                System.out.println("Проверьте путь к файлу!");
            }
        }
    }
}