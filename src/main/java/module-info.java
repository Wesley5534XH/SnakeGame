module Snake.Game {
    requires hanyaeger;

    exports snakegame;
    exports snakegame.entities.map;
    exports snakegame.entities.text;

    opens audio;
    opens backgrounds;
    opens sprites;

}