package snakegame.FruitSpawners;

import com.github.hanyaeger.api.*;
import com.github.hanyaeger.api.entities.EntitySpawner;
import snakegame.sprites.*;

import java.util.Random;

public class FruitSpawner extends EntitySpawner {

    private final Random r = new Random();
    private final double w, h;

    public FruitSpawner(double w, double h) {
        super(1000);
        this.w = w;
        this.h = h;
    }

    protected void spawnEntities() {
        Coordinate2D c = new Coordinate2D(
                r.nextInt((int) w),
                r.nextInt((int) h)
        );

        int x = r.nextInt(100);

        if (x < 40) spawn(new Apple(c));
        else if (x < 65) spawn(new Berry(c));
        else if (x < 85) spawn(new Banana(c));
        else spawn(new Grape(c));
    }
}