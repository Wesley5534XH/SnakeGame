package snakegame.entities.buttons;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.userinput.MouseButtonPressedListener;
import javafx.scene.input.MouseButton;
import javafx.scene.paint.Color;

public class QuitButton extends MenuButton implements MouseButtonPressedListener {

    public QuitButton(Coordinate2D coordinate, String text, Color color) {
        super(coordinate, text, color);
    }

    @Override
    public void onMouseButtonPressed(MouseButton button, Coordinate2D coordinate2D) {
        System.exit(0);
    }
}