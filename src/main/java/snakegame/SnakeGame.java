package snakegame;

import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.YaegerGame;
import snakegame.scenes.GameScene;
import snakegame.scenes.MainMenuScene;

public class SnakeGame extends YaegerGame{

    @Override
    public void setupGame() {
        setGameTitle("Snake Game");
        setSize(new Size(800, 600));
    }

    @Override
    public void setupScenes() {
        addScene(0, new MainMenuScene(this));
        addScene(1, new GameScene());
    }
    public static void main(String[] args) {
        launch(args);
    }
}
