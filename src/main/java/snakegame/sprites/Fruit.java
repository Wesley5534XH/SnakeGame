package snakegame.sprites;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;

public class Fruit extends DynamicSpriteEntity {

    public Fruit(Coordinate2D coordinate, String foodType) { //Red
        super(foodType, coordinate, new Size(40, 40));
    }


    public void fruitManager(){


    }
}
