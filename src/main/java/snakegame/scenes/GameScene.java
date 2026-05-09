package snakegame.scenes;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.EntitySpawnerContainer;
import com.github.hanyaeger.api.scenes.DynamicScene;
import com.github.hanyaeger.api.scenes.TileMapContainer;
import snakegame.FruitSpawners.FruitSpawner;
import snakegame.SnakeGame;
import snakegame.entities.map.WallTileMap;
import snakegame.entities.text.FruitPointsText;
import snakegame.entities.text.ScoreManager;
import snakegame.sprites.Snake;
import snakegame.sprites.SnakeSegment;

public class GameScene extends DynamicScene implements TileMapContainer, EntitySpawnerContainer {

    private final SnakeGame game;
    private final ScoreManager scoreManager;

    public GameScene(SnakeGame game, ScoreManager scoreManager) {
        this.game = game;
        this.scoreManager = scoreManager;
    }

    @Override
    public void setupScene() {
        scoreManager.reset();
        setBackgroundImage("backgrounds/Background2.jpg");
        setBackgroundAudio("audio/SnakeGameSound.mp3");
    }

    @Override
    public void setupEntities() {
        FruitPointsText points = new FruitPointsText(new Coordinate2D(20, 20));
        addEntity(points);

        Snake snake = new Snake(new Coordinate2D(100, 100), points, game, this, scoreManager);
        addEntity(snake);
    }

    @Override
    public void setupTileMaps() {
        addTileMap(new WallTileMap());
    }

    @Override
    public void setupEntitySpawners() {
        addEntitySpawner(new FruitSpawner(getWidth(), getHeight()));
    }

    public SnakeSegment addSnakeSegment(Coordinate2D pos) {
        SnakeSegment s = new SnakeSegment(pos);
        addEntity(s);
        return s;
    }
}