package snakegame.entities.buttons;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import com.github.hanyaeger.api.userinput.MouseEnterListener;
import com.github.hanyaeger.api.userinput.MouseExitListener;
import javafx.scene.Cursor;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public abstract class MenuButton extends TextEntity implements MouseEnterListener, MouseExitListener {

    private final Color defaultColor;

    protected MenuButton(Coordinate2D coordinate, String text, Color color) {
        super(coordinate, text);
        defaultColor = color;
        setFill(color);
        setFont(Font.font("Roboto", FontWeight.BOLD, 30));
    }

    @Override
    public void onMouseEntered() {
        setFill(Color.PURPLE);
        setCursor(Cursor.HAND);
    }

    @Override
    public void onMouseExited() {
        setFill(defaultColor);
        setCursor(Cursor.DEFAULT);
    }
}