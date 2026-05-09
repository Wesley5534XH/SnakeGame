package snakegame.sprites;

import com.github.hanyaeger.api.Coordinate2D;
import javafx.scene.paint.Color;

public class Berry extends Fruit {

    public Berry(Coordinate2D coordinate) {
        super(coordinate, 40);
        setFill(Color.BLACK);
    }

    @Override
    protected void applyEffect(Snake snake) {
        snake.decreaseScore();
    }
}