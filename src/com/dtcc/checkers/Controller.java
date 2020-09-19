package com.dtcc.checkers;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class Controller extends JFrame {

    private Action drawAction;
    private final int drawDelay = 30; //Music

    private View view;
    private Model model;

    public Controller() {

        model = new Model();
        view = new View(model.getBoard());

        drawAction = new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                char pressedKey = view.getPressedKey();
                if(view.isMoveSelected()){
                    String[][] board = model.update(view.getMove());
                    view.update(board);
                }
                else if(pressedKey == 's'){
                    String temp_board[][] = model.getBoard();
                    Model.save(temp_board);
                }
                else if(pressedKey == 'l'){
                    view.update(model.load());
                }
            }
        };

        add(view);

        setUndecorated(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000,1000);//400 width and 500 height
        setLayout(new GridLayout());
        setVisible(true);//making the frame visible

    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable(){
            public void run(){
                Controller a = new Controller();
                Timer t = new Timer(a.drawDelay, a.drawAction);
                t.start();

            }//run
        });//runnable
    }


}
