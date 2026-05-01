package snakegame.sprites;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.SceneBorderCrossingWatcher;
import com.github.hanyaeger.api.entities.impl.SpriteEntity;

import java.util.Random;

public class Wall extends SpriteEntity implements Collider {

    public Wall(Coordinate2D coordinate) {
        super("sprites/Brown.png",  coordinate, new Size(40, 40));
    }
}
