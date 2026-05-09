package snakegame.sprites;

import com.github.hanyaeger.api.Coordinate2D;
import javafx.scene.paint.Color;

public class Banana extends Fruit {

    public Banana(Coordinate2D coordinate) {
        super(coordinate, 40);
        setFill(Color.YELLOW);
    }

    @Override
    protected void applyEffect(Snake snake) {
        snake.increaseSpeed();
    }
}