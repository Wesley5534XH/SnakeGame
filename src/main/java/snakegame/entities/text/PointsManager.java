package snakegame.entities.text;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class PointsManager extends TextEntity {
	public PointsManager(Coordinate2D coordinate) {
        super(coordinate);
        setFont(Font.font("Roboto", FontWeight.NORMAL, 30));
        setFill(Color.DARKBLUE);
    }

    public void setPointsText(int points) {
        setText("Points: " + points);
    }
}
