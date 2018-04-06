package com.example.android.quizapp;

/**
 * Created by QuynhNguyen on 4/6/18.
 */

public class QuestionLibrary {

    private String questionsList [] = {
            "When was Google founded?",
            "Which term was Google derived from?",
            "What was the original name of Google?",
            "Why are there goats on the lawns at the Mountain View HQ?",
            "What was the first ever Google Doodle?",
            "The original Google computer storage was built with what?",
            "When was \'Google\' added as a verb in the Oxford English Dictionary?",
            "What is the nickname of Google\'s new employees?",
            "What is the unofficial slogan of Google?"
    };

    private String optionsList [][] = {
            {"September 1, 1998", "September 2, 1998", "September 3, 1998", "September 4, 1998"},
            {"googol", "gooogle", "googel", "gogle"},
            {"Yahoo", "Backrub", "Bing", "Ask"},
            {"To entertain visitors during open house", "To provide fresh milk to the employees", "To keep employees calm and focus", "To mow the lawns as part of Google\'s green initiative"},
            {"Fall Equinox", "Burning Man stick figure", "Pac-Man", "Claude Monet"},
            {"Legos", "Nanoblocks", "Duplo", "Minecraft"},
            {"February 2000", "August 2002", "April 2004", "June 2006"},
            {"Nooglers", "Googlers", "Backrubbers", "Freshmen"},
            {"\'Do the right thing\'", "\'You can make money without doing evil\'", "\'Don\'t be evil\'", "\'Think different\'"}
    };

    private String correctAnswersList [] = {
            "September 4, 1998",
            "googol",
            "Backrub",
            "To mow the lawns as part of Google\'s green initiative",
            "Burning Man stick figure",
            "Legos",
            "June 2006",
            "Nooglers",
            "\'Don\'t be evil\'"
    };

    public String getQuestion(int a) {
        String question = questionsList[a];
        return question;
    };


    public String getOption1(int a) {
        String option1 = optionsList[a][0];
        return option1;
    };


    public String getOption2(int a) {
        String option2 = optionsList[a][1];
        return option2;
    };

    public String getOption3(int a) {
        String option3 = optionsList[a][2];
        return option3;
    };

    public String getOption4(int a) {
        String option4 = optionsList[a][3];
        return option4;
    };

    public String correctAnswersList(int a) {
        String correctAnswer = correctAnswersList[a];
        return correctAnswer;
    };
    
}
