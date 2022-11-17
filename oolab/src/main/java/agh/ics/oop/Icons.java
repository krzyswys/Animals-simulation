package agh.ics.oop;

import java.awt.*;
import javax.swing.*;

import static java.lang.Math.abs;

public enum Icons {
    COBBLE, DIRT, BORDER, GRASS, RANDOM, BEE,CAT,CHICKEN,COW_MUSHROOM, FISH,OCELOT,PIG,SHEEP,SKELETON,SPIDER,WOLF;
    int sizeOfPic = 40;
    public ImageIcon getIcon() {

        switch (this) {
            case COBBLE: {
                ImageIcon cobbleIco = new ImageIcon(this.getClass().getResource("/cobble.png"));
                Image imagec = cobbleIco.getImage();
                Image newimgc = imagec.getScaledInstance(sizeOfPic, sizeOfPic, java.awt.Image.SCALE_SMOOTH);
                return new ImageIcon(newimgc);
            }
            case DIRT: {
                ImageIcon dirtIco = new ImageIcon(this.getClass().getResource("/dirt.jpg"));
                Image image = dirtIco.getImage();
                Image newimg = image.getScaledInstance(sizeOfPic, sizeOfPic, java.awt.Image.SCALE_SMOOTH);
                return new ImageIcon(newimg);
            }
            case BORDER: {
                ImageIcon borderIco = new ImageIcon(this.getClass().getResource("/border.png"));
                Image image2 = borderIco.getImage();
                Image newimg2 = image2.getScaledInstance(sizeOfPic, sizeOfPic, java.awt.Image.SCALE_SMOOTH);
                return new ImageIcon(newimg2);
            }
            case GRASS: {
                ImageIcon grassIco = new ImageIcon(this.getClass().getResource("/grass.jpg"));
                Image image = grassIco.getImage();
                Image newimg = image.getScaledInstance(sizeOfPic, sizeOfPic, java.awt.Image.SCALE_SMOOTH);
                return new ImageIcon(newimg);
            }
            default:
                return null;
        }
    }
    public ImageIcon getAnimal() {

        switch (this) {
            case BEE: {
                ImageIcon cobbleIco = new ImageIcon(this.getClass().getResource("/bee.png"));
                Image imagec = cobbleIco.getImage();
                Image newimgc = imagec.getScaledInstance(sizeOfPic, sizeOfPic, java.awt.Image.SCALE_SMOOTH);
                return new ImageIcon(newimgc);
            }
            case CAT: {
                ImageIcon dirtIco = new ImageIcon(this.getClass().getResource("/cat.png"));
                Image image = dirtIco.getImage();
                Image newimg = image.getScaledInstance(sizeOfPic, sizeOfPic, java.awt.Image.SCALE_SMOOTH);
                return new ImageIcon(newimg);
            }
            case CHICKEN: {
                ImageIcon borderIco = new ImageIcon(this.getClass().getResource("/chicken.png"));
                Image image2 = borderIco.getImage();
                Image newimg2 = image2.getScaledInstance(sizeOfPic, sizeOfPic, java.awt.Image.SCALE_SMOOTH);
                return new ImageIcon(newimg2);
            }
            case FISH: {
                ImageIcon grassIco = new ImageIcon(this.getClass().getResource("/cow_mushr.png"));
                Image image = grassIco.getImage();
                Image newimg = image.getScaledInstance(sizeOfPic, sizeOfPic, java.awt.Image.SCALE_SMOOTH);
                return new ImageIcon(newimg);
            }
            case OCELOT: {
                ImageIcon grassIco = new ImageIcon(this.getClass().getResource("/ocelot.png"));
                Image image = grassIco.getImage();
                Image newimg = image.getScaledInstance(sizeOfPic, sizeOfPic, java.awt.Image.SCALE_SMOOTH);
                return new ImageIcon(newimg);
            }
            case PIG: {
                ImageIcon grassIco = new ImageIcon(this.getClass().getResource("/pig.png"));
                Image image = grassIco.getImage();
                Image newimg = image.getScaledInstance(sizeOfPic, sizeOfPic, java.awt.Image.SCALE_SMOOTH);
                return new ImageIcon(newimg);
            }
            case SHEEP: {
                ImageIcon grassIco = new ImageIcon(this.getClass().getResource("/sheep.jpg"));
                Image image = grassIco.getImage();
                Image newimg = image.getScaledInstance(sizeOfPic, sizeOfPic, java.awt.Image.SCALE_SMOOTH);
                return new ImageIcon(newimg);
            }
            case SKELETON: {
                ImageIcon grassIco = new ImageIcon(this.getClass().getResource("/skeleton.png"));
                Image image = grassIco.getImage();
                Image newimg = image.getScaledInstance(sizeOfPic, sizeOfPic, java.awt.Image.SCALE_SMOOTH);
                return new ImageIcon(newimg);
            }
            case SPIDER: {
                ImageIcon grassIco = new ImageIcon(this.getClass().getResource("/spider.jpg"));
                Image image = grassIco.getImage();
                Image newimg = image.getScaledInstance(sizeOfPic, sizeOfPic, java.awt.Image.SCALE_SMOOTH);
                return new ImageIcon(newimg);
            }
            case WOLF: {
                ImageIcon grassIco = new ImageIcon(this.getClass().getResource("/wolf.jpg"));
                Image image = grassIco.getImage();
                Image newimg = image.getScaledInstance(sizeOfPic, sizeOfPic, java.awt.Image.SCALE_SMOOTH);
                return new ImageIcon(newimg);
            }
            default:
                return null;
        }
    }
    public ImageIcon getRandomAnimalIcon() {
        ImageIcon[] icons = {new ImageIcon(this.getClass().getResource("/bee.png")),
                new ImageIcon(this.getClass().getResource("/cat.png")),
                new ImageIcon(this.getClass().getResource("/chicken.png")),
                new ImageIcon(this.getClass().getResource("/cow_mushr.png")),
                new ImageIcon(this.getClass().getResource("/ocelot.png")),
                new ImageIcon(this.getClass().getResource("/pig.png")),
                new ImageIcon(this.getClass().getResource("/sheep.jpg")),
                new ImageIcon(this.getClass().getResource("/skeleton.png")),
                new ImageIcon(this.getClass().getResource("/spider.jpg")),
                new ImageIcon(this.getClass().getResource("/wolf.jpg"))};
        int i=0;
        for (ImageIcon icon : icons) {
            Image image = icon.getImage();
            Image newimg = image.getScaledInstance(sizeOfPic, sizeOfPic, Image.SCALE_SMOOTH);
            icons[i]=new ImageIcon(newimg);
            i++;

        }
        int index = (int) Math.floor(Math.random() * (icons.length));
        return icons[index];


    }

