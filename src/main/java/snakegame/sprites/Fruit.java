package snakegame.sprites;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.DynamicRectangleEntity;
import com.github.hanyaeger.api.media.SoundClip;
import snakegame.interfaces.Consumable;
import java.util.Timer;
import java.util.TimerTask;

public abstract class Fruit extends DynamicRectangleEntity implements Collider, Consumable {

    private static final int DESPAWN_TIME = 30000;
    private final SoundClip sound;

    protected Fruit(Coordinate2D coordinate, double size) {
        super(coordinate);
        setWidth(size);
        setHeight(size);
        sound = new SoundClip("audio/snakefruiteffect.mp3");
        startDespawnTimer();
    }

    @Override
    public final void consume(Snake snake) {
        sound.play();
        applyEffect(snake);
        remove();
    }

    protected abstract void applyEffect(Snake snake);

    private void startDespawnTimer() {
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                remove();
            }
        }, DESPAWN_TIME);
    }
}