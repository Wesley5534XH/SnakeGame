package snakegame.entities.text;

public class ScoreManager {

    private int score;

    public void addPoint() {
        score++;
    }

    public void removePoint() {
        if (score > 0) {
            score--;
        }
    }

    public int getScore() {
        return score;
    }

    public void reset(){
        score = 0;
    }
}