package ru.oop.slon;
import java.util.Scanner;

public class SlonClient {
    private final Scanner scanner;

    public SlonClient() {
        this.scanner = new Scanner(System.in);
    }

    public void print(String message) {
        System.out.println(message);
    }

    public String ask() {
        if (scanner.hasNextLine()) {
            return scanner.nextLine();
        }
        return "";
    }

    public void close() {
        scanner.close();
    }
}