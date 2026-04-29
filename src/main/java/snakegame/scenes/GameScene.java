package snakegame.scenes;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.scenes.DynamicScene;
import org.checkerframework.checker.units.qual.C;
import snakegame.sprites.Snake;
import snakegame.sprites.Wall;

public class GameScene extends DynamicScene {
    public GameScene() {

    }

    @Override
    public void setupScene() {
        setBackgroundImage("backgrounds/Background2.jpg");
        setBackgroundAudio("audio/SnakeGameSound.mp3");
    }

    @Override
    public void setupEntities() {
        Snake snake = new Snake(new Coordinate2D(100, 100));
        addEntity(snake);

        Wall wall = new Wall(new Coordinate2D(200, 200));
        addEntity(wall);
    }
}
