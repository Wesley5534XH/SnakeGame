package snakegame.entities.map;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.SpriteEntity;

public class Wall extends SpriteEntity implements Collider {

    public Wall(Coordinate2D coordinate, Size wallSize, String wallLocation) {
        super(wallLocation, coordinate, wallSize);
    }
}
