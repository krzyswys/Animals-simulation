package agh.ics.oop;
import java.awt.*;
import javax.swing.*;

import static java.lang.Math.abs;

public enum Icons {
    COBBLE,DIRT, BORDER, GRASS;

    public ImageIcon getIcon() {

        switch(this) {
            case COBBLE:
            {
                ImageIcon cobbleIco = new ImageIcon(this.getClass().getResource("/cobble.png"));
                Image imagec = cobbleIco.getImage();
                Image newimgc = imagec.getScaledInstance(40, 40,  java.awt.Image.SCALE_SMOOTH);
                return new ImageIcon(newimgc);
            }
            case DIRT:{
                ImageIcon dirtIco = new ImageIcon(this.getClass().getResource("/dirt.jpg"));
                Image image = dirtIco.getImage();
                Image newimg = image.getScaledInstance(40, 40,  java.awt.Image.SCALE_SMOOTH);
                return new ImageIcon(newimg);
            }
            case BORDER:{
                ImageIcon borderIco = new ImageIcon(this.getClass().getResource("/border.png"));
                Image image2 = borderIco.getImage();
                Image newimg2 = image2.getScaledInstance(40, 40,  java.awt.Image.SCALE_SMOOTH);
                return new ImageIcon(newimg2);
            }
            case GRASS:{
                ImageIcon grassIco = new ImageIcon(this.getClass().getResource("/grass.jpg"));
                Image image = grassIco.getImage();
                Image newimg = image.getScaledInstance(40, 40,  java.awt.Image.SCALE_SMOOTH);
               return new ImageIcon(newimg);
            }



            default:
                return null;
        }
    }

}
