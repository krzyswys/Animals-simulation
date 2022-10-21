package agh.ics.oop;

public class Animal {

    public Animal() {
    }

    private Vector2d vector = new Vector2d(2, 2);
    private MapDirection orientation= MapDirection.NORTH;

    public Animal(Vector2d vector, MapDirection orientation) {
        if (vector.x>=0 && vector.y>=0 && vector.x<=4 && vector.y<=4){ // defaultowo tworzy się na 2,2, north ale jakby chciało sie customowo to nie wejdzie poza mapę
            this.vector = vector;
            this.orientation = orientation;
        }


    }

    @Override
    public String toString() {
        String wordX = Integer.toString(vector.x);
        String wordY = Integer.toString(vector.y);
        return "(" + wordX + "," + wordY + "," + orientation.name() + ")";
    }

    public boolean isAt(Vector2d position) {
        return position.x == this.vector.x && position.y == this.vector.y;
    }

    public void move(MoveDirection direction) {
        if (direction == MoveDirection.RIGHT) {
            this.orientation = this.orientation.next();
        } else if (direction == MoveDirection.LEFT) {
            this.orientation = this.orientation.previous();
        } else if (direction == MoveDirection.FORWARD) {
            Vector2d obj = this.orientation.toUnitVector();
            int objx = obj.x;
            int objy = obj.y;
            if (this.vector.x + objx <= 4 && this.vector.y + objy <= 4 && this.vector.y + objy >= 0 && this.vector.x + objx >= 0) {
                this.vector = new Vector2d(this.vector.x + objx, this.vector.y + objy);
            }
        } else if (direction == MoveDirection.BACKWARD) {
            Vector2d obj = this.orientation.toUnitVector();
            int objx = obj.x;
            int objy = obj.y;
            if (this.vector.x - objx <= 4 && this.vector.y - objy <= 4 && this.vector.y - objy >= 0 && this.vector.x - objx >= 0) {
                this.vector = new Vector2d(this.vector.x - objx, this.vector.y - objy);
            }
        }

    }
}
