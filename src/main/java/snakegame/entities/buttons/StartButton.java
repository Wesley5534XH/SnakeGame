package snakegame.entities.buttons;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.userinput.MouseButtonPressedListener;
import javafx.scene.input.MouseButton;
import javafx.scene.paint.Color;
import snakegame.SnakeGame;

public class StartButton extends MenuButton implements MouseButtonPressedListener {

    private final SnakeGame game;

    public StartButton(Coordinate2D coordinate, String text, Color color, SnakeGame game) {
        super(coordinate, text, color);
        this.game = game;
    }

    @Override
    public void onMouseButtonPressed(MouseButton button, Coordinate2D coordinate2D) {
        game.setActiveScene(1);
    }
}