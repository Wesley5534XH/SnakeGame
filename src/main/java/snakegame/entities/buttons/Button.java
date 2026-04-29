package snakegame.entities.buttons;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import com.github.hanyaeger.api.userinput.MouseButtonPressedListener;
import com.github.hanyaeger.api.userinput.MouseEnterListener;
import com.github.hanyaeger.api.userinput.MouseExitListener;
import javafx.scene.Cursor;
import javafx.scene.input.MouseButton;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import snakegame.SnakeGame;


public class Button extends TextEntity implements MouseButtonPressedListener, MouseEnterListener, MouseExitListener {

    private SnakeGame game;
    private Color color;

    public Button(Coordinate2D coordinate, Color color,  String text, SnakeGame game) {
        super(coordinate, text);
        this.game = game;
        this.color = color;
        setFill(color);
        setFont(Font.font("Robot", FontWeight.BOLD, 30));


    }

    @Override
    public void onMouseButtonPressed(MouseButton button, Coordinate2D coordinate2D) {
        game.setActiveScene(1);
    }

    @Override
    public void onMouseEntered() {
        setFill(Color.PURPLE);
        setCursor(Cursor.HAND);
    }

    @Override
    public void onMouseExited() {
        setFill(color);
        setCursor(Cursor.DEFAULT);
    }
}
