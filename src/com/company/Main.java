package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;


public class Main extends JFrame implements ActionListener {

    private QuestionGenerator questionGenerator;

    public QuestionGenerator getQuestionGenerator() {
        return questionGenerator;
    }

    public void setQuestionGenerator(QuestionGenerator questionGenerator) {
        this.questionGenerator = questionGenerator;
    }

    private int currenQuestion;
    private List<Question> questionList = new ArrayList<>();



    public Main(){
        setQuestionGenerator(new SimpleQuestionGenerator());
        questionList = questionGenerator.generateQuestions();
        setSize(500,500);
        setTitle("Milionaires");
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JButton yesButton = new JButton("TAK");
        JButton noButton = new JButton("NIE");
        label = new JLabel(currenQuestion+1 + ". " + questionList.get(currenQuestion).getContent(),0);
        label2 = new JLabel("Punktacja: " + score + "/" + (currenQuestion), 0);
        setLayout(new GridLayout(4,1));
        add(label);
        add(yesButton);
        add(noButton);
        add(label2);
        yesButton.addActionListener(this);
        noButton.addActionListener(this);
    }

    private JLabel label;
    private JLabel label2;
    private int score;
    private boolean correctPrevious;
    private String clickPrevious;
    private JButton button;

    public static void main(String[] args) {
	// write your code here
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Main main = new Main();
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        button = (JButton) e.getSource();
        if (currenQuestion < questionList.size()-1) {
            if (questionList.get(currenQuestion).isCorrect() == true && button.getText().equals("TAK") || questionList.get(currenQuestion).isCorrect() == false && button.getText().equals("NIE")) {score++;}
            correctPrevious = questionList.get(currenQuestion+1).isCorrect();
            currenQuestion++;
            label.setText(currenQuestion+1 + ". " + questionList.get(currenQuestion).getContent());
            label2.setText("Punktacja: " + score + "/" + (currenQuestion));
        }
        else if (currenQuestion == questionList.size()-1){
            clickPrevious = button.getText();
            currenQuestion++;
            if ((correctPrevious == true && clickPrevious.equals("TAK")) || (correctPrevious == false && clickPrevious.equals("NIE"))) score++;
            label.setText("KONIEC GRY!");
            label2.setText("Punktacja: " + score + "/" + (currenQuestion));
        }
    }
}
