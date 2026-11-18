package ru.oop.slon;

public class Main {
    public static void main(String[] args) {
        SlonLogic dialog = new SlonLogic();
        SlonClient client = new SlonClient();
        client.print(dialog.getGreeting());
        client.print("");
        while (true) {
            String userInput = client.ask();
            if (dialog.isExitCommand(userInput)) {
                client.print("Пока!");
                break;
            }
            String response = dialog.processResponse(userInput);
            client.print(response);
            client.print("");
        }
        client.close();
    }
}