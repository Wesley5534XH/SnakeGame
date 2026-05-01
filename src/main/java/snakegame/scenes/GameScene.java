package snakegame.scenes;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.scenes.DynamicScene;
import snakegame.SnakeGame;
import snakegame.entities.text.PointsManager;
import snakegame.sprites.Snake;
import snakegame.sprites.Wall;

import java.util.Random;

public class GameScene extends DynamicScene {

    private SnakeGame game;

    public GameScene(SnakeGame game) {
        this.game = game;
    }

    @Override
    public void setupScene() {
        setBackgroundImage("backgrounds/Background2.jpg");
        setBackgroundAudio("audio/SnakeGameSound.mp3");
    }

    @Override
    public void setupEntities() {
        PointsManager points = new PointsManager(new Coordinate2D(50, 50));
        addEntity(points);

        Snake snake = new Snake(new Coordinate2D(100, 100), points, game);
        addEntity(snake);

        spawnWalls(5);
    }

    private void spawnWalls(int amount) {
        Random random = new Random();
        int tileSize = 40;
        int wallLocationX = 380;
        int wallLocationY = 200;

        for (int i = 0; i < amount; i++) {

            int x = wallLocationX;
            int y = wallLocationY + tileSize * i;

            addEntity(new Wall(new Coordinate2D(x, y)));
        }
    }
}