    public ImageIcon getRandomIcon() {
        ImageIcon[] icons = {new ImageIcon(this.getClass().getResource("/blue_wool.png")),
                new ImageIcon(this.getClass().getResource("/brown_wool.png")),
                new ImageIcon(this.getClass().getResource("/cyan_wool.png")),
                new ImageIcon(this.getClass().getResource("/green_wool.png")),
                new ImageIcon(this.getClass().getResource("/light_blue_wool.png")),
                new ImageIcon(this.getClass().getResource("/light_gray_wool.png")),
                new ImageIcon(this.getClass().getResource("/lime_wool.png")),
                new ImageIcon(this.getClass().getResource("/magenta_wool.png")),
                new ImageIcon(this.getClass().getResource("/orange_wool.png")),
                new ImageIcon(this.getClass().getResource("/pink_wool.png")),
                new ImageIcon(this.getClass().getResource("/purple_wool.png")),
                new ImageIcon(this.getClass().getResource("/red_wool.png")),
                new ImageIcon(this.getClass().getResource("/yellow_wool.png"))};
        int i=0;
        for (ImageIcon icon : icons) {
            Image image = icon.getImage();
            Image newimg = image.getScaledInstance(sizeOfPic, sizeOfPic, Image.SCALE_SMOOTH);
            icons[i]=new ImageIcon(newimg);
            i++;

        }
        int index = (int) Math.floor(Math.random() * (icons.length));
        return icons[index];


    }

}
