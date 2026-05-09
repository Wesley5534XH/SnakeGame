package snakegame.sprites;

import com.github.hanyaeger.api.Coordinate2D;
import snakegame.scenes.GameScene;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class SnakeBodyManager {

    private static final int SEGMENT_DISTANCE = 40;

    private final List<SnakeSegment> segments = new ArrayList<>();
    private final List<SnakeSegment> toRemove = new ArrayList<>();

    private final LinkedList<Coordinate2D> previousPositions = new LinkedList<>();
    private final GameScene scene;

    public SnakeBodyManager(GameScene scene) {
        this.scene = scene;
    }

    public void grow(Coordinate2D position) {
        SnakeSegment segment = scene.addSnakeSegment(position);
        segments.add(segment);
    }

    public void shrink() {
        if (!segments.isEmpty()) {
            SnakeSegment lastSegment = segments.getLast();
            toRemove.add(lastSegment); // toevoegen aan verwijderlijst
            segments.remove(lastSegment); // verwijderen
        }
    }

    public void update(Coordinate2D currentPosition, int speed) {
        previousPositions.addFirst(new Coordinate2D(currentPosition.getX(), currentPosition.getY()));
        while (previousPositions.size() > 2000) {
            previousPositions.removeLast();
        }
        for (int i = 0; i < segments.size(); i++) {
            int index = (i + 1) * SEGMENT_DISTANCE / Math.max(speed, 1); //segmenten > juiste snelheid en ruimte
            index = Math.max(index, 1);

            if (previousPositions.size() > index) {
                segments.get(i).setAnchorLocation(previousPositions.get(index));
            }
        }
        processRemovals(); // Veilig opschonen
    }

    private void processRemovals() {
        for (SnakeSegment segment : toRemove) {
            segment.remove();
        }
        toRemove.clear();
    }

    public int getSegmentCount() {
        return segments.size();
    }

    public List<SnakeSegment> getSegments() {
        return segments;
    }

    public boolean collidesWithHead(Coordinate2D headPosition) {
        for (int i = 2; i < segments.size(); i++) {
            SnakeSegment segment = segments.get(i);
            double distanceX = Math.abs(headPosition.getX() - segment.getAnchorLocation().getX());
            double distanceY = Math.abs(headPosition.getY() - segment.getAnchorLocation().getY());
            if (distanceX < 20 && distanceY < 20) {
                return true;
            }
        }
        return false;
    }
}