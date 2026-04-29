package snakegame.scenes;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import com.github.hanyaeger.api.scenes.StaticScene;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import snakegame.SnakeGame;
import snakegame.entities.buttons.Button;

public class MainMenuScene extends StaticScene {

    private SnakeGame game;

    public MainMenuScene(SnakeGame game) {
        this.game = game;
    }

    @Override
    public void setupScene() {
        setBackgroundAudio("audio/SnakeGameSound.mp3");
        setBackgroundImage("backgrounds/Background1.jpg");
    }

    @Override
    public void setupEntities() {
        var snakeGameText = new TextEntity(new Coordinate2D(getWidth()/2,getHeight()/2),"Snake Game");
        snakeGameText.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        snakeGameText.setFill(Color.DARKBLUE);
        snakeGameText.setFont(Font.font("Roboto", FontWeight.SEMI_BOLD, 80));
        addEntity(snakeGameText);
        //eventueel class van maken met methode en hier invoegen

        Button startButton = new Button(new Coordinate2D(getWidth()/2-30,getHeight()/2+30), Color.YELLOW, "Start", game);
        addEntity(startButton);
    }
}
