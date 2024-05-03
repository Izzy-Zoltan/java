import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.*;

// import Minesweeper.Minesweeper.MineTile;

public class Hangman {
    private class MineTile extends JButton {
        int r;
        int c;

        public MineTile(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
    int tilesize = 64;
    int rows = 1;
    int collumns = 8;
    int boardDimension = 8*tilesize;

    JFrame frame = new JFrame("Minesweeper"); //creates a new window
    JLabel textLabel = new JLabel();
    JPanel textPanel = new JPanel();
    JPanel BoardPanel = new JPanel();

    MineTile[][] board = new MineTile[rows][collumns];
    ArrayList<MineTile> mineList;
    Hangman(){
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
        for(int r=0; r < rows; r++){
            for(int c=0; c < collumns; c++) {
                MineTile tile = new MineTile(r, c);
                board[r][c] = tile;

                tile.setFocusable(false);
                tile.setMargin(new Insets(0, 0, 0, 0));
                tile.setFont(new Font("Comic Sans Unicode MS", Font.PLAIN, 45));
                tile.addMouseListener((new MouseAdapter() {
                    @Override
                    public void mousePressed(MouseEvent e){
                        MineTile tile = (MineTile) e.getSource();

                        if (e.getButton() == MouseEvent.BUTTON1){
                            if (tile.getText() == "") {
                                //if(mineList.contains(tile)){
                                    //revealMines();+
                               // }
                            }
                        }
                    }
                }));
                tile.setPreferredSize(new Dimension(32,32));
                BoardPanel.add(tile);
            }
        }
        frame.setVisible(true);

        setMines();
    }

    void setMines() {
        mineList = new ArrayList<MineTile>();
    }
}

