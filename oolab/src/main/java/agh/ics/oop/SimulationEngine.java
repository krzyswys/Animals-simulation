package agh.ics.oop;

import java.awt.*;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import javax.swing.Timer;
import javax.swing.*;
import javax.swing.border.Border;


public class SimulationEngine implements IEngine {

    Timer timer;

    public MoveDirection[] directions;
    public IWorldMap map;
    public Vector2d[] positions;
    private final LinkedList<Animal> animals = new LinkedList<>();

    private int jj = 0;
    private int x = 0;
    static JButton[][] button;
    private Color[] colors;

    public SimulationEngine(MoveDirection[] directions, IWorldMap mapa, Vector2d[] pos) {
        this.directions = directions;
        this.map = mapa;
        this.positions = pos;
        button = new JButton[mapa.getRightEgde().y + 2][mapa.getRightEgde().x + 2];
        colors = new Color[positions.length];

    }

    public IWorldMap getMap() {
        return this.map;
    }

    @Override
    public void runFrame() {


        Vector2d size = map.getRightEgde();
        JFrame frame = new JFrame("teee");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel okno = new JPanel(new GridLayout(size.y + 2, size.x + 2, 1, 1));
        okno.setMaximumSize(new Dimension(1080, 720));
        frame.setVisible(true);

        int sizeOfRec = 40;
        Border emptyBorder = BorderFactory.createEmptyBorder();


        for (int i = 0; i <= size.y + 1; i++) {

            for (int j = 0; j <= size.x + 1; j++) {

                if (j == 0) {
                    button[i][j] = new JButton(String.valueOf(size.y + 1 - (i)));
                    button[i][j].setPreferredSize(new Dimension(sizeOfRec, sizeOfRec));
                    button[i][j].setBackground(Color.gray);
                    button[i][j].setForeground(Color.white);

                } else if (i == 0) {
                    button[i][j] = new JButton(String.valueOf(j - 1));
                    button[i][j].setPreferredSize(new Dimension(sizeOfRec, sizeOfRec));
                    button[i][j].setBackground(Color.gray);
                    button[i][j].setForeground(Color.white);


                } else {
                    button[i][j] = new JButton("");
                    button[i][j].setPreferredSize(new Dimension(sizeOfRec, sizeOfRec));
                    button[i][j].setBackground(Color.white);


                }
                if (i == 0 && j == 0) {
                    button[i][j] = new JButton("y\\x");
                    button[i][j].setPreferredSize(new Dimension(sizeOfRec, sizeOfRec));
                    button[i][j].setBackground(Color.gray);
                    button[i][j].setForeground(Color.white);

                }
                button[i][j].setBorder(emptyBorder);
                button[i][j].setRolloverEnabled(false);
                okno.add(button[i][j]);
            }
        }


        int numOfAnimals = positions.length;
        for (int c = 0; c < positions.length; c++) {

            int a = (int) Math.floor(Math.random() * (256 - 110 + 1) + 110);
            int b = (int) Math.floor(Math.random() * (256 + 1) + 0);
            int cc = (int) Math.floor(Math.random() * (256 + 1) + 0);
            Color col = new Color(a, b, cc);
            colors[c] = col;
        }
        for (int i = 0; i < numOfAnimals; i++) {
            Animal man = new Animal(map, positions[i]);

            animals.add(man);
            button[size.y - positions[i].y + 1][positions[i].x + 1].setBackground(colors[i]);
            button[size.y - positions[i].y + 1][positions[i].x + 1].setText(man.toString());
        }

        frame.setContentPane(okno);
        frame.pack();




        ActionListener a = e -> {
            MoveDirection o = directions[x];
            if (jj == numOfAnimals) {
                jj = 0;
            }
            Animal man = animals.get(jj);
            Vector2d state = man.getPosition();
            man.move(o);
            Vector2d state2 = man.getPosition();

            button[size.y - state.y + 1][state.x + 1].setBackground(Color.white);
            button[size.y - state.y + 1][state.x + 1].setText("");
            button[size.y - state2.y + 1][state2.x + 1].setBackground(colors[jj]);
            button[size.y - state2.y + 1][state2.x + 1].setText(man.toString());


            jj++;
            x++;

            if (x == directions.length - 1) {
                timer.stop();
//                System.exit(0);
            }
        };
        timer = new Timer(300, a);
        timer.start();



    }
    public void run() {
        int numOfAnimals = positions.length;
        for (int i = 0; i < numOfAnimals; i++) {
            Animal man = new Animal(map, positions[i]);
            animals.add(man);

        }
        System.out.println(map.toString());

        int j = 0;
        for (MoveDirection o : directions) {
            if (j == numOfAnimals) {
                j = 0;
            }
            Animal man = animals.get(j);
            man.move(o);
            System.out.println(map.toString());
            j++;
        }
    }

}

