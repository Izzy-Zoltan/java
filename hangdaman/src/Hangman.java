import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader; 

public class Hangman {

    int tilesize = 64;
    int boardDimension = 8*tilesize;

    JFrame frame = new JFrame("Minesweeper"); //creates a new window
    JLabel textLabel = new JLabel();
    JPanel textPanel = new JPanel();
    JPanel BoardPanel = new JPanel();
    FileReader fr;

    Hangman(){
        try{
        FileReader fr = new FileReader("C:\\Users\\mzoltan\\Documents\\GitHub\\java\\minesweep\\src\\words.txt");
    } catch (FileNotFoundException ex){
        ex.printStackTrace();
    }
        BufferedReader br = new BufferedReader(fr);


        frame.setSize(boardDimension, boardDimension);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        textLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 32));
        textLabel.setHorizontalAlignment((JLabel.CENTER));
        textLabel.setText("Hangman");
        textLabel.setOpaque(true);

        textPanel.setLayout(new BorderLayout());
        textPanel.add(textLabel);
        frame.add(textPanel, BorderLayout.NORTH);
        BoardPanel.setLayout(new FlowLayout());
        //BoardPanel.setBackground(Color.PINK);
        frame.add(BoardPanel);
        JTextField field = new JTextField(10);
        frame.add(field, BorderLayout.SOUTH);
        frame.setVisible(true);
        
    }
}

