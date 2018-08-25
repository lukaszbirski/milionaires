package com.company;

import java.util.ArrayList;
import java.util.List;

public class SimpleQuestionGenerator implements QuestionGenerator {

    @Override
    public List<Question> generateQuestions() {
        List<Question> questions= new ArrayList<>();
        questions.add(new Question("Czy Polska leży w Europe?", true));
        questions.add(new Question("Czy kot szczeka?", false));
        questions.add(new Question("Czy krowa daje mleko?", true));
        questions.add(new Question("Czy w Javie jest wielodziedziczenie?", false));
        questions.add(new Question("Czy Berlin jest stolicą Niemiec?", true));
        questions.add(new Question("Czy krowy latają?", false));

        return questions;
    }
}
