package ru.job4j.condition;

/**
 * DummyBot
 *
 * @author Rodion V.
 * @version 1.0
 * @since 1.0
 */
public class DummyBot {
    /**
     * Отвечает на вопросы.
     *
     * @param question Вопрос от клиента.
     * @return Ответ.
     */
    public String answer(String question) {
        String rsl = "Это ставит меня в тупик. Спросите другой вопрос.";
        if ("Привет, Бот.".equals(question)) {
            rsl = "Привет, умник";
        } else if (question.equals("Пока.")) {
            rsl = "До скорой встречи.";
        }
        return rsl;
    }
}

