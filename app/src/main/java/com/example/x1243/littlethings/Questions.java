package com.example.x1243.littlethings;

/**
 * Created by x1243 on 4/28/2017.
 */

public class Questions {

    public String mQuestions[] = {
            "How many people will experience some kind of mental health problem in the course of a year?",
            "What is the most common mental health disorder in Britain?",
            "What percentage of children have a mental health problem at any given time?",
            "How many people does depression affect?",
            "Who is most likely to die from comminting suicide?",
            "How many prisoners have a mental disorder?",
            "How many people worldwide are estimated to have a mental health problem?",
            "What are not physical symptoms of depression?",
            "How many people are affected by an eating disorder in the uk?",
            "What is the female to male ratio of Obsessive Compulsive Disorder"

    };

    private String mChoices[][] = {
            {"1 in 4", "1 in 10", "1 in 6", "1 in 3"},
            {"Eating Disorders", "Schizophrenia", "Depression", "Epilepsy"},
            {"15%", "10%", "5%", "20%"},
            {"1 in 5", "1 in 3", "1 in 10", "1 in 12"},
            {"Men", "Women", " ", " "},
            {"1 in 2", "1 in 5", "9 in 10", "1 in 3"},
            {"300 million", "450 million", "100 million", "550 million"},
            {"Sleeping for longer", "Lessened sex drive", "Constipation", "Loss of appetite"},
            {"0.5 million", "1.7 million", "0.9 million", "1.1 million"},
            {"10:7", "15:9", "7:10", "9:15"}
    };

    private String mCorrectAnswers[] = {"1 in 4", "Depression", "10%", "1 in 5", "Men", "9 in 10", "450 million", "Sleeping for longer", "1.1 million", "15:9"};

    public String getQuestion(int a){
        String question = mQuestions[a];
        return question;
    }

    public String getChoice1(int a){
        String choice = mChoices[a][0];
        return choice;
    }

    public String getChoice2(int a){
        String choice = mChoices[a][1];
        return choice;
    }

    public String getChoice3(int a){
        String choice = mChoices[a][2];
        return choice;
    }

    public String getChoice4(int a){
        String choice = mChoices[a][3];
        return choice;
    }

    public String getCorrectAnswer(int a){
        String answer = mCorrectAnswers[a];
        return answer;
    }
}
