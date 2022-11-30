package agh.ics.oop.gui;

import agh.ics.oop.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.geometry.HPos;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import static java.lang.Math.abs;

public class App extends Application {

    private final AbstractWorldMap map = new GrassField(10);
    public Vector2d[] positions;
    private int cellSize = 50;
    private static final double borderWidth = 0;
    private int fontSize = cellSize / 3;
    private  Animal[] animals;
    public IMapElement[] grass;
    private final OptionsParser commandParser = new OptionsParser();
    public int span = 1;
    private  ImageView[] colors;
    private  Animal[] a;
    Vector2d left;
    Vector2d right;
    Vector2d size;

    @Override
    public void init() {
        try {
//        b l f f b b f f r f f f f l f f f f r b l f f b b l b f f f r r r r l l l r f f f b b f f b l f b r f r f f f f r l f b l f f f b b l f r f f l l f r b f f f b r r f l l b f b l l b f b b f r f r l r b l r r b f f b b f f f f f f f f f f b l f f b b l b f f f r r r r l l l r f f f b b f f b l f b r f r f f f f r l f b l f f f b b l f r f f l l f r b f f f b r r f l l b f b l l b f b b f r f r l r b l r r b f f b b f f f f f f f f f f b l f f b b l b f f f r r r r l l l r f f f b b f f b l f b r f r f f f f r l f b l f f f b b l f r f f l l f r b f f f b r r f l l b f b l l b f b b f r f r l r b l r r b f f b b f f f f f f f f f f b l f f b b l b f f f r r r r l l l r f f f b b f f b l f b r f r f f f f r l f b l f f f b b l f r f f l l f r b f f f b r r f l l b f b l l b f b b f r f r l r b l r r
            String[] x = (getParameters().getRaw()).toArray(new String[0]);
            MoveDirection[] directions = commandParser.parse(x);

            AbstractWorldMap map = new GrassField(10);
            this.positions = new Vector2d[]{new Vector2d(2, 2), new Vector2d(3, 4)};
            IEngine engine = new SimulationEngine(directions, map, positions);
            engine.run();
            animals= map.getAnimals();
            left = map.getLeftEdge();
            right = map.getRightEgde();
            size = new Vector2d(abs(left.x) + right.x + 1, abs(left.y) + right.y + 1);

            System.out.println(animals.length);

        } catch (IllegalArgumentException e) {
            System.out.println(e + "abc");
        }


    }

    @Override
    public void start(Stage primaryStage) {
        int rows;
        int cols;
        colors = new ImageView[positions.length];
        for (int c = 0; c < positions.length; c++) {
            Image img = Icons.RANDOM.getRandomAnimalIcon();
            ImageView view = new ImageView(img);
            view.setFitHeight(cellSize);
            view.setPreserveRatio(true);
            colors[c] =  view;
        }
        map.addGrass(map.bound(0));
        grass = map.getGrass();



        rows = (size.y) + 1;
        cols = (size.x) + 1;

        GridPane grid = new GridPane();
        grid.setStyle("-fx-background-color: white");
        grid.setGridLinesVisible(true);

        for (int i = 0; i < cols; i++) {
            grid.getColumnConstraints().add(new ColumnConstraints(cellSize));
        }
        for (int i = 0; i < rows; i++) {
            grid.getRowConstraints().add(new RowConstraints(cellSize));
        }

        generateMap(grid, rows,  cols);

        Scene scene = new Scene(grid, cols * cellSize, rows * cellSize);
        primaryStage.setScene(scene);
        primaryStage.show();
//        ActionListener a = e -> {
//            int j = 0;
//            for (MoveDirection o : directions) {
//                if (j == positions.length) {
//                    j = 0;
//                }
//                Animal man = animals.get(j);
//                map.moveAnimal(man,o);
//
////                grid.getChildren().clear();
//
//                generateMap(grid, rows, left, cols, size);
//                j++;
//            }
//
//        };
//        timer = new Timer(100, a);
//        timer.start();
    }

    private void generateMap(GridPane grid, int rows,  int cols) {



        for (int i = 0; i < 1; i++) {
            Label header = new Label("");
            Image imgt = new Image("border.png");
            ImageView viewt = new ImageView(imgt);
            viewt.setFitHeight(cellSize);
            viewt.setPreserveRatio(true);
            header.setGraphic(viewt);
            grid.add(header, 0, 0, span, span);
            Label headerr = new Label("y\\x");
            headerr.setFont(new Font(fontSize));
            headerr.setTextFill(Color.web("white"));
            GridPane.setHalignment(headerr, HPos.CENTER);
            grid.add(headerr, 0, 0, span, span);
        }

        for (int i = 0; i < cols - 1; i++) {
            Label header = new Label("");
            Image imgt = new Image("border.png");
            ImageView viewt = new ImageView(imgt);
            viewt.setFitHeight(cellSize);
            viewt.setPreserveRatio(true);
            header.setGraphic(viewt);
            grid.add(header, i+1, 0, span, span);

            Label field = new Label(String.valueOf(left.x + i));
            field.setFont(new Font(fontSize));
            field.setTextFill(Color.web("white"));
            GridPane.setHalignment(field, HPos.CENTER);
            grid.add(field, i + 1, 0, span, span);
        }

        for (int i = 0; i < rows - 1; i++) {
            Label header = new Label("");
            Image imgt = new Image("border.png");
            ImageView viewt = new ImageView(imgt);
            viewt.setFitHeight(cellSize);
            viewt.setPreserveRatio(true);
            header.setGraphic(viewt);
            grid.add(header, 0, i+1, span, span);

            Label field = new Label(String.valueOf(rows + left.y - 2 - i));
            field.setFont(new Font(fontSize));
            field.setTextFill(Color.web("white"));
            GridPane.setHalignment(field, HPos.CENTER);
            grid.add(field, 0, i + 1, span, span);

        }
        for (int i = 0; i < rows - 1; i++) {
            for (int j = 0; j < cols - 1; j++) {
                Label field = new Label("");
                Image img = new Image("cobble.png");
                ImageView view = new ImageView(img);
                view.setFitHeight(cellSize);
                view.setPreserveRatio(true);
                field.setGraphic(view);
                grid.add(field, j + 1, i + 1, span, span);
            }
        }

        for (IMapElement iMapElement : grass) {
            Label field = new Label("");

            Image img = new Image("grass.jpg");
            ImageView view = new ImageView(img);
            view.setFitHeight(cellSize);
            view.setPreserveRatio(true);
            field.setGraphic(view);

            grid.add(field, iMapElement.getPosition().x + left.x + 1, size.y - iMapElement.getPosition().y + left.y, span, span);
        }
        int iter=0;
        for (Animal d : animals) {
            Label field = new Label("");
            field.setGraphic(colors[iter]);
            iter++;
            grid.add(field,  d.getPosition().x - left.x + 1,  size.y - d.getPosition().y + left.y, span, span);
        }
    }
}
