package snakegame.entities.text;

import com.github.hanyaeger.api.*;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import javafx.scene.text.Font;

public class FruitPointsText extends TextEntity {

    public FruitPointsText(Coordinate2D c) {
        super(c);
        setFont(Font.font("Roboto", 30));
    }

    public void setPointsText(int p) {
        setText("Points: " + p);
    }
}