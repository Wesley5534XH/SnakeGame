package snakegame.sprites;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.SceneBorderTouchingWatcher;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.scenes.SceneBorder;
import com.github.hanyaeger.api.userinput.KeyListener;
import javafx.scene.input.KeyCode;

import java.util.Set;

public class Snake extends DynamicSpriteEntity implements KeyListener, SceneBorderTouchingWatcher {


    public Snake(Coordinate2D coordinate) {
        super("sprites/SnakeHead.png", coordinate, new Size(40, 40));
    }

    @Override
    public void onPressedKeysChange(Set<KeyCode> pressedKeys) {
        if (pressedKeys.contains(KeyCode.LEFT)) {
            setMotion(10, 270d);
            setCurrentFrameIndex(2);
        } else if (pressedKeys.contains(KeyCode.RIGHT)) {
            setMotion(10, 90d);
            setCurrentFrameIndex(1);
        } else if (pressedKeys.contains(KeyCode.UP)) {
            setMotion(10, 180d);
        } else if (pressedKeys.contains(KeyCode.DOWN)) {
            setMotion(10, 0d);
        }
    }

    @Override
    public void notifyBoundaryTouching(SceneBorder border) {
        setSpeed(0);

        switch (border) {
            case TOP:
                setAnchorLocationY(1);
                break;
            case BOTTOM:
                setAnchorLocationY(getSceneHeight() - getHeight() - 1);
                break;
            case LEFT:
                setAnchorLocationX(1);
                break;
            case RIGHT:
                setAnchorLocationX(getSceneWidth() - getWidth() - 1);
            default:
                break;
        }
    }
}
