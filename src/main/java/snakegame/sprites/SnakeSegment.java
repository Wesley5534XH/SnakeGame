package snakegame.sprites;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;

public class SnakeSegment extends DynamicSpriteEntity {

    public SnakeSegment(Coordinate2D coordinate) {
        super("sprites/snakebody.png", coordinate, new Size(40, 40));
    }
}
