package ru.oop.slon;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SlonLogicTest {

    @Test
    void returnsExpectedGreeting() {
        SlonLogic logic = new SlonLogic();
        String expected = "Привет!\n" +
                "Я - продавец слона\n" +
                "Для справки используй \\help или\n" +
                "Купи слона!";
        assertEquals(expected, logic.getGreeting());
    }

    @Test
    void returnsHelpOnHelpCommand() {
        SlonLogic logic = new SlonLogic();
        assertEquals(logic.getHelp(), logic.processResponse("\\help"));
        assertEquals(logic.getHelp(), logic.processResponse("  \\help  "));
    }

    @Test
    void teasesWithUserPhrase() {
        SlonLogic logic = new SlonLogic();
        String expected = "Все говорят \"Не хочу\".\nА ты купи слона!";
        assertEquals(expected, logic.processResponse("Не хочу"));
    }

    @Test
    void escapesQuotesInUserPhrase() {
        SlonLogic logic = new SlonLogic();
        String expected = "Все говорят \"Сказал \\\"привет\\\"\".\nА ты купи слона!";
        assertEquals(expected, logic.processResponse("Сказал \"привет\""));
    }

    @Test
    void recognizesExitCommandIgnoringCaseAndSpaces() {
        SlonLogic logic = new SlonLogic();
        assertTrue(logic.isExitCommand("exit"));
        assertTrue(logic.isExitCommand("  EXIT  "));
        assertFalse(logic.isExitCommand("выход"));
    }
}