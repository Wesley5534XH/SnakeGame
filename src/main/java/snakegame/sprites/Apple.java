package snakegame.sprites;

import com.github.hanyaeger.api.Coordinate2D;
import javafx.scene.paint.Color;

public class Apple extends Fruit {

    public Apple(Coordinate2D coordinate) {
        super(coordinate, 40);
        setFill(Color.RED);
    }

    @Override
    protected void applyEffect(Snake snake) {
        snake.increaseScore();
    }
}