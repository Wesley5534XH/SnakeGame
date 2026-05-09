package snakegame.scenes;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import com.github.hanyaeger.api.scenes.StaticScene;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import snakegame.SnakeGame;
import snakegame.entities.buttons.StartButton;
import snakegame.entities.buttons.QuitButton;
import snakegame.entities.text.ScoreManager;
import snakegame.sprites.Snake;

public class GameOverScene extends StaticScene {

    private final SnakeGame game;
    private final ScoreManager scoreManager;

    public GameOverScene(SnakeGame game, ScoreManager scoreManager) {
        this.game = game;
        this.scoreManager = scoreManager;
    }

    @Override
    public void setupScene() {
        setBackgroundImage("backgrounds/Background2.jpg");
    }

    @Override
    public void setupEntities() {
        TextEntity text = new TextEntity(new Coordinate2D(getWidth()/2, getHeight()/4), "Game Over"); //tekst maken
        text.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        text.setFill(Color.RED);
        text.setFont(Font.font("Roboto", FontWeight.BOLD, 70));
        addEntity(text);

        TextEntity textPoints = new TextEntity(new Coordinate2D(getWidth()/2, getHeight()/3+50), "Punten: " + scoreManager.getScore());
        textPoints.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        textPoints.setFill(Color.RED);
        textPoints.setFont(Font.font("Roboto", FontWeight.BOLD, 50));
        addEntity(textPoints);

        addEntity(new StartButton(new Coordinate2D(getWidth()/2-50, getHeight()/2), "Play Again", Color.YELLOW,  game));
        addEntity(new QuitButton(new Coordinate2D(getWidth()/2-50, getHeight()/2+50),"Quit", Color.YELLOW));
    }
}