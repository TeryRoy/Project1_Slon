package ru.oop.slon;

public class SlonLogic {
    private final String helpCommand = "\\help";

    public String getGreeting() {
        return "Привет!\n" +
                "Я - продавец слона\n" +
                "Для справки используй " + helpCommand + " или\n" +
                "Купи слона!";
    }

    public String getHelp() {
        return "Я бот, который очень хочет продать тебе слона.\n" +
                "Просто пиши что угодно, а я буду отвечать.\n" +
                "Команда exit - выход из программы\n" +
                "Команда " + helpCommand + " покажет это сообщение.";
    }

    public String processResponse(String userInput) {
        String trimmedInput = userInput.trim();
        if (trimmedInput.equals(helpCommand)) {
            return getHelp();
        }
        String safeInput = trimmedInput.replace("\"", "\\\"");
        return "Все говорят \"" + safeInput + "\".\n" + "А ты купи слона!";
    }

    public boolean isExitCommand(String input) {
        String cmd = input.trim().toLowerCase();
        return cmd.equals("exit");
    }
}