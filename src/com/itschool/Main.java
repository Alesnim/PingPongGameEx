package com.itschool;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Main {

    public static void main(String[] args) {
        JFrame win = new JFrame();
        win.setSize(Commons.WIDTH, Commons.HEIGTH);
        win.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        win.setResizable(false);
        win.setVisible(true);

        win.add(new MyPanel());

    }
}

class MyPanel extends JPanel {
    int x = 50;
    int y = 60;

    int dx =1;
    int dy = 1;

    static final int xPl = 30;
    int yPl = 50;

    Timer timerFrame;


    public MyPanel(){
        this.setFocusable(true);
        timerFrame = new Timer(10, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                repaint();
            }
        });
        timerFrame.start();

        addKeyListener(new MyListener());
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D graphics2D = (Graphics2D) g;
        moveShar(x, y);
        x+= dx;
        y+=dy;


        graphics2D.fillOval(x, y, 30,30);
        graphics2D.fillRect(xPl, yPl, 20,40);
    }


    private void moveShar(int x, int y ){
        if (x == 400-60) {
            dx = -1;
        }

        if (x == 0){
            dx =1;
        }

        if (y == 400-60){
            dy = -1;
        }

        if (y == 0){
            dy =1;
        }

    }

    private class MyListener implements KeyListener {

        @Override
        public void keyTyped(KeyEvent e) {

        }

        @Override
        public void keyPressed(KeyEvent e) {
            int keyCode = e.getKeyCode();
            if (keyCode == KeyEvent.VK_DOWN){
                if (yPl+40 != Commons.HEIGTH-40) {
                    yPl += 10;
                }

            }
            if (keyCode == KeyEvent.VK_UP){
                if (yPl != 0){
                    yPl -= 10;
                }

            }

        }

        @Override
        public void keyReleased(KeyEvent e) {

        }
    }
}
