package snakegame.sprites;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.UpdateExposer;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.SceneBorderTouchingWatcher;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.scenes.SceneBorder;
import com.github.hanyaeger.api.userinput.KeyListener;
import javafx.scene.input.KeyCode;
import snakegame.SnakeGame;
import snakegame.entities.map.Wall;
import snakegame.entities.text.FruitPointsText;
import snakegame.enums.Direction;
import snakegame.interfaces.Consumable;
import snakegame.entities.text.ScoreManager;
import snakegame.scenes.GameScene;

import java.util.Set;

public class Snake extends DynamicSpriteEntity implements KeyListener, SceneBorderTouchingWatcher, Collided, Collider, UpdateExposer {

    private static final int START_SPEED = 1;
    private final SnakeGame game;
    private final FruitPointsText fruitPointsText;
    private final ScoreManager scoreManager;
    private final SnakeBodyManager bodyManager;
    private int speed = START_SPEED;
    private Direction currentDirection;

    public Snake(Coordinate2D coordinate, FruitPointsText fruitPointsText, SnakeGame game, GameScene scene, ScoreManager scoreManager) {

        super("sprites/SnakeHead.png", coordinate, new Size(40, 40));
        this.game = game;
        this.fruitPointsText = fruitPointsText;
        this.scoreManager = scoreManager;
        this.bodyManager = new SnakeBodyManager(scene);
        //updateScoreText();
    }

    @Override
    public void onPressedKeysChange(Set<KeyCode> pressedKeys) {
        if (pressedKeys.contains(KeyCode.LEFT) && currentDirection != Direction.RIGHT) {
            move(Direction.LEFT);
        } else if (pressedKeys.contains(KeyCode.RIGHT) && currentDirection != Direction.LEFT) {
            move(Direction.RIGHT);
        } else if (pressedKeys.contains(KeyCode.UP) && currentDirection != Direction.DOWN) {
            move(Direction.UP);
        } else if (pressedKeys.contains(KeyCode.DOWN) && currentDirection != Direction.UP) {
            move(Direction.DOWN);
        }
    }

    private void move(Direction direction) {
        currentDirection = direction;
        setMotion(speed, direction.getAngle());
    }

    @Override
    public void notifyBoundaryTouching(SceneBorder border) {
        switch (border) {
            case TOP -> setAnchorLocationY(getSceneHeight() - getHeight());
            case BOTTOM -> setAnchorLocationY(0);
            case LEFT -> setAnchorLocationX(getSceneWidth() - getWidth());
            case RIGHT -> setAnchorLocationX(0);
        }
    }

    @Override
    public void onCollision(java.util.List<Collider> collidingObjects) {
        for (Collider collider : collidingObjects) {
            if (collider instanceof Consumable consumable) {
                consumable.consume(this);
            } else if (collider instanceof Wall) {
                game.setActiveScene(2);
           }
        }
    }

    public void increaseScore() {
        scoreManager.addPoint();
        bodyManager.grow(getAnchorLocation());
        updateScoreText();
    }

    public void decreaseScore() {
        if (scoreManager.getScore() <= 0) {
            game.setActiveScene(2);
            return;
        }
        scoreManager.removePoint();
        bodyManager.shrink();
        updateScoreText();
    }

    public void increaseSpeed() {
        speed++;
    }

    public void decreaseSpeed() {
        if (speed > 1) {
            speed--;
        }
    }

    private void updateScoreText() {
        fruitPointsText.setPointsText(scoreManager.getScore());
    }

    @Override
    public void explicitUpdate(long timestamp) {
        bodyManager.update(getAnchorLocation(), speed);
        if (bodyManager.collidesWithHead(getAnchorLocation())) {
            game.setActiveScene(2);
        }
    }
}