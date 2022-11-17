package agh.ics.oop;

import java.awt.*;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import javax.swing.Timer;
import javax.swing.*;
import javax.swing.border.Border;

import java.awt.Component;
import java.awt.Graphics2D;
import java.awt.Graphics;
import java.awt.RenderingHints;
import java.awt.geom.AffineTransform;
import javax.swing.Icon;

import static java.lang.Math.abs;


public class SimulationEngineFrame implements IEngine {

    Timer timer;
    boolean hasmoved = true;
    public MoveDirection[] directions;
    public AbstractWorldMap map;
    public Vector2d[] positions;
    private final LinkedList<Animal> animals = new LinkedList<>();

    private int jj = 0;
    private int x = 0;
    static JButton[][] button;
public Map<Vector2d, Grass> grass = new HashMap<>();

    public Map<Vector2d, Grass> removedGrass = new HashMap<>();

    private Icon[] colors;
    public boolean wasThisGrass[][];
    JFrame frame = new JFrame("");


    public SimulationEngineFrame(MoveDirection[] directions, AbstractWorldMap mapa, Vector2d[] pos) {
        this.directions = directions;
        this.map = mapa;
        this.positions = pos;


        colors = new Icon[positions.length];
        for (int c = 0; c < positions.length; c++) {
            colors[c] =  new RotatedIcon(Icons.RANDOM.getRandomAnimalIcon(), 0);
        }
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public IWorldMap getMap() {
        return this.map;
    }

    public JPanel buildMap(boolean refresh) {



        grass = map.getGrass();
        removedGrass = map.getRemovedGrass();

        Vector2d[] p = map.edges();
        Vector2d left = p[1];
        Vector2d right = p[0];
        Vector2d size = new Vector2d(abs(left.x)+right.x+1, abs(left.y)+right.y+1);

        int sizeOfRec = 40;
        Border emptyBorder = BorderFactory.createEmptyBorder();

        int numOfAnimals = positions.length;
//        b f f b b f f f f f f f f f f b l f f b b l b f f f r r r r l l l r f f f b b f f b l f b r f r f f f f r l f b l f f f b b l f r f f l l f r b f f f b r r f l l b f b l l b f b b f r f r l r b l r r b  f  f  b  b  f  f  f  f  f  f  f  f  f  f  b  l  f  f  b  b  l  b  f  f  f  r  r  r  r  l  l  l  r  f  f  f  b  b  f  f  b  l  f  b  r  f  r  f  f  f  f  r  l  f  b  l  f  f  f  b  b  l  f  r  f  f  l  l  f  r  b  f  f  f  b  r  r  f  l  l  b  f  b  l  l  b  f  b  b  f  r  f  r  l  r  b  l  r  r b f f b b f f f f f f f f f f b l f f b b l b f f f r r r r l l l r f f f b b f f b l f b r f r f f f f r l f b l f f f b b l f r f f l l f r b f f f b r r f l l b f b l l b f b b f r f r l r b l r r b  f  f  b  b  f  f  f  f  f  f  f  f  f  f  b  l  f  f  b  b  l  b  f  f  f  r  r  r  r  l  l  l  r  f  f  f  b  b  f  f  b  l  f  b  r  f  r  f  f  f  f  r  l  f  b  l  f  f  f  b  b  l  f  r  f  f  l  l  f  r  b  f  f  f  b  r  r  f  l  l  b  f  b  l  l  b  f  b  b  f  r  f  r  l  r  b  l  r  r
        JPanel okno = new JPanel(new GridLayout(size.y + 3, size.x + 3, 0, 0));
        button = new JButton[size.y + 4][size.x + 4];
        wasThisGrass = new boolean[size.y+4][size.x+4];



        okno.setMaximumSize(new Dimension(1080, 720));

        for (int i = 0; i <= size.y + 2; i++) {

            for (int j = 0; j <= size.x + 2; j++) {

                if (j == 0) {
                    button[i][j] = new JButton(String.valueOf(size.y + 1 - (i)+ left.y));
                    button[i][j].setPreferredSize(new Dimension(sizeOfRec, sizeOfRec));
                    button[i][j].setIcon(Icons.BORDER.getIcon());


                } else if (i == 0) {
                    button[i][j] = new JButton(String.valueOf(j - 2 + left.x));
                    button[i][j].setPreferredSize(new Dimension(sizeOfRec, sizeOfRec));
                    button[i][j].setIcon(Icons.BORDER.getIcon());



                } else {
                    button[i][j] = new JButton("");
                    button[i][j].setPreferredSize(new Dimension(sizeOfRec, sizeOfRec));
                    button[i][j].setIcon(Icons.COBBLE.getIcon());


                }
                if (i == 0 && j == 0) {
                    button[i][j] = new JButton("y\\x");
                    button[i][j].setPreferredSize(new Dimension(sizeOfRec, sizeOfRec));
                    button[i][j].setIcon(Icons.BORDER.getIcon());


                }
                button[i][j].setBorder(emptyBorder);
                button[i][j].setRolloverEnabled(false);
                button[i][j].setVerticalTextPosition(SwingConstants.CENTER);
                button[i][j].setHorizontalTextPosition(SwingConstants.CENTER);
                button[i][j].setForeground(Color.white);

                wasThisGrass[i][j]=false;
                okno.add(button[i][j]);
            }
        }
        if (refresh){
            for (Grass d : removedGrass.values()) {
                Vector2d positiond = d.getPosition();
                wasThisGrass[size.y - positiond.y + 1 + left.y][positiond.x + 2- left.x]=true;
                button[size.y - positiond.y + 1 + left.y][positiond.x + 2- left.x].setIcon(Icons.DIRT.getIcon());
            }
            for (IMapElement iMapElement : grass.values()) {
                wasThisGrass[size.y - iMapElement.getPosition().y + 1 + left.y][iMapElement.getPosition().x + 2 - left.x] = true;
                button[size.y - iMapElement.getPosition().y + 1 + left.y][iMapElement.getPosition().x + 2 - left.x].setIcon(Icons.GRASS.getIcon());
            }
            int iterato = 0;
            for (Animal d : animals) {
                Vector2d positiond = d.getPosition();
                button[size.y - positiond.y + 1 + left.y][positiond.x + 2- left.x].setIcon(null);
                button[size.y - positiond.y + 1 + left.y][positiond.x + 2- left.x].setIcon(colors[iterato]);
                iterato++;
            }

        }
       else {
            for (int i = 0; i < numOfAnimals; i++) {
                Animal man = new Animal(map, positions[i]);

                animals.add(man);
                button[size.y - positions[i].y + 1+ left.y][positions[i].x + 2- left.x].setIcon(colors[i]);
            }
        }
        return okno;

    }


    @Override
    public void run() {
        AtomicReference<JPanel> okno = new AtomicReference<>(buildMap(false));

        ActionListener a = e -> {
            if(hasmoved){
                okno.set(buildMap(true));

                hasmoved = false;
            }

            Vector2d[] p = map.edges();
            Vector2d left = p[1];
            Vector2d right = p[0];
            Vector2d size = new Vector2d(abs(left.x)+right.x+1, abs(left.y)+right.y+1);


            frame.setContentPane(okno.get());
            frame.pack();

            MoveDirection o = directions[x];
            if (jj == positions.length) {

                jj = 0;
            }

            Animal man = animals.get(jj);
            Vector2d state = man.getPosition();
            hasmoved=map.moveAnimal(man, o);

            Vector2d state2 = man.getPosition();

         if (wasThisGrass[size.y - state.y + 1+ left.y][state.x + 2- left.x]==true){
             button[size.y - state.y + 1+ left.y][state.x + 2- left.x].setIcon(Icons.DIRT.getIcon());
         }
         else {
             button[size.y - state.y + 1+ left.y][state.x + 2- left.x].setIcon(Icons.COBBLE.getIcon());
         }
            button[size.y - state.y + 1+ left.y][state.x + 2- left.x].setText("");
            button[size.y - state2.y + 1+ left.y][state2.x + 2- left.x].setIcon(null);
            switch (o){
                case LEFT -> colors[jj] = new RotatedIcon(colors[jj],-90.0);
                case RIGHT -> colors[jj] = new RotatedIcon(colors[jj],90.0);
            }
            button[size.y - state2.y + 1+ left.y][state2.x + 2- left.x].setIcon(colors[jj]);
            okno.get().setVisible(true);
            jj++;
            x++;
            if (x == directions.length - 1) {
                timer.stop();
//                System.exit(0);
            }
        };
        timer = new Timer(100, a);
        timer.start();

    }


}

