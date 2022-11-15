package agh.ics.oop;
//Zdefiniuj klasę Grass (kępka trawy), która:
//w konstruktorze akceptuje parametr Vector2d, określający pozycję kępki trawy,
//posiada metodę publiczną Vector2d getPosition(), która zwraca jej pozycję,
//posiada metodę publiczną String toString(), która zwraca * jako swoją reprezentację.
public class Grass {
    private Vector2d position;

    public Grass(Vector2d vector) {
        this.position=vector;
    }

    public Vector2d getPosition(){
        return this.position;
    }
    @Override
    public String toString(){
        return "*";
    }
}
