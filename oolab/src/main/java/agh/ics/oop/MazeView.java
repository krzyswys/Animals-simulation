//package agh.ics.oop;
//
//import javax.swing.*;
//import java.awt.*;
//
//class MazeView extends JPanel{
//
//    private Cell grid[][];
//    private Cell cell;
//
//    private int row;
//    private int col;
//
//    private int width = 600;
//    private int height = 580;
//
//    // Create a maze view JPanel that is rows tall and cols wide
//    MazeView(int rows, int cols){
//        super.setBackground(Color.BLACK);
//        super.setLayout(new GridLayout(rows, cols));
//
//        newGrid(rows, cols);
//    }
//    boolean[] walls = {true, true, true, true};
//
//    // Draw the lines of one cell with w width and h height
//    void drawCell(Graphics g, int w, int h){
//
//        // Set the color of the lines to white
//        g.setColor(Color.WHITE);
//
//        // If the top wall exists draw a top line
//        if (walls[0]) {
//            g.drawLine(TopLeftX(), TopLeftY(), TopRightX(w), TopRightY());
//        }
//        // If a right wall exists draw a right line
//        if (walls[1]) {
//            g.drawLine(TopRightX(w), TopRightY(), BotRightX(w), BotRightY(h));
//        }
//        // If a bottom wall exists draw a bottom line
//        if (walls[2]) {
//            g.drawLine(BotRightX(w), BotRightY(h), BotLeftX(), BotLeftY(h));
//        }
//        // If a left wall exists draw a left line
//        if (walls[3]) {
//            g.drawLine(BotLeftX(), BotLeftY(h), TopLeftX(), TopLeftY());
//        }
//    }
//
//    // Set each coordinate for the lines, these will make a square that
//// is w wide and h high
//    private int TopLeftX()      { return i;      }
//    private int TopLeftY()      { return j;      }
//    private int TopRightX(int w){ return i * w;  }
//    private int TopRightY()     { return j;      }
//    private int BotRightX(int w){ return i * w;  }
//    private int BotRightY(int h){ return j * h;  }
//    private int BotLeftX()      { return i;      }
//    private int BotLeftY(int h) { return j * h;  }
//
//    // Paint all the cells
//    public void paintComponent(Graphics g){
//        super.paintComponent(g);
//
//        // Get the height and width of each cell
//        int h = height / 10;
//        int w = width / 5;
//
//        // Loop to draw each cell
//        for (int i = 0; i <= 10; i++){
//            for (int j = 0; j <= 5; j++){
//
//                grid[i][j].drawCell(g, w, h);
//            }
//        }
//    }
//}