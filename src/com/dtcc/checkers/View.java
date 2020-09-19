package com.dtcc.checkers;

        import javax.swing.*;
        import java.awt.*;
        import java.awt.event.KeyEvent;
        import java.awt.event.KeyListener;
        import java.awt.event.MouseAdapter;
        import java.awt.event.MouseEvent;

public class View extends JPanel {

    private String[][] board;
    private Point start;
    private Point end;
    private char pressedKey;
    private int keyCount = 0;

    public View(String[][] board){

        this.board = board;

        addMouseListener(new MouseAdapter() {
            // notify controller & model a mouse click has occurred & send click coordinates
            @Override
            public void mousePressed(MouseEvent me) {

                if(isInBounds(me.getPoint())){

                    if(start == null){
                        start = me.getPoint();
                    }
                    else{
                        end = me.getPoint();
                    }
                }

            }
        });

        KeyboardFocusManager.getCurrentKeyboardFocusManager()
                .addKeyEventDispatcher(new KeyEventDispatcher() {
                    @Override
                    public boolean dispatchKeyEvent(KeyEvent e) {
                        if(keyCount == 1) {
                            pressedKey = e.getKeyChar();

                        }
                        keyCount++;
                        keyCount %= 3;
                        return false;
                    }
                });

    }

    private boolean isInBounds(Point p){
        return p.x >= 100 && p.x <= 900 && p.y >= 100 && p.y <= 900;
    }

    public boolean isMoveSelected(){
        return start != null && end != null;
    }

    public Move getMove(){

        Move move = new Move();

        move.startX = (start.x-100)/100;
        move.startY = (start.y-100)/100;
        move.endX = (end.x-100)/100;
        move.endY = (end.y-100)/100;

        return move;

    }

    public char getPressedKey(){

        char heisenbergChar = this.pressedKey;
        this.pressedKey = '-';

        return heisenbergChar;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); //ALWAYS call this method first!

        for(int i = 1; i < 9; i++){
            for(int j = 1; j < 9; j++){

                if(i%2 == j%2){
                    g.setColor(Color.decode("#FFFFFF"));
                }

                else{
                    g.setColor(Color.decode("#a52a2a"));

                }

                g.fillRect(i*100, j*100, 100, 100);
            }
        }

        if(board != null) {
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {

                    if(!board[j][i].equals("EMPTY")) {

                        if (board[j][i].charAt(0) == 'R') {
                            g.setColor(Color.RED);
                        }

                        else if (board[j][i].charAt(0) == 'B') {
                            g.setColor(Color.BLACK);
                        }

                        g.fillOval(100*(i+1) + 10, 100*(j+1) + 10, 80, 80);

                        if (board[j][i].charAt(2) == 'K') {
                            g.setColor(Color.YELLOW);
                            g.fillRect(100*(i+1) + 25, 100*(j+1) + 45, 50, 20);
                            g.fillRect(100*(i+1) + 25, 100*(j+1) + 35, 10, 10);
                            g.fillRect(100*(i+1) + 45, 100*(j+1) + 35, 10, 10);
                            g.fillRect(100*(i+1) + 65, 100*(j+1) + 35, 10, 10);
                        }
                    }
                }
            }
        }

    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(300, 300);
    }

    public void update(String[][] board) {

        this.board = board;
        this.start = null;
        this.end = null;

        repaint();

    }
}