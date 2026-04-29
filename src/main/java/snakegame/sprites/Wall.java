package snakegame.sprites;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;

public class Wall extends DynamicSpriteEntity implements Collider {

    public Wall(Coordinate2D coordinate) {
        super("sprites/Brown.png",  coordinate, new Size(40, 40));
    }

    public void setWall(){
        //5 random walls
    }
}
