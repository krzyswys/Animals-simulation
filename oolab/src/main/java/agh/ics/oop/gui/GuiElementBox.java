package agh.ics.oop.gui;

import agh.ics.oop.IMapElement;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import java.io.FileInputStream;
import java.io.FileNotFoundException;


public class GuiElementBox {
    private final VBox box = new VBox();

    public GuiElementBox(int imageSize, IMapElement element, Image image){

        ImageView view = new ImageView(image);
        view.setFitWidth(imageSize);
        view.setFitHeight(imageSize);

        Label label1 = new Label(element.toString());
        label1.setTextFill(Color.color(25, 25, 25));
        Label label2 = new Label(element.getPosition().toString());
        label2.setTextFill(Color.color(25, 25, 25));

        this.box.getChildren().addAll(view, label1, label2);
        this.box.setAlignment(Pos.CENTER);

    }

    public VBox getBox(){
        return this.box;
    }
}