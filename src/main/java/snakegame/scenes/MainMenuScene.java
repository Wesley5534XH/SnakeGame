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

public class MainMenuScene extends StaticScene {

    private final SnakeGame game;

    public MainMenuScene(SnakeGame game) {
        this.game = game;
    }

    @Override
    public void setupScene() {
        setBackgroundImage("backgrounds/Background.jpg");
        setBackgroundAudio("audio/snakegamesound.mp3");

    }

    @Override
    public void setupEntities() {
        TextEntity title = new TextEntity(new Coordinate2D(getWidth()/2, getHeight()/2-50), "Snake Game");
        title.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        title.setFill(Color.DARKBLUE);
        title.setFont(Font.font("Roboto", FontWeight.BOLD, 80));
        addEntity(title);

        addEntity(new StartButton(new Coordinate2D(350, 300),"Start",Color.YELLOW, game));
        addEntity(new QuitButton(new Coordinate2D(350, 350),"Quit", Color.YELLOW));
    }
}