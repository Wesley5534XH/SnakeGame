package snakegame.sprites;

import com.github.hanyaeger.api.Coordinate2D;
import javafx.scene.paint.Color;

public class Grape extends Fruit {

    public Grape(Coordinate2D coordinate) {
        super(coordinate, 40);
        setFill(Color.PURPLE);
    }

    @Override
    protected void applyEffect(Snake snake) {
        snake.decreaseSpeed();
    }
}