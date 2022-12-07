package agh.ics.oop.gui;

import agh.ics.oop.*;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.geometry.HPos;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.LinkedList;

import static java.lang.Math.abs;

public class App extends Application implements IPositionChangeObserver{

    private final AbstractWorldMap map = new GrassField(10);
    public Vector2d[] positions;
    private int cellSize = 50;
    private static final double borderWidth = 0;
    private int fontSize = cellSize / 3;
    private LinkedList<Animal> animals;
    public IMapElement[] grass;
    private final OptionsParser commandParser = new OptionsParser();
    public int span = 1;
    private  ImageView[] colors;
    private  Animal[] a;
    GridPane grid = new GridPane();
    SimulationEngine engine;
    Vector2d left;
    Vector2d right;
    Vector2d size;


    int rows;
    int cols;
    String[] x;


    @Override
    public void init() {
        try {
//        b l f f b b f f r f f f f l f f f f r b l f f b b l b f f f r r r r l l l r f f f b b f f b l f b r f r f f f f r l f b l f f f b b l f r f f l l f r b f f f b r r f l l b f b l l b f b b f r f r l r b l r r b f f b b f f f f f f f f f f b l f f b b l b f f f r r r r l l l r f f f b b f f b l f b r f r f f f f r l f b l f f f b b l f r f f l l f r b f f f b r r f l l b f b l l b f b b f r f r l r b l r r b f f b b f f f f f f f f f f b l f f b b l b f f f r r r r l l l r f f f b b f f b l f b r f r f f f f r l f b l f f f b b l f r f f l l f r b f f f b r r f l l b f b l l b f b b f r f r l r b l r r b f f b b f f f f f f f f f f b l f f b b l b f f f r r r r l l l r f f f b b f f b l f b r f r f f f f r l f b l f f f b b l f r f f l l f r b f f f b r r f l l b f b l l b f b b f r f r l r b l r r
             x = (getParameters().getRaw()).toArray(new String[0]);
            MoveDirection[] directions = commandParser.parse(x);

            AbstractWorldMap map = new GrassField(10);
            this.positions = new Vector2d[]{new Vector2d(2, 2), new Vector2d(3, 4)};
            this.engine = new SimulationEngine(directions, map, positions);
            this.engine.run();
            grass = engine.getGrass();
            animals= engine.getAnimals();
            for(Animal a : animals){
                a.addObserver(this);
            }


        } catch (IllegalArgumentException e) {
            System.out.println(e + "abc");
        }


    }
    public void updateData(){
        grass= this.engine.getGrass();
        animals= engine.getAnimals();
        left = engine.getE()[1];
        right = engine.getE()[0];
        size = new Vector2d(abs(left.x) + abs(right.x) + 1, abs(left.y) + abs(right.y
        )+ 1);
        rows = (size.y) +2;
        cols = (size.x) +2;
    }
    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition){
        Platform.runLater(() -> {

            while(this.grid.getRowConstraints().size() > 0){
                this.grid.getRowConstraints().remove(0);
            }

            while(this.grid.getColumnConstraints().size() > 0){
                this.grid.getColumnConstraints().remove(0);
            }

            Node node = this.grid.getChildren().get(0);
            this.grid.getChildren().clear();
            this.grid.getChildren().add(0,node);
            generateMap();
        });
    }
    public VBox setupConst(){
        updateData();
        this.colors = new ImageView[positions.length];
        for (int c = 0; c < positions.length; c++) {
            Image img = Icons.RANDOM.getRandomAnimalIcon();
            ImageView view = new ImageView(img);
            view.setFitHeight(cellSize);
            view.setPreserveRatio(true);
            colors[c] =  view;
        }
        this.grid.setGridLinesVisible(true);

        this.grid.setMaxHeight(0); grid.setMaxWidth(0);
        TextField movesInput = new TextField();
        movesInput.setPrefWidth(Math.floor(600));
        movesInput.setPromptText("");
        Button startButton = new Button("START");
        startButton.setOnAction(action -> {
            String[] args = movesInput.getText().split(" ");
            this.engine.applyMoves(OptionsParser.parse(args));
            Thread engineThread = new Thread(this.engine);
            engineThread.start();
        });
        HBox hBox = new HBox();
        hBox.getChildren().addAll(movesInput, startButton);
        hBox.setAlignment(Pos.CENTER);
        hBox.setStyle("-fx-font-size: 20px");
        VBox vBox = new VBox();
        vBox.getChildren().addAll(this.grid, hBox);
        vBox.setAlignment(Pos.CENTER);
        vBox.setStyle("-fx-background-color: #56565e;");
        VBox.setMargin(hBox, new Insets(50, 0, 50, 0));
        this.grid.setStyle("-fx-background-color: white");
        this.grid.setGridLinesVisible(true);
        return vBox;
    }
    @Override
    public void start(Stage primaryStage) {
        VBox vBox = setupConst();
        generateMap();
        Scene scene = new Scene(vBox, cols * cellSize, rows * cellSize);
        primaryStage.setScene(scene);
        primaryStage.setTitle("World");
        primaryStage.show();
    }

    public void addConstaints(){
        for (int i = 0; i < cols-1; i++) {
            this.grid.getColumnConstraints().add(new ColumnConstraints(cellSize));
        }
        for (int i = 0; i < rows-1; i++) {
            this.grid.getRowConstraints().add(new RowConstraints(cellSize));
        }
    }

    public void populateBackground(){
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
            this.grid.add(header, i+1, 0, span, span);

            Label field = new Label(String.valueOf(left.x + i));
            field.setFont(new Font(fontSize));
            field.setTextFill(Color.web("white"));
            GridPane.setHalignment(field, HPos.CENTER);
            this.grid.add(field, i + 1, 0, span, span);
        }

        for (int i = 0; i < rows - 1; i++) {
            Label header = new Label("");
            Image imgt = new Image("border.png");
            ImageView viewt = new ImageView(imgt);
            viewt.setFitHeight(cellSize);
            viewt.setPreserveRatio(true);
            header.setGraphic(viewt);
            this.grid.add(header, 0, i+1, span, span);

            Label field = new Label(String.valueOf(rows + left.y - 2 - i));
            field.setFont(new Font(fontSize));
            field.setTextFill(Color.web("white"));
            GridPane.setHalignment(field, HPos.CENTER);
            this.grid.add(field, 0, i + 1, span, span);

        }
        for (int i = 0; i < rows - 1; i++) {
            for (int j = 0; j < cols - 1; j++) {
                Label field = new Label("");
                Image img = new Image("cobble.png");
                ImageView view = new ImageView(img);
                view.setFitHeight(cellSize);
                view.setPreserveRatio(true);
                field.setGraphic(view);
                this.grid.add(field, j + 1, i + 1, span, span);
            }
        }
    }
    public void populateWorld(){
//        VBox box = new GuiElementBox(3*(cellSize/4), iMapElement,img).getBox();
        for (IMapElement iMapElement : grass) {
            Label field = new Label("");

            Image img = new Image("grass.jpg");
            ImageView view = new ImageView(img);
            view.setFitHeight(cellSize);
            view.setPreserveRatio(true);
            field.setGraphic(view);

            this.grid.add(field, iMapElement.getPosition().x + left.x + 1, size.y - iMapElement.getPosition().y + left.y, span, span);
        }
        int iter=0;
        for (Animal d : animals) {
            System.out.println(d.getPosition());
            MapDirection head = d.getOrientation();
            switch (head){
                case EAST -> colors[iter].setRotate(90);
                case WEST -> colors[iter].setRotate(270);
                case NORTH -> colors[iter].setRotate(0);
                case SOUTH -> colors[iter].setRotate(180);
            }
            Label field = new Label("");
            field.setGraphic(colors[iter]);
            iter++;
            this.grid.add(field,  d.getPosition().x - left.x + 1,  size.y - d.getPosition().y + left.y, span, span);
        }
    }
    private void generateMap() {
        updateData();
        addConstaints();
        populateBackground();
        populateWorld();
    }
}